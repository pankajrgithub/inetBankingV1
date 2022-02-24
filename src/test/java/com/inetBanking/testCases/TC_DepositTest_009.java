package com.inetBanking.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.DepositPage;
import com.inetBanking.pageObject.LoginPage;

public class TC_DepositTest_009 extends BaseClass{
	LoginPage lp;
	DepositPage dp;

	@Test
	public void depositAmount() throws InterruptedException {
		driver.get(urls);
		logger.info("Browser opened");
		lp=new LoginPage(driver);

		lp.setUserName(user);
		lp.setUserPass(password);
		Thread.sleep(2000);
		logger.info("User and password provided");

		lp.clickLogin();
		logger.info("clicked on login button");
		Thread.sleep(5000);
		
		dp=new DepositPage(driver);

		dp.clickDepositLnk();
		Thread.sleep(2000);
		
		
		Assert.assertEquals(driver.getPageSource().contains("Amount Deposit Form"), true);
		logger.info("Test Pass");
		
		dp.clickResetBtn();
		Thread.sleep(2000);
		logger.info("Clicked on Reset button");
		
		dp.setAcNo(102081);
		logger.info("account number provided");
		Thread.sleep(2000);
		
		dp.setAmount(5000);
		logger.info("amount provided");
		Thread.sleep(1000);
		
		dp.setDesc("Saving");
		logger.info("description provided");
		Thread.sleep(1000);
		
		dp.clickSubmit();
		
		Thread.sleep(2000);
		
		if(isAlert()==true) {
			try {
				captureScreen(driver, "depositAmount");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(false);
			
			logger.info("Test case failed");
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
		}
		else {
		
		Assert.assertEquals(driver.getPageSource().contains("Transaction details of Deposit for Account 102081"), true);
		logger.info("Test Case Pass");
		}
	}
	
	public boolean isAlert() {
		try {
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		return true;
		}catch(Exception e){
			return false;
			
		}
	}
}
