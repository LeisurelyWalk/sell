package com.xidian.utils;

import java.util.Random;

/**
 * Created by zhoukang on 2017/11/21.
 */
public class KeyUtil {
    /*
    生成唯一主键
     */
    public static synchronized String genUniqueKey(){
        Random random=new Random();


        Integer number= random.nextInt(900000)+100000;


        return  System.currentTimeMillis() +String.valueOf(number);

    }
}
