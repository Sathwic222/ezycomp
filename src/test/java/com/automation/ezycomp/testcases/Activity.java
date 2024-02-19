package com.automation.ezycomp.testcases;

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
import com.automation.ezycomp.pageobjects.ActivityPag;
import com.automation.ezycomp.pageobjects.HomePage_SuperAdmin;
import com.automation.ezycomp.pageobjects.LoginPage;
import com.automation.ezycomp.pageobjects.act;

import junit.framework.Assert;

public class Activity extends TestBase {
	
	LoginPage loginpage;
	HomePage_SuperAdmin home; 
	ReportLog logger;
	act actss;
	ActivityPag Activity;
	
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
	 public void AddingActivityWithValidDetails() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			Activity = new ActivityPag();
			home.Masters();
			home.Activity();
			home.NavArrowclose();
			actss.ActionClick();
			actss.ActionsAdd();
			Activity.EnterActivityName(prop.getProperty("EnterActivityNameInput"));
			Activity.AddActivityType();
			home.Dropdown(prop.getProperty("ActivityType"));
			Activity.AddPeridiocity();
			home.Dropdown(prop.getProperty("PeriodicityType"));
			Activity.AddCalendarTypeDropDown();
			home.Dropdown(prop.getProperty("CalendarType"));
			home.Submit();
			Thread.sleep(5000);
			Assert.assertTrue(home.CreatedSucees());
			logger.logPass("Masters Activity: Adding new Activity with valid inputs");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	 }
	
	
	@Test(priority=2)
	 public void AddingActivityWithDuplicate() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			Activity = new ActivityPag();
			home.Masters();
			home.Activity();
			home.NavArrowclose();
			actss.ActionClick();
			actss.ActionsAdd();
			Activity.EnterActivityName(prop.getProperty("EnterActivityNameInput")); 
			Activity.AddActivityType();
			home.Dropdown(prop.getProperty("ActivityType"));
			Activity.AddPeridiocity();
			home.Dropdown(prop.getProperty("PeriodicityType"));
			Activity.AddCalendarTypeDropDown();
			home.Dropdown(prop.getProperty("CalendarType"));
			home.Submit();
			Thread.sleep(5000);
			Assert.assertTrue(home.AlreadyExixts());
			logger.logPass("Masters Activity: Duplicates not allowing");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	 }
	
	@Test(priority=3)
	 public void AddingActivityWithblank() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			Activity = new ActivityPag();
			home.Masters();
			home.Activity();
			home.NavArrowclose();
			actss.ActionClick();
			actss.ActionsAdd();
			Activity.EnterActivityName(prop.getProperty("EnterActivityNameInput"));
			home.SubmitDisabled();
			logger.logPass("Adding New Activity with blank fields:- Submit button Disabled as expected for blank fields");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
			
	 }
	
	@Test(priority=4)
	 public void ActivityPageDropdowns() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			Activity = new ActivityPag();
			home.Masters();
			home.Activity();
			home.NavArrowclose();
			Activity.Establishment();
			home.Dropdown(prop.getProperty("ActivityType"));
			Assert.assertTrue(home.Search_value(prop.getProperty("ActivityType")));
			Thread.sleep(3000);
			logger.logPass("Masters Activity:Type dropdown Working 'selected value displaying in grid'");
			Activity.PeriodicityDropdown();
			home.Dropdown(prop.getProperty("PeriodicityType"));
			Assert.assertTrue(home.Search_value(prop.getProperty("PeriodicityType")));
			logger.logPass("Masters Activity: Periodicity dropdown Working 'selected value displaying in grid'");
			Activity.CalendarTypeDropDown();
			home.Dropdown(prop.getProperty("CalendarType"));
			Assert.assertTrue(home.Search_value(prop.getProperty("CalendarType")));
			logger.logPass("Masters Activity: CalendarType dropdown Working 'selected value displaying in grid'");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}		
	 }
	
	@Test(priority=5)
	public void ActivityPageSearch() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			home.Masters();
			home.Activity();
			home.NavArrowclose();
			home.Search(prop.getProperty("EnterActivityNameInput"));
			Thread.sleep(3000);
			//home.Search_value("Tax");
			Assert.assertTrue(home.Search_value(prop.getProperty("EnterActivityNameInput")));
			logger.logPass("Search With Valid Activity : The search results include the element that matched the search term.");
			home.Search("bnsdvsddjbms");
			Thread.sleep(3000);
			Assert.assertTrue(home.Search_value("No Data Available"));
			logger.logPass("Search With In Valid Activity : Act name not displayed");
			home.SearchClear();
			home.Search("Dis");
			Thread.sleep(3000);
			Assert.assertTrue(home.Search_value("Disp"));
			logger.logPass("Search With Partial Activity Name : Dispalying Activities");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=6)
	public void ActivityPageActionsUpdate() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			Activity = new ActivityPag();
			home.Masters();
			home.Activity();
			home.NavArrowclose();
			Thread.sleep(5000);
			home.Search(prop.getProperty("EnterActivityNameInput"));
			Thread.sleep(3000);
			home.Edit(prop.getProperty("EnterActivityNameInput"));
			Activity.AddActivityType();
			home.Dropdown(prop.getProperty("EditActivityType"));
			home.Submit();
			Thread.sleep(4000);
			Assert.assertTrue(home.Update());
			logger.logPass("Activity Page : Edit is Working");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=7)
	public void ActivityPageActionsView() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			Activity = new ActivityPag();
			home.Masters();
			home.Activity();
			home.NavArrowclose();
			Thread.sleep(5000);
			home.Search(prop.getProperty("EnterActivityNameInput"));
			Thread.sleep(3000);
			home.View(prop.getProperty("EnterActNameInput"));
			Assert.assertTrue(home.ActionsViewDisplayed(prop.getProperty("EnterActNameInput")));
			logger.logPass("Activity Page : View is working ");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=8)
	public void ActivityPageActionsDelete() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			actss = new act();
			Activity = new ActivityPag();
			home.Masters();
			home.Activity();
			home.NavArrowclose();
			Thread.sleep(5000);
			home.Search(prop.getProperty("EnterActivityNameInput"));
			Thread.sleep(3000);
			home.Delete(prop.getProperty("EnterActivityNameInput"));
			//Thread.sleep(2000);
			home.Yes();
			Thread.sleep(2000);
			Assert.assertTrue(home.Search_value("deleted successfully."));
			logger.logPass("Activity Page : Delete is working ");
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
			home.NAvMenu("Activity");
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
			home.NAvMenu("Activity");
			home.NavArrowclose();
			actss.ActionClick();
			actss.ActionsButton("Export");
			Thread.sleep(5000);
			ExcelOperations ex = new ExcelOperations(System.getProperty("user.dir") + "\\externalFiles\\downloadFiles\\Activities.xlsx");
			String sheetName = "Activities";
			int rowcount = ex.getRowcount(sheetName);
			int colcount = ex.getColcount(sheetName);
			Assert.assertEquals("Count Matching", home.Showing(),rowcount);
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