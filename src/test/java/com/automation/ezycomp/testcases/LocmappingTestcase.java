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
	public void Add_comp_locationmapping() throws InterruptedException, IOException {
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
			mapping.compdop("Filpkart");
			mapping.Dropdown("Filpkart");
			Thread.sleep(3000);
			mapping.asscompdop("BigSales");
			mapping.Dropdown("BigSales");

			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			mapping.actionbtn();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			mapping.ActionsButtonAdd();
			mapping.statedrop("Telangana");
			mapping.Dropdown("Telangana");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			mapping.citydrop("Hyderabad");
			mapping.Dropdown("Hyderabad");

			mapping.locname("AutoMatIom");
			mapping.loccode("audo");
			mapping.conpername("munna");
			mapping.mobile("7890123453");
			mapping.email("sathwic222@gmail.com");
			mapping.address("1-12,ravind colony,anderi,mumbai");
			Thread.sleep(5000);
			mapping.submitbtn();
			//Assert.assertTrue();
			logger.logPass("Add location for company is passed");
		} catch (Exception e) {
			logger.logFail("Add location for company is failed" + e.getMessage());
		}
	}

	// location will be deleted
	@Test(priority = 2)
	public void loc_delete() throws InterruptedException, IOException {
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
		public void search() throws InterruptedException, IOException {
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

			@Test(priority = 4)
			public void invalid_search() throws InterruptedException, IOException {
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
					mapping.search("tyvyv12..0");

					logger.logPass(" location for company is passed");
				} catch (Exception e) {
					logger.logFail(" location for company is failed" + e.getMessage());

				}
			}
				@Test(priority = 5)
				public void Edit_actions() throws InterruptedException, IOException {
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
						driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
						mapping.compdop("Etv AndhraPradesh");
						mapping.Dropdown("Etv AndhraPradesh");
						driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
						mapping.asscompdop("Etv Win");
						mapping.Dropdown("Etv Win");
						driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
						mapping.edit();
						mapping.locname("Telegram_12_qwe");
						mapping.submitbtn();




						logger.logPass(" location for company is passed");
					} catch (Exception e) {
						logger.logFail(" location for company is failed" + e.getMessage());

					}

			}
	@Test(priority = 6)
	public void View_actions() throws InterruptedException, IOException {
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
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			mapping.compdop("Etv AndhraPradesh");
			mapping.Dropdown("Etv AndhraPradesh");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			mapping.asscompdop("Etv News");
			mapping.Dropdown("Etv News");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			mapping.view();

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


