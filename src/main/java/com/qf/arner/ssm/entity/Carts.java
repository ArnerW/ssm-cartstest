package com.qf.arner.ssm.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Carts implements Serializable {
    /**
     * 主键购物车ID
     */
    private Integer cartsId;

    /**
     * 商品数量
     */
    private Integer num;

    /**
     * 商品ID 外键
     */
    private Integer productId;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 状态值 0为正常，1为删除
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

}

