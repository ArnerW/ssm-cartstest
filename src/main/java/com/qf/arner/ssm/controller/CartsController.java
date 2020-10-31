package com.qf.arner.ssm.controller;


import com.qf.arner.ssm.dto.CartsDto;
import com.qf.arner.ssm.entity.Carts;
import com.qf.arner.ssm.response.ResponseEntity;
import com.qf.arner.ssm.sercice.CartsService;
import com.qf.arner.ssm.vo.CartsVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 购物车功能
 * 1.添加购物车
 *      1.1 如果商品已存在，直接数量添加
 *      1.2 如果商品不存在，创建该条记录
 * 2.查看购物车
 * 3.删除购物车
 * 4.修改商品的数量
 * 5.加入收藏夹功能
 *
 */
@RestController
@RequestMapping("/carts")
public class CartsController {

    @Resource
    CartsService cartsService;

    /**
     * 通过用户ID查询购物车
     * @param userId 用户id
     * @return List<Carts> 购物车信息
     */
    @GetMapping("/list")
    public ResponseEntity<List<CartsVo>> selectCartsListByUserId(@RequestParam("userId") int userId){
        try{
            List<CartsVo> cartsVos = cartsService.selectCartsListByUserId(userId);
            return ResponseEntity.success(cartsVos);
        }catch (Exception e){
            return ResponseEntity.error();
        }
    }

    /**
     * 添加商品进购物车
     * @param cartsDto 接收前端发送过来的实体类
     * @return List<Carts> 购物车信息
     */
    @PostMapping("/add")
    public ResponseEntity<Object> addCarts(CartsDto cartsDto){
        try{
            int i = cartsService.addCarts(cartsDto);
            if(i > 0){
                return ResponseEntity.success(true);
            }else {
                return ResponseEntity.error();
            }
        }catch (Exception e){
            return ResponseEntity.error();
        }
    }

    /**
     * 删除购物车
     * @param cartsIds 购物车id
     * @return List<Carts> 购物车信息
     */
    @PutMapping("/del")
    public ResponseEntity<Object> delete(@RequestParam("cartsIds") List<Integer> cartsIds){
        try{
            int i = cartsService.delete(cartsIds);
            if(i > 0){
                return ResponseEntity.success(true);
            }else {
                return ResponseEntity.error();
            }
        }catch (Exception e){
            return ResponseEntity.error();
        }
    }

    /**
     * 修改购物车商品数量
     * @param cartsId 购物车id
     * @param num  产品数量
     * @return List<Carts> 购物车信息
     */
    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestParam("cartsId") int cartsId, @RequestParam("num") int num){
        try{
            int i = cartsService.updateByCartsId(cartsId, num);
            if(i > 0){
                return ResponseEntity.success(true);
            }else {
                return ResponseEntity.error();
            }
        }catch (Exception e){
            return ResponseEntity.error();
        }
    }
}
