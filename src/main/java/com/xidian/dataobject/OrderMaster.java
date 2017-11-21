package com.xidian.dataobject;

import com.xidian.enums.OrderStatusEnum;
import com.xidian.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by zhoukang on 2017/11/21.
 */
@Entity
@DynamicUpdate
@Data
public class OrderMaster {
    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus= OrderStatusEnum.NEW.getCode();

    private Integer payStatus= PayStatusEnum.WAIT.getCode();

    private Date createTime;

    private Date updateTime;
}
