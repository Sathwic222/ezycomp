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
import com.automation.ezycomp.pageobjects.EmailPage;
import com.automation.ezycomp.pageobjects.HomePage_SuperAdmin;
import com.automation.ezycomp.pageobjects.LoginPage;
import com.automation.ezycomp.pageobjects.Notification_page;
import com.automation.ezycomp.pageobjects.manage_user_page;

public class Notification_Testcases extends TestBase{
	
	LoginPage loginpage;
	HomePage_SuperAdmin home; 
	ReportLog logger;
	manage_user_page manage;
	EmailPage email;
	Notification_page notifications;
	
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
	@Test (priority = 1)
	public void Adding_notifications() throws InterruptedException, IOException {
		try {
		loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
		home = new HomePage_SuperAdmin();
		manage = new manage_user_page();
		email = new EmailPage();
		notifications = new Notification_page();
		
		Thread.sleep(5000);
		email.emailNotifications();
		notifications.Notification();
		notifications.Addnew();
		notifications.Template();
		Thread.sleep(3000);
		home.Dropdown("Adding Mapping");
		Thread.sleep(5000);
		notifications.Company();
		home.Dropdown("SN Reddy LTD");
		notifications.Title("mappings for testing");
		notifications.Message("{{Act Name}}, {{Activity Name}}, {{Rule Name}}");
		notifications.submit();
		Thread.sleep(3000);
		Assert.assertTrue(notifications.successfull());
		logger.logPass("notification added succesfully");
		}catch (Exception e) {
			logger.logFail("notification not added "+e.getMessage());
		}	
	}
	
	@Test (priority = 2)
	public void Adding_notifications_already_exists() throws InterruptedException, IOException {
		try {
		loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
		home = new HomePage_SuperAdmin();
		manage = new manage_user_page();
		email = new EmailPage();
		notifications = new Notification_page();
		
		Thread.sleep(5000);
		email.emailNotifications();
		notifications.Notification();
		notifications.Addnew();
		notifications.Template();
		Thread.sleep(3000);
		home.Dropdown("Adding Mapping");
		Thread.sleep(5000);
		notifications.Company();
		home.Dropdown("SN Reddy LTD");
		notifications.Title("mappings for testing");
		notifications.Message("{{Act Name}}, {{Activity Name}}, {{Rule Name}}");
		notifications.submit();
		Thread.sleep(3000);
		Assert.assertTrue(notifications.duplicate());
		logger.logPass("notification already exists");
		}catch (Exception e) {
			logger.logFail("notifications not done "+e.getMessage());
		}	
	}
	
	
	@Test(priority = 3)
	public void Template_DD() throws InterruptedException, IOException{
		try {
		loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
		home = new HomePage_SuperAdmin();
		manage = new manage_user_page();
		email = new EmailPage();
		notifications = new Notification_page();
		Thread.sleep(3000);
		email.emailNotifications();
		notifications.Notification();
		Thread.sleep(3000);
		notifications.Template_dd();
		home.Dropdown("Adding Mapping");
		Thread.sleep(3000);
		Assert.assertTrue(notifications.Addmaping());
		logger.logPass("dropdown working");
	} catch (Exception e) {
		logger.logFail(" dropdown not working "+e.getMessage());
	}
	}

	
	@Test(priority = 4)
	public void Company_DD() throws InterruptedException, IOException{
		try {
		loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
		home = new HomePage_SuperAdmin();
		manage = new manage_user_page();
		email = new EmailPage();
		email.emailNotifications();
		notifications = new Notification_page();
		Thread.sleep(3000);
		notifications.Notification();
		Thread.sleep(3000);
		notifications.company_dd();
		Thread.sleep(3000);
		
		home.Dropdown("SN Reddy LTD");
		Assert.assertTrue(notifications.country_dd());
		logger.logPass("dropdown working");
	} catch (Exception e) {
		logger.logFail(" dropdown not working "+e.getMessage());
	}
	}
	@Test(priority = 5)
	public void Edit() throws IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			manage = new manage_user_page();
			email = new EmailPage();
			notifications = new Notification_page();
			Thread.sleep(3000);
			email.emailNotifications();
			notifications.Notification();
			Thread.sleep(3000);
			notifications.Template_dd();
			Thread.sleep(3000);
			home.Dropdown("Adding Mapping");
			Thread.sleep(3000);
			home.Actions("Adding Mapping", "Edit");
			notifications.Title("123");
			notifications.submit();
			Thread.sleep(3000);
			home.updated();
			logger.logPass("Edit updated");
		} catch (Exception e) {
			logger.logFail(" edit not updated"+e.getMessage());
	}
}
	@Test(priority = 6)
	public void View() throws IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			manage = new manage_user_page();
			email = new EmailPage();
			notifications = new Notification_page();
			email.emailNotifications();
			notifications.Notification();
			Thread.sleep(3000);
			notifications.Template_dd();
			Thread.sleep(2000);
			home.Dropdown("Adding Mapping");
			Thread.sleep(2000);
			home.Actions("Adding Mapping", "View");
			
			logger.logPass("view Responding");
		} catch (Exception e) {
			logger.logFail(" View not responding "+e.getMessage());
	}
}
	@Test(priority = 7)
	public void Delete() throws IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			manage = new manage_user_page();
			email = new EmailPage();
			notifications = new Notification_page();
			email.emailNotifications();
			notifications.Notification();
			Thread.sleep(3000);
			notifications.Template_dd();
			Thread.sleep(2000);
			home.Dropdown("Adding Mapping");
			Thread.sleep(2000);
			home.Actions("Adding Mapping", "Delete");
			home.Yes();
			Thread.sleep(3000);
			home.Search_value("deleted successfully.");
			Thread.sleep(2000);
			logger.logPass("deleted succesfully");
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
