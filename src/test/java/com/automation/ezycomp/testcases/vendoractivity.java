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



public class vendoractivity extends TestBase {
	LoginPage loginpage;
	HomePage_SuperAdmin home; 
	ReportLog logger;
	LoginPageTest logins;
	
	@BeforeSuite
	public void testSuite() {
		logger = new ReportLog(driver);
	}
	
	@BeforeMethod 
	public void setup(Method m) throws InterruptedException, IOException {
		logger.startTest(m.getName());
		initialization();
		driver.manage().window().maximize();
		String url = prop.getProperty("url");
		driver.get(url);
		
	}
	
	@Test(priority=1)
	public void AddNewCity() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Vendor"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			home.NAvMenu("Activities");
			home.NavArrowclose();	

			
//			home.Submit();
//			Thread.sleep(2000);
//			Assert.assertTrue(home.CreatedSucees());
			logger.logPass("Test Add New City completed successfully.");
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
