package com.example.exe_2.service;

import com.example.exe_2.exception.UnsupertCodeException;
import com.example.exe_2.model.Request;
import org.springframework.stereotype.Service;

@Service
public interface UnsupportedCodeService {
    void isCode(Request request) throws UnsupertCodeException;
}
