package com.automation.ezycomp.testcases;


import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.automation.ezycomp.base.TestBase;
import com.automation.ezycomp.functionLabrary.ReportLog;
import com.automation.ezycomp.pageobjects.HomePage_SuperAdmin;
import com.automation.ezycomp.pageobjects.LoginPage;
import com.automation.ezycomp.pageobjects.Verticalpage;

import junit.framework.Assert;

public class Vertical extends TestBase {

	LoginPage loginpage;
	HomePage_SuperAdmin home; 
	ReportLog logger;
	Verticalpage Vertical;
	
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
	public void AddNewVertical() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			Vertical = new Verticalpage();
			Thread.sleep(5000);
			home.NAvMenu("Companies");
			home.NAvMenu("Verticals");
			home.NavArrowclose();
			home.AddNewButton();
			Vertical.InAddCompanyDropdown();
			Thread.sleep(2000);
			home.Dropdown(prop.getProperty("AddCompanyDropdown"));
			Vertical.EnterVerticalName(prop.getProperty("VerticalName"), prop.getProperty("VerticalCode"));
			Vertical.EnterVerticalDescription(prop.getProperty("VerticalDescription"));
			home.Submit();
			Thread.sleep(2000);
			Assert.assertTrue(home.CreatedSucees());
			logger.logPass("Add New Vertical completed successfully.");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}	
	}
	
	@Test(priority=2)
	public void AddNewVerticalDuplicate() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			Vertical = new Verticalpage();
			Thread.sleep(5000);
			home.NAvMenu("Companies");
			home.NAvMenu("Verticals");
			home.NavArrowclose();
			home.AddNewButton();
			Vertical.InAddCompanyDropdown();
			Thread.sleep(2000);
			home.Dropdown(prop.getProperty("AddCompanyDropdown"));
			Vertical.EnterVerticalName(prop.getProperty("VerticalName"), prop.getProperty("VerticalCode"));
			Vertical.EnterVerticalDescription(prop.getProperty("VerticalDescription"));
			home.Submit();
			Thread.sleep(2000);
			Assert.assertTrue(home.Search_value("DUPLICATE"));
			logger.logPass("Add New Vertical completed successfully.");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}	
	}
	
	@Test(priority=3)
	 public void AddingVerticalwithblank() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			Vertical = new Verticalpage();
			Thread.sleep(5000);
			home.NAvMenu("Companies");
			home.NAvMenu("Verticals");
			home.NavArrowclose();
			home.AddNewButton();
//			home.SubmitEnabled();
			Assert.assertFalse(home.SubmitEnabled());
			logger.logPass("Adding New Vertical with blank fields:- Submit button Disabled as expected for blank fields");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}		
	 }
	
	@Test(priority=4)
	 public void VerticalPageDropdown() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			Vertical = new Verticalpage();
			Thread.sleep(5000);
			home.NAvMenu("Companies");
			home.NAvMenu("Verticals");
			home.NavArrowclose();   
			Vertical.CompanyDropdown();
			Thread.sleep(2000);
			home.Dropdown(prop.getProperty("AddCompanyDropdown"));
			Assert.assertTrue(home.Search_value(prop.getProperty("AddCompanyDropdown")));
			Thread.sleep(3000);
			logger.logPass("Verticals:Comapany dropdown Working 'selected value displaying in grid'");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}		
	 }
	
	@Test(priority=5)
	public void VerticalPageSearch() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			Vertical = new Verticalpage();
			Thread.sleep(5000);
			home.NAvMenu("Companies");
			home.NAvMenu("Verticals");
			home.NavArrowclose();
			home.Search(prop.getProperty("Searchvalue"));
			Thread.sleep(3000);
			//home.Search_value("Tax");
			Assert.assertTrue(home.Search_value(prop.getProperty("Searchvalue")));
			logger.logPass("Search With Valid Vertical Name : The search results include the element that matched the search term.");
			home.Search("bnsdvsddjbms");
			Thread.sleep(3000);
			Assert.assertTrue(home.Search_value("No Data Available"));
			logger.logPass("Search With In Valid Vertical Name : Act name not displayed");
			home.SearchClear();
			home.Search("pro");
			Thread.sleep(3000);
			Assert.assertTrue(home.Search_value("pro"));
			logger.logPass("Search With Partial Vertical Name : Dispalying Verticals");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=6)
	public void VerticalPageEdit() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			Vertical = new Verticalpage();
			Thread.sleep(5000);
			home.NAvMenu("Companies");
			home.NAvMenu("Verticals");
			home.NavArrowclose();
			home.Search(prop.getProperty("VerticalCode"));
			Thread.sleep(3000);
			home.Edit(prop.getProperty("VerticalCode"));
			Vertical.EnterVerticalDescription("dhr");
			home.Submit();
			Thread.sleep(4000);
			Assert.assertTrue(home.Update());
			logger.logPass("vertical Page : Edit is Working");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=7)
	public void VerticalPageView() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			Vertical = new Verticalpage();
			Thread.sleep(5000);
			home.NAvMenu("Companies");
			home.NAvMenu("Verticals");
			home.NavArrowclose();
			home.Search(prop.getProperty("VerticalCode"));
			Thread.sleep(3000);
			home.View(prop.getProperty("VerticalCode"));
			Assert.assertTrue(home.ActionsViewDisplayed(prop.getProperty("VerticalCode")));
			logger.logPass("vertical Page : View is working ");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=8)
	public void VerticalPageDelete() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			Vertical = new Verticalpage();
			Thread.sleep(5000);
			home.NAvMenu("Companies");
			home.NAvMenu("Verticals");
			home.NavArrowclose();
			home.Search(prop.getProperty("VerticalCode"));
			Thread.sleep(3000);
			home.Delete(prop.getProperty("VerticalCode"));
			//Thread.sleep(2000);
			home.Yes();
			Thread.sleep(3000);
			Assert.assertTrue(home.Search_value("deleted successfully."));
			logger.logPass("vertical Page : Delete is working ");
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
