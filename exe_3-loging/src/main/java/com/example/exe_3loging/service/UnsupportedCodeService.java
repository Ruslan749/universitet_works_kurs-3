package com.example.exe_3loging.service;

import com.example.exe_3loging.exception.UnsupertCodeException;
import com.example.exe_3loging.model.Request;
import org.springframework.stereotype.Service;

@Service
public interface UnsupportedCodeService {
    void isCode(Request request) throws UnsupertCodeException;
}
