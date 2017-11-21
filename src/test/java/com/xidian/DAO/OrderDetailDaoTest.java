package com.xidian.DAO;

import com.xidian.dataobject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by zhoukang on 2017/11/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {
    @Autowired
    private OrderDetailDao orderDetailDao;
    @Test
    public void saveTest(){
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("123123");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("http://xxxxx.jpg");
        orderDetail.setProductId("12");
        orderDetail.setProductName("皮皮虾");
        orderDetail.setProductPrice(new BigDecimal(3.2));
        orderDetail.setProductQuantity(2);
        orderDetailDao.save(orderDetail);
    }

}