package com.Xero.TestCases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Xero.Pages.signUpPage;
import com.relevantcodes.extentreports.LogStatus;
import com.ta.XeroPageObjectModel.XeroBaseClass;

public class signUpTest extends XeroBaseClass{

signUpPage signup;
@BeforeTest
public void triggerDependency() {
	signup = new signUpPage(driver);
}

@BeforeClass
public void freeDemo() {
	signup.Freedemo();
}

@Test(priority=1)
public void signupTestID02A() throws Exception {
	logger = reports.startTest("SignUp TestID02A");
	signup.signUpA();
	logger.log(LogStatus.INFO, "Sign Up Demo TestID02A");
	reports.endTest(logger);
	
	//take a Screenshot using selenium
		TakesScreenshot ts = (TakesScreenshot) driver;//screenshot set up is done.
		File source = ts.getScreenshotAs(OutputType.FILE);//takes the screenshot and saving it to source object.
		String spathOfScreenShot = System.getProperty("user.dir")+"//screenshot/sreenshot_"+"SignUpFreeDemo_"+"TestID02A_"+".png";//path of screenshot.
		File destination = new File(spathOfScreenShot);//file got created
		FileUtils.copyFile(source, destination);//file is copied here.
		logger.log(LogStatus.INFO, "Sign Up Fields Pass");
		logger.log(LogStatus.PASS, logger.addScreenCapture(spathOfScreenShot));//attaching screenshot to extend report.
		
}

@Test(priority=2)
public void signupTestID02B() throws Exception {
	logger = reports.startTest("SignUp TestID02B");
	signup.signUpB();
	logger.log(LogStatus.INFO, "Sign Up Demo TestID02B");
	reports.endTest(logger);
	
	//take a Screenshot using selenium
		TakesScreenshot ts = (TakesScreenshot) driver;//screenshot set up is done.
		File source = ts.getScreenshotAs(OutputType.FILE);//takes the screenshot and saving it to source object.
		String spathOfScreenShot = System.getProperty("user.dir")+"//screenshot/sreenshot_"+"SignUpFreeDemo_"+"TestID02B_"+".png";//path of screenshot.
		File destination = new File(spathOfScreenShot);//file got created
		FileUtils.copyFile(source, destination);//file is copied here.
		logger.log(LogStatus.INFO, "Error Message as we left fields empty");
		logger.log(LogStatus.PASS, logger.addScreenCapture(spathOfScreenShot));//attaching screenshot to extend report.
}

@Test(priority=3)
public void signupTestID02C() throws Exception {
	logger = reports.startTest("SignUp TestID02C");
	signup.signUpC();
	logger.log(LogStatus.INFO, "Sign Up Demo TestID02C");
	reports.endTest(logger);
	
	//take a Screenshot using selenium
		TakesScreenshot ts = (TakesScreenshot) driver;//screenshot set up is done.
		File source = ts.getScreenshotAs(OutputType.FILE);//takes the screenshot and saving it to source object.
		String spathOfScreenShot = System.getProperty("user.dir")+"//screenshot/sreenshot_"+"SignUpFreeDemo_"+"TestID02C_"+".png";//path of screenshot.
		File destination = new File(spathOfScreenShot);//file got created
		FileUtils.copyFile(source, destination);//file is copied here.
		logger.log(LogStatus.INFO, "Terms and Privacy is Sucess");
		logger.log(LogStatus.PASS, logger.addScreenCapture(spathOfScreenShot));//attaching screenshot to extend report.
}

@Test(priority=4)
public void signupTestID02D() throws Exception {
	logger = reports.startTest("SignUp TestID02D");
	signup.signUpD();
	logger.log(LogStatus.INFO, "Sign Up Demo TestID02D");
	reports.endTest(logger);
	
	//take a Screenshot using selenium
		TakesScreenshot ts = (TakesScreenshot) driver;//screenshot set up is done.
		File source = ts.getScreenshotAs(OutputType.FILE);//takes the screenshot and saving it to source object.
		String spathOfScreenShot = System.getProperty("user.dir")+"//screenshot/sreenshot_"+"SignUpFreeDemo_"+"TestID02D_"+".png";//path of screenshot.
		File destination = new File(spathOfScreenShot);//file got created
		FileUtils.copyFile(source, destination);//file is copied here.
		logger.log(LogStatus.INFO, "Offer Details is Sucess");
		logger.log(LogStatus.PASS, logger.addScreenCapture(spathOfScreenShot));//attaching screenshot to extend report.
}

@Test(priority=5)
public void signupTestID02E() throws Exception {
	logger = reports.startTest("SignUp TestID02E");
	signup.signUpE();
	logger.log(LogStatus.INFO, "Sign Up Demo TestID02E");
	reports.endTest(logger);
	
	//take a Screenshot using selenium
		TakesScreenshot ts = (TakesScreenshot) driver;//screenshot set up is done.
		File source = ts.getScreenshotAs(OutputType.FILE);//takes the screenshot and saving it to source object.
		String spathOfScreenShot = System.getProperty("user.dir")+"//screenshot/sreenshot_"+"SignUpFreeDemo_"+"TestID02E_"+".png";//path of screenshot.
		File destination = new File(spathOfScreenShot);//file got created
		FileUtils.copyFile(source, destination);//file is copied here.
		logger.log(LogStatus.INFO, "Accountant and BookKeeper is Sucess");
		logger.log(LogStatus.PASS, logger.addScreenCapture(spathOfScreenShot));//attaching screenshot to extend report.
}
}
