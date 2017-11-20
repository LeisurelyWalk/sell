package com.xidian.VO;

import lombok.Data;

/**
 * Created by zhoukang on 2017/11/20.
 */
@Data
public class ResultVO<T> {
    private Integer code;
    /*
    提示信息
     */
    private String msg;
    private T data;
}
