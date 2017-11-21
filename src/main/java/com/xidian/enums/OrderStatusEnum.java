package com.xidian.enums;

import lombok.Data;
import lombok.Getter;

/**
 * Created by zhoukang on 2017/11/21.
 */
@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FINISH(1,"完结"),
    CANCEL(2,"取消");

    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
