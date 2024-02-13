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

public class State extends TestBase {
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
	public void AddNewLaw() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage();
			home = new HomePage_SuperAdmin();
			loginpage.login("superadmin@ezycomp.com", "test123");
			loginpage.loginbtn();
			Thread.sleep(5000);
			home.NavArrow();
			home.NavArrow1();
			home.Add();
		    home.Law("Tax", "this is the law");
			home.Submit();
			Thread.sleep(2000);
			Assert.assertTrue(home.LawVerfication());
			logger.logPass("Test AddNewLaw completed successfully.");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}	
	}
	
	
	@Test(priority=2)
	public void AddDuplicate() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage();
			home = new HomePage_SuperAdmin();
			loginpage.login("superadmin@ezycomp.com", "test123");
			loginpage.loginbtn();
			Thread.sleep(5000);
			home.NavArrow();
			home.NavArrow1();
			home.Add();
			home.Law("Tax", "this is the law");
			home.Submit();
			Thread.sleep(2000);
			logger.logPass("Test AddNewLaw completed successfully.");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=3)
	public void AddBlank() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage();
			home = new HomePage_SuperAdmin();
			loginpage.login("superadmin@ezycomp.com", "test123");
			loginpage.loginbtn();
			Thread.sleep(5000);
			home.NavArrow();
			home.NavArrow1();
			home.Add();
			home.Law(" ", " ");
			home.SubmitDisabled();
			logger.logPass("Submit button Disabled as expected for blank fields");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=4)
	public void SearchWithValidLaw() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage();
			home = new HomePage_SuperAdmin();
			loginpage.login("superadmin@ezycomp.com", "test123");
			loginpage.loginbtn();
			Thread.sleep(5000);
			home.NavArrow();
			home.Search("Tax");
			Thread.sleep(3000);
			home.SearchVerfication();
			logger.logPass("The search results include the element that matched the search term.");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	@Test(priority=5)
	public void SearchWithInValidLaw() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage();
			home = new HomePage_SuperAdmin();
			loginpage.login("superadmin@ezycomp.com", "test123");
			loginpage.loginbtn();
			Thread.sleep(5000);
			home.NavArrow();
			home.Search("tobe");
			Thread.sleep(3000);
			home.SearchVerfication1();
			logger.logPass("No data Avilable displayed");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
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
