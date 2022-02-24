package com.inetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.inetBanking.testCases.BaseClass;

public class EditAccountPage {
	WebDriver driver;
	public EditAccountPage(WebDriver ldriver){
		driver=ldriver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//a[contains(text(),'Edit Account')]")
	WebElement lnkEditAc;

	@FindBy(name="accountno")
	WebElement txtAc_No;

	@FindBy(name="res")
	WebElement btnRest;
	
	@FindBy(name="AccSubmit")
	WebElement btnSubmit;
	
	@FindBy(name="a_type")
	WebElement selType;
	
	public void clickEditAclnk() {
		BaseClass.waitForElement(lnkEditAc,30)	;
		lnkEditAc.click();
	}

	public void setAcNo(String acno) {
		BaseClass.waitForElement(txtAc_No,30)	;
		txtAc_No.sendKeys(acno);
	}
	
	public void clickResBtn() {
		BaseClass.waitForElement(btnRest,30);
		btnRest.click();
	}
	
	public void clickOnSubmit() {
		BaseClass.waitForElement(btnSubmit,20);
		btnSubmit.click();
	}
	
	public void setAcType(String type) {
		Select acnType=new Select(selType);
		acnType.selectByVisibleText(type);
	}
}
