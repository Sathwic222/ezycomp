package com.automation.ezycomp.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.automation.ezycomp.base.TestBase;
import com.automation.ezycomp.functionLabrary.ReportLog;
import com.automation.ezycomp.pageobjects.HomePage_SuperAdmin;
import com.automation.ezycomp.pageobjects.LoginPage;

public class Emails extends TestBase {
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
			home.Arrow();
			home.emailNotifications();
			home.email_temp();
			home.AddNewBtn();
			home.Template_type("user creation");
			home.email_company("adani");
			home.Email_subject("creating user");
			home.Email_cc("testcase8995@gmail.com");
			home.Email_body("this is vamshidhar reddy");
			home.Email_signature("rvr");
			home.create();
			Assert.assertTrue(home.added_sucessfully());
			logger.logPass("email added succesfully");
			}catch (Exception e) {
				logger.logFail("email not created");
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

