package com.demokart.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demokart.utils.BaseClass;

public class CartPage extends BaseClass{

	
			@FindBy(xpath="(//span[contains(@id,'product_price')])[2]")
			public WebElement unitPrice;
			
			@FindBy(xpath="//span[contains(@id,'total_product_price')]")
			public WebElement cartTotal;
			
			public CartPage(){
				PageFactory.initElements(driver, this);
			}
}
