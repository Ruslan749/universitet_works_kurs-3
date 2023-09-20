package com.example.exe_2.service;

import com.example.exe_2.exception.UnsupertCodeException;
import com.example.exe_2.exception.ValidationFailedException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException;
    void isCode(BindingResult bindingResult) throws UnsupertCodeException;

}