package com.demokart.utils;

public class DataUtil {

	public static Object[][] getData(String tcName,String sheetName,ReadExcel r){
		int tcStartRow=0;
		
		while(!r.getCellData(sheetName, 0, tcStartRow).equals(tcName)){
			//System.out.println(r.getCellData(sheetName, 0, tcStartRow));
			tcStartRow++;
		}
		System.out.println(tcStartRow);
		
		int cols=0;
		int colStartRow=tcStartRow+1;
		while(!r.getCellData(sheetName, cols, colStartRow).equals("N")){
			//System.out.println(r.getCellData(sheetName, 0, tcStartRow));
			cols++;
		}
		System.out.println(cols);
		
		int rows=0;
		int dataStartRow=tcStartRow+2;
		while(!r.getCellData(sheetName, 0, dataStartRow+rows).equals("N")){
			//System.out.println(r.getCellData(sheetName, 0, tcStartRow));
			rows++;
		}
		System.out.println(rows);
		Object[][] data=new Object[rows][cols];		
		int index=0;
		for(int rNum=dataStartRow;rNum<dataStartRow+rows;rNum++){
			for(int cNum=0;cNum<cols;cNum++){
				//System.out.print(r.getCellData("Sheet1", cNum, rNum)+"-- ");
				data[index][cNum]=r.getCellData(sheetName, cNum, rNum);
			}
			index++;
			System.out.println();
		}
		
		return data;
		
	}
	
}
