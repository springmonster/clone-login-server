package com.kuang.login.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmsRequestDto {

    @NotEmpty(message = "homer id不能为空")
    private String homerId;

    @NotEmpty(message = "手机号不能为空")
    @Pattern(regexp = "^[1]\\\\d{10}$", message = "手机号不正确")
    private String phoneNumber;
}
