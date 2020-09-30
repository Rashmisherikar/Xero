package com.Xero.TestCases;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Xero.Pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;
import com.ta.XeroPageObjectModel.XeroBaseClass;

public class loginTest extends XeroBaseClass {

loginPage ologin;
@BeforeTest
public void triggerXeroDependency() {
	ologin = new loginPage(driver);
}

@BeforeClass
public void clickLoginTab() {
	ologin.loginTab();
}

@Test(dataProvider = "loginUserDataDetails")
public void logingIntoBrowserWithTestData(String loginUserName, String loginPassword, String sXpath) throws Exception {
	
	ologin = new loginPage(driver);
	logger = reports.startTest("logingIntoBrowser_"+loginUserName+"_"+loginPassword);
	
	ologin.loginpageXero(loginUserName,loginPassword);
	logger.log(LogStatus.INFO, "Login Successful");
	oBroUtil.ExplicitWebDriverWait(driver.findElement(By.xpath(sXpath)),500);
	Assert.assertEquals(driver.findElement(By.xpath(sXpath)).isDisplayed(), true);
	reports.endTest(logger);
	
	//take a Screenshot using selenium
	TakesScreenshot ts = (TakesScreenshot) driver;//screenshot set up is done.
	File source = ts.getScreenshotAs(OutputType.FILE);//takes the screenshot and saving it to source object.
	String spathOfScreenShot = System.getProperty("user.dir")+"//screenshot/sreenshot_"+"logingIntoBrowser_"+loginUserName+"_"+loginPassword+".png";//path of screenshot.
	File destination = new File(spathOfScreenShot);//file got created
	FileUtils.copyFile(source, destination);//file is copied here.
	logger.log(LogStatus.INFO, "login test case is passed");
	logger.log(LogStatus.PASS, logger.addScreenCapture(spathOfScreenShot));//attaching screenshot to extend report.
	
}

@DataProvider(name="loginUserDataDetails")
public Object[][] getDataForLogin() throws Exception {
	return readexcelAndReturnObject(System.getProperty("user.dir")+"/resources/TestLoginData/td_UserName_Password.xls");
}

@Test
public Object[][] readexcelAndReturnObject(String sFile) throws Exception{
	
 	HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(sFile));
	HSSFSheet myExcelSheet = myExcelBook.getSheet("XeroLoginDetails");
	HSSFRow row1 = myExcelSheet.getRow(0);
	
	System.out.println(myExcelSheet.getPhysicalNumberOfRows()); // To take total number of Rows
	//System.out.println(row1.getLastCellNum());
	
	int iCountCol = row1.getLastCellNum();
	int iCountRow = myExcelSheet.getPhysicalNumberOfRows();
	Object[][] excelData = new Object[iCountRow][iCountCol]; // Creating multi-dimensional array
	
	for(int countRow = 0; countRow < iCountRow; countRow++) {
		for(int countcol = 0; countcol <iCountCol; countcol++) {
			
			HSSFRow tempRow = myExcelSheet.getRow(countRow);
	
			String sTemp;
			try {
				sTemp = tempRow.getCell(countcol).getStringCellValue();
			}catch(Exception a) {
				sTemp=Double.toString(tempRow.getCell(countcol).getNumericCellValue()); //get numbers data from .xls file
			}
			
			excelData[countRow][countcol] = sTemp;	
		}
	}	
	return excelData;	
}

}

