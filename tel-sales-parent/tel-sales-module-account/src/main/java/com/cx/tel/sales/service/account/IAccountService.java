package com.cx.tel.sales.service.account;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cx.tel.sales.domain.account.Account;

/**
 * account - service
 * @author yangjie
 *  功能描述:登陆账户管理  interface define
 */
public interface IAccountService extends IService<Account>{
	/**
	 * default select object by uuid
	 * @param uuid
	 * @return Account
	 */
	public Account selectByUUid(String uuid);
	
	//登陆
	public Account login(String account,String password);
	//初始化账户
	public Account createAccountInit(String account,String password);
	//验证账户是否存在
	public Account checkAccount(String account);
	//修改账户密码
	public void chargeAccountPwd(String account,String pwd1,String pwd2,String code);
}
