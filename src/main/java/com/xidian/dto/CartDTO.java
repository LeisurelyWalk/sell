package com.xidian.dto;

import lombok.Data;

/**
 * Created by zhoukang on 2017/11/21.
 */
@Data
public class CartDTO {
    private String productId;
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
