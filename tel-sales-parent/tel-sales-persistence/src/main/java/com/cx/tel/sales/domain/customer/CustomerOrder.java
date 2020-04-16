package com.cx.tel.sales.domain.customer;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * customerOrder - domain
 * @author yangjie
 *  功能描述:客户订单管理
 */
 @ApiModel(value="customerOrder", description="客户订单")
@TableName("customer_order")
public class CustomerOrder implements Serializable {
	private static final long serialVersionUID = 1L;
	@TableId(value = "uuid",type = IdType.UUID)//uuid strategy
	private String uuid ; //业务主键UUID
	@TableField(value = "SALES_TEL_ACCOUNT_UUID")
	private String salesTelAccountUuid ; //电销电话uuid
	@TableField(value = "CUSTOMER_UUID")
	private String customerUuid ; //那个用户uuid
	@TableField(value = "ACCOUNT_UUID")
	private String accountUuid ; //销售员UUID
	@TableField(value = "TEAM_UUID")
	private String teamUuid ; //所属总团队ID
	@TableField(value = "PARENT_DEPT_UUID")
	private String parentDeptUuid ; //所属部门UUID
	@TableField(value = "ORDER_NO")
	private String orderNo ; //业务订单号
	@TableField(value = "ORDER_TIME")
	private Date orderTime ; //订单时间
	@TableField(value = "ORDER_STATE")
	private String orderState ; //订单状态:[1待发货2已发货]
	@TableField(value = "MPOS_SNO")
	private String mposSno ; //pos机序列码[确定终端信息]

	public String getUuid() {
		return this.uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	@ApiModelProperty(value = "电销电话uuid")
	public String getSalesTelAccountUuid() {
		return salesTelAccountUuid;
	}
	public void setSalesTelAccountUuid(String salesTelAccountUuid) {
		this.salesTelAccountUuid = salesTelAccountUuid;
	}
	@ApiModelProperty(value = "那个用户uuid")
	public String getCustomerUuid() {
		return customerUuid;
	}
	public void setCustomerUuid(String customerUuid) {
		this.customerUuid = customerUuid;
	}
	@ApiModelProperty(value = "销售员UUID")
	public String getAccountUuid() {
		return accountUuid;
	}
	public void setAccountUuid(String accountUuid) {
		this.accountUuid = accountUuid;
	}
	@ApiModelProperty(value = "所属总团队ID")
	public String getTeamUuid() {
		return teamUuid;
	}
	public void setTeamUuid(String teamUuid) {
		this.teamUuid = teamUuid;
	}
	@ApiModelProperty(value = "所属部门UUID")
	public String getParentDeptUuid() {
		return parentDeptUuid;
	}
	public void setParentDeptUuid(String parentDeptUuid) {
		this.parentDeptUuid = parentDeptUuid;
	}
	@ApiModelProperty(value = "业务订单号")
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	@ApiModelProperty(value = "订单时间")
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	@ApiModelProperty(value = "订单状态:[1待发货2已发货]")
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	@ApiModelProperty(value = "pos机序列码[确定终端信息]")
	public String getMposSno() {
		return mposSno;
	}
	public void setMposSno(String mposSno) {
		this.mposSno = mposSno;
	}
}