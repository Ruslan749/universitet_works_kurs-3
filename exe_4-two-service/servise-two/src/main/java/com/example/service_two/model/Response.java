package com.example.service_two.model;

import com.example.service_two.Enum.Codes;
import com.example.service_two.Enum.ErrorCodes;
import com.example.service_two.Enum.ErrorMessages;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Response {
    private String uid;
    private String operationUid;
    private String systemTime;
    private Codes code;
    private ErrorCodes errorCode;
    private ErrorMessages errorMassage;
}
