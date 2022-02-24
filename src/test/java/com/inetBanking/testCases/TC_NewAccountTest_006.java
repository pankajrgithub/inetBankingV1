package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.LoginPage;
import com.inetBanking.pageObject.NewAccountPage;

public class TC_NewAccountTest_006 extends BaseClass{
LoginPage lp;
NewAccountPage nap;
	@Test
	public void newAccountTest() throws InterruptedException, IOException {
		driver.get(urls);
		logger.info("URL Provided");
		lp=new LoginPage(driver);
		
		lp.setUserName(user);
		lp.setUserPass(password);
		logger.info("User and Password Provided");
		Thread.sleep(4000);
		
		lp.clickLogin();
		logger.info("Clicked on login");
		
		nap=new NewAccountPage(driver);
		
		nap.clicklnkAccount();
		logger.info("Clicked on New Account link");
		Thread.sleep(2000);
		Assert.assertEquals(true, driver.getPageSource().contains("Add new account form"));
		
		nap.clickOnReset();
		logger.info("Clicked on Reset button");
		Thread.sleep(2000);
		
		nap.setCustId("52545");
		logger.info("Customer id provided");
		Thread.sleep(2000);
		
		nap.setAcType("Savings");
		logger.info("Account Type provided");
		Thread.sleep(2000);
		
		nap.setInitalDep(3000);
		logger.info("Initial deposit provided");
		Thread.sleep(2000);
		
		nap.clickOnSubmit();
		logger.info("Clicked on submmit");
		Thread.sleep(4000);
		
		if(isAlert()==true) {
			logger.info("Test Failed:Customer id doesn't exist!");
			captureScreen(driver,"newAccountTest");
			Assert.assertTrue(false);
			Thread.sleep(2000);
			driver.switchTo().alert().accept();		
			
		}
		else
		{
			Assert.assertEquals(true,driver.getPageSource().contains("Account Generated Successfully!!!"));
			logger.info("Test Pass:Customer aacount Generated Successfully");
		}
		
	}
	public boolean isAlert() {
		try {
		driver.switchTo().alert().accept();
		return true;
		}catch(Exception e) {
			return false;
		}
	}
	
}
