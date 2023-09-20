package com.example.exe_2.exception;

public class UnsupertCodeException extends Exception {

    public UnsupertCodeException(String message) {
        super(message);
        System.out.println(message);
    }
}
