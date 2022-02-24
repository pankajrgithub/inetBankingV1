package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.DeleteAccountPage;
import com.inetBanking.pageObject.EditAccountPage;
import com.inetBanking.pageObject.LoginPage;

public class TC_DelAccountTest_008 extends BaseClass{

	LoginPage lp;
	EditAccountPage ap;
	DeleteAccountPage dap;
	
	@Test
	public void DelAccountTest() throws InterruptedException, IOException {
	
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
		
		dap=new DeleteAccountPage(driver);
		dap.clickDelAcc();
		Thread.sleep(2000);
		logger.info("click on delete account link");
		
		Assert.assertEquals(driver.getPageSource().contains("Delete Account Form"), true);
		logger.info("Test Pass!!");
		
		ap=new EditAccountPage(driver);
		ap.clickResBtn();
		Thread.sleep(2000);
		logger.info("clicked on reset button");
		ap.setAcNo("1020811");
		Thread.sleep(2000);
		logger.info("account number provided");
		
		ap.clickOnSubmit();
		Thread.sleep(2000);
		logger.info("Clicked on Submit button");
		
		if(driver.switchTo().alert().getText().contains("Do you really want to delete this Account?")) {
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			if(driver.switchTo().alert().getText().contains("Account does not exist")) {
				Thread.sleep(2000);
				captureScreen(driver,"DelAccountTest");
				driver.switchTo().alert().accept();	
				Thread.sleep(2000);
				logger.info("Account id doesn't exist!!");
				Assert.assertTrue(false);
				
			}
		}
		else {

			driver.switchTo().alert().accept();	
			Thread.sleep(2000);
			if(driver.switchTo().alert().getText().equals("Account Deleted Sucessfully")) {
				Thread.sleep(2000);
				driver.switchTo().alert().accept();
				logger.info("Customer deleted sucessfully");
				Assert.assertTrue(true);			

			}

		}
	}
}
