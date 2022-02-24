package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.EditAccountPage;
import com.inetBanking.pageObject.LoginPage;

public class TC_EditAccountTest_007 extends BaseClass {
LoginPage lp;
EditAccountPage ap;
	
	@Test
	public void EditNewAccount() throws InterruptedException, IOException {
		
		driver.get(urls);
		Thread.sleep(2000);
		logger.info("URL provided");
	
		lp=new LoginPage(driver);
		lp.setUserName(user);
		Thread.sleep(2000);
		lp.setUserPass(password);
		Thread.sleep(2000);
		logger.info("User name and Password Provided");
		lp.clickLogin();
		Thread.sleep(3000);
		logger.info("Clicked on login button");
		
		
		ap=new EditAccountPage(driver);
		ap.clickEditAclnk();
		Thread.sleep(2000);
		logger.info("clicked on Edit Account Link");
		
		Assert.assertEquals(driver.getPageSource().contains("Edit Account Form"), true);
		logger.info("Test Pass........");
		
		ap.clickResBtn();
		Thread.sleep(3000);
		logger.info("Clicked on Reset button");
		
		ap.setAcNo("102081");
		Thread.sleep(2000);
		logger.info("Account number provided");
		
		ap.clickOnSubmit();
		Thread.sleep(2000);
		if(isAlert()==true) {
			captureScreen(driver,"TC_EditAccountTest_007");
			Assert.assertTrue(false);
			logger.info("Test Case failed");
			driver.switchTo().alert().accept();
		}
		else {
			Assert.assertEquals(driver.getPageSource().contains("Edit Account Entry Form"), true);
			logger.info("Test Case Passed");
			ap.setAcType("Savings");
			Thread.sleep(2000);
			ap.clickOnSubmit();
			
			Assert.assertEquals(driver.getPageSource().contains("Account details updated Successfully!!!"), true);
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














