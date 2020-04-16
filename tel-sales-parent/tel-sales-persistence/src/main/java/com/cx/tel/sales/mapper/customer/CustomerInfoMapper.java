package com.cx.tel.sales.mapper.customer;
 
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cx.tel.sales.domain.customer.CustomerInfo;
/**
 * customerInfo - mapper
 * @author yangjie
 *  功能描述:客户基础信息管理
 */
@Mapper
public interface CustomerInfoMapper extends BaseMapper<CustomerInfo>{
	/**
	 * select object by uuid
	 * @param uuid
	 * @return Account
	 */
	public CustomerInfo selectByUUid(String uuid);
}
