package com.xidian.controller;

import com.xidian.VO.ResultVO;
import com.xidian.converter.OrderForm2OrderDTOConverter;
import com.xidian.dto.OrderDTO;
import com.xidian.enums.ResultEnum;
import com.xidian.exception.SellException;
import com.xidian.form.OrderForm;
import com.xidian.service.OrderService;
import com.xidian.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhoukang on 2017/11/22.
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;
    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确，orderFrom={}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO= OrderForm2OrderDTOConverter.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】 购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);

        }
        OrderDTO creatResult= orderService.create(orderDTO);
        Map<String,String>map= new HashMap<>();
        map.put("orderId",creatResult.getOrderId());

        return ResultVOUtil.success(map);
    }

    //订单列表

    //订单详情

    //取消订单
}
