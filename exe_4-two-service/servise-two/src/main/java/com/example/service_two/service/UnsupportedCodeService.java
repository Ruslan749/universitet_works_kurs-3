package com.example.service_two.service;

import com.example.service_two.exception.UnsupertCodeException;
import com.example.service_two.model.Request;
import org.springframework.stereotype.Service;

@Service
public interface UnsupportedCodeService {
    void isCode(Request request) throws UnsupertCodeException;
}
