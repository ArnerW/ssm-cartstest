package com.qf.arner.ssm.vo;

import lombok.Data;

/**
 * vo为包装底层持久类的一个类
 * 对数据进行包装处理，保证不暴露原表的结构
 */
@Data
public class CartsVo {
    private Integer cartsId;

    private Integer num;

    private Integer productId;

    private Integer userId;

    private Integer status;
}
