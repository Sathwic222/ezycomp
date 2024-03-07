
	package com.automation.ezycomp.testcases;

	import java.io.IOException;
	import java.lang.reflect.Method;

	import com.automation.ezycomp.pageobjects.*;
	import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.Test;

	import com.automation.ezycomp.base.TestBase;
	import com.automation.ezycomp.functionLabrary.ReportLog;

	import junit.framework.Assert;

	import java.util.PriorityQueue;
	import java.util.concurrent.TimeUnit;

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

		@Test(priority = 1)
		public void Search() throws InterruptedException, IOException {
			try {
				loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
				home = new HomePage_SuperAdmin();
				//loginpage = new LoginPage();
				Company = new Companies();
				company = new CompaniesAddnew();
				// logger.logInfo("Entering username and password");
				//loginpage.login("superadmin@ezycomp.com", "test123");
				//loginpage.loginbtn();
				//Thread.sleep(5000);
				//Company.Rightarrow();
				Company.Companieslist();
				Company.ManageCompanies();
				Company.Search("filpkart");
				Thread.sleep(5000);
				//Assert.assertTrue();
				logger.logPass("Login functionality for super admin is passed");
			} catch (Exception e) {
				logger.logFail("Login functionality for super admin is failed" + e.getMessage());

			}

		}

/// Adding details to companies 		

		@Test(priority = 2)
		public void AddCompanyWithValidDetails() throws InterruptedException, IOException {
			try {
				loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
				company = new CompaniesAddnew();
				home = new HomePage_SuperAdmin();
				logger.logInfo("clicking on manage companies in companies ");
				home.NAvMenu("Companies");
				home.NAvMenu("Manage Companies");
				//company.Companieslist();
				//company.ManageCompanies();
				//company.addbutton();
				logger.logInfo("Entering Company Details");
				company.companycode();
				//company.Associatecompany();
				Thread.sleep(5000);
                //company.Parentcompdop("Telegram");
//              //  company.Dropdown("Telegram");
				//company.copyAssociatecompany();
				company.companyname();
				company.businesstypedop("IT");
				company.Dropdown("IT");
				company.website("www.virtusa.com");
				company.esttypedop();
				company.Dropdown("Factory");
				company.statusdop();
				company.Dropdown("Active");
				company.empdop();
				company.Dropdown("1-100");
				//Thread.sleep(3000);
				company.scrollIntoView(company.Logoupload);
				company.Logoupload("C:\\Users\\sathw\\OneDrive\\Pictures\\download (3).png");
				Thread.sleep(5000);
				company.create();
				Thread.sleep(2000);
				Assert.assertTrue(home.CreatedSucees());
				Thread.sleep(3000);
				//company.save();
				company.savenxt();
				// spoc details---------------------------------
				logger.logInfo("Entering SPOC Details");
				Thread.sleep(5000);
				company.address("Maharastra");
				company.statedop();
				company.Dropdown("Maharashtra");
				Thread.sleep(3000);
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

				// Statutory Details
				logger.logInfo("Entering Statutory Details");
				Thread.sleep(5000);
				company.Pannumber();
				company.Tannumber();
				company.FullName();
				company.pansurname();
				company.pandesignation();
				company.panmobile();
				company.panemail();
				company.panplace();
				Thread.sleep(2000);
				company.gstnumbr();
				company.save();
				Thread.sleep(3000);
				company.savenext();


				// SMTP Details
				logger.logInfo("Entering SMTP Details");
				Thread.sleep(6000);
				company.email();
				company.passwrd();
				company.hos();
				Thread.sleep(2000);
				company.por();
				company.Dropdown("465");
				Thread.sleep(2000);
				company.save();
				company.Saveclose();
				logger.logPass("shown as per given");
			} catch (Exception e) {
				logger.logFail("Login functionality for super admin is failed" + e.getMessage());

			}
		}

		@Test(priority = 3)
		public void AddingCompanyDuplicate() throws InterruptedException, IOException {
			try {
				loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
				home = new HomePage_SuperAdmin();
				company = new CompaniesAddnew();
				home.NAvMenu("Companies");
				home.NAvMenu("Manage Companies");
				home.NavArrowclose();
				//company.Companieslist();
				//company.ManageCompanies();
				company.addneww();
				logger.logInfo("Entering Company With Duplicate Details");
				company.companycode("abcd");
				//company.Associatecompany();
				// company.copyAssociatecompany();
				company.companyname("Sony");
				company.businesstypedop("IT");
				company.Dropdown("IT");
				company.website("www.virtusa.com");
				company.esttypedop();
				company.Dropdown("Factory");
				company.statusdop();
				company.Dropdown("Active");
				company.empdop();
				company.Dropdown("1-100");
				//Thread.sleep(3000);
				company.scrollIntoView(company.Logoupload);
				company.Logoupload("C:\\Users\\sathw\\OneDrive\\Pictures\\download (3).png");
				Thread.sleep(5000);
				company.create();
				Thread.sleep(2000);
				Assert.assertTrue(home.AlreadyExixts());
				logger.logPass("Companies : Duplicates Not taking");
			} catch (Exception e) {
				logger.logFail("An exception occurred:" + e.getMessage());
			}

		}

		@Test(priority = 4)
		public void CompaniesActionsUpdate() throws InterruptedException, IOException {
			try {
				loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
				home = new HomePage_SuperAdmin();
				Company = new Companies();
				company = new CompaniesAddnew();
				Company.Companieslist();
				Company.ManageCompanies();
				// home.NavArrowclose();
				Company.Search("Medicover");
				logger.logInfo("Update the details in companies");
				Thread.sleep(5000);
				company.edit("Medicover");
				//company.companyname1();
				//company.website("www.medicover.com");
				company.businesstypedop("NonIT");
				company.save();
				home.waitForElement(home.UpdateSuccess);
				Assert.assertTrue(home.Update());
				logger.logPass("Companies Page : Edit is Working");
			} catch (Exception e) {
				logger.logFail("An exception occurred:" + e.getMessage());
			}
		}


		@Test(priority = 5)
		public void comp() throws InterruptedException, IOException {
			try {
				loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
				home = new HomePage_SuperAdmin();
				Company = new Companies();
				company = new CompaniesAddnew();
				Company.Companieslist();
				Company.ManageCompanies();
				// home.NavArrowclose();
				company.Search("Brands");
				driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
				company.delete("Brands");
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				company.yes();
				logger.logPass("Company details will be deleted ");
			} catch (Exception e) {
				logger.logFail("Login functionality for super admin is failed" + e.getMessage());
			}

		}

		@Test(priority = 6)
		public void invalidSearch() throws InterruptedException, IOException {
			try {
				loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
				home = new HomePage_SuperAdmin();
				Company = new Companies();
				company = new CompaniesAddnew();
				Company.Companieslist();
				Company.ManageCompanies();
				Company.Search("filart");
				Thread.sleep(5000);
				//Assert.assertTrue();
				logger.logPass("Companies Page : invalid data search is Working");
			} catch (Exception e) {
				logger.logFail("An exception occurred" + e.getMessage());

			}

		}


		@Test(priority = 7)
		public void CompaniesActionsview() throws InterruptedException, IOException {
			try {
				loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
				home = new HomePage_SuperAdmin();
				company = new CompaniesAddnew();
				Company.Companieslist();
				Company.ManageCompanies();
				// home.NavArrowclose();
				Company.Search("Medicover");
				Thread.sleep(5000);
				company.view("Medicover");
				Thread.sleep(5000);
				company.closbtn();
				home.waitForElement(home.UpdateSuccess);
				Assert.assertTrue(home.Update());
				logger.logPass("Companies Page : Edit is Working");
			} catch (Exception e) {
				logger.logFail("An exception occurred:" + e.getMessage());
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

	