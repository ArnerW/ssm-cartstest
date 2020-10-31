package com.qf.arner.ssm.controller;

import com.qf.arner.ssm.entity.Product;
import com.qf.arner.ssm.sercice.ProductService;
import com.qf.arner.ssm.sercice.impl.ProductServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    ProductServiceImpl productService;

    @GetMapping("/list")
    public List<Product> selectList(){
        List<Product> products =null;
        try {
            products =  productService.selectList();
        }catch (Exception e){

        }
        return products;
    }

}
