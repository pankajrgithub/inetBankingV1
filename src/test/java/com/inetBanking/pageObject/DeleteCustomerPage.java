package com.inetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetBanking.testCases.BaseClass;

public class DeleteCustomerPage {
	WebDriver driver;
	public DeleteCustomerPage(WebDriver ddriver) {
		driver=ddriver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="/html/body/div[3]/div/ul/li[4]/a")
	WebElement linkDel;

	@FindBy(name="res")
	WebElement btnReset;

	@FindBy(name="cusid")
	WebElement txtCustId;

	@FindBy(name="AccSubmit")
	WebElement btnSubmitCust;

	public void clickOnDelLnk() {
     	BaseClass.waitForElement(linkDel,40);
		
		linkDel.click();
		
	}

	public void clickOnReset() {
		BaseClass.waitForElement(btnReset,30);
		btnReset.click();
	}

	public void SetCustomerId(String cusid) {
		BaseClass.waitForElement(txtCustId,30);
		txtCustId.sendKeys(cusid); 
	}
	public void clickOnSubmit() {
		BaseClass.waitForElement(btnSubmitCust,30);
		btnSubmitCust.click();
	}
}