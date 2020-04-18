package com.cx.tel.sales.api.account;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cx.tel.sales.commons.base.controller.BaseController;
import com.cx.tel.sales.commons.exception.BusinessException;
import com.cx.tel.sales.commons.out.WebResout;
import com.cx.tel.sales.service.account.IAccountInfoService;
import com.cx.tel.sales.domain.account.AccountInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(value = "accountInfoApi", description = "账户基础信息-对外接口")
@RestController
@RequestMapping("/api/1.0.0/account/accountInfo")
public class ApiAccountInfoController extends BaseController {
	private static final long serialVersionUID = 1L;
	@Autowired
	private IAccountInfoService accountInfoService;
	/**
	 * 分页查看
	 */
	@ApiOperation(value = "列表", notes = "查询账户基础信息列表",response=AccountInfo.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "没有查找到账户基础信息") })
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "current", value = "当前页", defaultValue = "1", required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "size", value = "每页显示条数，默认10条", defaultValue = "20", required = true, dataType = "int", paramType = "query"), 
		@ApiImplicitParam(name = "orderF", value = "排序字段", dataType = "string", paramType = "query"), 
		@ApiImplicitParam(name = "orderDir", value = "排序方式 ASC|DESC", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "uuid", value = "主键业务唯一UUID", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "accountUuid", value = "登陆账户UUID", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "handImg", value = "用户头像", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "nikeName", value = "账户昵称", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "birthday", value = "员工生日", dataType = "date-time", paramType = "query"),
		@ApiImplicitParam(name = "weixin", value = "微信号码", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "jobCode", value = "员工工号", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "jobDeptUuid", value = "所属部门", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "jobDutyKey", value = "工作职务[数据字典职务读取数据]", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "teamTopUuid", value = "一级团队名称", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "jobEntryTime", value = "入职时间", dataType = "date-time", paramType = "query"),
		@ApiImplicitParam(name = "jobDimissionTime", value = "离职时间", dataType = "date-time", paramType = "query"),
		@ApiImplicitParam(name = "createTime", value = "创建时间", dataType = "date-time", paramType = "query"),
		@ApiImplicitParam(name = "createAccountUuid", value = "创建人UUID", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "updateTime", value = "修改时间", dataType = "date-time", paramType = "query"),
		@ApiImplicitParam(name = "updateAccountUuid", value = "修改人UUID", dataType = "date-time", paramType = "query"),
		@ApiImplicitParam(name = "hqIs", value = "是否是总部的账号[1总部0非总部]", dataType = "string", paramType = "query"),
	})
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public WebResout list(
			HttpServletRequest request,
			@RequestParam(value = "current", defaultValue = "1") int current,
			@RequestParam(value = "size", defaultValue ="10") int size,
			@RequestParam(value = "orderF", required = false) String orderF, 
			@RequestParam(value = "orderDir", required = false) String orderDir,
			AccountInfo accountInfo) throws BusinessException {
			
			Page<AccountInfo> page = new Page<AccountInfo>();
			page.setCurrent(current);
			page.setSize(size);
			if(!StringUtils.isEmpty(orderF) && !StringUtils.isEmpty(orderDir)) { //排序字段不为空
				if("ASC".toLowerCase().equals(orderDir.toLowerCase())) {
					page.setAsc(orderF); //支持多字段排序[传入list<String>]
				} else {
					page.setDesc(orderF); //支持多字段排序[传入list<String>]
				}
			}
			QueryWrapper<AccountInfo> wrapper = new QueryWrapper<AccountInfo>();
	       // wrapper.eq("account", account.getAccount()); //测试业务
			IPage<AccountInfo> pageAccountInfo = accountInfoService.page(page, wrapper);
			return success(request,pageAccountInfo);
	}
}
