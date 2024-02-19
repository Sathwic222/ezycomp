package com.automation.ezycomp.testcases;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

//import org.openqa.selenium.Keys;
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
import com.automation.ezycomp.pageobjects.act;

import junit.framework.Assert;

public class addacts extends TestBase {
	
	LoginPage loginpage;
	HomePage_SuperAdmin home; 
	ReportLog logger;
	act actss;
	
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
	 public void AddingAct() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			home.Masters();
			home.act();
			home.NavArrowclose();
			actss.ActionClick();
			actss.ActionsAdd();
			actss.EnterActName(prop.getProperty("EnterActNameInput"));
			actss.TypeClick();
			home.Dropdown(prop.getProperty("Estblishmenttypevalue"));
			actss.LawClick();
			home.Dropdown(prop.getProperty("LawDropDownValue"));
			home.Submit();
			Thread.sleep(5000);
			Assert.assertTrue(home.CreatedSucees());
			logger.logPass("Masters Act: Adding new law with valid inputs");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
			
	 }
	
	@Test(priority=2)
	 public void AddingActsDuplicate() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			home.Masters();
			home.act();
			home.NavArrowclose();
			actss.ActionClick();
			home.ActionsAdd("Add New");
			actss.EnterActName(prop.getProperty("EnterActNameInput"));
			actss.TypeClick();
			home.Dropdown(prop.getProperty("Estblishmenttypevalue"));
			actss.LawClick();
			home.Dropdown(prop.getProperty("LawDropDownValue"));
			home.Submit();
			Thread.sleep(5000);
			Assert.assertTrue(home.AlreadyExixts());
			logger.logPass("Masters Act: Duplicates Not taking");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
			
	 }
	
	@Test(priority=3)
	 public void AddingActwithblank() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			home.Masters();
			home.act();
			home.NavArrowclose();
			actss.ActionClick();
			actss.ActionsAdd();
			actss.EnterActName("");
			home.SubmitDisabled();
//			Assert.assertTrue(home.SubmitDisabled());
			logger.logPass("Adding New Act with blank fields:- Submit button Disabled as expected for blank fields");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
			
	 }
	
	@Test(priority=4)
	 public void Dropdown() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			home.Masters();
			home.act();
			home.NavArrowclose();
			actss.Establishment();
			home.Dropdown(prop.getProperty("Estblishmenttypevalue"));
			Assert.assertTrue(home.Search_value(prop.getProperty("Estblishmenttypevalue")));
			Thread.sleep(3000);
			logger.logPass("Masters Act: Establishment type dropdown Working 'selected value displaying in grid'");
			actss.LawDropdown();
			home.Dropdown(prop.getProperty("LawDropDownValue"));
			Thread.sleep(3000);
			Assert.assertTrue(home.Search_value(prop.getProperty("LawDropDownValue")));
			logger.logPass("Masters Act: Law dropdown Working 'selected value displaying in grid'");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}		
	 }
	
	@Test(priority=5)
	public void Search() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			home.Masters();
			home.act();
			home.NavArrowclose();
			home.Search(prop.getProperty("EnterActNameInput"));
			Thread.sleep(3000);
			//home.Search_value("Tax");
			Assert.assertTrue(home.Search_value(prop.getProperty("EnterActNameInput")));
			logger.logPass("Search With Valid Act : The search results include the element that matched the search term.");
			home.Search("bnsdvsddjbms");
			Thread.sleep(3000);
			Assert.assertTrue(home.Search_value("No Data Available"));
			logger.logPass("Search With In Valid Act : Act name not displayed");
			home.SearchClear();
			home.Search("Fac");
			Thread.sleep(3000);
			Assert.assertTrue(home.Search_value("Fac"));
			logger.logPass("Search With Partial Act Name : Dispalying Acts");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=6)
	public void LawPageActionsUpdate() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			home.Masters();
			home.act();
			home.NavArrowclose();
			Thread.sleep(5000);
			home.Search(prop.getProperty("EnterActNameInput"));
			Thread.sleep(3000);
			home.Edit(prop.getProperty("EnterActNameInput"));
			actss.TypeClick();
			home.Dropdown(prop.getProperty("EditEstablishment"));
			home.Submit();
			Thread.sleep(4000);
			Assert.assertTrue(home.Update());
			logger.logPass("Act Page : Edit is Working");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=7)
	public void LawPageActionsView() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			home.Masters();
			home.act();
			home.NavArrowclose();
			Thread.sleep(5000);
			home.Search(prop.getProperty("EnterActNameInput"));
			Thread.sleep(3000);
			home.View(prop.getProperty("EnterActNameInput"));
			Assert.assertTrue(home.ActionsViewDisplayed(prop.getProperty("EnterActNameInput")));
			logger.logPass("Act Page : View is working ");
			home.Close();
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=8)
	public void LawPageActionsDelete() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			home.Masters();
			home.act();
			home.NavArrowclose();
			Thread.sleep(5000);
			home.Search(prop.getProperty("EnterActNameInput"));
			Thread.sleep(3000);
			home.Delete(prop.getProperty("EnterActNameInput"));
			Thread.sleep(2000);
			home.Yes();
			Thread.sleep(2000);
			Assert.assertTrue(home.Search_value("deleted successfully."));
			logger.logPass("Act Page : Delete is working ");
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
			home.NAvMenu("Act");
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
			home.Masters();
			home.act();
			home.NavArrowclose();
			actss.ActionClick();
			actss.ActionsButton("Export");
			ExcelOperations ex = new ExcelOperations(System.getProperty("user.dir") + "\\externalFiles\\downloadFiles\\Acts.xlsx");

			String sheetName = "Acts";
			int rowcount = ex.getRowcount(sheetName);
			int colcount = ex.getColcount(sheetName);



		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}

	}
	
//	@Test(priority=3)
//	 public void File() throws InterruptedException, IOException {
//		try {
//			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
//			home = new HomePage_SuperAdmin();
//			actss = new act();
//			Thread.sleep(5000);
//			home.Masters();
//			home.act();
//			home.NavArrowclose();
//			actss.ActionClick();
//			actss.Choosefile("C:\\Users\\DELL\\Downloads\\ActsTemplat.xlsx");
////			Assert.assertTrue(home.SubmitDisabled());
//			logger.logPass("Adding New Act with blank fields:- Submit button Disabled as expected for blank fields");
//		} catch (Exception e) {
//			logger.logFail("An exception occurred:"+e.getMessage());
//		}
//			
//	 }
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	@AfterSuite
	public void endTestSuite() {
		logger.endTestSuite();
	}

}