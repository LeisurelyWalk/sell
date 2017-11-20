package com.xidian.DAO;

import com.xidian.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by 伊逍 Senior on 2017/11/18.
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer> {
    ProductCategory findByCategoryType(Integer categoryType);
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
