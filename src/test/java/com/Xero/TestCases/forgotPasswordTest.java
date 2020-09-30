package com.Xero.TestCases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Xero.Pages.forgotPasswordPage;
import com.relevantcodes.extentreports.LogStatus;
import com.ta.XeroPageObjectModel.XeroBaseClass;

public class forgotPasswordTest extends XeroBaseClass{

forgotPasswordPage forgotPass;
@BeforeTest
public void triggerDependency() {
	forgotPass = new forgotPasswordPage(driver);
}

@BeforeClass
public void clickLoginTab() {
	forgotPass.loginTab();
}

@Test
public void TestForgotPassword() throws Exception {
	logger = reports.startTest("ForgotPassword");
	forgotPass.forgotpassword();
	logger.log(LogStatus.INFO, "Forgot Password Success");
	reports.endTest(logger);
	
	//take a Screenshot using selenium
		TakesScreenshot ts = (TakesScreenshot) driver;//screenshot set up is done.
		File source = ts.getScreenshotAs(OutputType.FILE);//takes the screenshot and saving it to source object.
		String spathOfScreenShot = System.getProperty("user.dir")+"//screenshot/sreenshot_"+"ForgotPassword"+".png";//path of screenshot.
		File destination = new File(spathOfScreenShot);//file got created
		FileUtils.copyFile(source, destination);//file is copied here.
		logger.log(LogStatus.INFO, "login test case is passed");
		logger.log(LogStatus.PASS, logger.addScreenCapture(spathOfScreenShot));//attaching screenshot to extend report.
}
}
 