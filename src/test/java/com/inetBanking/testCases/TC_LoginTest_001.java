package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void loginTest() throws IOException {
			
		driver.get(urls);
		logger.info("URL is oppend");
		LoginPage login=new LoginPage(driver);
		
		login.setUserName(user);
		logger.info("Entered user name");
		
		login.setUserPass(password);
		logger.info("Entered password");
		
		login.clickLogin();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			
			logger.info("Test case pass");
		}
		else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Test case failed");
		}
	}
}
