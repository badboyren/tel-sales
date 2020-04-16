package com.cx.tel.sales.service.account.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cx.tel.sales.domain.account.AccountDayArrange;
import com.cx.tel.sales.mapper.account.AccountDayArrangeMapper;
import com.cx.tel.sales.service.account.IAccountDayArrangeService;

/**
 * accountDayArrange - serviceImpl
 * @author yangjie
 *  功能描述:我的日程管理管理  service impl
 */
@Service
@Transactional
public class  AccountDayArrangeServiceImpl extends ServiceImpl<AccountDayArrangeMapper, AccountDayArrange> implements IAccountDayArrangeService   {
	
	@Autowired
    private AccountDayArrangeMapper accountDayArrangeMapper;
    /**
	 * select object by uuid
	 * @param uuid
	 * @return Account
	 */
	public AccountDayArrange selectByUUid(String uuid) {
		return accountDayArrangeMapper.selectByUUid(uuid);
	}
	

}
