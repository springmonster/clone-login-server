package com.kuang.login.exceptions;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
    protected int code;

    public BaseException(int code, String msg) {
        super(msg);
        this.code = code;
    }
}
