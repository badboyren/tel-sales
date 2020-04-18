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
import com.cx.tel.sales.service.account.IAccountService;
import com.cx.tel.sales.domain.account.Account;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(value = "accountApi", description = "登陆账户-对外接口")
@RestController
@RequestMapping("/api/1.0.0/account/account")
public class ApiAccountController extends BaseController {
	private static final long serialVersionUID = 1L;
	@Autowired
	private IAccountService accountService;
	/**
	 * 分页查看
	 */
	@ApiOperation(value = "列表", notes = "查询登陆账户列表",response=Account.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "没有查找到登陆账户") })
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "current", value = "当前页", defaultValue = "1", required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "size", value = "每页显示条数，默认10条", defaultValue = "20", required = true, dataType = "int", paramType = "query"), 
		@ApiImplicitParam(name = "orderF", value = "排序字段", dataType = "string", paramType = "query"), 
		@ApiImplicitParam(name = "orderDir", value = "排序方式 ASC|DESC", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "uuid", value = "主键ID", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "account", value = "登陆账户[手机号]", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "password", value = "登陆密码", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "salt", value = "盐值", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "state", value = "账号状态1:可用2:冻结3:黑名单", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "createTime", value = "创建时间", dataType = "date-time", paramType = "query"),
		@ApiImplicitParam(name = "firstLoginTime", value = "第一次登陆时间", dataType = "date-time", paramType = "query"),
		@ApiImplicitParam(name = "lastLoginTime", value = "最近一次登陆时间", dataType = "date-time", paramType = "query"),
		@ApiImplicitParam(name = "parentUuid", value = "账号的上级[谁给的账号]", dataType = "string", paramType = "query"),
	})
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public WebResout list(
			HttpServletRequest request,
			@RequestParam(value = "current", defaultValue = "1") int current,
			@RequestParam(value = "size", defaultValue ="10") int size,
			@RequestParam(value = "orderF", required = false) String orderF, 
			@RequestParam(value = "orderDir", required = false) String orderDir,
			Account account) throws BusinessException {
			
			Page<Account> page = new Page<Account>();
			page.setCurrent(current);
			page.setSize(size);
			if(!StringUtils.isEmpty(orderF) && !StringUtils.isEmpty(orderDir)) { //排序字段不为空
				if("ASC".toLowerCase().equals(orderDir.toLowerCase())) {
					page.setAsc(orderF); //支持多字段排序[传入list<String>]
				} else {
					page.setDesc(orderF); //支持多字段排序[传入list<String>]
				}
			}
			QueryWrapper<Account> wrapper = new QueryWrapper<Account>();
	        wrapper.eq("account", account.getAccount()); //测试业务
			IPage<Account> pageAccount = accountService.page(page, wrapper);
			return success(request,pageAccount);
	}
}
