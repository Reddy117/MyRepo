package com.demokart.utils;

public class Test {

	public static void main(String[] args) {
		ReadExcel r=new ReadExcel();
	//	System.out.println(r.getCellData("Sheet1", 0, 1));
		DataUtil.getData("TC3", "Sheet1", r);
	}
}


