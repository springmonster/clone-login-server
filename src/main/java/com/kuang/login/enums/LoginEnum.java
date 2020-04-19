package com.kuang.login.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum LoginEnum {

    VALIDATE_HOMER_ID_SUCCESS(HttpStatus.OK.value(), "userId验证成功"),
    VALIDATE_HOMER_ID_FAIL(HttpStatus.BAD_REQUEST.value(), "userId验证失败"),
    LOGIN_SUCCESS(HttpStatus.OK.value(), "登录成功"),
    LOGIN_FAIL(HttpStatus.BAD_REQUEST.value(), "登录失败");

    private final int code;
    private final String msg;

    LoginEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}