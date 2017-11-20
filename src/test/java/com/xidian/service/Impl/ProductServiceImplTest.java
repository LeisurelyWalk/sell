package com.xidian.service.Impl;

import com.xidian.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zhoukang on 2017/11/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() throws Exception {
        ProductInfo productInfo = productService.findOne("1");
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> productInfoList =productService.findUpAll();
    }

    @Test
    public void findAll() throws Exception {
        PageRequest request=new PageRequest(0,2);
        Page<ProductInfo> productInfoPage =productService.findAll(request);

    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo =new ProductInfo();
        productInfo.setProductId("12");
        productInfo.setProductName("皮皮虾");
        productInfo.setCategoryType(1);
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(200);
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductDescription("也很好吃");
        productInfo.setProductStatus(1);
        productService.save(productInfo);

    }

}