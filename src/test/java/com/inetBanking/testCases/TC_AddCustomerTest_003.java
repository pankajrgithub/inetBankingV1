package com.inetBanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.AddCustomerPage;
import com.inetBanking.pageObject.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{

	@Test
	void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp=new LoginPage(driver);
		
		driver.get(urls);
		logger.info("Url oppend");
		driver.manage().window().maximize();
		
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setUserPass(password);
		logger.info("user password provided");
		lp.clickLogin();
		logger.info("logged in");
		
		Thread.sleep(2000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.addNewCustomerLink();
	    logger.info("New Cstomer Page oppend");
	    Thread.sleep(1000);
	    addcust.customerName("pankaj");
	    logger.info("Name provided");
	    Thread.sleep(1000);
	    addcust.radioGender();
	    logger.info("Gender selected");
	    Thread.sleep(1000);
	    addcust.customerDob("04", "18", "1994");
	    logger.info("dob provided");
	    Thread.sleep(2000);
	    
	    addcust.customerAdrs("noida smarkworks");
	    logger.info("customer address provided");
	    Thread.sleep(1000);
	    addcust.customerCity("Delhi");
	    logger.info("City provided");
	    Thread.sleep(1000);
	    addcust.customerState("Delhi");
	    logger.info("State provided");
	    Thread.sleep(1000);
	    addcust.customerPin("201301");
	    logger.info("Customer pin provided");
	    
	    Thread.sleep(1000);
	    addcust.customerPhone("9879807656");
	    logger.info("customer telephone provided");
		
	    Thread.sleep(1000);
	    String email=randomstring()+"@gmail.com";
	    addcust.customerEmail(email);
	    logger.info("customer email provided");
	    
	    Thread.sleep(1000);
	    addcust.customerPass("pankaj@98");
	    logger.info("customer password provided");
	    
	    Thread.sleep(1000);
	    addcust.submitButton();
	    logger.info("customer data submitted");
	    
	    if(driver.getPageSource().contains("Customer Registered Successfully!!")) {
	    	Assert.assertTrue(true);
	    	logger.info("Test Case pass");
	    }
	    else {
	    	captureScreen(driver,"addNewCustomer");
	    	Assert.assertTrue(false);
	    	logger.info("Test Case failed");
	    }
	}
	
	public String randomstring()
	{
		String generateString=RandomStringUtils.randomAlphabetic(8);
		return generateString;
	}
}




























