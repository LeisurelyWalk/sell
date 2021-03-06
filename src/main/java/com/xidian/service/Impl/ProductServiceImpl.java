package com.xidian.service.Impl;

import com.xidian.DAO.ProductInfoDao;
import com.xidian.dataobject.ProductInfo;
import com.xidian.dto.CartDTO;
import com.xidian.enums.ProductStatusEnum;
import com.xidian.enums.ResultEnum;
import com.xidian.exception.SellException;
import com.xidian.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by zhoukang on 2017/11/20.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoDao.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoDao.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoDao.save(productInfo);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO:cartDTOList){
            ProductInfo productInfo=productInfoDao.findOne(cartDTO.getProductId());
            if(productInfo==null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result=productInfo.getProductStock()+cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            productInfoDao.save(productInfo);
        }


    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
    for(CartDTO cartDTO:cartDTOList){
        ProductInfo productInfo= productInfoDao.findOne(cartDTO.getProductId());
        if(productInfo==null){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        Integer res=productInfo.getProductStock()-cartDTO.getProductQuantity();
        if(res  < 0){
            throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
        }
        productInfo.setProductStock(res);

        productInfoDao.save(productInfo);
    }
    }
}
