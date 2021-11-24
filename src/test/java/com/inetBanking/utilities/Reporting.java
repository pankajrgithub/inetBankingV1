package com.inetBanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{

	public ExtentReports extent;
	public ExtentSparkReporter  htmlreports;
//	public ExtentHtmlReporter htmlreports;
	public ExtentTest logger;
	
	
	public void onStart(ITestContext testContext) {
		
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Reports-"+timestamp+".html";
		
		htmlreports =new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		try {
			htmlreports.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlreports);
		
		extent.setSystemInfo("host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "pankaj");
		
		htmlreports.config().setDocumentTitle("inetBanking Test Project");
		htmlreports.config().setReportName("Functional Test Automation Report");
		htmlreports.config().setTheme(Theme.DARK);
	}
	public void onTestSuccess(ITestResult tr) {
		logger=extent.createTest(tr.getName());//create new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	public void onTestFailure(ITestResult tr) {
		logger=extent.createTest(tr.getName()); //create new entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String ScreenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		
		File f=new File(ScreenshotPath);
		if(f.exists())
		{
			try {
				logger.fail("Screen shot is below:"+logger.addScreenCaptureFromPath(ScreenshotPath));
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void onTestSkipped(ITestResult tr) {
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.YELLOW));
		
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}

