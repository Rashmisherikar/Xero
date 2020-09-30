package com.Xero.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ta.XeroPageObjectModel.XeroBaseClass;

public class startTrailOrganizationPage extends XeroBaseClass{

	WebDriver driver;
public startTrailOrganizationPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);	
}

@FindBy(xpath="//a[@class='btn btn-tertiary-alt global-ceiling-bar-btn']") WebElement LoginTab;
@FindBy(id="xl-form-email") WebElement UserName;
@FindBy(id="xl-form-password") WebElement PassWord;
@FindBy(id="xl-form-submit") WebElement LoginButton;

@FindBy(xpath="//*[name()='path' and contains(@d,'M0 0l5 5 5')]") WebElement LeftTopNameDropDownArrow;
@FindBy(xpath="//a[contains(text(),'My Xero')]") WebElement MyXero;

@FindBy(xpath="//input[@data-automationid='organisation-name--input']") WebElement BusinessName;
@FindBy(xpath="//input[@data-automationid='industry-autocompleter--input']") WebElement IndustryName;

@FindBy(xpath="//li[(@class='xui-pickitem xui-pickitem-medium')]") List<WebElement> IndustryNameSelect;
@FindBy(xpath="//div[@data-automationid='industry-autocompleter--list--scrollable-container']//ul[@role='group']/li//span[@class='xui-pickitem--text']/span") List<WebElement> IndustryNamelist;
@FindBy(xpath="//div[@class='xui-textinput--sideelement xui-textinput--sideelement-align-center xui-textinput--sideelement-icon']//div[@class='xui-iconwrapper xui-iconwrapper-medium']") WebElement CountryDropDown;
@FindBy(xpath="//div[@data-automationid='country-autocompleter--list--scrollable-container']//ul[@role='group']/li//span[@class='xui-pickitem--text']/span") List<WebElement> CountryDropDownList;
@FindBy(xpath="//span[@class='trigger-text__18E4o']") WebElement TimeZone;
@FindBy(xpath="//div[@class='xui-dropdown--scrollable-container']//ul[@role='group']/li//span[@class='xui-pickitem--text']/span") List<WebElement> TimeZoneList;
//@FindBy(xpath="//div[@class='panel-width-max__3w8jt xui-panel--section box-shadow-remove__3juP5']//div[2]//label[1]//div[1]") WebElement DoYouHaveEmployee;
@FindBy(xpath="(//div[@class='xui-styledcheckboxradio--radio xui-styledcheckboxradio--radio-small'])[2]") WebElement DoYouHaveEmployee;
@FindBy(xpath="//button[@class='xui-button xui-actions--primary button__2_4F- xui-actions--button-spacing xui-button-create xui-button-medium xui-button-fullwidth']") WebElement StartTrailButton;


@FindBy(xpath="//a[@id='ext-gen1042']") WebElement AddOrganization;
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

public void StartXeroTrial() throws InterruptedException {
	oBroUtil.ExplicitWebDriverWait(LeftTopNameDropDownArrow, 40);
	oBroUtil.ufClickElement(LeftTopNameDropDownArrow);
	oBroUtil.ExplicitWebDriverWait(MyXero, 30);
	oBroUtil.ufClickElement(MyXero);
	Thread.sleep(2000);
	ArrayList<String> NewWindow = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(NewWindow.get(1));
	Thread.sleep(2000);
	oBroUtil.ExplicitWebDriverWait(AddOrganization, 40);
	oBroUtil.ufClickElement(AddOrganization);
	Thread.sleep(2000);
	oBroUtil.ExplicitWebDriverWait(BusinessName, 40);
	oBroUtil.ufClickElement(BusinessName);
	oBroUtil.ufSendKeys(BusinessName, "TestTek");
	oBroUtil.ExplicitWebDriverWait(IndustryName, 100);
	oBroUtil.ufClickElement(IndustryName);
	oBroUtil.ufSendKeys(IndustryName, "Software");
	
	//oBroUtil.ExplicitWebDriverWait(IndustryNameSelect, 60);
	Thread.sleep(2000);
	//oBroUtil.ufClickElement(IndustryNameSelect);
	
	List<WebElement> liIndustryList = IndustryNameSelect;
	System.out.println("total number of Industrial Names suggestions in search box : "+liIndustryList.size());
	for(int count = 0; count < liIndustryList.size(); count++) {
		System.out.println(liIndustryList.get(count).getText());
		if(liIndustryList.get(count).getText().trim().equals("Software Testing")) {
			System.out.println("Industrial Names Found");
			liIndustryList.get(count).click();
			break;
		}
	}
	
	//Thread.sleep(3000);
	
	
	oBroUtil.ExplicitWebDriverWait(CountryDropDown, 40);
	oBroUtil.ufClickElement(CountryDropDown);
	List<WebElement> liCountryList = CountryDropDownList;
	System.out.println("total number of Country suggestions in search box : " +liCountryList.size());
	for(int count = 0; count < liCountryList.size(); count++) {
		//System.out.println(liCountryList.get(count).getText());
		if(liCountryList.get(count).getText().trim().equals("United States")) {
			System.out.println("Found Country Names");
			liCountryList.get(count).click();
			break;
		}
	}
	Thread.sleep(5000);
	
	oBroUtil.ExplicitWebDriverWait(TimeZone, 40);
	oBroUtil.ufClickElement(TimeZone);
	List<WebElement> liTimeList = TimeZoneList;
	System.out.println("total number of Time suggestions in search box : " +liTimeList.size());
	for(int count = 0; count < liTimeList.size(); count++) {
		//System.out.println(liCountryList.get(count).getText());
		if(liTimeList.get(count).getText().trim().equals("(UTC+02:00) Chisinau")) {
			System.out.println("Found Time Zones");
			liTimeList.get(count).click();
			break;
		}
	}
	
	Thread.sleep(4000);
	((JavascriptExecutor)driver).executeScript("window.scrollBy(200,600)");
	Thread.sleep(1000);
	oBroUtil.ExplicitWebDriverWait(DoYouHaveEmployee, 40);
	oBroUtil.ufClickElement(DoYouHaveEmployee);
	oBroUtil.ExplicitWebDriverWait(StartTrailButton, 20);
	oBroUtil.ufClickElement(StartTrailButton);
}

}
