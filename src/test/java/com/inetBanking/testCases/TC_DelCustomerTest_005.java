package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.DeleteCustomerPage;
import com.inetBanking.pageObject.LoginPage;

public class TC_DelCustomerTest_005 extends BaseClass{

	LoginPage lp;
	DeleteCustomerPage delcust;

	@Test
	public void delCustomerTest() throws InterruptedException, IOException {
		lp=new LoginPage(driver);

		driver.get(urls);
		logger.info("URL Provided");
		lp.setUserName(user);
		lp.setUserPass(password);
		logger.info("User name and password provided");
		Thread.sleep(2000);
		lp.clickLogin();
		Thread.sleep(3000);
		logger.info("Clicked on login button");

		delcust=new DeleteCustomerPage(driver);
         
		delcust.clickOnDelLnk();
		logger.info("Clicked on Delete Customer Link");

		Thread.sleep(2000);
		
		Assert.assertEquals(driver.getPageSource().contains("Edit Customer Form"), true);

		delcust.clickOnReset();
		Thread.sleep(1000);
		logger.info("Clicked on Reset button");

		delcust.SetCustomerId("63798");
		Thread.sleep(1000);
		logger.info("Customer id provided");

		delcust.clickOnSubmit();
		logger.info("Clicked on Submit button");
		Thread.sleep(2000);

		if(driver.switchTo().alert().getText().contains("Do you really want to delete this Customer?")) {
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			if(driver.switchTo().alert().getText().contains("Customer does not exist!!")) {
				Thread.sleep(2000);
				captureScreen(driver,"delCustomerTest");
				driver.switchTo().alert().accept();			
				Thread.sleep(2000);
				logger.info("Customer id doesn't exist!!");
				Assert.assertTrue(false);
				
			}
		}
		else {

			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			if(driver.switchTo().alert().getText().equals("Customer deleted Successfully")) {
				Thread.sleep(2000);
				driver.switchTo().alert().accept();
				logger.info("Customer deleted sucessfully");
				Assert.assertTrue(true);

				

			}

		}


	}
}


