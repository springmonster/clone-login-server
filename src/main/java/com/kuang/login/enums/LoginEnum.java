package com.kuang.login.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum LoginEnum {

    VALIDATE_HOMER_ID_SUCCESS(HttpStatus.OK.value(), "homerId验证成功"),
    VALIDATE_HOMER_ID_FAIL(HttpStatus.BAD_REQUEST.value(), "homerId查询失败");

    private final int code;
    private final String msg;

    LoginEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}