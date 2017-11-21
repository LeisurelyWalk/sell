package com.xidian.service.Impl;

import com.xidian.dataobject.OrderDetail;
import com.xidian.dto.OrderDTO;
import com.xidian.enums.OrderStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zhoukang on 2017/11/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String buyerOpenId="110110";
    @Test
    public void create() throws Exception {
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setBuyerAddress("西电");
        orderDTO.setBuyerName("senior");
        orderDTO.setBuyerPhone("8888");
        orderDTO.setBuyerOpenid(buyerOpenId);

        List<OrderDetail> orderDetailList =new ArrayList<>();
        OrderDetail o1=new OrderDetail();
        o1.setProductId("1");
        o1.setProductQuantity(20);
        orderDetailList.add(o1);

        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO orderDTO1=orderService.create(orderDTO);
        log.info("【创建订单】result={}",orderDTO1.toString());
    }

    @Test
    public void findOne() throws Exception {
        OrderDTO orderDTO= orderService.findOne("123456");
        System.out.println(orderDTO.toString());
    }

    @Test
    public void findList() throws Exception {
        PageRequest pageRequest=new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage= orderService.findList(buyerOpenId,pageRequest);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() throws Exception {
        OrderDTO orderDTO= orderService.findOne("123456");
        orderDTO=orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),orderDTO.getOrderStatus());
    }

    @Test
    public void finish() throws Exception {
        OrderDTO orderDTO= orderService.findOne("123456");
        orderDTO=orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISH.getCode(),orderDTO.getOrderStatus());
    }

    @Test
    public void paid() throws Exception {
    }

}