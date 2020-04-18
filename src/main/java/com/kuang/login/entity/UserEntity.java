package com.kuang.login.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * user
 *
 * @author
 */
@Data
public class UserEntity implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * user id
     */
    private String userId;

    private static final long serialVersionUID = 1L;
}