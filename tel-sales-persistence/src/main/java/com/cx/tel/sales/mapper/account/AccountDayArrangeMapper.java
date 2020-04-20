package com.cx.tel.sales.mapper.account;
 
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cx.tel.sales.domain.account.AccountDayArrange;
/**
 * accountDayArrange - mapper
 * @author yangjie
 *  功能描述:我的日程管理管理
 */
@Mapper
public interface AccountDayArrangeMapper extends BaseMapper<AccountDayArrange>{
	/**
	 * select object by uuid
	 * @param uuid
	 * @return Account
	 */
	public AccountDayArrange selectByUUid(String uuid);
}
