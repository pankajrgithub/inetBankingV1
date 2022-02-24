package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.EditCustomerInfoPage;
import com.inetBanking.pageObject.LoginPage;

public class TC_EditCustomerInfoTest_004 extends BaseClass{

 EditCustomerInfoPage custInfo;
 LoginPage lp;
 
 @Test
 public void updateCustInfoTest() throws IOException, InterruptedException {
	 lp=new LoginPage(driver);
	 logger.info("************URL enters***************");
	 driver.get(urls);
	 
	 lp.setUserName(user);
	 lp.setUserPass(password);
	 logger.info("user and password entered");
	 
	 lp.clickLogin(); 
	 logger.info("user looged in successfuly");
	 
	 custInfo=new EditCustomerInfoPage(driver);
	 
	 custInfo.clickEditLink();
	 logger.info("clicked on Edit Customer link");
	 
	 if(driver.getPageSource().contains("Edit Customer Form")) {
		 Assert.assertTrue(true);
		 logger.info("Test Pass");
	 }else {
		 Assert.assertTrue(false);
		 captureScreen(driver,"updateCustinfo");
		 logger.info("Test Failed");
	 }
	 custInfo.clickOnReset();
	 logger.info("clicked on Reset button");
	 Thread.sleep(1000);
	 custInfo.SetCustomerId("13913");
	 logger.info("Customer id provided");
	 custInfo.clickOnSubmit();
	 logger.info("clicked on submit button");
	 Thread.sleep(1000);
	 if(isAlertAppears()==true) {
		 Assert.assertTrue(false);
		 captureScreen(driver,"updateCustinfo");
		 logger.info("Customer doesn't exist!!");
		 Thread.sleep(2000);
		 driver.switchTo().alert().accept();
		 driver.switchTo().defaultContent();
		 
	 }
	 else
	 {
		 if(driver.getPageSource().contains("Edit Customer")) {
			 Assert.assertTrue(true);
			 logger.info("Test Pass!!");
		 }
	 }
	 custInfo.setAddress("Springfield London England");
	 Thread.sleep(2000);
	 
	 logger.info("Customer address changed");
	 custInfo.setCity("LondonUK");
	 Thread.sleep(2000);
	 
	 logger.info("Customer city changed");
	 custInfo.setPin("342232");
	 Thread.sleep(2000);
	 logger.info("Customer pin changed");
	 
	 custInfo.setPhoneNum("8790987654");
	 Thread.sleep(2000);
	 logger.info("Customer phone changed");
	 
	 String email=randomstring()+"@yahoo.com";
	 
	 custInfo.setEmail(email);
	 Thread.sleep(2000);
	 logger.info("Customer email changed");
	 
	 custInfo.btnSubmitUpdate();
	 Thread.sleep(2000);
	 logger.info("Updates submitted");
	 
	 if(driver.getPageSource().contains("Customer details updated Successfully!!!")) {
		 Assert.assertTrue(true);
		 logger.info("Test Case pass");
	 }
	 
 }
	 
	public boolean isAlertAppears() {
	//	boolean flag=false;
	//   String alertText=driver.switchTo().alert().getText();  
		try {
	//   if(alertText.equals("Customer does not exist!!")) {
			 Thread.sleep(2000);
			driver.switchTo().alert().accept();
			 return true;
	//	 }
		}catch(Exception e) {	
			 return false;
		 }
		}
	

		
}  

