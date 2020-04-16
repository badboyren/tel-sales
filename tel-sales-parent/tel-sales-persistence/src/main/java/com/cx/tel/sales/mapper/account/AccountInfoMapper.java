package com.cx.tel.sales.mapper.account;
 
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cx.tel.sales.domain.account.AccountInfo;
/**
 * accountInfo - mapper
 * @author yangjie
 *  功能描述:账户基础信息管理
 */
@Mapper
public interface AccountInfoMapper extends BaseMapper<AccountInfo>{
	/**
	 * select object by uuid
	 * @param uuid
	 * @return Account
	 */
	public AccountInfo selectByUUid(String uuid);
}
