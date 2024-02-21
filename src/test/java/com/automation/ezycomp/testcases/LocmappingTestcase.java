package com.automation.ezycomp.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import com.automation.ezycomp.base.TestBase;
import com.automation.ezycomp.functionLabrary.ReportLog;
import com.automation.ezycomp.pageobjects.Companies;
import com.automation.ezycomp.pageobjects.CompaniesAddnew;
import com.automation.ezycomp.pageobjects.HomePage_SuperAdmin;
import com.automation.ezycomp.pageobjects.Locationmapping;
import com.automation.ezycomp.pageobjects.LoginPage;

public class LocmappingTestcase extends TestBase {

	LoginPage loginpage;
	HomePage_SuperAdmin home;
	ReportLog logger;
	Locationmapping mapping;


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
// Adding locations to companies
	@Test(priority = 1)
	public void locationmapping() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			loginpage = new LoginPage();
			mapping = new Locationmapping();
			logger.logInfo("Entering username and password");
			mapping.Homepage();
			//mapping.NavDoubleright();
			mapping.Companieslist();
			mapping.locmap();
			Thread.sleep(3000);
			mapping.compdop("ETV AndhraPradesh");
			mapping.Dropdown("Etv AndhraPradesh");
			Thread.sleep(3000);
			mapping.asscompdop("ETV News");
			mapping.Dropdown("ETV News");

			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			mapping.actionbtn();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			mapping.ActionsButtonAdd();
			mapping.statedrop("Maharashtra");
			mapping.Dropdown("Maharashtra");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			mapping.citydrop("Barshi");
			mapping.Dropdown("Barshi");

			mapping.locname();
			mapping.loccode();
			mapping.conpername();
			mapping.mobile();
			mapping.email();
			mapping.address();
			mapping.submitbtn();
			//Assert.assertTrue();
			logger.logPass("Add location for company is passed");
		} catch (Exception e) {
			logger.logFail("Add location for company is failed" + e.getMessage());
		}
	}

	// location will be deleted
	@Test(priority = 2)
	public void locmap() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			loginpage = new LoginPage();
			mapping = new Locationmapping();
			logger.logInfo("Entering username and password");
			mapping.Homepage();
			//mapping.NavDoubleright();
			mapping.Companieslist();
			mapping.locmap();
			mapping.compdop("sathwic IT solutions");
			mapping.Dropdown("sathwic IT solutions");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			mapping.asscompdop("Sathwic IT Services");
			mapping.Dropdown("Sathwic IT Services");

			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			mapping.delete();

			logger.logPass(" location for company is passed");
		} catch (Exception e) {
			logger.logFail(" location for company is failed" + e.getMessage());


		}
	}
       // Searching the location,contact
		@Test(priority = 3)
		public void locmap3() throws InterruptedException, IOException {
			try {
				loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
				home = new HomePage_SuperAdmin();
				loginpage = new LoginPage();
				mapping = new Locationmapping();
				logger.logInfo("Entering username and password");
				mapping.Homepage();
				//mapping.NavDoubleright();
				mapping.Companieslist();
				mapping.locmap();
				mapping.compdop("sathwic IT solutions");
				mapping.Dropdown("sathwic IT solutions");
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				mapping.asscompdop("Sathwic IT Services");
				mapping.Dropdown("Sathwic IT Services");

				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				mapping.search("KON");

				logger.logPass(" location for company is passed");
			} catch (Exception e) {
				logger.logFail(" location for company is failed" + e.getMessage());



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


