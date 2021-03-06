package com.xidian.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
/**
 * Created by 伊逍 Senior on 2017/11/18.
 */
@Entity
@DynamicUpdate
@Data
public class ProductCategory {
    /* 类目id*/
    @Id
    @GeneratedValue
    private Integer categoryId;
    /* 类目名字*/
    private String categoryName;
    /* 类目编号*/
    private Integer categoryType;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public ProductCategory(){

    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryType=" + categoryType +
                '}';
    }
}
