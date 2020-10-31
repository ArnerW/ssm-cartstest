package com.qf.arner.ssm.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 状态 0为存在，1为删除
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}

