package com.cx.tel.sales.service.account.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cx.tel.sales.domain.account.AccountInfo;
import com.cx.tel.sales.mapper.account.AccountInfoMapper;
import com.cx.tel.sales.service.account.IAccountInfoService;

/**
 * accountInfo - serviceImpl
 * @author yangjie
 *  功能描述:账户基础信息管理  service impl
 */
@Service
@Transactional
public class  AccountInfoServiceImpl extends ServiceImpl<AccountInfoMapper, AccountInfo> implements IAccountInfoService   {
	
	@Autowired
    private AccountInfoMapper accountInfoMapper;
    /**
	 * select object by uuid
	 * @param uuid
	 * @return Account
	 */
	public AccountInfo selectByUUid(String uuid) {
		return accountInfoMapper.selectByUUid(uuid);
	}
	

}
