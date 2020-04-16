package com.cx.tel.sales.api.customer;

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
import com.cx.tel.sales.service.customer.ICustomerInfoService;
import com.cx.tel.sales.domain.customer.CustomerInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(value = "customerInfoApi", description = "客户基础信息-对外接口")
@RestController
@RequestMapping("/api/1.0.0/customer/customerInfo")
public class ApiCustomerInfoController extends BaseController {
	private static final long serialVersionUID = 1L;
	@Autowired
	private ICustomerInfoService customerInfoService;
	/**
	 * 分页查看
	 */
	@ApiOperation(value = "列表", notes = "查询客户基础信息列表",response=CustomerInfo.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "没有查找到客户基础信息") })
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "current", value = "当前页", defaultValue = "1", required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "size", value = "每页显示条数，默认10条", defaultValue = "20", required = true, dataType = "int", paramType = "query"), 
		@ApiImplicitParam(name = "orderF", value = "排序字段", dataType = "string", paramType = "query"), 
		@ApiImplicitParam(name = "orderDir", value = "排序方式 ASC|DESC", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "uuid", value = "业务主键UUID", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "salesTelAccountUuid", value = "电销账户UUID", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "customerName", value = "客户名称", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "customerWeixin", value = "客户微信", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "cityLevel1", value = "省市区[省]UUID", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "cityLevel1Name", value = "省市区[省]名称", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "cityLevel2", value = "省市区[市]UUID", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "cityLevel2Name", value = "省市区[市]名称", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "cityLevel3", value = "省市区[区]UUID", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "cityLevel3Name", value = "省市区[区]名称", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "detaileAddress", value = "客户详细地址", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "createTime", value = "创建时间", dataType = "date-time", paramType = "query"),
	})
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public WebResout list(
			HttpServletRequest request,
			@RequestParam(value = "current", defaultValue = "1") int current,
			@RequestParam(value = "size", defaultValue ="10") int size,
			@RequestParam(value = "orderF", required = false) String orderF, 
			@RequestParam(value = "orderDir", required = false) String orderDir,
			CustomerInfo customerInfo) throws BusinessException {
			
			Page<CustomerInfo> page = new Page<CustomerInfo>();
			page.setCurrent(current);
			page.setSize(size);
			if(!StringUtils.isEmpty(orderF) && !StringUtils.isEmpty(orderDir)) { //排序字段不为空
				if("ASC".toLowerCase().equals(orderDir.toLowerCase())) {
					page.setAsc(orderF); //支持多字段排序[传入list<String>]
				} else {
					page.setDesc(orderF); //支持多字段排序[传入list<String>]
				}
			}
			QueryWrapper<CustomerInfo> wrapper = new QueryWrapper<CustomerInfo>();
	       // wrapper.eq("account", account.getAccount()); //测试业务
			IPage<CustomerInfo> pageCustomerInfo = customerInfoService.page(page, wrapper);
			return success(request,pageCustomerInfo);
	}
}
