package com.demokart.utils;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class BaseClass {

	public static WebDriver driver;
	public static FileInputStream f;
	public static Properties p;
	public static Actions a;
	public static void initialize(String browser){
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			
		}else if(browser.equals("ff")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/test/resources/Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		a=new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.get(p.getProperty("url"));
			
	}
	
	public BaseClass(){
		try{
			f=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Config/config.property");
			p=new Properties();
			p.load(f);
		}catch(Exception e){
			
		}
	}
	
	public static void mouseHover(WebElement ele){
		try{
			a.moveToElement(ele).perform();
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
}	