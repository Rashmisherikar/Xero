 package com.Xero.Pages;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ta.XeroPageObjectModel.XeroBaseClass;

public class signUpPage extends XeroBaseClass {

WebDriver driver;
@FindBy(xpath="//a[@class='btn btn-primary global-ceiling-bar-btn at-element-marker']") WebElement FreeDemoTab;
@FindBy(xpath="//input[@name='FirstName']") WebElement FirstName;
@FindBy(xpath="//input[@name='LastName']") WebElement LastName;
@FindBy(xpath="//input[@name='EmailAddress']") WebElement EmailAdress;
@FindBy(xpath="//input[@name='PhoneNumber']") WebElement PhoneNumber;
@FindBy(xpath="//select[@name='LocationCode']") WebElement LocationCode;
@FindBy(xpath="//iframe[@role='presentation']") WebElement iframeRobot;

@FindBy(xpath="//span[@id='recaptcha-anchor']") WebElement ImNotARobot;
@FindBy(xpath="//input[@name='TermsAccepted']") WebElement TermsAccepted;
@FindBy(xpath="//span[@class='g-recaptcha-submit']") WebElement GettingStartedButton;


@FindBy(xpath="//a[contains(text(),'terms')]") WebElement Terms;
@FindBy(xpath="//a[contains(text(),'privacy')]") WebElement Privacy;
@FindBy(xpath="//a[contains(text(),'offer details')]") WebElement OfferDetails;
@FindBy(xpath="//a[contains(text(),'accountant or bookkeeper')]") WebElement AccountantOrBookkeeper;

public signUpPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

public void Freedemo() {
	oBroUtil.ExplicitWebDriverWait(FreeDemoTab, 30);
	oBroUtil.ufClickElement(FreeDemoTab);
}
public void signUpA() throws InterruptedException {

	oBroUtil.ExplicitWebDriverWait(FirstName, 20);
	oBroUtil.ufSendKeys(FirstName, "Rashmi");
	oBroUtil.ExplicitWebDriverWait(LastName, 20);
	oBroUtil.ufSendKeys(LastName, "Sherikar");
	oBroUtil.ExplicitWebDriverWait(EmailAdress, 20);
	oBroUtil.ufSendKeys(EmailAdress, "rashmishyam30@gmail.com");
	oBroUtil.ExplicitWebDriverWait(PhoneNumber, 20);
	oBroUtil.ufSendKeys(PhoneNumber, "6503346605");
	((JavascriptExecutor)driver).executeScript("window.scrollBy(200,300)");
	oBroUtil.ufClickElement(LocationCode);
	Select location = new Select(LocationCode);
	location.selectByVisibleText("United States");
	/*System.out.println("Before Iframe");
	driver.switchTo().frame(iframeRobot);
	System.out.println("After Iframe");
	Thread.sleep(8000);
	
	oBroUtil.ExplicitWebDriverWait(ImNotARobot, 20);
	oBroUtil.ufClickElement(ImNotARobot);
	oBroUtil.CaptureScreenShot("I_am_not_Robot_ScreenShot");
	System.out.println("Im Not A Robot whether check box is selected : "+ImNotARobot.isSelected());
	driver.switchTo().defaultContent();
	Thread.sleep(2000);*/
	oBroUtil.ExplicitWebDriverWait(TermsAccepted, 40);
	oBroUtil.ufClickElement(TermsAccepted);
	System.out.println("check whether check box is selected : "+TermsAccepted.isSelected());
	oBroUtil.ExplicitWebDriverWait(GettingStartedButton, 60);
	oBroUtil.ufClickElement(GettingStartedButton);
	Thread.sleep(2000);
}

public void signUpB() throws InterruptedException {

	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", GettingStartedButton);
	Thread.sleep(3000);
	oBroUtil.ExplicitWebDriverWait(GettingStartedButton, 30);
	oBroUtil.ufClickElement(GettingStartedButton);		
}

public void signUpC() throws Exception {
	
	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", Terms);
	//Thread.sleep(2000);
	oBroUtil.ExplicitWebDriverWait(Terms, 30);
	oBroUtil.ufClickElement(Terms);	
	ArrayList<String> WindowTabTerms = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(WindowTabTerms.get(1));
	driver.close();
	driver.switchTo().window(WindowTabTerms.get(0));
	oBroUtil.ExplicitWebDriverWait(Privacy, 30);
	oBroUtil.ufClickElement(Privacy);	
	ArrayList<String> WindowTabPrivacy = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(WindowTabPrivacy.get(1));
	driver.close();
	driver.switchTo().window(WindowTabPrivacy.get(0));
}

public void signUpD() {
	
	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", OfferDetails);
	oBroUtil.ExplicitWebDriverWait(OfferDetails, 30);
	oBroUtil.ufClickElement(OfferDetails);
	ArrayList<String> WindowTabOfferDetails = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(WindowTabOfferDetails.get(1));
	driver.close();
	driver.switchTo().window(WindowTabOfferDetails.get(0));
}

public void signUpE() {
	
	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",AccountantOrBookkeeper);
	oBroUtil.ExplicitWebDriverWait(AccountantOrBookkeeper, 30);
	oBroUtil.ufClickElement(AccountantOrBookkeeper);	
	oBroUtil.CaptureScreenShot("AccountantOrBookkeeper");
}
}
