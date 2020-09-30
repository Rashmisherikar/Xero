package com.ta.XeroPageObjectModel;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XeroBrowserUtility extends XeroBaseClass{

public WebDriver LaunchBrowser(String sBrowserName, String appURL) {
		
		switch(sBrowserName) { 
		case "ch": 
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "ff": 
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
			default:
				break;
		}
		
		driver.get(appURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		return driver;
	}
	
public Properties loginReadDetails() throws Exception {
	
	String sPath = System.getProperty("user.dir")+"/lib/config.properties";
	Properties prop = new Properties();
	FileInputStream fi = new FileInputStream(sPath);
	prop.load(fi);
	return prop;
		
}
public void CaptureScreenShot(String ScreenShotName) {
	
	try {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./screenshot/"+ScreenShotName+".png")); //. operator refers to current working directory.
		System.out.println("Screenshot taken");
	} catch (Exception e) {
		
		System.out.println("Exception while taking screenshot" +e.getMessage());
	} 
	
}
	
	
public void ExplicitWebDriverWait(WebElement ele,int time) {
		
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(ele));	
		}

public void ufClickElement(WebElement ele) {
	ele.click();
}

public void ufClearElement(WebElement ele) {
	ele.clear();
}

public void ufSendKeys(WebElement ele, String text) {
	ele.sendKeys(text);
}

public void tearDownBrowser() {
	driver.quit();
	}

}
