package com.cx.tel.sales.commons.orm;

public class TableUtils {
		/**
		 * abc_def ->AbcDef
		 * @param str
		 * @return
		 */
		public static String getTableColumn(String columnName) {
//			String attribute = columnName.toLowerCase().trim();
			String temp = "";
			char[] strs = columnName.toCharArray();
			for(int i=0;i<strs.length;i++) {
				if(strs[i]>='a'&&strs[i]<='z') { //小写字母
				}
			}
//			return attribute;
			return "";
		}
	public static void main(String[] args) {
		System.out.println(TableUtils.getTableColumn("abc_def"));
		
	}
}
