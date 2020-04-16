package com.cx.tel.sales.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cx.tel.sales.domain.customer.CustomerFollowRecord;
import com.cx.tel.sales.mapper.customer.CustomerFollowRecordMapper;
import com.cx.tel.sales.service.customer.ICustomerFollowRecordService;

/**
 * customerFollowRecord - serviceImpl
 * @author yangjie
 *  功能描述:客户跟进记录管理  service impl
 */
@Service
@Transactional
public class  CustomerFollowRecordServiceImpl extends ServiceImpl<CustomerFollowRecordMapper, CustomerFollowRecord> implements ICustomerFollowRecordService   {
	
	@Autowired
    private CustomerFollowRecordMapper customerFollowRecordMapper;
    /**
	 * select object by uuid
	 * @param uuid
	 * @return Account
	 */
	public CustomerFollowRecord selectByUUid(String uuid) {
		return customerFollowRecordMapper.selectByUUid(uuid);
	}
	

}
