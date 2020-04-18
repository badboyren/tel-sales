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
import com.cx.tel.sales.service.account.IAccountDayArrangeService;
import com.cx.tel.sales.domain.account.AccountDayArrange;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(value = "accountDayArrangeApi", description = "我的日程管理-对外接口")
@RestController
@RequestMapping("/api/1.0.0/account/accountDayArrange")
public class ApiAccountDayArrangeController extends BaseController {
	private static final long serialVersionUID = 1L;
	@Autowired
	private IAccountDayArrangeService accountDayArrangeService;
	/**
	 * 分页查看
	 */
	@ApiOperation(value = "列表", notes = "查询我的日程管理列表",response=AccountDayArrange.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "没有查找到我的日程管理") })
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "current", value = "当前页", defaultValue = "1", required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "size", value = "每页显示条数，默认10条", defaultValue = "20", required = true, dataType = "int", paramType = "query"), 
		@ApiImplicitParam(name = "orderF", value = "排序字段", dataType = "string", paramType = "query"), 
		@ApiImplicitParam(name = "orderDir", value = "排序方式 ASC|DESC", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "uuid", value = "业务主键UUID", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "arrangeContext", value = "日程备注信息", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "urgencyType", value = "重要程度[1:重要2:普通]", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "startDate", value = "开始时间", dataType = "date-time", paramType = "query"),
		@ApiImplicitParam(name = "endDate", value = "结束时间", dataType = "date-time", paramType = "query"),
		@ApiImplicitParam(name = "accountUuid", value = "创建人UUID", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "parentDeptUuid", value = "上级所属部门UUID", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "customerInput", value = "手动输入客户信息", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "customerJoinUuid", value = "客户关联日程[优先级高]", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "arrangeColor", value = "日志标记颜色[红橙黄绿青蓝紫1234567]", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "deleteIs", value = "是否删除[1:删除0未删除]", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "createTime", value = "创建时间", dataType = "date-time", paramType = "query"),
		@ApiImplicitParam(name = "updateTime", value = "最近更新时间", dataType = "date-time", paramType = "query"),
	})
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public WebResout list(
			HttpServletRequest request,
			@RequestParam(value = "current", defaultValue = "1") int current,
			@RequestParam(value = "size", defaultValue ="10") int size,
			@RequestParam(value = "orderF", required = false) String orderF, 
			@RequestParam(value = "orderDir", required = false) String orderDir,
			AccountDayArrange accountDayArrange) throws BusinessException {
			
			Page<AccountDayArrange> page = new Page<AccountDayArrange>();
			page.setCurrent(current);
			page.setSize(size);
			if(!StringUtils.isEmpty(orderF) && !StringUtils.isEmpty(orderDir)) { //排序字段不为空
				if("ASC".toLowerCase().equals(orderDir.toLowerCase())) {
					page.setAsc(orderF); //支持多字段排序[传入list<String>]
				} else {
					page.setDesc(orderF); //支持多字段排序[传入list<String>]
				}
			}
			QueryWrapper<AccountDayArrange> wrapper = new QueryWrapper<AccountDayArrange>();
	       // wrapper.eq("account", account.getAccount()); //测试业务
			IPage<AccountDayArrange> pageAccountDayArrange = accountDayArrangeService.page(page, wrapper);
			return success(request,pageAccountDayArrange);
	}
}
