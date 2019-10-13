package com.demokart.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demokart.pages.CartPage;
import com.demokart.pages.HomePage;
import com.demokart.pages.LandPage;
import com.demokart.utils.BaseClass;
import com.demokart.utils.DataUtil;
import com.demokart.utils.ReadExcel;

public class KartPageTest extends BaseClass{
	LandPage lp;
	HomePage hp;
	CartPage cp;
	ReadExcel r=new ReadExcel();
	
	@Test(dataProvider="getverifyLoginData",retryAnalyzer=RetryAnalyzer.class)
	public void verifyLogin(String col1,String col2) throws InterruptedException{
		
		initialize("chrome");
		lp=new LandPage();
		hp=new HomePage();
		cp=new CartPage();
		lp.login(p.getProperty("uName"), p.getProperty("pWord"));
		hp.addProductToKart(hp.WomanTab, hp.blousesLink, hp.blouseImg,col1,col2);
		
		hp.kartLink.click();
		Thread.sleep(3000);
		String unitPrcVal=cp.unitPrice.getText();
		String tatolVal=cp.cartTotal.getText();
		String unitprice=unitPrcVal.substring(1);
		System.out.println(unitprice);
		String totalprice=tatolVal.substring(1);
		double actTotal=Double.parseDouble(unitprice)*3;
		Assert.assertEquals(actTotal, Double.parseDouble(totalprice));
		System.out.println(unitPrcVal);
		
	}
	
	@AfterMethod
	public void tearDown(){
		hp.logOut();
	}
	
	@DataProvider
	public Object[][] getverifyLoginData(){
		
		return DataUtil.getData("VerifyTotal", "Sheet1", r);
	}
}
