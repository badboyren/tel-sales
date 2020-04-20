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
 * accountInfo - domain
 * @author yangjie
 *  功能描述:账户基础信息管理
 */
 @ApiModel(value="accountInfo", description="账户基础信息")
@TableName("account_info")
public class AccountInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	@TableId(value = "uuid",type = IdType.UUID)//uuid strategy
	private String uuid ; //主键业务唯一UUID
	@TableField(value = "ACCOUNT_UUID")
	private String accountUuid ; //登陆账户UUID
	@TableField(value = "HAND_IMG")
	private String handImg ; //用户头像
	@TableField(value = "NIKE_NAME")
	private String nikeName ; //账户昵称
	@TableField(value = "BIRTHDAY")
	private Date birthday ; //员工生日
	@TableField(value = "WEIXIN")
	private String weixin ; //微信号码
	@TableField(value = "JOB_CODE")
	private String jobCode ; //员工工号
	@TableField(value = "JOB_DEPT_UUID")
	private String jobDeptUuid ; //所属部门
	@TableField(value = "JOB_DUTY_KEY")
	private String jobDutyKey ; //工作职务[数据字典职务读取数据]
	@TableField(value = "TEAM_TOP_UUID")
	private String teamTopUuid ; //一级团队名称
	@TableField(value = "JOB_ENTRY_TIME")
	private Date jobEntryTime ; //入职时间
	@TableField(value = "JOB_DIMISSION_TIME")
	private Date jobDimissionTime ; //离职时间
	@TableField(value = "CREATE_TIME")
	private Date createTime ; //创建时间
	@TableField(value = "CREATE_ACCOUNT_UUID")
	private String createAccountUuid ; //创建人UUID
	@TableField(value = "UPDATE_TIME")
	private Date updateTime ; //修改时间
	@TableField(value = "UPDATE_ACCOUNT_UUID")
	private Date updateAccountUuid ; //修改人UUID
	@TableField(value = "HQ_IS")
	private String hqIs ; //是否是总部的账号[1总部0非总部]

	public String getUuid() {
		return this.uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	@ApiModelProperty(value = "登陆账户UUID")
	public String getAccountUuid() {
		return accountUuid;
	}
	public void setAccountUuid(String accountUuid) {
		this.accountUuid = accountUuid;
	}
	@ApiModelProperty(value = "用户头像")
	public String getHandImg() {
		return handImg;
	}
	public void setHandImg(String handImg) {
		this.handImg = handImg;
	}
	@ApiModelProperty(value = "账户昵称")
	public String getNikeName() {
		return nikeName;
	}
	public void setNikeName(String nikeName) {
		this.nikeName = nikeName;
	}
	@ApiModelProperty(value = "员工生日")
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@ApiModelProperty(value = "微信号码")
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	@ApiModelProperty(value = "员工工号")
	public String getJobCode() {
		return jobCode;
	}
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	@ApiModelProperty(value = "所属部门")
	public String getJobDeptUuid() {
		return jobDeptUuid;
	}
	public void setJobDeptUuid(String jobDeptUuid) {
		this.jobDeptUuid = jobDeptUuid;
	}
	@ApiModelProperty(value = "工作职务[数据字典职务读取数据]")
	public String getJobDutyKey() {
		return jobDutyKey;
	}
	public void setJobDutyKey(String jobDutyKey) {
		this.jobDutyKey = jobDutyKey;
	}
	@ApiModelProperty(value = "一级团队名称")
	public String getTeamTopUuid() {
		return teamTopUuid;
	}
	public void setTeamTopUuid(String teamTopUuid) {
		this.teamTopUuid = teamTopUuid;
	}
	@ApiModelProperty(value = "入职时间")
	public Date getJobEntryTime() {
		return jobEntryTime;
	}
	public void setJobEntryTime(Date jobEntryTime) {
		this.jobEntryTime = jobEntryTime;
	}
	@ApiModelProperty(value = "离职时间")
	public Date getJobDimissionTime() {
		return jobDimissionTime;
	}
	public void setJobDimissionTime(Date jobDimissionTime) {
		this.jobDimissionTime = jobDimissionTime;
	}
	@ApiModelProperty(value = "创建时间")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@ApiModelProperty(value = "创建人UUID")
	public String getCreateAccountUuid() {
		return createAccountUuid;
	}
	public void setCreateAccountUuid(String createAccountUuid) {
		this.createAccountUuid = createAccountUuid;
	}
	@ApiModelProperty(value = "修改时间")
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@ApiModelProperty(value = "修改人UUID")
	public Date getUpdateAccountUuid() {
		return updateAccountUuid;
	}
	public void setUpdateAccountUuid(Date updateAccountUuid) {
		this.updateAccountUuid = updateAccountUuid;
	}
	@ApiModelProperty(value = "是否是总部的账号[1总部0非总部]")
	public String getHqIs() {
		return hqIs;
	}
	public void setHqIs(String hqIs) {
		this.hqIs = hqIs;
	}
}