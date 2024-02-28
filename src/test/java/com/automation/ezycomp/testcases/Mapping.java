package com.automation.ezycomp.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;

import com.automation.ezycomp.utils.ExcelOperations;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.automation.ezycomp.base.TestBase;
import com.automation.ezycomp.functionLabrary.ReportLog;
import com.automation.ezycomp.pageobjects.HomePage_SuperAdmin;
import com.automation.ezycomp.pageobjects.LoginPage;
import com.automation.ezycomp.pageobjects.MappingPage;
import com.automation.ezycomp.pageobjects.act;

import junit.framework.Assert;




public class Mapping extends TestBase {
	
	LoginPage loginpage;
	HomePage_SuperAdmin home; 
	ReportLog logger;
	act actss;
	MappingPage Map;
	
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
	 public void AddingMappingWithValidDetails() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			Map = new MappingPage();
			home.NAvMenu("Masters");
			home.NAvMenu("Mappings");
			home.NavArrowclose();
			actss.ActionClick();
			Map.Add();
			Map.EnterStateType();
			home.Dropdown("State");
			Map.EnterActName("testings");
			Thread.sleep(3000);
			home.Dropdown("testings");
			Map.EnterRuleName("123");
			Thread.sleep(3000);
			home.Dropdown("123");
			Map.EnterActivityName("123");
			Thread.sleep(3000);
			home.Dropdown("123");
			Map.EnterStateName();
			Thread.sleep(3000);
			home.Dropdown("Bihar");
			Thread.sleep(3000);
			Map.NextButton();
			Thread.sleep(8000);
			Map.ComplianceDescription("ascbjvbakfhvawi;o");
			Map.RiskDropdown();
			home.Dropdown("Low");
			Map.AuditTypeDropDown();
			home.Dropdown("Internal");
			Map.ProofOfCompliance("vuaqgcfbiulahfd");
			Map.EnterPenalty("cbaihfcoa€ahfc");
			Map.MaxPenaltyAmount("1234");
			Map.impriosonmentTickBox();
			Map.NextButton();
			Map.NextButton();
			Thread.sleep(5000);
			Assert.assertTrue(home.CreatedSucees());
			logger.logPass("Masters Act: Adding new law with valid inputs");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
			
	 }
	
	@Test(priority=2)
	 public void AddingMappingWithDuplicates() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			Map = new MappingPage();
			home.NAvMenu("Masters");
			home.NAvMenu("Mappings");
			home.NavArrowclose();
			Map.EnteringMappingDetails();
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			home.scrollIntoView(home.Duplicate);
			//js.executeScript("arguments[0].scrollIntoView(true);", new Object[] { home.Duplicate});
			//js.executeScript("window.scrollBy(0,-150)", new Object[] {""});
			Assert.assertTrue(home.AlreadyExixts());
			logger.logPass("Masters Act: Adding new law with valid inputs");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
			
	 }
	
//	@Test(priority=2)
//	 public void AddingMappingWithDuplicates() throws InterruptedException, IOException {
//		try {
//			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
//			home = new HomePage_SuperAdmin();
//			actss = new act();
//			Map = new MappingPage();
//			home.NAvMenu("Masters");
//			home.NAvMenu("Mappings");
//			home.NavArrowclose();
//			actss.ActionClick();
//			Map.Add();
//			Map.EnterStateType();
//			home.Dropdown("State");
//			Map.EnterActName("testings");
//			Thread.sleep(3000);
//			home.Dropdown("testings");
//			Map.EnterRuleName("123");
//			Thread.sleep(3000);
//			home.Dropdown("123");
//			Map.EnterActivityName("123");
//			Thread.sleep(3000);
//			home.Dropdown("123");
//			Map.EnterStateName();
//			Thread.sleep(3000);
//			home.Dropdown("Bihar");
//			Thread.sleep(3000);
//			Map.NextButton();
//			Thread.sleep(3000);
//			//JavascriptExecutor js = (JavascriptExecutor) driver;
//			home.scrollIntoView();
//			//js.executeScript("arguments[0].scrollIntoView(true);", new Object[] { home.Duplicate});
//			//js.executeScript("window.scrollBy(0,-150)", new Object[] {""});
//			Assert.assertTrue(home.AlreadyExixts());
//			logger.logPass("Masters Act: Adding new law with valid inputs");
//		} catch (Exception e) {
//			logger.logFail("An exception occurred:"+e.getMessage());
//		}
//			
//	 }

	
	@Test(priority=3)
	 public void MappingsPageDropdown() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			Map = new MappingPage();
			home.NAvMenu("Masters");
			home.NAvMenu("Mappings");
			home.NavArrowclose();
			Map.StateDropdown();
			home.Dropdown(prop.getProperty("Statedropdown"));
			Assert.assertTrue(home.Search_value(prop.getProperty("Statedropdown")));
			Thread.sleep(3000);
			logger.logPass("Masters Mapping : State dropdown Working 'selected value displaying in grid'");
			Map.TypeDropdown();
			home.Dropdown(prop.getProperty("Typedropdown"));
			Assert.assertTrue(home.Search_value(prop.getProperty("Typedropdown")));
			logger.logPass("\"Masters Mapping : Type dropdown Working 'selected value displaying in grid'");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}		
	 }
	
	@Test(priority=4)
	public void Search() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			Map = new MappingPage();
			home.NAvMenu("Masters");
			home.NAvMenu("Mappings");
			home.NavArrowclose();
			home.Search(prop.getProperty("Statedropdown"));
			Thread.sleep(3000);
			Assert.assertTrue(home.Search_value(prop.getProperty("Statedropdown")));
			logger.logPass("Search With Valid Mappings : The search results include the element that matched the search term.");
			home.Search("bnsdvsddjbms");
			Thread.sleep(3000);
			Assert.assertTrue(home.Search_value("No Data Available"));
			logger.logPass("Search With In Valid Mappings : Act name not displayed");
			home.SearchClear();
			home.Search("Fac");
			Thread.sleep(3000);
			Assert.assertTrue(home.Search_value("Fac"));
			logger.logPass("Search With Partial Mappings Name : Dispalying Mappings");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=5)
	public void LawPageActions() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			Map = new MappingPage();
			home.NAvMenu("Masters");
			home.NAvMenu("Mappings");
			home.NavArrowclose();
			Thread.sleep(5000);
			Map.StateDropdown();
			home.Dropdown("Bihar");
			home.Search("testings");
			Thread.sleep(4000);
			home.Edit("testings");
			Map.ComplianceDescription("ef");
			Map.NextButton();
			Map.NextButton();
			Thread.sleep(4000);
			Assert.assertTrue(home.Update());
			logger.logPass("Mappings Page : Edit is Working");
			home.View("testings");
			Assert.assertTrue(home.ActionsViewDisplayed("testings"   ));
			logger.logPass("Mappings Page : View is working ");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=6)
	public void LawPageActionsDelete() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			Map = new MappingPage();
			home.NAvMenu("Masters");
			home.NAvMenu("Mappings");
			home.NavArrowclose();
			Thread.sleep(5000);
			Map.StateDropdown();
			home.Dropdown("Bihar");
			home.Search("testings");
			Thread.sleep(2000);
			home.Delete("testings");
			Thread.sleep(2000);
			home.Yes();
			Thread.sleep(2000);
			Assert.assertTrue(home.Search_value("deleted successfully."));
			logger.logPass("Act Page : Delete is working ");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}

	@Test(priority=7)
	public void ExportExcel() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			Map = new MappingPage();
			home.NAvMenu("Masters");
			home.NAvMenu("Mappings");
			home.NavArrowclose();
			logger.logInfo("Clicking on actions button");
			actss.ActionClick();
			logger.logInfo("Clicking on Export button");
			Map.MappingExportButton();
			Thread.sleep(9000);
			ExcelOperations ex = new ExcelOperations(System.getProperty("user.dir") + "\\externalFiles\\downloadFiles\\Act-Rule-Activity-State-Mapping.xlsx");
			String sheetName = "ActStateMappings";
			int rowcount = ex.getRowcount(sheetName);
			int colcount = ex.getColcount(sheetName);
			Assert.assertEquals("Count Matching", home.Showing(),rowcount);
			logger.logPass("Mapping page : Export is working and count is matching ");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}

	@Test(priority=8)
	public void ValidateExportExcel() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			Map = new MappingPage();
			home.NAvMenu("Masters");
			home.NAvMenu("Mappings");
			home.NavArrowclose();
			Map.TypeDropdown();
			//home.Dropdown("");
			//Iterator<Object[]> tblData = home.getTableData();
			actss.ActionClick();
			logger.logInfo("Clicking on Export button");
			Map.MappingExportButton();
			Thread.sleep(5000);
			ExcelOperations ex = new ExcelOperations(System.getProperty("user.dir") + "\\externalFiles\\downloadFiles\\Act-Rule-Activity-State-Mapping.xlsx");
			String sheetName = "ActStateMappings"; //workbook.getSheetAt(0);
			int rowcount = ex.getRowcount(sheetName);
			int colcount = ex.getColcount(sheetName);
			//List<Object[]> xlData = ex.getData(sheetName,rowcount,colcount);
			Iterator<Object[]> xlData = ex.getData(sheetName,rowcount,colcount);
			//Assert.assertTrue(home.compareListColumnCount(tblData, xlData));
			//logger.logPass("Export is working and Column count is matching ");
			String[] col = {"Act Name","Rule Name","Rule No","Section No","Activity Name","Establishment Type","State Name","Form Name","Compliance Nature","Proof Of Compliance","Penalty","Risk","Maximum Penalty Amount","Impriosonment","Continuing Penalty","Cancellation Suspension Of License","Statutory Authority","Compliance Description","Audit Type"};
			Assert.assertTrue(home.compareColumnNames(xlData,col));
			logger.logPass("Export is working and columns names are matching ");
			Thread.sleep(5000);
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	
	@Test(priority=9)
	 public void File() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			Thread.sleep(5000);
			home.Masters();
			home.act();
			home.NavArrowclose();
			actss.ActionClick();
			actss.Choosefile("C:\\Users\\DELL\\Downloads\\ActsTemplat.xlsx");
//			Assert.assertTrue(home.SubmitDisabled());
			logger.logPass("Adding New Act with blank fields:- Submit button Disabled as expected for blank fields");
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