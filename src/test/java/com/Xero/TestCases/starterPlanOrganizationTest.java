package com.Xero.TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Xero.Pages.starterPlanOrganizationPage;
import com.relevantcodes.extentreports.LogStatus;
import com.ta.XeroPageObjectModel.XeroBaseClass;

public class starterPlanOrganizationTest extends XeroBaseClass{

	starterPlanOrganizationPage trailOrg;

	@BeforeTest
	public void triggerDependency() {
		trailOrg = new starterPlanOrganizationPage(driver);
	}
		 
	@BeforeClass
	public void loginTabClick() throws InterruptedException {
		trailOrg.loginTab();
		trailOrg.LoginUserPassDetails(prop.getProperty("username"), prop.getProperty("password"));
	}
	 
	@Test(priority=1)
	public void trailBuyPlanOrganizationTest() throws InterruptedException, IOException {
		logger = reports.startTest("Start Trail Buy Organization Start From Login");
		trailOrg.StartXeroBuyStarterPlanTrial();
		 logger.log(LogStatus.INFO, "Start Trail Buy Starter Plan Click Successful");
			reports.endTest(logger);
			
			//take a Screenshot using selenium
			TakesScreenshot ts = (TakesScreenshot) driver;//screenshot set up is done.
			File source = ts.getScreenshotAs(OutputType.FILE);//takes the screenshot and saving it to source object.
			String spathOfScreenShot = System.getProperty("user.dir")+"//screenshot/sreenshot_"+"StartTrailBuyStarterPlanTrailORGTEST08C"+".png";//path of screenshot.
			File destination = new File(spathOfScreenShot);//file got created
			FileUtils.copyFile(source, destination);//file is copied here.
			logger.log(LogStatus.INFO, "Trail Organization Start Buy Click Test is passed");
			logger.log(LogStatus.PASS, logger.addScreenCapture(spathOfScreenShot));//attaching screenshot to extend report.	
	}
	
	@Test(priority=2)
	public void trailbuyStarterPlanOrgTest() throws IOException {
		logger = reports.startTest("Start Trail Buy Starter Plan Organization Start From Login");
		trailOrg.StarterPlanEarly();
		logger.log(LogStatus.INFO, "Start Trail Buy Starter Plan Click Successful");
		reports.endTest(logger);
		
		//take a Screenshot using selenium
		TakesScreenshot ts = (TakesScreenshot) driver;//screenshot set up is done.
		File source = ts.getScreenshotAs(OutputType.FILE);//takes the screenshot and saving it to source object.
		String spathOfScreenShot = System.getProperty("user.dir")+"//screenshot/sreenshot_"+"StartTrialStarterPlanTrailORGTEST08C"+".png";//path of screenshot.
		File destination = new File(spathOfScreenShot);//file got created
		FileUtils.copyFile(source, destination);//file is copied here.
		logger.log(LogStatus.INFO, "Trail Organization Start Buy Starter Plan Click Test is passed");
		logger.log(LogStatus.PASS, logger.addScreenCapture(spathOfScreenShot));//attaching screenshot to extend report.	
	}
	
	@Test(priority=3)
	public void CreateNewBillingAccountTest() throws InterruptedException, IOException {
		logger = reports.startTest("Start Trail Create New Account Start From Login");
		trailOrg.CreateNewBillingAccount();
		logger.log(LogStatus.INFO, "Start Trail Create New Account Click Successful");
		reports.endTest(logger);
		
		//take a Screenshot using selenium
		TakesScreenshot ts = (TakesScreenshot) driver;//screenshot set up is done.
		File source = ts.getScreenshotAs(OutputType.FILE);//takes the screenshot and saving it to source object.
		String spathOfScreenShot = System.getProperty("user.dir")+"//screenshot/sreenshot_"+"StartTrialCreateAccountTrailORGTEST08C"+".png";//path of screenshot.
		File destination = new File(spathOfScreenShot);//file got created
		FileUtils.copyFile(source, destination);//file is copied here.
		logger.log(LogStatus.INFO, "Trail Organization Start Buy Starter Plan Click Test is passed");
		logger.log(LogStatus.PASS, logger.addScreenCapture(spathOfScreenShot));//attaching screenshot to extend report.	
	}
	
	@Test(priority=4)
	public void CreditCardDetailsTest() throws InterruptedException, IOException {
		logger = reports.startTest("Star Trail Credit Card Details From Login");
		trailOrg.CreditCardDetails();
		logger.log(LogStatus.INFO, "Start Trail Credit Card Click Successful");
		reports.endTest(logger);
		
		//take a Screenshot using selenium
		TakesScreenshot ts = (TakesScreenshot) driver;//screenshot set up is done.
		File source = ts.getScreenshotAs(OutputType.FILE);//takes the screenshot and saving it to source object.
		String spathOfScreenShot = System.getProperty("user.dir")+"//screenshot/sreenshot_"+"StartTrialCreditCardTrailORGTEST08C"+".png";//path of screenshot.
		File destination = new File(spathOfScreenShot);//file got created
		FileUtils.copyFile(source, destination);//file is copied here.
		logger.log(LogStatus.INFO, "Trail Organization Start Credit Card Details Click Test is passed");
		logger.log(LogStatus.PASS, logger.addScreenCapture(spathOfScreenShot));//attaching screenshot to extend report.	
	}
		 
	}

