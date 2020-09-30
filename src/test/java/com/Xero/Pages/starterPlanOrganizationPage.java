package com.Xero.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ta.XeroPageObjectModel.XeroBaseClass;

public class starterPlanOrganizationPage extends XeroBaseClass{

	WebDriver driver;
	public starterPlanOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}

	@FindBy(xpath="//a[@class='btn btn-tertiary-alt global-ceiling-bar-btn']") WebElement LoginTab;
	@FindBy(id="xl-form-email") WebElement UserName;
	@FindBy(id="xl-form-password") WebElement PassWord;
	@FindBy(id="xl-form-submit") WebElement LoginButton;

	@FindBy(xpath="//*[name()='path' and contains(@d,'M0 0l5 5 5')]") WebElement LeftTopNameDropDownArrow;
	@FindBy(xpath="//a[contains(text(),'My Xero')]") WebElement MyXero;
	
	@FindBy(xpath="//a[@id='ext-gen1042']") WebElement AddOrganization;
	
	@FindBy(xpath="//input[@data-automationid='organisation-name--input']") WebElement BusinessName;
	@FindBy(xpath="//input[@data-automationid='industry-autocompleter--input']") WebElement IndustryName;
	@FindBy(xpath="//li[(@class='xui-pickitem xui-pickitem-medium')]") List<WebElement> IndustryNameSelect;
	@FindBy(xpath="//div[@data-automationid='industry-autocompleter--list--scrollable-container']//ul[@role='group']/li//span[@class='xui-pickitem--text']/span") List<WebElement> IndustryNamelist;
	@FindBy(xpath="//div[@class='xui-textinput--sideelement xui-textinput--sideelement-align-center xui-textinput--sideelement-icon']//div[@class='xui-iconwrapper xui-iconwrapper-medium']") WebElement CountryDropDown;
	@FindBy(xpath="//div[@data-automationid='country-autocompleter--list--scrollable-container']//ul[@role='group']/li//span[@class='xui-pickitem--text']/span") List<WebElement> CountryDropDownList;
	@FindBy(xpath="//span[@class='trigger-text__18E4o']") WebElement TimeZone;
	@FindBy(xpath="//div[@class='xui-dropdown--scrollable-container']//ul[@role='group']/li//span[@class='xui-pickitem--text']/span") List<WebElement> TimeZoneList;
	@FindBy(xpath="(//div[@class='xui-styledcheckboxradio--radio xui-styledcheckboxradio--radio-small'])[2]") WebElement DoYouHaveEmployee;
	@FindBy(xpath="//button[@class='xui-button xui-actions--secondary button__2_4F- xui-button-standard xui-button-medium xui-button-fullwidth']") WebElement StartTrailBuyButton;

	@FindBy(xpath="//div[@data-automationid='Early--radio']") WebElement EarlyRadio;
	@FindBy(xpath="//button[@id='continueButton']//span[contains(text(),'Continue to select billing account')]") WebElement SelectBillingAccountButton;
	
	@FindBy(xpath="//input[@id='contactAddress']") WebElement StreetAddress;
	@FindBy(id="contactCity") WebElement TownCity;
	@FindBy(xpath="//div[@id='postalAddress']//button[@class='xui-button xui-select--button xui-u-fullwidth xui-button-standard xui-button-medium']") WebElement StateRegionDropDown;
	@FindBy(xpath="//li[@class='xui-pickitem xui-pickitem-medium']") List<WebElement> StateRegionList;
	@FindBy(id="contactPostalCode") WebElement ZipCode;
	@FindBy(id="stepAccountCreate") WebElement ContinueToReviewPayButton;
	
	@FindBy(xpath="//span[contains(text(),'Credit card')]") WebElement CreditCardButton;
	
	@FindBy(xpath="//iframe[@name='__privateStripeFrame9607']") WebElement IframeCreditDetails;
	@FindBy(id="stripe-card-number") WebElement CardNumber;
	@FindBy(xpath="//input[@class='InputElement is-empty Input Input--empty' and  @name='exp-date']") WebElement ExpiryDate;
	@FindBy(xpath="//input[@class='InputElement is-empty Input Input--empty' and  @name='cvc']") WebElement SecurityCode;
	@FindBy(xpath="//input[@id='stripe-cardholder-name']") WebElement NameOnTheCard;
	@FindBy(id="continueButton") WebElement ConfirmPurchase;
	
	public void loginTab() throws InterruptedException {
		oBroUtil.ExplicitWebDriverWait(LoginTab, 30);
		oBroUtil.ufClickElement(LoginTab);
		Thread.sleep(1000);
	}

	public void LoginUserPassDetails(String username, String password) throws InterruptedException {

		oBroUtil.ExplicitWebDriverWait(UserName, 40);
		oBroUtil.ufClearElement(UserName);
		oBroUtil.ufSendKeys(UserName, username);
		oBroUtil.ExplicitWebDriverWait(PassWord, 40);
		oBroUtil.ufClearElement(PassWord);
		oBroUtil.ufSendKeys(PassWord, password);
		oBroUtil.ExplicitWebDriverWait(LoginButton, 40);
		oBroUtil.ufClickElement(LoginButton);
		Thread.sleep(1000);
	}

	public void StartXeroBuyStarterPlanTrial() throws InterruptedException {
		oBroUtil.ExplicitWebDriverWait(LeftTopNameDropDownArrow, 40);
		oBroUtil.ufClickElement(LeftTopNameDropDownArrow);
		oBroUtil.ExplicitWebDriverWait(MyXero, 40);
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
		oBroUtil.ufSendKeys(BusinessName, "TestTeckArch");
		oBroUtil.ExplicitWebDriverWait(IndustryName, 100);
		oBroUtil.ufClickElement(IndustryName);
		oBroUtil.ufSendKeys(IndustryName, "Software");
		
		Thread.sleep(2000);
	
		List<WebElement> liIndustryList = IndustryNameSelect;
		System.out.println("total number of Industrial Names suggestions in search box : "+liIndustryList.size());
		for(int count = 0; count < liIndustryList.size(); count++) {
			//System.out.println(liIndustryList.get(count).getText());
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
		Thread.sleep(1000);
		
		oBroUtil.ExplicitWebDriverWait(TimeZone, 40);
		oBroUtil.ufClickElement(TimeZone);
		List<WebElement> liTimeList = TimeZoneList;
		System.out.println("total number of Time suggestions in search box : " +liTimeList.size());
		for(int count = 0; count < liTimeList.size(); count++) {
			//System.out.println(liTimeList.get(count).getText());
			if(liTimeList.get(count).getText().trim().equals("(UTC+02:00) Chisinau")) {
				System.out.println("Found Time Zones");
				liTimeList.get(count).click();
				break;
			}
		}
		
		Thread.sleep(1000);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(200,600)");
		Thread.sleep(1000);
		oBroUtil.ExplicitWebDriverWait(DoYouHaveEmployee, 40);
		oBroUtil.ufClickElement(DoYouHaveEmployee);
		oBroUtil.ExplicitWebDriverWait(StartTrailBuyButton, 20);
		oBroUtil.ufClickElement(StartTrailBuyButton);
		//Thread.sleep(3000);
	}
	
	public void StarterPlanEarly() {
		
		oBroUtil.ExplicitWebDriverWait(EarlyRadio, 20);
		oBroUtil.ufClickElement(EarlyRadio);
		oBroUtil.ExplicitWebDriverWait(SelectBillingAccountButton, 20);
		oBroUtil.ufClickElement(SelectBillingAccountButton);
	}
	
	public void CreateNewBillingAccount() throws InterruptedException {
		oBroUtil.ExplicitWebDriverWait(StreetAddress, 20);
		oBroUtil.ufClickElement(StreetAddress);
		oBroUtil.ufSendKeys(StreetAddress, "20800 valley green drive");
		oBroUtil.ExplicitWebDriverWait(TownCity, 20);
		oBroUtil.ufClickElement(TownCity);
		oBroUtil.ufSendKeys(TownCity, "Cupertino");
		
		oBroUtil.ExplicitWebDriverWait(StateRegionDropDown, 20);
		oBroUtil.ufClickElement(StateRegionDropDown);
		
		List<WebElement> liTown = StateRegionList;
		System.out.println("total number of State sugessions : " +liTown.size());
		for(int count = 0; count < liTown.size(); count++) {
			if(liTown.get(count).getText().trim().equals("California")) {
				liTown.get(count).click();
				break;
			}
		}
		
		oBroUtil.ExplicitWebDriverWait(ZipCode, 20);
		oBroUtil.ufClickElement(ZipCode);
		oBroUtil.ufSendKeys(ZipCode, "95014");
		oBroUtil.ExplicitWebDriverWait(ContinueToReviewPayButton, 20);
		oBroUtil.ufClickElement(ContinueToReviewPayButton);
		Thread.sleep(4000);
		
	}
	
	public void CreditCardDetails() throws InterruptedException {
		oBroUtil.ExplicitWebDriverWait(CreditCardButton, 40);
		oBroUtil.ufClickElement(CreditCardButton);
		System.out.println("Before Iframe");
		oBroUtil.CaptureScreenShot("Not_Entering_Inside_Iframe_CardNumber");
		oBroUtil.ExplicitWebDriverWait(IframeCreditDetails, 40);
		driver.switchTo().frame(IframeCreditDetails);
		System.out.println("After Iframe");
		Thread.sleep(2000);
		oBroUtil.ExplicitWebDriverWait(CardNumber, 30);
		oBroUtil.ufClickElement(CardNumber);
		oBroUtil.ufSendKeys(CardNumber, "4541 9823 3873 6439");
		oBroUtil.ExplicitWebDriverWait(ExpiryDate, 20);
		oBroUtil.ufClickElement(ExpiryDate);
		oBroUtil.ufSendKeys(ExpiryDate, "01/25");
		oBroUtil.ExplicitWebDriverWait(SecurityCode, 20);
		oBroUtil.ufClickElement(SecurityCode);
		oBroUtil.ufSendKeys(SecurityCode, "342");
		oBroUtil.ExplicitWebDriverWait(NameOnTheCard, 20);
		oBroUtil.ufClickElement(NameOnTheCard);
		oBroUtil.ufSendKeys(NameOnTheCard, "Nisha");
		oBroUtil.ExplicitWebDriverWait(ConfirmPurchase, 20);
		oBroUtil.ufClickElement(ConfirmPurchase);
		driver.switchTo().defaultContent();
	} 

	}
