package com.inetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerInfoPage {

	WebDriver driver;
	
	public EditCustomerInfoPage(WebDriver ldriver){
		driver=ldriver;	
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText="Edit Customer")
	WebElement linkEdit;
	
	@FindBy(name="res")
	WebElement btnReset;
	
	@FindBy(name="cusid")
	WebElement txtCustId;
	
	@FindBy(name="AccSubmit")
	WebElement btnSubmitCust;
	
	@FindBy(name="addr")
	WebElement txteditAddrs;
	
	@FindBy(name="city")
	WebElement txteditCity;
	
	@FindBy(name="state")
	WebElement txteditState;
	
	@FindBy(name="pinno")
	WebElement txteditPin;
	
	@FindBy(name="telephoneno")
	WebElement txteditPhone;
	
	@FindBy(name="emailid")
	WebElement txteditEmail;
	
	@FindBy(name="sub")
	WebElement btnSubmit;
	
	//Actions on WebElements
	public void clickEditLink() {
		linkEdit.click();
	}
	
	public void clickOnReset() {
		btnReset.click();
	}
	
	public void SetCustomerId(String cusid) {
		txtCustId.sendKeys(cusid); 
	}
	public void clickOnSubmit() {
		btnSubmitCust.click();
	}
	
	public void setAddress(String adrs) {
		boolean isEnable=txteditAddrs.isEnabled();
		if(isEnable==true) {
		txteditAddrs.clear();
		txteditAddrs.sendKeys(adrs);
		}
		else {
			System.out.println("Enabled"+isEnable);
		}
	}
	public void setCity(String updatedCity) {
		txteditCity.sendKeys(updatedCity);
	}
	public void setState(String stateUpdates) {
		txteditState.sendKeys(stateUpdates);
	}
	public void setPin(String updatedPin) {
		txteditCity.sendKeys(updatedPin);
	}
	
	public void setPhoneNum(String updatedPhone) {
		txteditCity.sendKeys(updatedPhone);
	}
	
	public void setEmail(String updateEmail) {
		txteditCity.sendKeys(updateEmail);
	}
	
	public void btnSubmitUpdate() {
		txteditCity.click();
	}
}
