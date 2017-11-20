package com.xidian.controller;

import com.xidian.VO.ProductInfoVO;
import com.xidian.VO.ProductVO;
import com.xidian.VO.ResultVO;
import com.xidian.dataobject.ProductCategory;
import com.xidian.dataobject.ProductInfo;
import com.xidian.service.CatetoryService;
import com.xidian.service.ProductService;
import com.xidian.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * 买家商品
 * Created by zhoukang on 2017/11/20.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CatetoryService catetoryService;

    @GetMapping("/list")
    public ResultVO list(){
        List<ProductInfo> productInfoList=productService.findUpAll();

        List<Integer> categoryTypeList=new ArrayList<>();
        for(ProductInfo productInfo:productInfoList){
            categoryTypeList.add(productInfo.getCategoryType());
        }
        List<ProductCategory>productCategoryList=catetoryService.findByCategoryTypeIn(categoryTypeList);

        List<ProductVO> productVOList=new ArrayList<>();

        for(ProductCategory productCategory:productCategoryList){
            ProductVO productVO=new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO>productInfoVOList=new ArrayList<>();


            for(ProductInfo productInfo:productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO=new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }

            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);

    }
}
