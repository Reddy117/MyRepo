package com.demokart.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.demokart.utils.BaseClass;

public class HomePage extends BaseClass{

	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	public WebElement myAccLabel;
	
	@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[1]/a")
	public WebElement WomanTab;
	
	@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[2]/a")
	public WebElement blousesLink;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
	public WebElement blouseImg;
	
	@FindBy(xpath="//*[@id=\"quantity_wanted\"]")
	public WebElement qtyText;
	
	@FindBy(xpath="//*[@id=\"group_1\"]")
	public WebElement sizeDrop;
	
	@FindBy(xpath="//*[@id=\"add_to_cart\"]/button/span")
	public WebElement addKartbtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[1]/span")
	public WebElement closeBtn;
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
	List<WebElement> logOutbtn;
	@FindBy(xpath="//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
	public WebElement kartLink;
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public void addProductToKart(WebElement ele1,WebElement ele2,WebElement ele3,String qty,String size){
		try{
			mouseHover(WomanTab);
			Thread.sleep(2000);
			blousesLink.click();
			blouseImg.click();
			Thread.sleep(2000);
			driver.switchTo().frame(0);
			qtyText.clear();
			qtyText.sendKeys(qty);
			new Select(sizeDrop).selectByVisibleText(size);
			
			Thread.sleep(3000);
			addKartbtn.click();
			Thread.sleep(2000);
			closeBtn.click();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void logOut(){
		try{
		if(logOutbtn.size()>0){
			logOutbtn.get(0).click();
		}
		driver.quit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
