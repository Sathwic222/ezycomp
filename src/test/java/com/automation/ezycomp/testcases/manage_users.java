package com.automation.ezycomp.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import com.automation.ezycomp.pageobjects.*;
import com.automation.ezycomp.utils.ExcelOperations;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.automation.ezycomp.base.TestBase;
import com.automation.ezycomp.functionLabrary.ReportLog;

import junit.framework.Assert;

public class manage_users extends TestBase{
	LoginPage loginpage;
	HomePage_SuperAdmin home; 
	ReportLog logger;
	manage_user_page manage;
	
	
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
			Thread.sleep(5000);

			manage.UserManagements();
			manage.ManageUser();
			Thread.sleep(5000);
			manage.AddNewBtn();
			logger.logInfo("Adding user");
			manage.Addingdetails(prop.getProperty("fullname"),prop.getProperty("username"),prop.getProperty("email"));
			manage.select_value();
			home.Dropdown(prop.getProperty("role"));
	   		Thread.sleep(2000);
	   		manage.Submitbtn();
			Thread.sleep(5000);
			Assert.assertTrue(manage.createdsucces());
			logger.logPass("user created sucessfully");
		}catch (Exception e) {
			logger.logFail("user not created"+e.getMessage());
		}	
	 }
	
	@Test(priority=2)
	 public void manage_user_already_exits()throws InterruptedException, IOException {
			try {
				loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
				home = new HomePage_SuperAdmin();
				manage = new manage_user_page();
				Thread.sleep(5000);

				manage.UserManagements();
				manage.ManageUser();
				Thread.sleep(5000);
				manage.AddNewBtn();
				logger.logInfo("Adding existing user");
				manage.Addingdetails(prop.getProperty("fullname"),prop.getProperty("username"),prop.getProperty("email"));
				manage.select_value();
				home.Dropdown(" ");
		   		Thread.sleep(2000);
		   		manage.Submitbtn();
				Thread.sleep(5000);
				Assert.assertTrue(manage.already_exists());
				logger.logPass("user_already_exists");
			}catch (Exception e) {
				logger.logFail("created user"+e.getMessage());
			}	
		 }
	@Test(priority=3)
	public void search() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			manage = new manage_user_page();
			Thread.sleep(5000);
			manage.UserManagements();
			manage.ManageUser();
			Thread.sleep(5000);
		manage.search("tillu");
		Thread.sleep(2000);
		manage.tilluname();
		manage.select_values();
		logger.logPass("shown as per given");
		
		
		}catch (Exception e) {
			logger.logFail("not shown"+e.getMessage());
		}
	}
	
	@Test(priority=4)
	 public void roledropdown()throws InterruptedException, IOException {
			try {
				loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
				home = new HomePage_SuperAdmin();
				manage = new manage_user_page();
				Thread.sleep(5000);
				manage.UserManagements();
				manage.ManageUser();
				Thread.sleep(5000);
				manage.dropdowns();
				home.Dropdown(prop.getProperty("role"));
				Thread.sleep(5000);
				Assert.assertTrue(home.SearchElement(prop.getProperty("role")));
				logger.logPass("type drop is working");
			}catch (Exception e) {
				logger.logFail("type drop is not working"+e.getMessage());
			}	
		 }
	
	@Test(priority = 5)
	public void Edit() throws IOException, InterruptedException {
		try {
		loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
		home = new HomePage_SuperAdmin();
		manage = new manage_user_page();
		Thread.sleep(5000);
//		home.Arrow();
		manage.UserManagements();
		manage.ManageUser();
		Thread.sleep(5000);
		manage.search(prop.getProperty("username"));
		Thread.sleep(5000);
		home.Actions("kcr","Edit");
		manage.clearing();
		Thread.sleep(5000);
		manage.edit_details(" hero");
		manage.Submitbtn();
		Thread.sleep(5000);
		Assert.assertTrue(home.SearchElement("updated successfully"));
		logger.logPass("Edit is working");
	}catch (Exception e) {
			logger.logFail(" Edit is not working "+e.getMessage());
		}
		
	}
	
	@Test(priority = 6)
	public void view() throws IOException, InterruptedException {
		try {
		loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
		home = new HomePage_SuperAdmin();
		manage = new manage_user_page();
		Thread.sleep(5000);
//		home.Arrow();
		manage.UserManagements();
		manage.ManageUser();
		Thread.sleep(5000);
		manage.search(prop.getProperty("username"));
		Thread.sleep(5000);
		home.Actions("kcr","View");
		Thread.sleep(3000);
		home.search_valued("Full Name");
//		Assert.assertTrue(home.SearchElement("updated successfully"));
		logger.logPass("VIEW IS WORKING");
		} catch (Exception e) {
			logger.logFail("not edit updated"+e.getMessage());
		}
		
	}
	
	@Test(priority = 7)
	public void delete() throws IOException, InterruptedException {
		try {
		loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
		home = new HomePage_SuperAdmin();
		manage = new manage_user_page();
		Thread.sleep(5000);
//		home.Arrow();
		manage.UserManagements();
		manage.ManageUser();
		Thread.sleep(5000);
		manage.search(prop.getProperty("username"));
		Thread.sleep(5000);
		home.Actions("kcr","Delete");
		Thread.sleep(3000);
		home.Yes();
		Thread.sleep(3000);
//		home.deleted();
			home.Search_value("deleted successfully.");
		logger.logPass("delete sucessfully");
	} catch (Exception e) {
		logger.logFail(" not deleted "+e.getMessage());
	}
		
	}

	@Test(priority=11)
	public void ExportExcel() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			home.NAvMenu("User Management");
			home.NAvMenu("Manage Users");
			home.NavArrowclose();
			home.ExportButton();
			Thread.sleep(5000);
			ExcelOperations ex = new ExcelOperations(System.getProperty("user.dir") + "\\externalFiles\\downloadFiles\\Users.xlsx");
			String sheetName = "Users";
			int rowcount = ex.getRowcount(sheetName);
			int colcount = ex.getColcount(sheetName);
			Assert.assertEquals("Count Matching", home.Showing(),rowcount);
			logger.logPass("Export file downloaded sucessfully");
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

