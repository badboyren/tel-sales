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
import com.cx.tel.sales.service.customer.ICustomerFollowRecordService;
import com.cx.tel.sales.domain.customer.CustomerFollowRecord;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(value = "customerFollowRecordApi", description = "客户跟进记录-对外接口")
@RestController
@RequestMapping("/api/1.0.0/customer/customerFollowRecord")
public class ApiCustomerFollowRecordController extends BaseController {
	private static final long serialVersionUID = 1L;
	@Autowired
	private ICustomerFollowRecordService customerFollowRecordService;
	/**
	 * 分页查看
	 */
	@ApiOperation(value = "列表", notes = "查询客户跟进记录列表",response=CustomerFollowRecord.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "没有查找到客户跟进记录") })
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "current", value = "当前页", defaultValue = "1", required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "size", value = "每页显示条数，默认10条", defaultValue = "20", required = true, dataType = "int", paramType = "query"), 
		@ApiImplicitParam(name = "orderF", value = "排序字段", dataType = "string", paramType = "query"), 
		@ApiImplicitParam(name = "orderDir", value = "排序方式 ASC|DESC", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "uuid", value = "业务主键UUID", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "accountUuid", value = "添加记录的人", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "followContext", value = "跟进历史", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "followTypeKey", value = "标记状态[数据字典key]", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "followTypeValue", value = "标记状态名称[数据字典描述value]", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "createTime", value = "创建时间", dataType = "date-time", paramType = "query"),
		@ApiImplicitParam(name = "salesTelAccountUuid", value = "电话记录ID", dataType = "string", paramType = "query"),
	})
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public WebResout list(
			HttpServletRequest request,
			@RequestParam(value = "current", defaultValue = "1") int current,
			@RequestParam(value = "size", defaultValue ="10") int size,
			@RequestParam(value = "orderF", required = false) String orderF, 
			@RequestParam(value = "orderDir", required = false) String orderDir,
			CustomerFollowRecord customerFollowRecord) throws BusinessException {
			
			Page<CustomerFollowRecord> page = new Page<CustomerFollowRecord>();
			page.setCurrent(current);
			page.setSize(size);
			if(!StringUtils.isEmpty(orderF) && !StringUtils.isEmpty(orderDir)) { //排序字段不为空
				if("ASC".toLowerCase().equals(orderDir.toLowerCase())) {
					page.setAsc(orderF); //支持多字段排序[传入list<String>]
				} else {
					page.setDesc(orderF); //支持多字段排序[传入list<String>]
				}
			}
			QueryWrapper<CustomerFollowRecord> wrapper = new QueryWrapper<CustomerFollowRecord>();
	       // wrapper.eq("account", account.getAccount()); //测试业务
			IPage<CustomerFollowRecord> pageCustomerFollowRecord = customerFollowRecordService.page(page, wrapper);
			return success(request,pageCustomerFollowRecord);
	}
}
