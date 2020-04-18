package com.cx.tel.sales.service.customer;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cx.tel.sales.domain.customer.CustomerFollowRecord;

/**
 * customerFollowRecord - service
 * @author yangjie
 *  功能描述:客户跟进记录管理  interface define
 */
public interface ICustomerFollowRecordService extends IService<CustomerFollowRecord>{
	/**
	 * default select object by uuid
	 * @param uuid
	 * @return Account
	 */
	public CustomerFollowRecord selectByUUid(String uuid);
}
