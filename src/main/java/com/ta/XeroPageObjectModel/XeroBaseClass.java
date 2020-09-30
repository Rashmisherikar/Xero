package com.ta.XeroPageObjectModel;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class XeroBaseClass {

	public WebDriver driver;
	public Properties prop;
	public static XeroBrowserUtility oBroUtil = new XeroBrowserUtility();
	public static ExtentReports reports;
	public static ExtentTest logger;
	String sPath = System.getProperty("user.dir")+"/ExtentReports/sampleReportBrowser.html";
	
	
@BeforeSuite
public void launchBrowser() throws Exception {
	reports = new ExtentReports(sPath);
	driver = oBroUtil.LaunchBrowser("ch", "https://www.xero.com/us/");
	prop = oBroUtil.loginReadDetails();
	//driver = oBroUtil.LaunchBrowser("ff", "https://www.xero.com/us/");
	System.out.println(driver.getTitle());
}

@AfterSuite
public void CloseBrowser() {
	oBroUtil.tearDownBrowser();
	reports.flush();
}

}
