package com.cx.tel.sales.commons.utils.exception;

import com.cx.tel.sales.commons.enums.ConstantEnum;
import com.cx.tel.sales.commons.exception.ServiceException;

/**
 * 全局提示异常
 */
public class GlobalMsgThrowException {
	public static void busServerExp(String msg) {
		throw new ServiceException(ConstantEnum._bus_SERVER_ERROR.getVal(),
				String.format(ConstantEnum._bus_SERVER_ERROR.getDesc(), msg));
	
	}
}
