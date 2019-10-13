package com.demokart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demokart.utils.BaseClass;

public class LandPage extends BaseClass{

	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	public WebElement signLink;
	
	@FindBy(xpath="//*[@id=\"email\"]")
	public WebElement emailTxt;
	
	@FindBy(xpath="//*[@id=\"passwd\"]")
	public WebElement passWordtxt;
	
	@FindBy(xpath="//*[@id=\"SubmitLogin\"]")
	public WebElement signbtn;
	
	public LandPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void login(String uName,String pWord){
		try{
			signLink.click();
			emailTxt.sendKeys(uName);
			passWordtxt.sendKeys(pWord);
			signbtn.click();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
