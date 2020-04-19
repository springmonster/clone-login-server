package com.kuang.login.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginRequestDto {

    @NotEmpty(message = "userId不能为空")
    private String userId;

    @NotEmpty(message = "smsCode不能为空")
    private String smsCode;
}
