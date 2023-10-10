package com.example.service_two.service;

import com.example.service_two.model.Request;
import com.example.service_two.model.Response;
import org.springframework.stereotype.Service;

@Service
public interface FormattedService {
    void modifyTime(Request request, Response response);
}
