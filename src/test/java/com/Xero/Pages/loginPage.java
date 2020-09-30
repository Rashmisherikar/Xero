package com.Xero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ta.XeroPageObjectModel.XeroBaseClass;

public class loginPage extends XeroBaseClass{
	
WebDriver driver;
@FindBy(xpath="//a[@class='btn btn-tertiary-alt global-ceiling-bar-btn']") WebElement LoginTab;
@FindBy(id="xl-form-email") WebElement UserName;
@FindBy(id="xl-form-password") WebElement PassWord;
@FindBy(id="xl-form-submit") WebElement LoginButton;

public loginPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
public void loginTab() {
	oBroUtil.ExplicitWebDriverWait(LoginTab, 30);
	oBroUtil.ufClickElement(LoginTab);
}
public void loginpageXero(String XeroUserName, String XeroPassWord) throws Exception {
	oBroUtil.ExplicitWebDriverWait(UserName, 40);
	oBroUtil.ufClearElement(UserName);
	oBroUtil.ufSendKeys(UserName, XeroUserName);
	oBroUtil.ExplicitWebDriverWait(PassWord, 40);
	oBroUtil.ufClearElement(PassWord);
	oBroUtil.ufSendKeys(PassWord, XeroPassWord);
	Thread.sleep(1000);
	oBroUtil.ExplicitWebDriverWait(LoginButton, 40);
	oBroUtil.ufClickElement(LoginButton);
}
}
