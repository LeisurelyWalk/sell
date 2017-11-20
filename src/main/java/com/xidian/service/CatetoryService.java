package com.xidian.service;

import com.xidian.dataobject.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 伊逍 Senior on 2017/11/19.
 */
public interface CatetoryService {
    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeIn(List<Integer>categoryType);
    ProductCategory save(ProductCategory productCategory);

}
