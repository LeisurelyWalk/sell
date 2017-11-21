package com.xidian.converter;

import com.xidian.dataobject.OrderMaster;
import com.xidian.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zhoukang on 2017/11/21.
 */
public class OrderMaster2OrderDTOConverter {
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);

        return orderDTO;
    }

    public  static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        List<OrderDTO>orderDTOList= orderMasterList.stream().map(e -> convert(e)).collect(Collectors.toList());

        return orderDTOList;
    }
}
