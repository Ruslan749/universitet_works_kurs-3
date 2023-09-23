package com.example.exe_3loging.controller;

import com.example.exe_3loging.Enum.Codes;
import com.example.exe_3loging.Enum.ErrorCodes;
import com.example.exe_3loging.Enum.ErrorMessages;
import com.example.exe_3loging.exception.UnsupertCodeException;
import com.example.exe_3loging.exception.ValidationFailedException;
import com.example.exe_3loging.model.Request;
import com.example.exe_3loging.model.Response;
import com.example.exe_3loging.service.UnsupportedCodeService;
import com.example.exe_3loging.service.ValidationService;
import com.example.exe_3loging.util.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
@Slf4j
@RestController
public class Mycontroller {
    private final ValidationService validationService;
    private final UnsupportedCodeService unsupportedCodeService;
    @Autowired
    public Mycontroller(ValidationService validationService, UnsupportedCodeService unsupportedCodeService, UnsupportedCodeService unsupportedCodeService1) {
        this.validationService = validationService;
        this.unsupportedCodeService = unsupportedCodeService1;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult) throws UnsupertCodeException {

        log.info("request:{}",request);
        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormatFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMassage(ErrorMessages.EMPTY)
                .build();

        try{
            validationService.isValid(bindingResult);
            unsupportedCodeService.isCode(request);
        }catch (ValidationFailedException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMassage(ErrorMessages.VALIDATION);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }catch (UnsupertCodeException e){
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            response.setErrorMassage(ErrorMessages.UNSUPPORTED);
            return new ResponseEntity<>(response, HttpStatus.I_AM_A_TEAPOT);
        }
        catch (Exception e){
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMassage(ErrorMessages.UNKNOWN);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
