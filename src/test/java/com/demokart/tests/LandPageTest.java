package com.demokart.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demokart.pages.HomePage;
import com.demokart.pages.LandPage;
import com.demokart.utils.BaseClass;

public class LandPageTest extends BaseClass{
	LandPage lp;
	HomePage hp;
	
	@BeforeMethod
	public void openApp(){
		initialize("chrome");
		lp=new LandPage();
		hp=new HomePage();
	}
	//@Test
	public void verifyLogin(){
		
		lp.login(p.getProperty("uName"), p.getProperty("pWord"));
	}
	
	@Test(retryAnalyzer=RetryAnalyzer.class)
	public void getLandPageTitle(){
		String title=driver.getTitle();
		Assert.assertEquals(true, false);
	}
	
	@AfterMethod
	public void tearDown(){
		hp.logOut();
	}
}
