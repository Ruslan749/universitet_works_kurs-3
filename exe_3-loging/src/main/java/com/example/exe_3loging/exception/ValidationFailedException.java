package com.example.exe_3loging.exception;

public class ValidationFailedException extends Exception {
    public ValidationFailedException(String message){
        super(message);
        System.out.println(message);
    }

}
