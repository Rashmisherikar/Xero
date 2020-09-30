package com.Xero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ta.XeroPageObjectModel.XeroBaseClass;

public class logoutPage extends XeroBaseClass{

WebDriver driver;
public logoutPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);	
}

@FindBy(xpath="//a[@class='btn btn-tertiary-alt global-ceiling-bar-btn']") WebElement LoginTab;
@FindBy(id="xl-form-email") WebElement UserName;
@FindBy(id="xl-form-password") WebElement PassWord;
@FindBy(id="xl-form-submit") WebElement LoginButton;
@FindBy(xpath="//abbr[@class='xrh-avatar xrh-avatar-color-1']") WebElement DisplayedUserName;
@FindBy(xpath="//div[@class='xrh-dropdown-layout xrh-addon--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionright']//a[@class='xrh-verticalmenuitem--body'][contains(text(),'Log out')]") WebElement LogoutUser;

public void loginTab() throws InterruptedException {
	oBroUtil.ExplicitWebDriverWait(LoginTab, 30);
	oBroUtil.ufClickElement(LoginTab);
	Thread.sleep(1000);
}

public void LoginUserPassDetails(String username, String password) {

	oBroUtil.ExplicitWebDriverWait(UserName, 40);
	oBroUtil.ufClearElement(UserName);
	oBroUtil.ufSendKeys(UserName, username);
	oBroUtil.ExplicitWebDriverWait(PassWord, 40);
	oBroUtil.ufClearElement(PassWord);
	oBroUtil.ufSendKeys(PassWord, password);
	oBroUtil.ExplicitWebDriverWait(LoginButton, 40);
	oBroUtil.ufClickElement(LoginButton);
}

public void xeroUserlogout() {
	oBroUtil.ExplicitWebDriverWait(DisplayedUserName, 40);
	oBroUtil.ufClickElement(DisplayedUserName);
	oBroUtil.ExplicitWebDriverWait(LogoutUser, 60);
	oBroUtil.ufClickElement(LogoutUser);
}
}
