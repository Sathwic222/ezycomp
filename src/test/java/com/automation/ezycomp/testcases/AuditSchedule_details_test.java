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
import com.automation.ezycomp.pageobjects.Audit_Schedule_details_page;
import com.automation.ezycomp.pageobjects.HomePage_SuperAdmin;
import com.automation.ezycomp.pageobjects.LoginPage;
import com.automation.ezycomp.pageobjects.manage_user_page;

import junit.framework.Assert;

public class AuditSchedule_details_test extends TestBase {
	LoginPage loginpage;
	HomePage_SuperAdmin home; 
	ReportLog logger;
	Audit_Schedule_details_page Audit;
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
	@Test(priority = 1)
	public void Audit_schedule_delete() throws InterruptedException, IOException {
		try {
		loginpage = new LoginPage(prop.getProperty("Superadmin"),prop.getProperty("password"));
		home = new HomePage_SuperAdmin();
		Audit = new Audit_Schedule_details_page();
		manage = new manage_user_page();
		Thread.sleep(3000);
		Audit.Audit_Management();
		Audit.A_S_Details();
		Audit.Audit_company();
		Thread.sleep(3000);
		home.Dropdown("AXIS");
		Thread.sleep(3000);
		Audit.Audit_ass_company();
		Thread.sleep(3000);
		home.Dropdown("Axis bank");
		Audit.Audit_location();
		Thread.sleep(3000);
		home.Dropdown("chn");
//		Audit.Advance();
//		Thread.sleep(3000);
//		Audit.month_year();
//		Audit.month();
		Audit.checkbox();
		Audit.delete();
		Thread.sleep(3000);
		Audit.yes();
		Thread.sleep(3000);
		Assert.assertTrue(manage.deletesucces());
		logger.logPass("deleted succesfully");
		}catch(Exception e) {
			logger.logFail(" not deleted "+e.getMessage());
			
		}
		
	}
	

@Test(priority = 2)
public void Audit_schedule_bulkdelete() throws InterruptedException, IOException {
	try {
	loginpage = new LoginPage(prop.getProperty("Superadmin"),prop.getProperty("password"));
	home = new HomePage_SuperAdmin();
	Audit = new Audit_Schedule_details_page();
	Thread.sleep(3000);
	Audit.Audit_Management();
	Audit.A_S_Details();
	Audit.Audit_company();
	Thread.sleep(3000);
	home.Dropdown("AXIS");
	Thread.sleep(3000);
	Audit.Audit_ass_company();
	Thread.sleep(3000);
	home.Dropdown("Axis bank");
	Audit.Audit_location();
	Thread.sleep(3000);
	home.Dropdown("chn");
//	Audit.Advance();
//	Thread.sleep(3000);
//	Audit.month_year();
//	Audit.month();
	Audit.checkbox();
//	Audit.delete();
	Audit.Bulk_deleted();
	Thread.sleep(3000);
	Audit.yes();
	Thread.sleep(3000);
	Assert.assertTrue(manage.deletesucces());
	logger.logPass("deleted succesfully");
	}catch(Exception e) {
		logger.logFail(" not deleted "+e.getMessage());
		
	}
	
}

@Test(priority = 2)
public void Audit_schedule_dropdowns() throws InterruptedException, IOException {
	try {
	loginpage = new LoginPage(prop.getProperty("Superadmin"),prop.getProperty("password"));
	home = new HomePage_SuperAdmin();
	Audit = new Audit_Schedule_details_page();
	Thread.sleep(3000);
	Audit.Audit_Management();
	Audit.A_S_Details();
	Audit.Audit_company();
	Thread.sleep(3000);
	home.Dropdown("AXIS");
	Thread.sleep(3000);
	Audit.Audit_ass_company();
	Thread.sleep(3000);
	home.Dropdown("Axis bank");
	Audit.Audit_location();
	Thread.sleep(3000);
	home.Dropdown("chn");
	home.Search_value("Axis bank");
	logger.logPass("shown as per given");
	
	
	}catch (Exception e) {
		logger.logFail("not shown"+e.getMessage());
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


