package com.xidian.DAO;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.xidian.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 伊逍 Senior on 2017/11/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {
    @Autowired
    private  ProductCategoryDao productCategoryDao;

    @Test
    public void findOneTest(){
        ProductCategory productCategory=productCategoryDao.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    public void saveTest(){
        ProductCategory productCategory=new ProductCategory("女生最爱",3);
        ProductCategory res=productCategoryDao.save(productCategory);
        System.out.println(res.toString());
    }

    @Test
    public void findByCategoryTypeTest(){
        ProductCategory productCategory=productCategoryDao.findByCategoryType(1);
        System.out.println(productCategory.toString());
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(1,3,4);
        List<ProductCategory> productCategory=productCategoryDao.findByCategoryTypeIn(list);
        System.out.println(productCategory.size());
    }
}