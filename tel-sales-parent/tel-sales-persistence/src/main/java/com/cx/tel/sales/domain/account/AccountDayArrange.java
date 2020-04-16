package com.cx.tel.sales.domain.account;

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
 * accountDayArrange - domain
 * @author yangjie
 *  功能描述:我的日程管理管理
 */
 @ApiModel(value="accountDayArrange", description="我的日程管理")
@TableName("account_day_arrange")
public class AccountDayArrange implements Serializable {
	private static final long serialVersionUID = 1L;
	@TableId(value = "uuid",type = IdType.UUID)//uuid strategy
	private String uuid ; //业务主键UUID
	@TableField(value = "ARRANGE_CONTEXT")
	private String arrangeContext ; //日程备注信息
	@TableField(value = "URGENCY_TYPE")
	private String urgencyType ; //重要程度[1:重要2:普通]
	@TableField(value = "START_DATE")
	private Date startDate ; //开始时间
	@TableField(value = "END_DATE")
	private Date endDate ; //结束时间
	@TableField(value = "ACCOUNT_UUID")
	private String accountUuid ; //创建人UUID
	@TableField(value = "PARENT_DEPT_UUID")
	private String parentDeptUuid ; //上级所属部门UUID
	@TableField(value = "CUSTOMER_INPUT")
	private String customerInput ; //手动输入客户信息
	@TableField(value = "CUSTOMER_JOIN_UUID")
	private String customerJoinUuid ; //客户关联日程[优先级高]
	@TableField(value = "ARRANGE_COLOR")
	private String arrangeColor ; //日志标记颜色[红橙黄绿青蓝紫1234567]
	@TableField(value = "DELETE_IS")
	private String deleteIs ; //是否删除[1:删除0未删除]
	@TableField(value = "CREATE_TIME")
	private Date createTime ; //创建时间
	@TableField(value = "UPDATE_TIME")
	private Date updateTime ; //最近更新时间

	public String getUuid() {
		return this.uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	@ApiModelProperty(value = "日程备注信息")
	public String getArrangeContext() {
		return arrangeContext;
	}
	public void setArrangeContext(String arrangeContext) {
		this.arrangeContext = arrangeContext;
	}
	@ApiModelProperty(value = "重要程度[1:重要2:普通]")
	public String getUrgencyType() {
		return urgencyType;
	}
	public void setUrgencyType(String urgencyType) {
		this.urgencyType = urgencyType;
	}
	@ApiModelProperty(value = "开始时间")
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@ApiModelProperty(value = "结束时间")
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@ApiModelProperty(value = "创建人UUID")
	public String getAccountUuid() {
		return accountUuid;
	}
	public void setAccountUuid(String accountUuid) {
		this.accountUuid = accountUuid;
	}
	@ApiModelProperty(value = "上级所属部门UUID")
	public String getParentDeptUuid() {
		return parentDeptUuid;
	}
	public void setParentDeptUuid(String parentDeptUuid) {
		this.parentDeptUuid = parentDeptUuid;
	}
	@ApiModelProperty(value = "手动输入客户信息")
	public String getCustomerInput() {
		return customerInput;
	}
	public void setCustomerInput(String customerInput) {
		this.customerInput = customerInput;
	}
	@ApiModelProperty(value = "客户关联日程[优先级高]")
	public String getCustomerJoinUuid() {
		return customerJoinUuid;
	}
	public void setCustomerJoinUuid(String customerJoinUuid) {
		this.customerJoinUuid = customerJoinUuid;
	}
	@ApiModelProperty(value = "日志标记颜色[红橙黄绿青蓝紫1234567]")
	public String getArrangeColor() {
		return arrangeColor;
	}
	public void setArrangeColor(String arrangeColor) {
		this.arrangeColor = arrangeColor;
	}
	@ApiModelProperty(value = "是否删除[1:删除0未删除]")
	public String getDeleteIs() {
		return deleteIs;
	}
	public void setDeleteIs(String deleteIs) {
		this.deleteIs = deleteIs;
	}
	@ApiModelProperty(value = "创建时间")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@ApiModelProperty(value = "最近更新时间")
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}