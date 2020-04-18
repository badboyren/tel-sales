package com.cx.tel.sales.mapper.account;
 
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cx.tel.sales.domain.account.Account;
/**
 * account - mapper
 * @author yangjie
 *  功能描述:登陆账户管理
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account>{
	/**
	 * select object by uuid
	 * @param uuid
	 * @return Account
	 */
	public Account selectByUUid(String uuid);
}
