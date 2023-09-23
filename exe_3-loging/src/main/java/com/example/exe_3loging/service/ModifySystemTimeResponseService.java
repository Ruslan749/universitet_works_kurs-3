package com.example.exe_3loging.service;

import com.example.exe_3loging.model.Response;
import com.example.exe_3loging.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Qualifier("ModifySystemTimeResponseService")
public class ModifySystemTimeResponseService implements ModifyResponseService{
    @Override
    public Response modify(Response response) {
        response.setSystemTime(DateTimeUtil.getCustomFormatFormat().format(new Date()));
        return response;
    }
}
