package com.cx.tel.sales.service.account.impl;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.tel.sales.commons.components.redis.RedisUtils;
import com.cx.tel.sales.commons.constants.account.AccountCons;
import com.cx.tel.sales.commons.constants.redis.RedisKeys;
import com.cx.tel.sales.commons.global.GlobalMsgThrowException;
import com.cx.tel.sales.commons.utils.sign.MD5Util;
import com.cx.tel.sales.domain.account.Account;
import com.cx.tel.sales.mapper.account.AccountMapper;
import com.cx.tel.sales.service.account.IAccountService;

/**
 * account - serviceImpl
 * @author yangjie
 *  功能描述:登陆账户管理  service impl
 */
@Service
@Transactional
public class  AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService   {
	
	@Autowired
    private AccountMapper accountMapper;
	@Autowired
	private RedisUtils redisUtils;
    /**
	 * select object by uuid
	 * @param uuid
	 * @return Account
	 */
	public Account selectByUUid(String uuid) {
		return accountMapper.selectByUUid(uuid);
	}
	@Override
	public Account createAccountInit(String account, String password) {
		Account acc = new Account();
		acc.setAccount(account);
		
		String[] pw = MD5Util.generatePasswd(password, account);
		acc.setPassword(pw[0]);
		acc.setSalt(pw[1]);
		acc.setState(AccountCons.accountState.account_state_ok.getVal());
		acc.setCreateTime(new Date());
		acc.setParentUuid(AccountCons.accountParentUUID.account_state_system.getVal());
		accountMapper.insert(acc);
		
		return acc;
	}
	
	//登陆
	@Override
	public Account login(String account, String password) {
		QueryWrapper<Account> queryWrapper = new QueryWrapper<Account>();
		queryWrapper.eq("account", account);
		Account dbOne = accountMapper.selectOne(queryWrapper);
		if(dbOne == null) {
			GlobalMsgThrowException.busServerExp("账户不存在,请检查账户");
		}
		String salt = dbOne.getAccount() + dbOne.getSalt();
		String pwd = MD5Util.decipherPasswd(password, salt);
		if (!pwd.equals(dbOne.getPassword())) { //
			GlobalMsgThrowException.busServerExp("用户名或密码错误");
		} 
		
		//设置redis cache
		String redisKey = RedisKeys.redis_app_login_user + dbOne.getUuid();
		redisUtils.set(redisKey, dbOne.getUuid(),
				RedisKeys.redis_app_login_user_time, TimeUnit.MINUTES); //设置token
		
		return dbOne; 
	}
	@Override
	public Account checkAccount(String account) {
		QueryWrapper<Account> queryWrapper = new QueryWrapper<Account>();
		queryWrapper.eq("account", account);
		Account dbOne = accountMapper.selectOne(queryWrapper);
		if(dbOne == null) {
			GlobalMsgThrowException.busServerExp("账户不存在,请检查账户");
		}
		return dbOne;
	}
	@Override
	public void chargeAccountPwd(String account, String pwd1, String pwd2, String code) {
		
		if(StringUtils.isEmpty(pwd1) || StringUtils.isEmpty(pwd2)) {
			GlobalMsgThrowException.busServerExp("pwd1或pwd2不能为空");
		
		}
		if(!pwd1.equals(pwd2)) {
			GlobalMsgThrowException.busServerExp("两次密码不成一致");
		}
		
		QueryWrapper<Account> queryWrapper = new QueryWrapper<Account>();
		queryWrapper.eq("account", account);
		Account dbOne = accountMapper.selectOne(queryWrapper);
		if(dbOne == null) {
			GlobalMsgThrowException.busServerExp("账户不存在,请检查账户");
		}
		try {
			//修改密码
			String[] pw = MD5Util.generatePasswd(pwd1, account);
			Account upAccount = new Account();
			upAccount.setPassword(pw[0]);
			upAccount.setSalt(pw[1]);
			
			UpdateWrapper<Account> updateWrapper = new UpdateWrapper<Account>();
			updateWrapper.eq("uuid", dbOne.getUuid());
			int upId = accountMapper.update(upAccount, updateWrapper);
			if(upId > 0) {
				//清空验证码缓存
				String redisKey = RedisKeys.redis_account_sms_ + account ;
				redisUtils.remove(redisKey);
			}
		} catch (Exception e) {
			e.printStackTrace();
			GlobalMsgThrowException.busServerExp("密码修改失败，请稍后再试");
		}
	}
}
