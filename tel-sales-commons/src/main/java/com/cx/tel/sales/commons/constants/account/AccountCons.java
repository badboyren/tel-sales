package com.cx.tel.sales.commons.constants.account;

public class AccountCons {
	
	//所属上级：系统创建
	public enum  accountParentUUID {
		account_state_system("0","系统创建");
		private String val;
		private String desc;
		private accountParentUUID(String val, String desc) {
			this.desc = desc;
			this.val = val;
		}
		public String getVal() {
			return this.val;
		}
		public String getDesc() {
			return this.desc;
		}
	}
	
	//账号状态1:可用2:冻结3:黑名单
	public enum  accountState {
		account_state_ok("1","可用"),
		account_state_lock("2","可用"),
		account_state_black("3","可用");
		private String val;
		private String desc;
		private accountState(String val, String desc) {
			this.desc = desc;
			this.val = val;
		}
		public String getVal() {
			return this.val;
		}
		public String getDesc() {
			return this.desc;
		}
	}
}
