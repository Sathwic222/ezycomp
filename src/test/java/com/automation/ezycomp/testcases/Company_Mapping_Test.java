package com.automation.ezycomp.testcases;

import java.awt.event.KeyEvent;
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
import com.automation.ezycomp.pageobjects.Company_Mapping_Page;
import com.automation.ezycomp.pageobjects.EmailPage;
import com.automation.ezycomp.pageobjects.HomePage_SuperAdmin;
import com.automation.ezycomp.pageobjects.LoginPage;
//import com.automation.ezycomp.pageobjects.Robot;
import com.automation.ezycomp.pageobjects.manage_user_page;

import junit.framework.Assert;

public class Company_Mapping_Test extends TestBase {
	
	LoginPage loginpage;
	HomePage_SuperAdmin home; 
	ReportLog logger;
	manage_user_page manage;
	EmailPage email;
	Company_Mapping_Page company;
	
	
	
	
	@BeforeSuite
	public void testsuite () {
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
	
	@Test(priority = 1)
	public void Add_user_location() throws IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			manage = new manage_user_page();
			email = new EmailPage();
			company = new Company_Mapping_Page();
			Thread.sleep(2000);
			manage.UserManagements();
			company.Company_mapping();
			company.Role_dropdown("vamshidhar Auditor");
			Thread.sleep(5000);
			home.double_dropdown("vamshidhar Auditor");
			company.Add_location();
			company.company();
			Thread.sleep(3000);
			home.Dropdown("SN Reddy LTD");
			Thread.sleep(3000);
			company.Ass_company();
			home.Dropdown("saregamapa");
			Thread.sleep(3000);
			String LocCnt="2";
			company.locationSelect(LocCnt);
			int cnt = company.locationsSelected();
//			company.location_count();
			manage.Submitbtn();
			Thread.sleep(6000);
			Assert.assertTrue(manage.createdsucces());
			logger.logPass("added succesfully");
			Assert.assertEquals("Location Count Matched", cnt, Integer.parseInt(company.get_location_count()));
			logger.logPass("Location Count Matched");
			
			

			//company.locationSelect("all");
			
		}catch(Exception e) {logger.logFail("not added"+e.getMessage());
			
		}
	}
	
	@Test(priority = 2)
	public void Edit_user_location() throws IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			manage = new manage_user_page();
			email = new EmailPage();
			company = new Company_Mapping_Page();
			Thread.sleep(2000);
			manage.UserManagements();
			company.Company_mapping();
			company.Role_dropdown("vamshidhar Auditor");
			Thread.sleep(5000);
			home.double_dropdown("vamshidhar Auditor");
			Thread.sleep(3000);
//			company.Add_location();
			home.Actions("SN Reddy LTD","Edit");
			Thread.sleep(3000);
			String LocCnt="1";
			company.locationSelect(LocCnt);
			int cnt = company.locationsSelected();
//			company.location_count();
			manage.Submitbtn();
			Thread.sleep(6000);
			Assert.assertTrue(manage.createdsucces());
			logger.logPass("added succesfully");
			Assert.assertEquals("Location Count Matched", cnt, Integer.parseInt(company.get_location_count()));
			logger.logPass("Location Count Matched");
			
			

			//company.locationSelect("all");
			
		}catch(Exception e) {logger.logFail("not added"+e.getMessage());
			
		}
	}
	
	@Test(priority = 3)
	public void dropdown() throws IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			manage = new manage_user_page();
			email = new EmailPage();
			company = new Company_Mapping_Page();
			Thread.sleep(2000);
			manage.UserManagements();
			company.Company_mapping();
			company.Role_dropdown("vamshidhar Auditor");
			Thread.sleep(5000);
			home.double_dropdown("vamshidhar Auditor");
			Thread.sleep(3000);
			Assert.assertTrue(company.data_checking());
			logger.logPass("done");
		} catch (Exception e) {
			logger.logFail("not done"+e.getMessage());
		}
		}
	
	@Test(priority = 4)
	public void delete() throws IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			manage = new manage_user_page();
			email = new EmailPage();
			company = new Company_Mapping_Page();
			Thread.sleep(2000);
			manage.UserManagements();
			company.Company_mapping();
			company.Role_dropdown("vamshidhar Auditor");
			Thread.sleep(5000);
			home.double_dropdown("vamshidhar Auditor");
			Thread.sleep(3000);
			home.Actions("SN Reddy LTD","Delete");
			home.Yes();
			Thread.sleep(6000);
//			home.deleted();
			home.Search_value("deleted successfully.");

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
