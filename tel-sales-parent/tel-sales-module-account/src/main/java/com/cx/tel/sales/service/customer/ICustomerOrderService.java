package com.cx.tel.sales.service.customer;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cx.tel.sales.domain.customer.CustomerOrder;

/**
 * customerOrder - service
 * @author yangjie
 *  功能描述:客户订单管理  interface define
 */
public interface ICustomerOrderService extends IService<CustomerOrder>{
	/**
	 * default select object by uuid
	 * @param uuid
	 * @return Account
	 */
	public CustomerOrder selectByUUid(String uuid);
}
