package com.qf.arner.ssm.sercice.impl;

import com.qf.arner.ssm.dto.CartsDto;
import com.qf.arner.ssm.entity.Carts;
import com.qf.arner.ssm.exception.ServiceException;
import com.qf.arner.ssm.mapper.CartsMapper;
import com.qf.arner.ssm.sercice.CartsService;
import com.qf.arner.ssm.utils.ColaBeanUtils;
import com.qf.arner.ssm.vo.CartsVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

import static com.qf.arner.ssm.utils.ErrorStatus.SERVICE_ERROR;

@Service
public class CartsServiceImpl implements CartsService {

    @Resource
    CartsMapper cartsMapper;

    @Override
    public int addCarts(CartsDto cartsDto) {
        /*
        * 两种情况；
        *       1.已存在，改变数量即可
        *       2.不存在，插入
        *           2.1 不存在用户id和产品id同时的信息,插入
        *           2.2 存在状态值为1的信息，修改状态值
        * */
        int temp = 0;
        try{
            Carts carts = cartsMapper.selectByUserIdAndProductId(cartsDto.getUserId(),cartsDto.getProductId(),0);
            if(carts != null){
                int num = carts.getNum()+cartsDto.getNum();
                temp = cartsMapper.updateByCartsId(carts.getCartsId(),num);
            }else {
                Carts carts1 = cartsMapper.selectByUserIdAndProductId(cartsDto.getUserId(), cartsDto.getProductId(), 1);
                if(carts1 != null){
                    int num = carts1.getNum()+cartsDto.getNum();
                    int i = cartsMapper.updateStatus(carts1.getCartsId(), 1, 0);
                    temp = cartsMapper.updateByCartsId(carts1.getCartsId(),num);
                }else{
                    carts = new Carts();
                    /**
                     * 将第一个参数对象中的属性拷贝到第二个参数对象中
                     * 要求：两个对象中的属性名和类型要一样
                     */
                    BeanUtils.copyProperties(cartsDto,carts);
                    temp = cartsMapper.insert(carts);
                }
            }
        }catch (Exception e){
            throw new ServiceException(SERVICE_ERROR.getMessage(), SERVICE_ERROR.getStatus());
        }
        return temp;
    }

    @Override
    public List<CartsVo> selectCartsListByUserId(int userId) {
        List<Carts> carts = cartsMapper.selectListByUserId(userId);
        List<CartsVo> cartsVos = ColaBeanUtils.copyListProperties(carts, CartsVo::new);
        return cartsVos;
    }

    @Override
    public int delete(List<Integer> cartsIds) {
        int temp = 0;
        for (Integer cartsId:cartsIds) {
            int i = cartsMapper.updateStatus(cartsId, 0, 1);
            temp++;
        }
        return temp;
    }

    @Override
    public int updateByCartsId(int cartsId, int num) {
        int i = cartsMapper.updateByCartsId(cartsId, num);
        return i;
    }

}
