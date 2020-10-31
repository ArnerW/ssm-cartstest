package com.qf.arner.ssm.mapper;

import com.qf.arner.ssm.entity.Product;

import java.util.List;

public interface ProductMapper {
    /**
     * 查询所有数据
     * @return
     */
    List<Product> selectList();
}
