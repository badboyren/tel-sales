package com.cx.tel.sales.service.customer;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cx.tel.sales.domain.customer.CustomerInfo;

/**
 * customerInfo - service
 * @author yangjie
 *  功能描述:客户基础信息管理  interface define
 */
public interface ICustomerInfoService extends IService<CustomerInfo>{
	/**
	 * default select object by uuid
	 * @param uuid
	 * @return Account
	 */
	public CustomerInfo selectByUUid(String uuid);
}
