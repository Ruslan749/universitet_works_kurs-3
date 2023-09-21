package com.example.exe_2.service;

import com.example.exe_2.exception.UnsupertCodeException;
import com.example.exe_2.model.Request;
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
