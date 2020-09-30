package com.Xero.TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Xero.Pages.uploadUserProfileImagePage;
import com.relevantcodes.extentreports.LogStatus;
import com.ta.XeroPageObjectModel.XeroBaseClass;

public class uploadUserProfileImageTest extends XeroBaseClass{

	uploadUserProfileImagePage profileimg;
@BeforeTest
public void triggerDependency() {
	profileimg = new uploadUserProfileImagePage(driver);
}

@BeforeClass
public void loginTabClick() throws InterruptedException {
	profileimg.loginTab();
	profileimg.LoginUserPassDetails(prop.getProperty("username"), prop.getProperty("password"));
}

@Test
public void uplaodImage() throws Exception {
	 logger = reports.startTest("Profile Image Test Start From Login");
	profileimg.ProfileNameClick();
	 logger.log(LogStatus.INFO, "Profile Image Click Successful");
		reports.endTest(logger);
		 
		//take a Screenshot using selenium
		TakesScreenshot ts = (TakesScreenshot) driver;//screenshot set up is done.
		File source = ts.getScreenshotAs(OutputType.FILE);//takes the screenshot and saving it to source object.
		String spathOfScreenShot = System.getProperty("user.dir")+"//screenshot/sreenshot_"+"UserImage"+".png";//path of screenshot.
		File destination = new File(spathOfScreenShot);//file got created
		FileUtils.copyFile(source, destination);//file is copied here.
		logger.log(LogStatus.INFO, "Logout User Click Test is passed");
		logger.log(LogStatus.PASS, logger.addScreenCapture(spathOfScreenShot));//attaching screenshot to extend report.
}
}
