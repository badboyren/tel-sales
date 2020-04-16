package com.cx.tel.sales.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cx.tel.sales.domain.customer.CustomerInfo;
import com.cx.tel.sales.mapper.customer.CustomerInfoMapper;
import com.cx.tel.sales.service.customer.ICustomerInfoService;

/**
 * customerInfo - serviceImpl
 * @author yangjie
 *  功能描述:客户基础信息管理  service impl
 */
@Service
@Transactional
public class  CustomerInfoServiceImpl extends ServiceImpl<CustomerInfoMapper, CustomerInfo> implements ICustomerInfoService   {
	
	@Autowired
    private CustomerInfoMapper customerInfoMapper;
    /**
	 * select object by uuid
	 * @param uuid
	 * @return Account
	 */
	public CustomerInfo selectByUUid(String uuid) {
		return customerInfoMapper.selectByUUid(uuid);
	}
	

}
