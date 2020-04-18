package com.kuang.login.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * homer
 * @author 
 */
@Data
public class HomerEntity implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * homer id
     */
    private String homerId;

    private static final long serialVersionUID = 1L;
}