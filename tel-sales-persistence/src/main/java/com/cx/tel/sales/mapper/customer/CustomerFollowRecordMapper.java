package com.cx.tel.sales.mapper.customer;
 
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cx.tel.sales.domain.customer.CustomerFollowRecord;
/**
 * customerFollowRecord - mapper
 * @author yangjie
 *  功能描述:客户跟进记录管理
 */
@Mapper
public interface CustomerFollowRecordMapper extends BaseMapper<CustomerFollowRecord>{
	/**
	 * select object by uuid
	 * @param uuid
	 * @return Account
	 */
	public CustomerFollowRecord selectByUUid(String uuid);
}
