package com.kuang.login.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class SmsRequestDto {

    @NotEmpty(message = "user id不能为空")
    private String userId;

    @NotEmpty(message = "手机号不能为空")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号不正确")
    private String phoneNumber;
}
