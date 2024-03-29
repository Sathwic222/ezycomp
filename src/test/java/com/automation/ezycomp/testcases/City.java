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
import com.automation.ezycomp.pageobjects.CityPage;
import com.automation.ezycomp.pageobjects.HomePage_SuperAdmin;
import com.automation.ezycomp.pageobjects.LoginPage;
import com.automation.ezycomp.pageobjects.act;

import junit.framework.Assert;

public class City extends TestBase {
	
	LoginPage loginpage;
	HomePage_SuperAdmin home; 
	ReportLog logger;
	LoginPageTest logins;
	act actss;
	CityPage City;
	
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
	public void AddNewCity() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			City = new CityPage();
			Thread.sleep(5000);
			home.NAvMenu("Masters");
			home.NAvMenu("City");
			home.NavArrowclose();
			home.AddNewButton();
			City.EnterCityName(prop.getProperty("EnterCityName"), prop.getProperty("EnterCityCode"));
			City.AddStateType();
			home.Dropdown(prop.getProperty("StateDropdown"));
			home.Submit();
			Thread.sleep(2000);
			Assert.assertTrue(home.CreatedSucees());
			logger.logPass("Test Add New City completed successfully.");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}	
	}
	
	@Test(priority=2)
	public void AddNewLCityDuplicates() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			City = new CityPage();
			home.NAvMenu("Masters");
			home.NAvMenu("City");
			home.NavArrowclose();
			home.AddNewButton();
			City.EnterCityName(prop.getProperty("EnterCityName"), prop.getProperty("EnterCityCode"));
			City.AddStateType();
			home.Dropdown(prop.getProperty("StateDropdown"));
			home.Submit();
			Thread.sleep(2000);
			Assert.assertTrue(home.Search_value("matching code"));
			logger.logPass("Masters City :- Duplicates Not Allowing");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}	
	}
	
	@Test(priority=3)
	 public void AddingRulewithblank() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			City = new CityPage();
			Thread.sleep(5000);
			home.NAvMenu("Masters");
			home.NAvMenu("City");
			home.NavArrowclose();
			home.AddNewButton();
//			home.SubmitEnabled();
			Assert.assertFalse(home.SubmitEnabled());
			logger.logPass("Adding New Rule with blank fields:- Submit button Disabled as expected for blank fields");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}		
	 }
	
	@Test(priority=4)
	 public void CityPageDropdown() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			City = new CityPage();
			Thread.sleep(5000);
			home.NAvMenu("Masters");
			home.NAvMenu("City");
			home.NavArrowclose();    
			City.TypeDropdownClick();
			home.Dropdown(prop.getProperty("StateDropdown"));
			Assert.assertTrue(home.Search_value(prop.getProperty("StateDropdown")));
			Thread.sleep(3000);
			logger.logPass("Masters Rule:Type dropdown Working 'selected value displaying in grid'");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}		
	 }
	
	@Test(priority=5)
	public void CityPageSearch() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			City = new CityPage();
			Thread.sleep(5000);
			home.NAvMenu("Masters");
			home.NAvMenu("City");
			home.NavArrowclose();
			home.Search(prop.getProperty("StateDropdown"));
			Thread.sleep(3000);
			//home.Search_value("Tax");
			Assert.assertTrue(home.Search_value(prop.getProperty("StateDropdown")));
			logger.logPass("Search With Valid Rule Name : The search results include the element that matched the search term.");
			home.Search("bnsdvsddjbms");
			Thread.sleep(3000);
			Assert.assertTrue(home.Search_value("No Data Available"));
			logger.logPass("Search With In Valid Rule Name : Act name not displayed");
			home.SearchClear();
			home.Search("tamil");
			Thread.sleep(3000);
			Assert.assertTrue(home.Search_value("Tamil"));
			logger.logPass("Search With Partial Rule Name : Dispalying Activities");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=6)
	public void CityPageActionsUpdate() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			City = new CityPage();
			Thread.sleep(5000);
			home.NAvMenu("Masters");
			home.NAvMenu("City");
			home.NavArrowclose();
			City.TypeDropdownClick();
			home.Dropdown(prop.getProperty("StateDropdown"));
			home.Search(prop.getProperty("EnterCityCode"));
			Thread.sleep(3000);
			home.Edit(prop.getProperty("EnterCityCode"));
			City.EnterCityName(prop.getProperty("EditCityName"), "");
			home.Submit();
			Thread.sleep(4000);
			Assert.assertTrue(home.Update());
			logger.logPass("City Page : Edit is Working");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=7)
	public void CityPageActionsView() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			City = new CityPage();
			Thread.sleep(5000);
			home.NAvMenu("Masters");
			home.NAvMenu("City");
			home.NavArrowclose();
			City.TypeDropdownClick();
			home.Dropdown(prop.getProperty("StateDropdown"));
			home.Search(prop.getProperty("EnterCityCode"));
			Thread.sleep(3000);
			home.View(prop.getProperty("EnterCityCode"));
			Assert.assertTrue(home.ActionsViewDisplayed(prop.getProperty("EnterCityCode")));
			logger.logPass("City Page : View is working ");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=8)
	public void CityPageActionsDelete() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			City = new CityPage();
			Thread.sleep(5000);
			home.NAvMenu("Masters");
			home.NAvMenu("City");
			home.NavArrowclose();
			City.TypeDropdownClick();
			home.Dropdown(prop.getProperty("StateDropdown"));
			home.Search(prop.getProperty("EnterCityCode"));
			Thread.sleep(3000);
			home.Delete(prop.getProperty("EnterCityCode"));
			//Thread.sleep(2000);
			home.Yes();
			Thread.sleep(2000);
			Assert.assertTrue(home.Search_value("deleted successfully."));
			logger.logPass("Rule Page : Delete is working ");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=9)
	public void Pagination() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			Thread.sleep(5000);
			home.NAvMenu("Masters");
			home.NAvMenu("City");
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


	@Test(priority=10)
	public void ExportExcel() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			home.NAvMenu("Masters");
			home.NAvMenu("City");
			home.NavArrowclose();
			logger.logInfo("Clicking on Export button");
			home.ExportButton();
			Thread.sleep(9000);
			ExcelOperations ex = new ExcelOperations(System.getProperty("user.dir") + "\\externalFiles\\downloadFiles\\Cities.xlsx");
			String sheetName = "Cities";
			int rowcount = ex.getRowcount(sheetName);
			int colcount = ex.getColcount(sheetName);
			Assert.assertEquals("Count Matching", home.Showing(),rowcount);
			logger.logPass("City Page :Export is working and count is matching ");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}

	@Test(priority=11)
	public void ValidateExportExcel() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			home.NAvMenu("Masters");
			home.NAvMenu("City");
			home.NavArrowclose();
			Iterator<Object[]> tblData = home.getTableData();
			logger.logInfo("Clicking on Export button");
			home.ExportButton();
			Thread.sleep(5000);
			ExcelOperations ex = new ExcelOperations(System.getProperty("user.dir") + "\\externalFiles\\downloadFiles\\Cities.xlsx");
			String sheetName = "Cities"; //workbook.getSheetAt(0);
			int rowcount = ex.getRowcount(sheetName);
			int colcount = ex.getColcount(sheetName);
			//List<Object[]> xlData = ex.getData(sheetName,rowcount,colcount);
			Iterator<Object[]> xlData = ex.getData(sheetName,rowcount,colcount);
			Assert.assertTrue(home.compareListColumnCount(tblData, xlData));
			logger.logPass("Export is working and Column count is matching ");
			String[] col = {"City Name","City Code","State Name"};
			Assert.assertTrue(home.compareColumnNames(xlData,col));
			logger.logPass("City page Export is working and columns names are matching ");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}

	//"Act Name","Rule Name","Rule No","Section No","Activity Name","Establishment Type","State Name","Form Name","Compliance Nature","Proof Of Compliance","Penalty","Risk","Maximum Penalty Amount","Impriosonment","Continuing Penalty","Cancellation Suspension Of License","Statutory Authority","Compliance Description","Audit Type"


	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	@AfterSuite
	public void endTestSuite() {
		logger.endTestSuite();
	}
}
