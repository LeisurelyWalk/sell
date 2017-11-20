package com.xidian.enums;

import lombok.Getter;

/**
 * Created by zhoukang on 2017/11/20.
 */
@Getter
public enum ProductStatusEnum {
    UP(0,"再架"),
    DOWN(1,"下架")
    ;
    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
