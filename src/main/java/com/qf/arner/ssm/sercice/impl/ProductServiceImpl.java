package com.qf.arner.ssm.sercice.impl;

import com.qf.arner.ssm.entity.Product;
import com.qf.arner.ssm.mapper.ProductMapper;
import com.qf.arner.ssm.sercice.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    ProductMapper productMapper;
    @Override
    public List<Product> selectList() {
        List<Product> products = null;
        try {
            products = productMapper.selectList();
        }catch (Exception e){

        }
        return products;
    }
}
