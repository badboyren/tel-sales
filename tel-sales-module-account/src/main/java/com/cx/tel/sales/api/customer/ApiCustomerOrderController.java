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
import com.cx.tel.sales.service.customer.ICustomerOrderService;
import com.cx.tel.sales.domain.customer.CustomerOrder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(value = "customerOrderApi", description = "客户订单-对外接口")
@RestController
@RequestMapping("/api/1.0.0/customer/customerOrder")
public class ApiCustomerOrderController extends BaseController {
	private static final long serialVersionUID = 1L;
	@Autowired
	private ICustomerOrderService customerOrderService;
	/**
	 * 分页查看
	 */
	@ApiOperation(value = "列表", notes = "查询客户订单列表",response=CustomerOrder.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "没有查找到客户订单") })
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "current", value = "当前页", defaultValue = "1", required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "size", value = "每页显示条数，默认10条", defaultValue = "20", required = true, dataType = "int", paramType = "query"), 
		@ApiImplicitParam(name = "orderF", value = "排序字段", dataType = "string", paramType = "query"), 
		@ApiImplicitParam(name = "orderDir", value = "排序方式 ASC|DESC", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "uuid", value = "业务主键UUID", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "salesTelAccountUuid", value = "电销电话uuid", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "customerUuid", value = "那个用户uuid", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "accountUuid", value = "销售员UUID", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "teamUuid", value = "所属总团队ID", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "parentDeptUuid", value = "所属部门UUID", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "orderNo", value = "业务订单号", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "orderTime", value = "订单时间", dataType = "date-time", paramType = "query"),
		@ApiImplicitParam(name = "orderState", value = "订单状态:[1待发货2已发货]", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "mposSno", value = "pos机序列码[确定终端信息]", dataType = "string", paramType = "query"),
	})
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public WebResout list(
			HttpServletRequest request,
			@RequestParam(value = "current", defaultValue = "1") int current,
			@RequestParam(value = "size", defaultValue ="10") int size,
			@RequestParam(value = "orderF", required = false) String orderF, 
			@RequestParam(value = "orderDir", required = false) String orderDir,
			CustomerOrder customerOrder) throws BusinessException {
			
			Page<CustomerOrder> page = new Page<CustomerOrder>();
			page.setCurrent(current);
			page.setSize(size);
			if(!StringUtils.isEmpty(orderF) && !StringUtils.isEmpty(orderDir)) { //排序字段不为空
				if("ASC".toLowerCase().equals(orderDir.toLowerCase())) {
					page.setAsc(orderF); //支持多字段排序[传入list<String>]
				} else {
					page.setDesc(orderF); //支持多字段排序[传入list<String>]
				}
			}
			QueryWrapper<CustomerOrder> wrapper = new QueryWrapper<CustomerOrder>();
	       // wrapper.eq("account", account.getAccount()); //测试业务
			IPage<CustomerOrder> pageCustomerOrder = customerOrderService.page(page, wrapper);
			return success(request,pageCustomerOrder);
	}
}
