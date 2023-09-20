package com.example.exe_2.exception;

import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.converter.HttpMessageNotReadableException;

public class UnsupertCodeException extends Exception {

    public UnsupertCodeException(String message) {
        super(message);
        System.out.println(message);
    }
}
