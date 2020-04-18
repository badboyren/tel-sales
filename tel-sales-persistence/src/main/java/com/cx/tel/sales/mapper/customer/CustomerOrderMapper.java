package com.cx.tel.sales.mapper.customer;
 
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cx.tel.sales.domain.customer.CustomerOrder;
/**
 * customerOrder - mapper
 * @author yangjie
 *  功能描述:客户订单管理
 */
@Mapper
public interface CustomerOrderMapper extends BaseMapper<CustomerOrder>{
	/**
	 * select object by uuid
	 * @param uuid
	 * @return Account
	 */
	public CustomerOrder selectByUUid(String uuid);
}
