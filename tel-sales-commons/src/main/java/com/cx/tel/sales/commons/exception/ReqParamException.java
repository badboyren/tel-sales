package com.cx.tel.sales.commons.exception;

/**
     *  缺少请求参数错误
  */
public class ReqParamException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	protected int expCode;
	protected String expMsg;

	public ReqParamException(int expCode, String expMsg) {
		this.expCode = expCode;
		this.expMsg = expMsg;
	}

	public int getExpCode() {
		return expCode;
	}

	public void setExpCode(int expCode) {
		this.expCode = expCode;
	}

	public String getExpMsg() {
		return expMsg;
	}

	public void setExpMsg(String expMsg) {
		this.expMsg = expMsg;
	}

	@Override
	public String toString() {
		return "ReqParamException [expCode=" + expCode + ", expMsg=" + expMsg + "]";
	}
}
