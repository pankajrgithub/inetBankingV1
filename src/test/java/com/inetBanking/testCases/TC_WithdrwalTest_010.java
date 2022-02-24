package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.DepositPage;
import com.inetBanking.pageObject.LoginPage;
import com.inetBanking.pageObject.WithdrwalPage;

public class TC_WithdrwalTest_010 extends BaseClass{
LoginPage lp;
DepositPage dp;
WithdrwalPage wp;
	@Test
	public void withdrawalAmount() throws InterruptedException, IOException {
		driver.get(urls);
		logger.info("URL provided...............");
		
		lp=new LoginPage(driver);
		
		lp.setUserName(user);
		lp.setUserPass(password);
		Thread.sleep(2000);
		
		logger.info("User and Password provided");
		
		lp.clickLogin();
		
		logger.info("Clicked on login button");
		Thread.sleep(5000);
		
		wp=new WithdrwalPage(driver);
		
		wp.clickWithdrawalLnk();		
		logger.info("Clicked on Withdrawal link");
		Thread.sleep(2000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
		Thread.sleep(4000);
		wp.clickWithdrawalLnk();
		
		Assert.assertEquals(driver.getPageSource().contains("Amount Withdrawal Form"), true);
		logger.info("Test Pass!!!!!!!!!!!");
		dp=new DepositPage(driver);
		
		dp.clickResetBtn();
		Thread.sleep(2000);
		logger.info("Clicked on Reset Button");
		
		dp.setAcNo(102081);
		Thread.sleep(2000);
		logger.info("Clicked on Reset Button");
		
		dp.setAmount(8000);
		Thread.sleep(2000);
		logger.info("Clicked on Reset Button");
		
		dp.setDesc("Withdraw");
		Thread.sleep(2000);
		logger.info("Clicked on Reset Button");
		
		dp.clickSubmit();
		Thread.sleep(2000);
		
		if(isAlert()==true) {
			Assert.assertTrue(false);
			driver.switchTo().alert().accept();
			captureScreen(driver,"withdrawalAmount");
			logger.info("Test Case Failed!!!");
		}
		else {
			
			Assert.assertEquals(driver.getPageSource().contains("Transaction details of Withdrawal for Account 102081"), true);
			logger.info("Test Passed....");
		}
		
	}
	public boolean isAlert() {
		try {
		if(driver.switchTo().alert().getText().contains("Transaction Failed. Account Balance Low!!!")){
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			logger.info("Account balance insuficiant");
		}
		else {
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			logger.info("Account Doesn't exist!!!");
		}
		return true;
		}catch(Exception e) {
			return false;
		}
	}
}
