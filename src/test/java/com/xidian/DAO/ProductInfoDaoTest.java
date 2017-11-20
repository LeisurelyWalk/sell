package com.xidian.DAO;

import com.xidian.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zhoukang on 2017/11/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Test
    public void saveTest(){

        ProductInfo productInfo =new ProductInfo();
        productInfo.setProductId("1");
        productInfo.setProductName("皮皮粥");
        productInfo.setCategoryType(1);
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(200);
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductDescription("很好吃");
        productInfo.setProductStatus(0);
        productInfoDao.save(productInfo);


    }
    @Test
    public void findByProductStatus() throws Exception {
     List<ProductInfo> list=productInfoDao.findByProductStatus(0);
    }

}