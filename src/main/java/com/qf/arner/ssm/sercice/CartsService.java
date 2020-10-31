package com.qf.arner.ssm.sercice;

import com.qf.arner.ssm.dto.CartsDto;
import com.qf.arner.ssm.vo.CartsVo;

import java.util.List;

public interface CartsService {
    int addCarts(CartsDto cartsDto);
    List<CartsVo> selectCartsListByUserId(int userId);
    int delete(List<Integer> cartsIds);
    int updateByCartsId(int cartsId,int num);
}
