package com.kuang.login.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Validated
public class LoginRequestDto {
    @NotEmpty(message = "homerId不能为空")
    private String homerId;

    @NotEmpty(message = "smsCode不能为空")
    @Size(min = 4, max = 4, message = "smsCode只能为4位")
    private int smsCode;
}
