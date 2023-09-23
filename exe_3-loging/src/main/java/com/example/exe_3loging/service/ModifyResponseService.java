package com.example.exe_3loging.service;

import com.example.exe_3loging.model.Response;
import org.springframework.stereotype.Service;

@Service
public interface ModifyResponseService {
    Response modify(Response response);
}
