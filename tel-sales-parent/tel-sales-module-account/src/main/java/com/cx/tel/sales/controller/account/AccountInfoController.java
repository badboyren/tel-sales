package com.cx.tel.sales.controller.account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.cx.tel.sales.commons.base.controller.BaseController;
import com.cx.tel.sales.commons.enums.ConstantEnum;
import com.cx.tel.sales.commons.exception.BusinessException;
import com.cx.tel.sales.commons.orm.QueryPage;
import com.cx.tel.sales.commons.out.WebResout;
import com.cx.tel.sales.domain.account.AccountInfo;
import com.cx.tel.sales.service.account.IAccountInfoService;


//  manage
//	大家开发的时候,记得把权限参数加上【统一备注写法入口】
//	oauth--start
//	
//	oauth--end
/**
 * accountInfo - 控制器
 * @author yangjie
 *  功能描述:账户基础信息管理  interface define
 */
@Controller
@RequestMapping(value = "/account/accountInfo", method = RequestMethod.POST)
public class AccountInfoController extends BaseController{
	private static final long serialVersionUID = 1L;

	@Autowired
	private IAccountInfoService accountInfoService;

	//分页参数:current=当前页  size=每页显示条数 
	//其他业务参数对应 模型Key
	@RequestMapping(value = "pager", method = RequestMethod.GET)
	@ResponseBody
	public WebResout list(HttpServletRequest request,
						@QueryPage Page<AccountInfo> page, 
						@ModelAttribute AccountInfo accountInfo) throws BusinessException{
		logger.debug("AccountInfoController exe list out={}",page);
		QueryWrapper<AccountInfo> wrapper = new QueryWrapper<AccountInfo>();
        //wrapper.eq("name", account.getName()); //测试业务
		IPage<AccountInfo> pageAccountInfo = accountInfoService.page(page, wrapper);
		return success(request,pageAccountInfo);
	}


//	保存对象：传入必要参数
//	如果有些参数不需要外部传入，开发者自己在方法里面自己初始化数据
	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute AccountInfo accountInfo,
							HttpServletRequest request) throws BusinessException{
		logger.debug("AccountInfoController exe saveObj param={}",accountInfo);
		boolean isSave = accountInfoService.save(accountInfo);
		if(isSave) {
			return success(request);
		}
		return fail(request);
	}


	//  获取满足条件的所有数据 : 自己拼接查询条件
	//  如果不写条件 ，将获取数据库所有数据
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		QueryWrapper<AccountInfo> queryWrapper = new QueryWrapper<AccountInfo>();
		//queryWrapper.eq("name", "张三");
		List<AccountInfo> list =  accountInfoService.list(queryWrapper);
		return success(request,list);
	}
	
//  满足单条数修改：必须传入ID
//  其他业务参数  自己补充控制
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,
					       @ModelAttribute AccountInfo accountInfo) throws BusinessException{
		logger.debug("AccountInfoController exe update?param={}",accountInfo);
		AccountInfo dbAccountInfo = accountInfoService.selectByUUid(accountInfo.getUuid());
		if(dbAccountInfo == null) { //数据不存在或已被删除
			return fail(request, ConstantEnum._FAIL_DATA_NULL);
		}
      boolean isUpdate = accountInfoService.saveOrUpdate(accountInfo);
		if(isUpdate) {
			return success(request);
		}
		return fail(request);
	}
	
}
