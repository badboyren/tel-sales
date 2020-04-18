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
 * customerInfo - domain
 * @author yangjie
 *  功能描述:客户基础信息管理
 */
 @ApiModel(value="customerInfo", description="客户基础信息")
@TableName("customer_info")
public class CustomerInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	@TableId(value = "uuid",type = IdType.UUID)//uuid strategy
	private String uuid ; //业务主键UUID
	@TableField(value = "SALES_TEL_ACCOUNT_UUID")
	private String salesTelAccountUuid ; //电销账户UUID
	@TableField(value = "CUSTOMER_NAME")
	private String customerName ; //客户名称
	@TableField(value = "CUSTOMER_WEIXIN")
	private String customerWeixin ; //客户微信
	@TableField(value = "CITY_LEVEL_1")
	private String cityLevel1 ; //省市区[省]UUID
	@TableField(value = "CITY_LEVEL_1_NAME")
	private String cityLevel1Name ; //省市区[省]名称
	@TableField(value = "CITY_LEVEL_2")
	private String cityLevel2 ; //省市区[市]UUID
	@TableField(value = "CITY_LEVEL_2_NAME")
	private String cityLevel2Name ; //省市区[市]名称
	@TableField(value = "CITY_LEVEL_3")
	private String cityLevel3 ; //省市区[区]UUID
	@TableField(value = "CITY_LEVEL_3_NAME")
	private String cityLevel3Name ; //省市区[区]名称
	@TableField(value = "DETAILE_ADDRESS")
	private String detaileAddress ; //客户详细地址
	@TableField(value = "CREATE_TIME")
	private Date createTime ; //创建时间

	public String getUuid() {
		return this.uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	@ApiModelProperty(value = "电销账户UUID")
	public String getSalesTelAccountUuid() {
		return salesTelAccountUuid;
	}
	public void setSalesTelAccountUuid(String salesTelAccountUuid) {
		this.salesTelAccountUuid = salesTelAccountUuid;
	}
	@ApiModelProperty(value = "客户名称")
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@ApiModelProperty(value = "客户微信")
	public String getCustomerWeixin() {
		return customerWeixin;
	}
	public void setCustomerWeixin(String customerWeixin) {
		this.customerWeixin = customerWeixin;
	}
	@ApiModelProperty(value = "省市区[省]UUID")
	public String getCityLevel1() {
		return cityLevel1;
	}
	public void setCityLevel1(String cityLevel1) {
		this.cityLevel1 = cityLevel1;
	}
	@ApiModelProperty(value = "省市区[省]名称")
	public String getCityLevel1Name() {
		return cityLevel1Name;
	}
	public void setCityLevel1Name(String cityLevel1Name) {
		this.cityLevel1Name = cityLevel1Name;
	}
	@ApiModelProperty(value = "省市区[市]UUID")
	public String getCityLevel2() {
		return cityLevel2;
	}
	public void setCityLevel2(String cityLevel2) {
		this.cityLevel2 = cityLevel2;
	}
	@ApiModelProperty(value = "省市区[市]名称")
	public String getCityLevel2Name() {
		return cityLevel2Name;
	}
	public void setCityLevel2Name(String cityLevel2Name) {
		this.cityLevel2Name = cityLevel2Name;
	}
	@ApiModelProperty(value = "省市区[区]UUID")
	public String getCityLevel3() {
		return cityLevel3;
	}
	public void setCityLevel3(String cityLevel3) {
		this.cityLevel3 = cityLevel3;
	}
	@ApiModelProperty(value = "省市区[区]名称")
	public String getCityLevel3Name() {
		return cityLevel3Name;
	}
	public void setCityLevel3Name(String cityLevel3Name) {
		this.cityLevel3Name = cityLevel3Name;
	}
	@ApiModelProperty(value = "客户详细地址")
	public String getDetaileAddress() {
		return detaileAddress;
	}
	public void setDetaileAddress(String detaileAddress) {
		this.detaileAddress = detaileAddress;
	}
	@ApiModelProperty(value = "创建时间")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}