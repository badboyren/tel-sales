package com.cx.tel.sales.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cx.tel.sales.domain.customer.CustomerOrder;
import com.cx.tel.sales.mapper.customer.CustomerOrderMapper;
import com.cx.tel.sales.service.customer.ICustomerOrderService;

/**
 * customerOrder - serviceImpl
 * @author yangjie
 *  功能描述:客户订单管理  service impl
 */
@Service
@Transactional
public class  CustomerOrderServiceImpl extends ServiceImpl<CustomerOrderMapper, CustomerOrder> implements ICustomerOrderService   {
	
	@Autowired
    private CustomerOrderMapper customerOrderMapper;
    /**
	 * select object by uuid
	 * @param uuid
	 * @return Account
	 */
	public CustomerOrder selectByUUid(String uuid) {
		return customerOrderMapper.selectByUUid(uuid);
	}
	

}
