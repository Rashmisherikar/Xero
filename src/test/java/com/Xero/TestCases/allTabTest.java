package com.Xero.TestCases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Xero.Pages.allTabPage;
import com.relevantcodes.extentreports.LogStatus;
import com.ta.XeroPageObjectModel.XeroBaseClass;

public class allTabTest extends XeroBaseClass{
	allTabPage allTab;
@BeforeTest
public void triggerDependency() {
	allTab = new allTabPage(driver);
}

@BeforeClass
public void loginTabClick() throws InterruptedException {
	allTab.loginTab();
	allTab.LoginUserPassDetails(prop.getProperty("username"), prop.getProperty("password"));
}

@Test
public void validateTrailMessage() {
	String TrailMessage = allTab.validateTrailMessage();
	Assert.assertEquals(TrailMessage, "You’re on a free 30-day trial that includes all features.");
}

@Test
public void AllTabTest() throws Exception {
	logger = reports.startTest("All Tabs Test Start From Login");
	allTab.allTabs();
	logger.log(LogStatus.INFO, "All Tabs Click Successful");
	reports.endTest(logger);
	
	//take a Screenshot using selenium
	TakesScreenshot ts = (TakesScreenshot) driver;//screenshot set up is done.
	File source = ts.getScreenshotAs(OutputType.FILE);//takes the screenshot and saving it to source object.
	String spathOfScreenShot = System.getProperty("user.dir")+"//screenshot/sreenshot_"+"AllTabs"+".png";//path of screenshot.
	File destination = new File(spathOfScreenShot);//file got created
	FileUtils.copyFile(source, destination);//file is copied here.
	logger.log(LogStatus.INFO, "All Tabs Click Test is passed");
	logger.log(LogStatus.PASS, logger.addScreenCapture(spathOfScreenShot));//attaching screenshot to extend report.	
}
}
