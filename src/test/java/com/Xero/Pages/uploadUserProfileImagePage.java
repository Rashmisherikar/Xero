package com.Xero.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ta.XeroPageObjectModel.XeroBaseClass;

public class uploadUserProfileImagePage extends XeroBaseClass{

	WebDriver driver;
public uploadUserProfileImagePage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//a[@class='btn btn-tertiary-alt global-ceiling-bar-btn']") WebElement LoginTab;
@FindBy(id="xl-form-email") WebElement UserName;
@FindBy(id="xl-form-password") WebElement PassWord;
@FindBy(id="xl-form-submit") WebElement LoginButton;
@FindBy(xpath="//abbr[@class='xrh-avatar xrh-avatar-color-1']") WebElement DisplayedUserName;
@FindBy(xpath="//h4[@class='xrh-verticalmenuitem--heading']") WebElement ProfileUserNameTab;
@FindBy(xpath="//span[@id='button-1041-btnInnerEl']") WebElement UploadImageButton;
@FindBy(xpath ="//div[@id='ext-comp-1167']//input[@id='filefield-1174-button-fileInputEl']") WebElement ChooseFileBrowse;

@FindBy(xpath="//div[@id='ext-comp-1167']//div[@id='button-1178-btnWrap']//a[@id='button-1178-btnEl']") WebElement UploadButton;

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

public void ProfileNameClick() throws Exception {
	oBroUtil.ExplicitWebDriverWait(DisplayedUserName, 40);
	oBroUtil.ufClickElement(DisplayedUserName);
	oBroUtil.ExplicitWebDriverWait(ProfileUserNameTab, 40);
	oBroUtil.ufClickElement(ProfileUserNameTab);
	oBroUtil.ExplicitWebDriverWait(UploadImageButton, 20);
	oBroUtil.ufClickElement(UploadImageButton);

	((JavascriptExecutor) driver).executeScript("arguments[0].click();", ChooseFileBrowse);
	oBroUtil.CaptureScreenShot("Upload_Profile_Image");
	Thread.sleep(1000);
	Runtime.getRuntime().exec("C:\\Users\\gsshy\\Desktop\\AutoIt\\xerofileupload.exe");
	Thread.sleep(2000);
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", UploadButton);
}
}
