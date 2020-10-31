package com.qf.arner.ssm.dto;


import lombok.Data;

/**
 * dto是对从前端接收到的实体类对象进行封装，
 * 不直接使用持久类对象进行接收，
 * 避免数据结构出错。
 */
@Data
public class CartsDto {
    private int userId;
    private int num;
    private int productId;
}
