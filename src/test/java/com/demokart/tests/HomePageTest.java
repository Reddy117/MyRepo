
package com.demokart.tests;

import org.testng.annotations.Test;

import com.demokart.pages.HomePage;
import com.demokart.pages.LandPage;
import com.demokart.utils.BaseClass;

public class HomePageTest extends BaseClass{

	LandPage lp;
	HomePage hp;
	@Test(retryAnalyzer=RetryAnalyzer.class)
	public void verifyLogin(){
		
		initialize("chrome");
		lp=new LandPage();
		hp=new HomePage();
		lp.login(p.getProperty("uName"), p.getProperty("pWord"));
		hp.addProductToKart(hp.WomanTab, hp.blousesLink, hp.blouseImg,"2","L");
	}
	
}
