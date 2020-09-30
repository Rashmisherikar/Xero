package com.Xero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ta.XeroPageObjectModel.XeroBaseClass;

public class forgotPasswordPage extends XeroBaseClass {

WebDriver driver;
@FindBy(xpath="//a[@class='btn btn-tertiary-alt global-ceiling-bar-btn']") WebElement LoginTab;
@FindBy(xpath="//a[contains(text(),'Forgot password?')]") WebElement ForgotPassword;
@FindBy(id="Email") WebElement Email;
@FindBy(xpath="//button[@id='submit-reset-password']") WebElement SendLink;

public forgotPasswordPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

public void loginTab() {
	oBroUtil.ExplicitWebDriverWait(LoginTab, 30);
	oBroUtil.ufClickElement(LoginTab);
}

public void forgotpassword() {
	oBroUtil.ExplicitWebDriverWait(ForgotPassword, 20);
	oBroUtil.ufClickElement(ForgotPassword);
	oBroUtil.ExplicitWebDriverWait(Email, 20);
	oBroUtil.ufSendKeys(Email, "rashmishyam30@gmail.com");
	oBroUtil.ExplicitWebDriverWait(SendLink, 40);
	oBroUtil.ufClickElement(SendLink);
	
}
}
