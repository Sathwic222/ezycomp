
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
import com.automation.ezycomp.pageobjects.Companies;
import com.automation.ezycomp.pageobjects.CompaniesAddnew;
import com.automation.ezycomp.pageobjects.HomePage_SuperAdmin;
	import com.automation.ezycomp.pageobjects.LoginPage;

	import junit.framework.Assert;

	public class CompaniesTestcase extends TestBase {
		
		LoginPage loginpage;
		HomePage_SuperAdmin home; 
		ReportLog logger;
		Companies Company;
		CompaniesAddnew company;
		
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
				loginpage = new LoginPage();
				Company = new Companies();
				company = new CompaniesAddnew();
				logger.logInfo("Entering username and password");
				loginpage.login("superadmin@ezycomp.com", "test123");
				loginpage.loginbtn();
				Thread.sleep(5000);
				Company.Rightarrow();
				Company.Companieslist();
				Company.ManageCompanies();
				Company.Search("filpkart");
				Thread.sleep(5000);
				//Assert.assertTrue();
				logger.logPass("Login functionality for super admin is passed");
			} catch (Exception e) {
				logger.logFail("Login functionality for super admin is failed"+e.getMessage());
				
			}
			
			
		 }
		
		@Test(priority=2)
		public void compdetails() throws InterruptedException, IOException {
			try {
			loginpage = new LoginPage();
			home = new HomePage_SuperAdmin();
			company = new CompaniesAddnew();
			logger.logInfo("Entering username and password");
			loginpage.login("superadmin@ezycomp.com", "test123");
			loginpage.loginbtn();
			Thread.sleep(5000);
			company.Rightarrow();
			company.Companieslist();
			company.ManageCompanies();	
			company.addbutton();
			company.companycode("Visa");
			//company.Associatecompany();
		    company.copyAssociatecompany();
			company.companyname("Virtusa");
			company.businesstypedop();
			company.Dropdown("IT");
			company.website("www.virtusa.com");
			company.esttypedop();
			company.Dropdown("Factory");
			company.statusdop();
			company.Dropdown("Active");
			company.empdop();
			company.Dropdown("1-100");
			Thread.sleep(3000);
			
			company.Logoupload("C:\\Users\\sathw\\Downloads//download.png");
			Thread.sleep(5000);
			company.create();
			Thread.sleep(3000);
			company.save();
			company.savenxt();
		
		// spoc details
			company.address();
			company.statedop();
			company.Dropdown("Maharashtra");	
			company.citydop();
			company.Dropdown("Mumbai");	
			company.countrydop();
			company.Dropdown("India");
			company.contactno();
			company.compemail();
			company.name();
			company.designation();
			company.department();
			company.contactpermob();
			company.contactperemail();
			Thread.sleep(5000);
			company.save();
			Thread.sleep(3000);
			company.savenext();
			
			
			logger.logPass("shown as per given");
		    }catch (Exception e) {
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

	