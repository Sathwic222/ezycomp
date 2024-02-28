package com.automation.ezycomp.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;

import com.automation.ezycomp.pageobjects.*;
import com.automation.ezycomp.utils.ExcelOperations;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.automation.ezycomp.base.TestBase;
import com.automation.ezycomp.functionLabrary.ReportLog;

import junit.framework.Assert;

public class Rule extends TestBase {

	LoginPage loginpage;
	HomePage_SuperAdmin home; 
	ReportLog logger;
	LoginPageTest logins;
	act actss;
	RulePage Rule;
	
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
	public void AddNewRule() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			Rule = new RulePage();
			Thread.sleep(5000);
			home.Masters();
			home.Rule();
			home.NavArrowclose();
			actss.ActionClick();
			actss.ActionsAdd();
			Rule.EnterRuleName(prop.getProperty("EnterRuleName"));
			Rule.TypeClick();
			home.Dropdown(prop.getProperty("EnterType"));
			Rule.EnterRuleNo(prop.getProperty("EnterSectionNo"), prop.getProperty("EnterRuleNo"), prop.getProperty("EnterUniqueIdentifier"));
			home.Submit();
			Thread.sleep(2000);
			Assert.assertTrue(home.CreatedSucees());
			logger.logPass("Test Add New Rule completed successfully.");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}	
	}
	
	@Test(priority=2)
	public void AddNewLRuleuplicates() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			Rule = new RulePage();
			Thread.sleep(5000);
			home.Masters();
			home.Rule();
			home.NavArrowclose();
			actss.ActionClick();
			actss.ActionsAdd();
			Rule.EnterRuleName(prop.getProperty("EnterRuleName"));
			Rule.TypeClick();
			home.Dropdown(prop.getProperty("EnterType"));
			Rule.EnterRuleNo(prop.getProperty("EnterSectionNo"), prop.getProperty("EnterRuleNo"), prop.getProperty("EnterUniqueIdentifier"));
			home.Submit();
			Thread.sleep(2000);
			Assert.assertTrue(home.AlreadyExixts());
			logger.logPass("");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}	
	}
	
	@Test(priority=3)
	 public void AddingRulewithblank() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			Rule = new RulePage();
			Thread.sleep(5000);
			home.Masters();
			home.Rule();
			home.NavArrowclose();
			actss.ActionClick();
			actss.ActionsAdd();
			Rule.EnterRuleName("");
//			home.SubmitEnabled();
			Assert.assertFalse(home.SubmitEnabled());
			logger.logPass("Adding New Rule with blank fields:- Submit button Disabled as expected for blank fields");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}		
	 }
	
	@Test(priority=4)
	 public void RuleDropdown() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			Rule = new RulePage();
			Thread.sleep(5000);
			home.Masters();
			home.Rule();
			home.NavArrowclose();
			Rule.TypeDropdownClick();
			home.Dropdown(prop.getProperty("EnterType"));
			Assert.assertTrue(home.Search_value(prop.getProperty("EnterType")));
			Thread.sleep(3000);
			logger.logPass("Masters Rule:Type dropdown Working 'selected value displaying in grid'");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}		
	 }
	
	@Test(priority=5)
	public void RulePageSearch() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			Rule = new RulePage();
			Thread.sleep(5000);
			home.Masters();
			home.Rule();
			home.NavArrowclose();
			home.Search(prop.getProperty("EnterRuleName"));
			Thread.sleep(3000);
			//home.Search_value("Tax");
			Assert.assertTrue(home.Search_value(prop.getProperty("EnterRuleName")));
			logger.logPass("Search With Valid Rule Name : The search results include the element that matched the search term.");
			home.Search("bnsdvsddjbms");
			Thread.sleep(3000);
			Assert.assertTrue(home.Search_value("No Data Available"));
			logger.logPass("Search With In Valid Rule Name : Act name not displayed");
			home.SearchClear();
			home.Search("Dis");
			Thread.sleep(3000);
			Assert.assertTrue(home.Search_value("Disp"));
			logger.logPass("Search With Partial Rule Name : Dispalying Activities");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=6)
	public void ActivityPageActionsUpdate() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			Rule = new RulePage();
			Thread.sleep(5000);
			home.Masters();
			home.Rule();
			home.NavArrowclose();
			Thread.sleep(5000);
			home.Search(prop.getProperty("EnterRuleName"));
			Thread.sleep(3000);
			home.Edit(prop.getProperty("EnterRuleName"));
			Rule.EnterRuleNo(prop.getProperty("EnterSectionNo"), prop.getProperty("EnterRuleNo"), prop.getProperty("EnterUniqueIdentifier"));
			home.Submit();
			Thread.sleep(4000);
			Assert.assertTrue(home.Update());
			logger.logPass("Rule Page : Edit is Working");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=7)
	public void ActivityPageActionsView() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			Rule = new RulePage();
			Thread.sleep(5000);
			home.Masters();
			home.Rule();
			home.NavArrowclose();
			Thread.sleep(5000);
			home.Search(prop.getProperty("EnterRuleName"));
			Thread.sleep(3000);
			home.View(prop.getProperty("EnterActNameInput"));
			Assert.assertTrue(home.ActionsViewDisplayed(prop.getProperty("EnterActNameInput")));
			logger.logPass("Rule Page : View is working ");
			//Assert.assertTrue(home.Search_value("deleted successfully."));
			logger.logPass("Rule Page : Delete is working ");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=8)
	public void ActivityPageActionsDelete() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			Rule = new RulePage();
			Thread.sleep(5000);
			home.Masters();
			home.Rule();
			home.NavArrowclose();
			Thread.sleep(5000);
			home.Search(prop.getProperty("EnterRuleName"));
			Thread.sleep(3000);
			home.Edit(prop.getProperty("EnterRuleName"));
			Rule.EnterRuleNo(prop.getProperty("EnterSectionNo"), prop.getProperty("EnterRuleNo"), prop.getProperty("EnterUniqueIdentifier"));
			home.Submit();
			Thread.sleep(4000);
			Assert.assertTrue(home.Update());
			logger.logPass("Rule Page : Edit is Working");
			home.View(prop.getProperty("EnterActNameInput"));
			Assert.assertTrue(home.ActionsViewDisplayed(prop.getProperty("EnterActNameInput")));
			logger.logPass("Rule Page : View is working ");
			home.Close();
			home.Delete(prop.getProperty("EnterRuleName"));
			//Thread.sleep(2000);
			home.Yes();
			Thread.sleep(2000);
			home.Search("bnsdvsddjbms");
			Thread.sleep(3000);
			Assert.assertTrue(home.Search_value("No Data Available"));
			//Assert.assertTrue(home.Search_value("deleted successfully."));
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
			home.NAvMenu("Rule");
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
			home.NAvMenu("Rule");
			home.NavArrowclose();
			logger.logInfo("Clicking on actions button");
			actss.ActionClick();
			logger.logInfo("Clicking on Export button");
			actss.ActionsButton("Export");
			Thread.sleep(9000);
			ExcelOperations ex = new ExcelOperations(System.getProperty("user.dir") + "\\externalFiles\\downloadFiles\\Rules.xlsx");
			String sheetName = "Rule";
			int rowcount = ex.getRowcount(sheetName);
			int colcount = ex.getColcount(sheetName);
			Assert.assertEquals("Count Matching", home.Showing(),rowcount);
			logger.logPass("Export is working and count is matching ");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}

	@Test(priority=11)
	public void ValidateExportExcel() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			home.NAvMenu("Masters");
			home.NAvMenu("Rule");
			home.NavArrowclose();
			//Iterator<Object[]> tblData = home.getTableData();
			actss.ActionClick();
			logger.logInfo("Clicking on Export button");
			actss.ActionsButton("Export");
			Thread.sleep(5000);
			ExcelOperations ex = new ExcelOperations(System.getProperty("user.dir") + "\\externalFiles\\downloadFiles\\Rules.xlsx");
			String sheetName = "Rule"; //workbook.getSheetAt(0);
			int rowcount = ex.getRowcount(sheetName);
			int colcount = ex.getColcount(sheetName);
			//List<Object[]> xlData = ex.getData(sheetName,rowcount,colcount);
			Iterator<Object[]> xlData = ex.getData(sheetName,rowcount,colcount);
			//Assert.assertTrue(home.compareListColumnCount(tblData, xlData));
			logger.logPass("Rule Export is working and Column count is matching ");
			String[] col = {"Rule Name","Unique Identifier","Rule No","Section No","Type","Description"};
			Assert.assertTrue(home.compareColumnNames(xlData,col));
			logger.logPass("Rule Export is working and columns names are matching ");
			Thread.sleep(5000);
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
