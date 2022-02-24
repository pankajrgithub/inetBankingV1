package com.inetBanking.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WithdrwalPage {
	WebDriver driver;
	public WithdrwalPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	By lnkWithdrawal=By.xpath("//a[contains(text(),'Withdrawal')]");

	public void clickWithdrawalLnk() {
		WebElement lnkWithdraw=driver.findElement(lnkWithdrawal);
		try {
			lnkWithdraw.click();
		}catch(Exception e) {
			driver.findElement(lnkWithdrawal).click();
		}
	}
}
