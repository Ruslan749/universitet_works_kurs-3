package com.example.exe_2.service;

import com.example.exe_2.exception.UnsupertCodeException;
import com.example.exe_2.exception.ValidationFailedException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
@Service
public class RequestValidationService implements ValidationService{
    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException {
        if (bindingResult.hasErrors()){
            throw new ValidationFailedException(bindingResult.getFieldError().toString());
        }
    }

    @Override
    public void isCode(BindingResult bindingResult) throws UnsupertCodeException {
        if (bindingResult.hasErrors()){
            throw new UnsupertCodeException(bindingResult.getFieldError().toString());
        }
    }

}
