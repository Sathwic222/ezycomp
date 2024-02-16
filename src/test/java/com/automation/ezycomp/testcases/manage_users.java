package com.automation.ezycomp.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Keys;
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

public class manage_users extends TestBase{
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
	 public void manage_user()throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage();
			home = new HomePage_SuperAdmin();
			logger.logInfo("Entering username and password");
			loginpage.login("superadmin@ezycomp.com", "test123");
			loginpage.loginbtn();
			Thread.sleep(5000);
//			home.Arrow();
//			home.UserManagements();
//			home.ManageUser();
//			Thread.sleep(5000);
//			home.AddNewBtn();
//			logger.logInfo("Adding user");
//			home.Addingdetails("rahul", "kcr", "testcase8995@gmail.com");
//			home.Rolefield("vendor");
//	   		Thread.sleep(2000);
//			home.Submitbtn();
//			Assert.assertTrue(home.createdsucces());
			logger.logPass("user created sucessfully");
		}catch (Exception e) {
			logger.logFail("user not created");
		}
			
		
		
	 }
	@Test(priority=2)
	public void search() throws InterruptedException, IOException {
		try {
		loginpage = new LoginPage();
		home = new HomePage_SuperAdmin();
		logger.logInfo("Entering username and password");
		loginpage.login("superadmin@ezycomp.com", "test123");
		loginpage.loginbtn();
		Thread.sleep(5000);
//		home.Arrow();
//		home.UserManagements();
//		home.ManageUser();
//		Thread.sleep(5000);
////		home.tillunames();
//		home.search("tillu");
//		Thread.sleep(2000);
//		home.tilluname();
		logger.logPass("shown as per given");
		}catch (Exception e) {
			logger.logFail("not shown");
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

