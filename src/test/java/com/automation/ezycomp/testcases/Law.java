package com.automation.ezycomp.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import com.automation.ezycomp.pageobjects.act;
import com.automation.ezycomp.utils.ExcelOperations;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.automation.ezycomp.base.TestBase;
import com.automation.ezycomp.functionLabrary.ReportLog;
import com.automation.ezycomp.pageobjects.HomePage_SuperAdmin;
import com.automation.ezycomp.pageobjects.LoginPage;

import junit.framework.Assert;

public class Law extends TestBase {

	LoginPage loginpage;
	HomePage_SuperAdmin home; 
	ReportLog logger;
	LoginPageTest logins;
	
	@BeforeSuite
	public void testSuite() {
		logger = new ReportLog(driver);
	}
	
	@BeforeMethod 
	public void setup(Method m) throws InterruptedException, IOException {
		logger.startTest(m.getName());
		initialization();
		driver.manage().window().maximize();
		String url = prop.getProperty("url");
		driver.get(url);
		
	}
	
	@Test(priority=1)
	public void AddNewLaw() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			home.Masters();
			home.Lawopen();
			home.NavArrowclose();
			home.AddNewButton();
		    home.Law("Tax", "this is the law");
			home.Submit();
			home.waitForElement(home.Success);
//			Thread.sleep(2000);
			Assert.assertTrue(home.CreatedSucees());
			logger.logPass("Test AddNewLaw completed successfully.");
			logger.logPass("Adding New law with blank fields:- Submit button Disabled as expected for blank fields");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}	
	}
	
	
	@Test(priority=2)
	public void AddNewLawDuplicate() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			home.Masters();
			home.Lawopen();
			home.NavArrowclose();
			home.AddNewButton();
		    home.Law("Tax", "this is the law");
			home.Submit();
			home.waitForElement(home.Duplicate);
			Thread.sleep(2000);
			Assert.assertTrue(home.AlreadyExixts());
			logger.logPass("Duplicate Not Taken: error throw as already exits.");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}	
	}
	
	@Test(priority=3)
	public void AddNewLawWithBlank() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			home.Masters();
			home.Lawopen();
			home.NavArrowclose();
			home.AddNewButton();
			home.Law(" ", " ");
			home.SubmitDisabled();
			logger.logPass("Adding New law with blank fields:- Submit button Disabled as expected for blank fields");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}	
	}
	
	@Test(priority=4)
	public void Search() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			home.Masters();
			home.Lawopen();
			home.NavArrowclose();
			home.Search("Tax");
			home.waitForElement(home.Searchvalue("Tax"));
			home.Search_value("Tax");
			Assert.assertTrue(home.Search_value("Tax"));
			logger.logPass("Search With Valid Law : The search results include the element that matched the search term.");
			home.Search("tobe");
			home.waitForElement(home.Searchvalue("No Data Available"));
			Assert.assertTrue(home.Search_value("No Data Available"));
			logger.logPass("Search With In Valid Law : Law name displayed");
			home.SearchClear();
			home.Search("ta");
			Thread.sleep(3000);
			Assert.assertTrue(home.Search_value("Ta"));
			logger.logPass("Search With Partial Law Name :No data Avilable displayed");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	
	@Test(priority=5)
	public void LawPageActionsUpdate() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			home.Masters();
			home.Lawopen();
			home.NavArrowclose();
//			Thread.sleep(5000);
			home.Search("Tax");
			home.waitForElement(home.Searchvalue("Tax"));
			home.Edit("Tax");
			home.NameEdit("taxs");
			home.Submit();
			home.waitForElement(home.UpdateSuccess);
			Assert.assertTrue(home.Update());
			logger.logPass("Law Page : Edit is Working");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=6)
	public void LawPageActionsView() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			home.Masters();
			home.Lawopen();
			home.NavArrowclose();
			Thread.sleep(5000);
			home.Search("Tax");
			home.waitForElement(home.Searchvalue("Tax"));
			home.View("Tax");
			Assert.assertTrue(home.ActionsViewDisplayed("Tax"));
			logger.logPass("Law Page : View is working ");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=7)
	public void LawPageActionsDelete() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			home.Masters();
			home.Lawopen();
			home.NavArrowclose();
			Thread.sleep(5000);
			home.Search("Tax");
			home.waitForElement(home.Searchvalue("Tax"));
			home.Delete("Tax");
			home.waitForElement(home.Yes);
//			Thread.sleep(2000);
			home.Yes();
			Thread.sleep(2000);
			Assert.assertTrue(home.Search_value("deleted successfully."));
			logger.logPass("Law Page : Delete is working ");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	@Test(priority=8)
	public void ExportExcel() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			home.NAvMenu("Masters");
			home.NAvMenu("Law Category");
			home.NavArrowclose();
			home.ExportButton();
			Thread.sleep(9000);
			ExcelOperations ex = new ExcelOperations(System.getProperty("user.dir") + "\\externalFiles\\downloadFiles\\Laws.xlsx");
			String sheetName = "Laws";
			int rowcount = ex.getRowcount(sheetName);
			int colcount = ex.getColcount(sheetName);
			Assert.assertEquals("Count Matching", home.Showing(),rowcount);
			logger.logPass("Law Page : Export is working and count is matching ");
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
