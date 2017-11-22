package com.xidian.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xidian.dataobject.OrderDetail;
import com.xidian.dto.OrderDTO;
import com.xidian.enums.ResultEnum;
import com.xidian.exception.SellException;
import com.xidian.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoukang on 2017/11/22.
 */
@Slf4j
public class OrderForm2OrderDTOConverter {
    public static OrderDTO convert(OrderForm orderForm){
        Gson gson=new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetaillist=new ArrayList<>();

        try {
            orderDetaillist= gson.fromJson(orderForm.getItems(),new TypeToken<List<OrderDetail>>(){}.getType());
        } catch (Exception e){
            log.error("【对象装换】错误，string={}",orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetaillist);
        return orderDTO;
    }

}
