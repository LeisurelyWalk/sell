package com.xidian.DAO;

import com.xidian.dataobject.OrderMaster;
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
public class OrderMasterDaoTest {
    @Autowired
    private OrderMasterDao orderMasterDao;

    @Test
    public void saveTest(){

        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setBuyerAddress("西电");
        orderMaster.setBuyerName("senior");
        orderMaster.setBuyerOpenid("11111");
        orderMaster.setBuyerPhone("66666");
        orderMaster.setOrderAmount(new BigDecimal(11));
        orderMaster.setOrderId("123456");
        orderMasterDao.save(orderMaster);

    }
    @Test
    public void findByBuyerOpenid() throws Exception {
        OrderMaster orderMaster=orderMasterDao.findByBuyerOpenid("11111");
    }

}