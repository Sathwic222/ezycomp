package com.automation.ezycomp.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.automation.ezycomp.base.TestBase;
import com.automation.ezycomp.functionLabrary.ReportLog;
import com.automation.ezycomp.pageobjects.HomePage_SuperAdmin;
import com.automation.ezycomp.pageobjects.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage_SuperAdmin home; 
	ReportLog logger;
	
	@BeforeSuite
	public void testSuite() {
		logger = new ReportLog(driver);
	}
	
	@BeforeMethod 
	public void setup(Method m) {
		logger.startTest(m.getName());
		initialization();
		String url = prop.getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	@Test(priority=1)
	 public void login() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage();
			home = new HomePage_SuperAdmin();
			logger.logInfo("Entering username and password");
			loginpage.login("superadmin@ezycomp.com", "test123");
			loginpage.loginbtn();
			Thread.sleep(5000);
			Assert.assertTrue(home.homePageVerfication());
			logger.logPass("Login functionality for super admin is passed");
		} catch (Exception e) {
			logger.logFail("Login functionality for super admin is failed"+e.getMessage());
		}
		
	 }
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	@AfterSuite
	public void endTestSuite() {
		logger.endTestSuite();
	}

}
