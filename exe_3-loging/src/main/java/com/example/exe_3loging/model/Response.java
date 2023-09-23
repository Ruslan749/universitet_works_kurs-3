package com.example.exe_3loging.model;

import com.example.exe_3loging.Enum.Codes;
import com.example.exe_3loging.Enum.ErrorCodes;
import com.example.exe_3loging.Enum.ErrorMessages;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private String uid;
    private String operationUid;
    private String systemTime;
    private Codes code;
    private ErrorCodes errorCode;
    private ErrorMessages errorMassage;
}
