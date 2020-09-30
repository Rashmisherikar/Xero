package com.Xero.TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Xero.Pages.buyNowOrganizationPage;
import com.relevantcodes.extentreports.LogStatus;
import com.ta.XeroPageObjectModel.XeroBaseClass;

public class buyNowOrganizationTest extends XeroBaseClass{

	buyNowOrganizationPage trailOrg;

	@BeforeTest
	public void triggerDependency() {
		trailOrg = new buyNowOrganizationPage(driver);
	}
		 
	@BeforeClass
	public void loginTabClick() throws InterruptedException {
		trailOrg.loginTab();
		trailOrg.LoginUserPassDetails(prop.getProperty("username"), prop.getProperty("password"));
	}
	 
	@Test
	public void trailStartOrganizationTest() throws InterruptedException, IOException {
		logger = reports.startTest("Start Trail Buy Organization Start From Login");
		trailOrg.StartXeroBuyTrial();
		 logger.log(LogStatus.INFO, "Start Trail Buy Click Successful");
			reports.endTest(logger);
			
			//take a Screenshot using selenium
			TakesScreenshot ts = (TakesScreenshot) driver;//screenshot set up is done.
			File source = ts.getScreenshotAs(OutputType.FILE);//takes the screenshot and saving it to source object.
			String spathOfScreenShot = System.getProperty("user.dir")+"//screenshot/sreenshot_"+"StartBuyTrailORG"+".png";//path of screenshot.
			File destination = new File(spathOfScreenShot);//file got created
			FileUtils.copyFile(source, destination);//file is copied here.
			logger.log(LogStatus.INFO, "Trail Organization Start Buy Click Test is passed");
			logger.log(LogStatus.PASS, logger.addScreenCapture(spathOfScreenShot));//attaching screenshot to extend report.	
	}
		 
	}
