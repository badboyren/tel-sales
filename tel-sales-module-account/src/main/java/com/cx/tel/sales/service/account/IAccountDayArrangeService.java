package com.cx.tel.sales.service.account;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cx.tel.sales.domain.account.AccountDayArrange;

/**
 * accountDayArrange - service
 * @author yangjie
 *  功能描述:我的日程管理管理  interface define
 */
public interface IAccountDayArrangeService extends IService<AccountDayArrange>{
	/**
	 * default select object by uuid
	 * @param uuid
	 * @return Account
	 */
	public AccountDayArrange selectByUUid(String uuid);
}
