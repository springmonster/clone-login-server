package com.kuang.login.vo;

import lombok.Data;

/**
 * 返回的基础Bean
 * @param <T>
 */
@Data
public class ResultVO<T> {
    int code;
    String msg;
    T data;
}
