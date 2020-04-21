package com.cx.tel.sales.job;

import org.springframework.stereotype.Component;

@Component
public class TaskJob {
	 /**
	      * 每天   获取终端已发货的终端状态
	  */
//	 @Scheduled(cron="0 0 8 * * ?")
	 public void task1() throws Exception {
		 
	 }
	 
	 /**
	  *分配任务额度
	  */
	// @Scheduled(cron="0 0 8 * * ?")
	 public void task2() throws Exception {
		 
	 }
	 
	 /**
	       * 获取交易数据   清分
	  */
	 public void task3() throws Exception { }
	 /**
	   汇总每个人每月累计交易总额  月结清算
	 */
	 public void task4() throws Exception { }
}
