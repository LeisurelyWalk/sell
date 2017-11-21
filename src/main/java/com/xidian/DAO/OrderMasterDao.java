package com.xidian.DAO;

import com.xidian.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhoukang on 2017/11/21.
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster,String>{

    OrderMaster findByBuyerOpenid(String buyerOpenId);
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenId, Pageable pageable);
}
