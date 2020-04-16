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
 * customerFollowRecord - domain
 * @author yangjie
 *  功能描述:客户跟进记录管理
 */
 @ApiModel(value="customerFollowRecord", description="客户跟进记录")
@TableName("customer_follow_record")
public class CustomerFollowRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	@TableId(value = "uuid",type = IdType.UUID)//uuid strategy
	private String uuid ; //业务主键UUID
	@TableField(value = "ACCOUNT_UUID")
	private String accountUuid ; //添加记录的人
	@TableField(value = "FOLLOW_CONTEXT")
	private String followContext ; //跟进历史
	@TableField(value = "FOLLOW_TYPE_KEY")
	private String followTypeKey ; //标记状态[数据字典key]
	@TableField(value = "FOLLOW_TYPE_VALUE")
	private String followTypeValue ; //标记状态名称[数据字典描述value]
	@TableField(value = "CREATE_TIME")
	private Date createTime ; //创建时间
	@TableField(value = "SALES_TEL_ACCOUNT_UUID")
	private String salesTelAccountUuid ; //电话记录ID

	public String getUuid() {
		return this.uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	@ApiModelProperty(value = "添加记录的人")
	public String getAccountUuid() {
		return accountUuid;
	}
	public void setAccountUuid(String accountUuid) {
		this.accountUuid = accountUuid;
	}
	@ApiModelProperty(value = "跟进历史")
	public String getFollowContext() {
		return followContext;
	}
	public void setFollowContext(String followContext) {
		this.followContext = followContext;
	}
	@ApiModelProperty(value = "标记状态[数据字典key]")
	public String getFollowTypeKey() {
		return followTypeKey;
	}
	public void setFollowTypeKey(String followTypeKey) {
		this.followTypeKey = followTypeKey;
	}
	@ApiModelProperty(value = "标记状态名称[数据字典描述value]")
	public String getFollowTypeValue() {
		return followTypeValue;
	}
	public void setFollowTypeValue(String followTypeValue) {
		this.followTypeValue = followTypeValue;
	}
	@ApiModelProperty(value = "创建时间")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@ApiModelProperty(value = "电话记录ID")
	public String getSalesTelAccountUuid() {
		return salesTelAccountUuid;
	}
	public void setSalesTelAccountUuid(String salesTelAccountUuid) {
		this.salesTelAccountUuid = salesTelAccountUuid;
	}
}