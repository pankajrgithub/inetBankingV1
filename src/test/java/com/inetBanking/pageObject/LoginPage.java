package com.inetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="uid")
	WebElement txtUserName;
	
	@FindBy(name="password")
	WebElement txtUserPassword;
	
	@FindBy(name="btnLogin")
	WebElement userLogin;
	
	@FindBy(linkText="Log out")
	WebElement logout;
	
	//operation/Actions
	
	public void setUserName(String user)
	{
		txtUserName.sendKeys(user);
	}
	
	public void setUserPass(String pass)
	{
		txtUserPassword.sendKeys(pass);
	}
	
	public void clickLogin()
	{
		 userLogin.click();
	}
	
	public void clickLogOut()
	{
		logout.click();
	}
}
