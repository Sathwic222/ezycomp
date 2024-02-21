package com.automation.ezycomp.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;

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
import com.automation.ezycomp.pageobjects.Statepage;
import com.automation.ezycomp.pageobjects.act;

import junit.framework.Assert;

public class State extends TestBase {

	LoginPage loginpage;
	HomePage_SuperAdmin home; 
	ReportLog logger;
	LoginPageTest logins;
	Statepage State;
	act actss;
	
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
	public void AddNewState() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			State = new Statepage();
			home.Masters();
			home.State();
			home.NavArrowclose();
			home.AddNewButton();
		    State.StateAdd("Tax", "ta");
			home.Submit();
			Thread.sleep(5000);
			Assert.assertTrue(home.CreatedSucees());
			logger.logPass("Test AddNewLaw completed successfully.");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}	
	}
	
	@Test(priority=2)
	public void AddNewStateWithDuplicate() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			State = new Statepage();
			home.Masters();
			home.State();
			home.NavArrowclose();
			home.AddNewButton();
			State.StateAdd("Tax", "ta");
			home.Submit();
			Thread.sleep(2000);
			Assert.assertTrue(home.Search_value("Please update"));
			logger.logPass("Duplicate Not Taken: error throw as already exits.");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}	
	}
	
	@Test(priority=3)
	public void AddNewStateWithBlank() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			State = new Statepage();
			home.Masters();
			home.State();
			home.NavArrowclose();
			home.AddNewButton();
			State.StateAdd("Tax","");
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
			State = new Statepage();
			home.Masters();
			home.State();
			home.NavArrowclose();
			home.Search("Tax");
			Thread.sleep(3000);
			home.Search_value("Tax");
			Assert.assertTrue(home.Search_value("Tax"));
			logger.logPass("Search With Valid State : The search results include the element that matched the search term.");
			home.Search("tobe");
			Thread.sleep(3000);
			Assert.assertTrue(home.Search_value("No Data Available"));
			logger.logPass("Search With In Valid State :No data Available displayed");
			home.SearchClear();
			home.Search("ta");
			Thread.sleep(3000);
			Assert.assertTrue(home.Search_value("Ta"));
			logger.logPass("Search With Partial State Name :State name displayed");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	
	@Test(priority=5)
	public void StatePageActionsUpdate() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			State = new Statepage();
			home.Masters();
			home.State();
			home.NavArrowclose();
			Thread.sleep(5000);   
			home.Search("Tax");
			Thread.sleep(3000);
			home.Edit("Tax");
			State.StateEdit("a");
			home.Submit();
			Thread.sleep(3000);
			Assert.assertTrue(home.Update());
			logger.logPass("Law Page : Edit is Working");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=6)
	public void StatePageActionsView() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			State = new Statepage();
			home.Masters();
			home.State();
			home.NavArrowclose();
			Thread.sleep(5000);   
			home.Search("Tax");
			Thread.sleep(3000);
			home.View("Taxa");
			Assert.assertTrue(home.ActionsViewDisplayed("Tax"));
			logger.logPass("Law Page : View is working ");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=7)
	public void StatePageActionsDelete() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			State = new Statepage();
			home.Masters();
			home.State();
			home.NavArrowclose();
			Thread.sleep(5000);   
			home.Search("Tax");
			Thread.sleep(3000);
			home.Delete("Taxa");
			Thread.sleep(2000);
			home.Yes();
			Thread.sleep(2000);
			Assert.assertTrue(home.Search_value("deleted successfully."));
			logger.logPass("Law Page : Delete is working ");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=8)
	public void Pagination() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			Thread.sleep(5000);
			home.NAvMenu("Masters");
			home.NAvMenu("State");
			home.NavArrowclose();
			home.Pagination("Next");
			Thread.sleep(2000);
			Assert.assertTrue(home.Pageshowing("51 - 100"));
			logger.logPass("pagination is working Navigate to next page");
			home.Pagination("Next");
			Thread.sleep(2000);
			Assert.assertTrue(home.Pageshowing("101 - 150"));
			logger.logPass("pagination is working Navigate to next page");
			home.Pagination("Previous");
			Thread.sleep(2000);
			Assert.assertTrue(home.Pageshowing("51 - 100"));
			logger.logPass("pagination is working Navigate to Previous page");
			
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}	
	}

	@Test(priority=9)
	public void ExportExcel() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			home.NAvMenu("Masters");
			home.NAvMenu("State");
			home.NavArrowclose();
			logger.logInfo("Clicking on Export button");
			home.ExportButton();
			Thread.sleep(9000);
			ExcelOperations ex = new ExcelOperations(System.getProperty("user.dir") + "\\externalFiles\\downloadFiles\\States.xlsx");
			String sheetName = "States";
			int rowcount = ex.getRowcount(sheetName);
			int colcount = ex.getColcount(sheetName);
			Assert.assertEquals("Count Matching", home.Showing(),rowcount);
			logger.logPass("State Page : Export is working and count is matching ");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}

	@Test(priority=10)
	public void ValidateExportExcel() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			home.NAvMenu("Masters");
			home.NAvMenu("State");
			home.NavArrowclose();
			Iterator<Object[]> tblData = home.getTableData();
			logger.logInfo("Clicking on Export button");
			home.ExportButton();
			Thread.sleep(5000);
			ExcelOperations ex = new ExcelOperations(System.getProperty("user.dir") + "\\externalFiles\\downloadFiles\\States.xlsx");
			String sheetName = "States"; //workbook.getSheetAt(0);
			int rowcount = ex.getRowcount(sheetName);
			int colcount = ex.getColcount(sheetName);
			//List<Object[]> xlData = ex.getData(sheetName,rowcount,colcount);
			Iterator<Object[]> xlData = ex.getData(sheetName,rowcount,colcount);
			Assert.assertTrue(home.compareListColumnCount(tblData, xlData));
			logger.logPass("Export is working and Column count is matching ");
			String[] col = {"State Name","State Code"};
			Assert.assertTrue(home.compareColumnNames(xlData,col));
			logger.logPass("State page Export is working and columns names are matching ");
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
