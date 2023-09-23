package com.example.exe_3loging.service;

import com.example.exe_3loging.exception.UnsupertCodeException;
import com.example.exe_3loging.model.Request;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class RequestUnsatedException implements UnsupportedCodeService {

    @Override
    public void isCode(Request request) throws UnsupertCodeException {
        if (Objects.equals(request.getUid(),"123")){
            throw new UnsupertCodeException();
        }
    }
}
