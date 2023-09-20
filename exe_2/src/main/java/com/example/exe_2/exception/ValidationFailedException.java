package com.example.exe_2.exception;

public class ValidationFailedException extends Exception {
    public ValidationFailedException(String message){
        super(message);
        System.out.println(message);
    }

}
