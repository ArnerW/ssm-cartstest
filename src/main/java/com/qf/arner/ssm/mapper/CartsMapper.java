package com.qf.arner.ssm.mapper;

import com.qf.arner.ssm.entity.Carts;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CartsMapper {
    /**
     * 添加购物车
     * @param carts 购物车类
     * @return
     */
    int insert(@Param("carts") Carts carts);

    /**
     * 根据用户id和产品id查询
     * @param userId 用户id
     * @param productId 产品id
     * @return
     */
    Carts selectByUserIdAndProductId(@Param("userId") int userId,@Param("productId") int productId,@Param("status") int status);

    /**
     * 根据购物车id更新商品数量
     * @param cartsId 购物车id
     * @param num 商品数量
     * @return
     */
    int updateByCartsId(@Param("cartsId") int cartsId,@Param("num") int num);

    /**
     * 修改状态值
     * @param cartsId 购物车id
     * @param num1 原状态值
     * @param num2 目标状态值
     * @return
     */
    int updateStatus(@Param("cartsId") int cartsId,@Param("num1") int num1,@Param("num2") int num2);

    /**
     * 根据用户id查看购物车
     * @param userId 用户id
     * @return
     */
    List<Carts> selectListByUserId(@Param("userId") int userId);

}
