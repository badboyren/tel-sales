package com.cx.tel.sales.controller.test;

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
import com.cx.tel.sales.domain.account.Account;
import com.cx.tel.sales.service.account.IAccountService;


@Controller
@RequestMapping("/accountTest")
public class AccountTestController extends BaseController{
	
	private static final long serialVersionUID = 1L;
	
//  manage
//	大家开发的时候,记得把权限参数加上【统一备注写法入口】
//	oauth--start
//	
//	oauth--end
	
	@Autowired
	private IAccountService accountService;
//	保存对象：传入必要参数
//	如果有些参数不需要外部传入，开发者自己在方法里面自己初始化数据
//	@PostMapping(value = "save")
//	@ResponseBody
//	public WebResout saveObj(@ModelAttribute Account account,HttpServletRequest request) throws BusinessException{
//		logger.debug("AccountController exe saveObj param={}",account);
//		boolean isSave = accountServcie.save(account);
//		if(isSave) {
//			return success(request);
//		}
//		return fail(request);
//	}
	
//  获取满足条件的所有数据 : 自己拼接查询条件
//  如果不写条件 ，将获取数据库所有数据
//	@GetMapping(value = "listAll")
//	@ResponseBody
//	public WebResout listAll(HttpServletRequest request) throws BusinessException{
//		QueryWrapper<Account> queryWrapper = new QueryWrapper<Account>();
//		queryWrapper.eq("name", "张三");
//		List<Account> list =  accountServcie.list(queryWrapper);
//		return success(request,list);
//	}
	
//  根据ID获取一条数据 : ID参数  外面传入
	@GetMapping(value = "get/{id}")
	@ResponseBody
	public WebResout getByUUID(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("AccountController exe getById?id={}",id);
		Account account = accountService.selectByUUid("rewrwe");
		if(account == null) { //数据不存在或已被删除
			return fail(request, ConstantEnum._FAIL_DATA_NULL);
		}
		logger.debug("AccountController exe getById out={} ",account);
		return success(request,account);
	}
	
//  根据ID删除一条数据 : ID参数  外面传入
//	@DeleteMapping(value = "remove/{id}")
//	@ResponseBody
//	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
//		logger.debug("AccountController exe delete?id={}",id);
//		boolean isRemove = accountServcie.removeById(id);
//		if(isRemove) {
//			return success(request);
//		}
//		logger.debug("PlatOrgInfoController exe delete?id={}",id);
//		return fail(request, ConstantEnum._FAIL);
//	}
//  满足单条数修改：必须传入ID
//  其他业务参数  自己补充控制
//	@PutMapping(value = "update")
//	@ResponseBody
//	public WebResout update(HttpServletRequest request,@ModelAttribute Account account) throws BusinessException{
//		logger.debug("PlatOrgInfoController exe update?baseAd={}",account);
//		Account dbAccount = accountServcie.getById(account.getId());
//		if(dbAccount == null) { //数据不存在或已被删除
//			return fail(request, ConstantEnum._FAIL_DATA_NULL);
//		}
//        boolean isUpdate = accountServcie.saveOrUpdate(account);
//		if(isUpdate) {
//			return success(request);
//		}
//		return fail(request);
//	}
	//分页参数:current=当前页  size=每页显示条数 
	//其他业务参数对应 模型Key
//	@RequestMapping(value = "pager", method = RequestMethod.GET)
//	@ResponseBody
//	public WebResout list(HttpServletRequest request,
//						@QueryPage Page<Account> page, 
//						@ModelAttribute Account account) throws BusinessException{
//		logger.debug("PlatOrgInfoController exe list out={}",page);
//		QueryWrapper<Account> wrapper = new QueryWrapper<Account>();
//      wrapper.eq("name", account.getName()); //测试业务
//		IPage<Account> pageAccount = accountServcie.page(page, wrapper);
//		return success(request,pageAccount);
//	}
}
