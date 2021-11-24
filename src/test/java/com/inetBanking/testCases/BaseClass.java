package com.inetBanking.testCases;


import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ConfigReader;


public class BaseClass {
/*
	public static Logger logger;
	String user="mngr367389";
	String password="YmAhUqe";
	String url="http://demo.guru99.com/V4/";
	static WebDriver driver;
	*/ //after configReader class
	
	ConfigReader configreader=new ConfigReader();
	String user=configreader.getUser();
	String password=configreader.getPassword();
	String urls=configreader.getApplicationURL();
	String edgepath=configreader.getEdgePath();
	static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String brws) {
	    logger=Logger.getLogger("inetBanking");
	    PropertyConfigurator.configure("Log4j.properties");
	    
	    if(brws.equals("chrome"))
	    {
	    	System.setProperty("webdriver.chrome.driver", configreader.getChromePath());
		    driver=new ChromeDriver();
	    }
	    else if(brws.equals("firefox")) {
	    	System.setProperty("webdriver.gecko.driver",configreader.getFirefoxPath());
		    driver=new FirefoxDriver();
	    }
	    else if(brws.equals("edge")) {
	    	System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+edgepath);
		    driver=new EdgeDriver();
	    }
	    	
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/" +tname+".png");
		FileHandler.copy(source,target);
		System.out.println("Screenshot taken");
	}
	
	
}
