package com.inetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetBanking.testCases.BaseClass;

public class DepositPage {
    WebDriver driver;
	public DepositPage(WebDriver ldriver){
		driver=ldriver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Deposit')]")
	WebElement lnkDeposit;
	
	@FindBy(name="res")
	WebElement btnReset;
	
	@FindBy(name="accountno")
	WebElement txtacNo;
	
	@FindBy(name="ammount")
	WebElement txtamount;
	
	@FindBy(name="desc")
	WebElement txtDesc;
	
	@FindBy(name="AccSubmit")
	WebElement btnSubmit;
	
	public void clickDepositLnk() {
		BaseClass.waitForElement(lnkDeposit,30);
		lnkDeposit.click();
	}
	
	public void clickResetBtn() {
		BaseClass.waitForElement(btnReset,30);
		btnReset.click();
	}

	public void setAcNo(int acno) {
		BaseClass.waitForElement(txtacNo,30);
		txtacNo.sendKeys(String.valueOf(acno));
	}
	
	public void setAmount(int amount) {
		BaseClass.waitForElement(txtamount,30);
		txtamount.sendKeys(String.valueOf(amount));
	}
	
	public void setDesc(String descrip) {
		BaseClass.waitForElement(txtDesc,30);
		txtDesc.sendKeys(descrip);
	}
	
	public void clickSubmit() {
		BaseClass.waitForElement(btnSubmit,30);
		btnSubmit.click();
	}
	
}
