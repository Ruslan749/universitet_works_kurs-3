package com.example.exe_2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    @NotBlank(message = "Uid  не может быть пустым ")
    @Size(max = 32)
    private String uid;
    @NotBlank(message = "operationUid не может быть пустым")
    @Size(max = 32)
    private String operationUid;
    private String systemName;
    private String systemTime;
    private String source;
    @Min(1)
    @Max(100000)
    private int communicationId;
    private int templateId;
    private int productCode;
    private int smsCode;

}
