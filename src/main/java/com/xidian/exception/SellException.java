package com.xidian.exception;

import com.xidian.enums.ResultEnum;

/**
 * Created by zhoukang on 2017/11/21.
 */
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMessage());

        this.code=resultEnum.getCode();
    }
    public SellException(Integer code,String message){
        super((message));
        this.code=code;
    }
}
