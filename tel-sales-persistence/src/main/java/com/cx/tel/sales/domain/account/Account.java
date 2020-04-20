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
 * account - domain
 * @author yangjie
 *  功能描述:登陆账户管理
 */
 @ApiModel(value="account", description="登陆账户")
@TableName("account")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	@TableId(value = "uuid",type = IdType.UUID)//uuid strategy
	private String uuid ; //主键ID
	@TableField(value = "ACCOUNT")
	private String account ; //登陆账户[手机号]
	@TableField(value = "PASSWORD")
	private String password ; //登陆密码
	@TableField(value = "SALT")
	private String salt ; //盐值
	@TableField(value = "STATE")
	private String state ; //账号状态1:可用2:冻结3:黑名单
	@TableField(value = "CREATE_TIME")
	private Date createTime ; //创建时间
	@TableField(value = "FIRST_LOGIN_TIME")
	private Date firstLoginTime ; //第一次登陆时间
	@TableField(value = "LAST_LOGIN_TIME")
	private Date lastLoginTime ; //最近一次登陆时间
	@TableField(value = "PARENT_UUID")
	private String parentUuid ; //账号的上级[谁给的账号]
	@TableField(value = "REST_PASSWORD")
	private String restPassword ; //是否重置过密码[1:是0否]
	@TableField(value = "HQ_IS")
	private String hqIs ; //是否是总部的账号[1总部0非总部]
	@TableField(value = "ACCOUNT_LEVEL")
	private String accountLevel ; //账户级别[1总部2团长3部门经理4组长5职员]

	public String getUuid() {
		return this.uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	@ApiModelProperty(value = "登陆账户[手机号]")
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	@ApiModelProperty(value = "登陆密码")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@ApiModelProperty(value = "盐值")
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	@ApiModelProperty(value = "账号状态1:可用2:冻结3:黑名单")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@ApiModelProperty(value = "创建时间")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@ApiModelProperty(value = "第一次登陆时间")
	public Date getFirstLoginTime() {
		return firstLoginTime;
	}
	public void setFirstLoginTime(Date firstLoginTime) {
		this.firstLoginTime = firstLoginTime;
	}
	@ApiModelProperty(value = "最近一次登陆时间")
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	@ApiModelProperty(value = "账号的上级[谁给的账号]")
	public String getParentUuid() {
		return parentUuid;
	}
	public void setParentUuid(String parentUuid) {
		this.parentUuid = parentUuid;
	}
	@ApiModelProperty(value = "是否重置过密码[1:是0否]")
	public String getRestPassword() {
		return restPassword;
	}
	public void setRestPassword(String restPassword) {
		this.restPassword = restPassword;
	}
	@ApiModelProperty(value = "是否是总部的账号[1总部0非总部]")
	public String getHqIs() {
		return hqIs;
	}
	public void setHqIs(String hqIs) {
		this.hqIs = hqIs;
	}
	@ApiModelProperty(value = "账户级别[1总部2团长3部门经理4组长5职员]")
	public String getAccountLevel() {
		return accountLevel;
	}
	public void setAccountLevel(String accountLevel) {
		this.accountLevel = accountLevel;
	}
}