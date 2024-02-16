package com.automation.ezycomp.testcases;

import java.awt.Dimension;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.support.PageFactoryFinder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.automation.ezycomp.base.TestBase;
import com.automation.ezycomp.functionLabrary.ReportLog;
import com.automation.ezycomp.pageobjects.EmailPage;
import com.automation.ezycomp.pageobjects.HomePage_SuperAdmin;
import com.automation.ezycomp.pageobjects.LoginPage;
import com.automation.ezycomp.pageobjects.manage_user_page;

public class Emails extends TestBase {
	LoginPage loginpage;
	HomePage_SuperAdmin home; 
	ReportLog logger;
	manage_user_page manage;
	EmailPage email;
	
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
			
		
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			manage = new manage_user_page();
			email = new EmailPage();
			Thread.sleep(5000);
			//home.Arrow();
			email.emailNotifications();
			email.emails_type();
			email.AddNew_button();		
			Thread.sleep(5000);
			email.Template_type();
			home.Dropdown("User Creation");
			Thread.sleep(5000);
			email.email_company();
			Thread.sleep(2000);
			home.Dropdown("Adani");
			email.Email_subject("creating user");
			email.Email_cc("testcase8995@gmail.com");
			email.Email_body("this is vamshidhar reddy");
//			home.scrollToBottom();
			email.Email_signature("rvr");
			email.create();
			Thread.sleep(2000);
			Assert.assertTrue(manage.createdsucces());
			logger.logPass("email added succesfully");
			}catch (Exception e) {
				logger.logFail("email not added"+e.getMessage());
			}	
}
	@Test(priority = 2)
	public void Template_dropdown() throws InterruptedException, IOException{
		try {
		loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
		home = new HomePage_SuperAdmin();
		manage = new manage_user_page();
		email = new EmailPage();
		Thread.sleep(3000);
		email.emailNotifications();
		Thread.sleep(3000);
		email.emails_type();
		Thread.sleep(3000);
		email.Type_t_drop();
		home.Dropdown("User Creation");
		Assert.assertTrue(email.texting());
		logger.logPass("done");
	} catch (Exception e) {
		logger.logFail(" not done "+e.getMessage());
	}
	}
	
	@Test(priority = 3)
	public void Company_dropdown() throws InterruptedException, IOException{
		try {
		loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
		home = new HomePage_SuperAdmin();
		manage = new manage_user_page();
		email = new EmailPage();
		Thread.sleep(3000);
		email.emailNotifications();
		Thread.sleep(3000);
		email.emails_type();
		Thread.sleep(3000);
		email.Type_t_drop();
		home.Dropdown("User Creation");
		Assert.assertTrue(email.texting());
		logger.logPass("done");
	} catch (Exception e) {
		logger.logFail("not done"+e.getMessage());
	}
	}
	
	
	@Test(priority = 4)
	public void Actions_Edit() throws InterruptedException, IOException{
		try {
		loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
		home = new HomePage_SuperAdmin();
		manage = new manage_user_page();
		email = new EmailPage();
		Thread.sleep(3000);
		email.emailNotifications();
		Thread.sleep(3000);
		email.emails_type();
		Thread.sleep(3000);
		email.Type_t_drop();
		home.Dropdown("User Creation");
		Thread.sleep(3000);
		home.Actions("Adani","Edit");
		email.Email_subject(" for ");
		email.Email_body(" hello ");
		email.create();
		Thread.sleep(3000);
		home.updated();
		Thread.sleep(5000);
		//Assert.assertTrue(home.Update());
		logger.logPass("edit updated");
	} catch (Exception e) {
		logger.logFail("not edit updated"+e.getMessage());
	}
	}
	
	
	@Test(priority = 5)
	public void Actions_View() throws InterruptedException, IOException{
		try {
		loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
		home = new HomePage_SuperAdmin();
		manage = new manage_user_page();
		email = new EmailPage();
		Thread.sleep(3000);
		email.emailNotifications();
		Thread.sleep(3000);
		email.emails_type();
		Thread.sleep(3000);
		email.Type_t_drop();
		home.Dropdown("User Creation");
		Thread.sleep(3000);
//		driver.manage().window().setSize(new Dimension(1000, 1000));
		home.Actions("Adani","View");
		Thread.sleep(3000);
		home.Search("Template Type");
	//	Assert.assertTrue(home.search_valued("Template Type"));
		logger.logPass("VIEW IS WORKING");
	} catch (Exception e) {
		logger.logFail("not edit updated"+e.getMessage());
	}
	}
	
	@Test(priority = 6)
	public void Actions_Delete() throws InterruptedException, IOException{
		try {
		loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
		home = new HomePage_SuperAdmin();
		manage = new manage_user_page();
		email = new EmailPage();
		Thread.sleep(3000);
		email.emailNotifications();
		Thread.sleep(3000);
		email.emails_type();
		Thread.sleep(3000);
		email.Type_t_drop();
		home.Dropdown("User Creation");
		Thread.sleep(3000);
		home.Actions("Adani","Delete");
		home.Yes();
		Thread.sleep(3000);
		home.Search_value("deleted successfully.");
		//home.deleted();
		//junit.framework.Assert.assertTrue(home.Search_value("deleted successfully."));

		logger.logPass("delete sucessfully");
	} catch (Exception e) {
		logger.logFail(" not deleted "+e.getMessage());
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

