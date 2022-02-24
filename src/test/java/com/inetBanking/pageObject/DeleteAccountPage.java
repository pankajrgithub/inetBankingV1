package com.inetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.inetBanking.testCases.BaseClass;

public class DeleteAccountPage {

	WebDriver driver;
	public DeleteAccountPage(WebDriver ldriver){
		driver=ldriver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(how=How.XPATH, using="//a[contains(text(),'Delete Account')]")
	WebElement lnkDelAcc;

	public void clickDelAcc() {
		BaseClass.waitForElement(lnkDelAcc,30);
		lnkDelAcc.click();
	}
}
