package com.cx.tel.sales.service.account;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cx.tel.sales.domain.account.AccountInfo;

/**
 * accountInfo - service
 * @author yangjie
 *  功能描述:账户基础信息管理  interface define
 */
public interface IAccountInfoService extends IService<AccountInfo>{
	/**
	 * default select object by uuid
	 * @param uuid
	 * @return Account
	 */
	public AccountInfo selectByUUid(String uuid);
}
