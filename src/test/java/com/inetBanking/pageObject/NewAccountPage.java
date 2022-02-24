package com.inetBanking.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.inetBanking.testCases.BaseClass;

public class NewAccountPage {

	WebDriver driver;
	//old technique to locate elements from webPage
	By lnkNewAcnt=By.xpath("//a[contains(text(),'New Account')]");
	By btnReset=By.name("reset");
	By txtcustId=By.name("cusid");
	By selAcType=By.name("selaccount");
	By txtInilDep=By.name("inideposit");
	By btnSubmit=By.name("button2");
	
	public NewAccountPage(WebDriver ddriver) {
		driver=ddriver;
		PageFactory.initElements(driver,this);		
		
	}
	public void clicklnkAccount() {
		WebElement lnkNewAccount=driver.findElement(lnkNewAcnt);
		BaseClass.waitForElement(lnkNewAccount, 50);
		lnkNewAccount.click();
	}
	public void clickOnReset() {
		driver.findElement(btnReset).click();
	}
	
	public void setCustId(String custid) {
		driver.findElement(txtcustId).sendKeys(custid);
	}
	
	public void setAcType(String actType) {
		WebElement acType=driver.findElement(selAcType);
		Select type=new Select(acType);
		type.selectByVisibleText(actType);
	}
	
	public void setInitalDep(int amount) {
		WebElement depAmount=driver.findElement(txtInilDep);
		BaseClass.waitForElement(depAmount, 30);
		depAmount.sendKeys(String.valueOf(amount));
	}
	
	public void clickOnSubmit() {
		driver.findElement(btnSubmit).click();
	}
}
