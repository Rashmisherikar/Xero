package com.Xero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ta.XeroPageObjectModel.XeroBaseClass;

public class allTabPage extends XeroBaseClass{

	WebDriver driver;
	
public allTabPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//a[@class='btn btn-tertiary-alt global-ceiling-bar-btn']") WebElement LoginTab;
@FindBy(id="xl-form-email") WebElement UserName;
@FindBy(id="xl-form-password") WebElement PassWord;
@FindBy(id="xl-form-submit") WebElement LoginButton;
@FindBy(xpath="//span[@class='xrh-banner--text xrh-banner--text-center']") WebElement DisplayTrailMessage;
@FindBy(xpath="//a[@name='navigation-menu/dashboard']") WebElement DashBoard;
@FindBy(xpath="//button[@name='navigation-menu/accounting']") WebElement Accounting;
@FindBy(xpath="//a[contains(text(),'Reports')]") WebElement Reports;
@FindBy(xpath="//button[@name='navigation-menu/contacts']") WebElement Contacts;
//div[@class='xrh-appbutton--body']//*[local-name()='svg']
@FindBy(xpath="//span[@class='xrh-appbutton--text']") WebElement CompanyNameDropDown;
@FindBy(xpath="//a[contains(text(),'Settings')]") WebElement Settings;
//li[1]//button[1]//div[1]//*[local-name()='svg']//*[name()='path' and contains(@d,'M7 5h5v2H7')]
@FindBy(xpath="(//div[@class='xrh-focusable--child xrh-iconwrapper']//*[local-name()='svg'])[1]") WebElement NewPlusTab;
@FindBy(xpath="//a[contains(text(),'Files')]") WebElement Files;
@FindBy(xpath="(//div[@class='xrh-focusable--child xrh-iconwrapper']//*[local-name()='svg'])[2]") WebElement Notification;
@FindBy(xpath="(//div[@class='xrh-focusable--child xrh-iconwrapper']//*[local-name()='svg'])[2]") WebElement SearchBox;
@FindBy(xpath="(//div[@class='xrh-focusable--child xrh-iconwrapper']//*[local-name()='svg'])[4]") WebElement HelpSymbol;


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
//	Assert.assertEquals(DisplayTrailMessage.getText(), "You’re on a free 30-day trial that includes all features.");
	//System.out.println(DisplayTrailMessage.getText());
}

public String validateTrailMessage() {
	return DisplayTrailMessage.getText();
}
public void allTabs() {
	
	oBroUtil.ExplicitWebDriverWait(DashBoard, 100);
	oBroUtil.ufClickElement(DashBoard);
	oBroUtil.ExplicitWebDriverWait(Accounting, 40);
	oBroUtil.ufClickElement(Accounting);
	oBroUtil.ExplicitWebDriverWait(Reports, 100);
	oBroUtil.ufClickElement(Reports);
	oBroUtil.ExplicitWebDriverWait(Contacts, 150);
	oBroUtil.ufClickElement(Contacts);
	oBroUtil.ExplicitWebDriverWait(CompanyNameDropDown, 140);
	oBroUtil.ufClickElement(CompanyNameDropDown);
	oBroUtil.ExplicitWebDriverWait(Settings, 40);
	oBroUtil.ufClickElement(Settings);
	oBroUtil.ExplicitWebDriverWait(NewPlusTab, 40);
	oBroUtil.ufClickElement(NewPlusTab);
	oBroUtil.ExplicitWebDriverWait(CompanyNameDropDown, 40);
	oBroUtil.ufClickElement(CompanyNameDropDown);
	oBroUtil.ExplicitWebDriverWait(Files, 80);
	oBroUtil.ufClickElement(Files);
	oBroUtil.ExplicitWebDriverWait(Notification, 100);
	oBroUtil.ufClickElement(Notification);
	oBroUtil.ExplicitWebDriverWait(SearchBox, 40);
	oBroUtil.ufClickElement(SearchBox);
	oBroUtil.ExplicitWebDriverWait(HelpSymbol, 40);
	oBroUtil.ufClickElement(HelpSymbol);
}
	
}
