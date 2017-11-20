package com.xidian.service.Impl;

import com.xidian.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by 伊逍 Senior on 2017/11/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CatetoryServiceImplTest {

    @Autowired
    private CatetoryServiceImpl catetoryService;

    @Test
    public void findOneTest() throws Exception {
        ProductCategory productCategory =catetoryService.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    public void findAll() throws Exception {

    }

    @Test
    public void findByCategoryTypeIn() throws Exception {

    }

    @Test
    public void save() throws Exception {

    }

}