package com.inetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver driver;
	//identification of WebElements 
	
	@FindBy(how=How.LINK_TEXT, using="New Customer")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(how=How.NAME,using="name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how=How.NAME,using="rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(how=How.ID_OR_NAME,using="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how=How.NAME,using="addr")
	@CacheLookup
	WebElement txtaddress;
	
	@FindBy(how=How.NAME,using="city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(how=How.NAME,using="state")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy(how=How.NAME, using="pinno")
	@CacheLookup
	WebElement txtpin;
	
	@FindBy(how=How.NAME,using="telephoneno")
	@CacheLookup
	WebElement txtphone;
	
	@FindBy(how=How.NAME,using="emailid")
	@CacheLookup
	WebElement txtemail;
	
	@FindBy(how=How.NAME,using="password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(how=How.NAME,using="sub")
	@CacheLookup
	WebElement btnsubmit;
	
	public AddCustomerPage(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(driver, this);
	}
	
	//Actions on WebElement
	
	public void addNewCustomerLink() {
		lnkAddNewCustomer.click();
	}
	
	public void customerName(String name) {
		txtCustomerName.sendKeys(name);
	}
	
	public void radioGender() {
		rdGender.click();
	}
	
	public void customerDob(String mm,String dd,String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void customerAdrs(String address) {
		txtaddress.sendKeys(address);
	}
	public void customerCity(String city) {
	txtcity.sendKeys(city);
	}
	
	public void customerState(String state) {
		txtstate.sendKeys(state);
		}
	
	public void customerPin(String pin) {
		txtpin.sendKeys(String.valueOf(pin));
		}
	public void customerPhone(String phone) {
		txtphone.sendKeys(String.valueOf(phone));
		}
	
	public void customerEmail(String email) {
		txtemail.sendKeys(email);
		}
	public void customerPass(String password) {
		txtpassword.sendKeys(password);
		}
	public void submitButton() {
		btnsubmit.click();
	}
	
	
}
