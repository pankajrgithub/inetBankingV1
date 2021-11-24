package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{

	@Test(dataProvider="Logindata")
	public void loginDDT(String user,String pswd) throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		driver.get(urls);
		logger.info("URL is oppend");
		lp.setUserName(user);
		logger.info("User name Provided");
		lp.setUserPass(pswd);
		logger.info("User Password Provided");
		lp.clickLogin();
		logger.info("logged in");
		
		Thread.sleep(2000);
		if(isAlertPresent()==true)
		{
			Assert.assertTrue(false);
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent(); //return to home page after closing alert		
			logger.info("Test Failed");
		}
		else 
		{
			Assert.assertTrue(true);
			lp.clickLogOut();
			logger.info("Test Case Pass");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
		}
	}
	public boolean isAlertPresent()
	{
		try {
		driver.switchTo().alert().accept();
		return true;
		}catch(Exception e) {
		return false;
	}
}
	
	@DataProvider(name="Logindata")
	String[][] getData() throws IOException {
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) //row value will get row[1]
		{
			for(int j=0;j<colcount;j++) //cell value will get cell [0]
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j); //1 0
			}
		}
		return logindata;	
	}
	
}
