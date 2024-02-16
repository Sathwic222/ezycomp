package com.automation.ezycomp.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

//import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.automation.ezycomp.base.TestBase;
import com.automation.ezycomp.functionLabrary.ReportLog;
import com.automation.ezycomp.pageobjects.Departmentpage;
import com.automation.ezycomp.pageobjects.HomePage_SuperAdmin;
import com.automation.ezycomp.pageobjects.LoginPage;

import junit.framework.Assert;

public class Department extends TestBase {
	
	LoginPage loginpage;
	HomePage_SuperAdmin home; 
	ReportLog logger;
	LoginPageTest logins;
	Departmentpage Department;
	
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
	 public void AddingDepartment() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			Department = new Departmentpage();
			home.NAvMenu("Companies");
			home.NAvMenu("Departments");
			home.NavArrowclose();
			home.AddNewButton();
			Department.AddCompanyDropdown();
			Thread.sleep(2000);
			home.Dropdown(prop.getProperty("AddCompanyDropdowns"));
			Department.AddVerticalDropdown();
			home.Dropdown(prop.getProperty("AddVerticalDropdown"));
			Department.AddDepartmentName(prop.getProperty("DeparmentName"), prop.getProperty("DeparmentCode"));
			Department.AddDepartmentDescription(prop.getProperty("DeparmentDescription"));
			home.Submit();
			Thread.sleep(3000);
			Assert.assertTrue(home.CreatedSucees());
			logger.logPass("Department : Adding new Department with valid inputs");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
			
	 }
	
	@Test(priority=2)
	 public void AddNewDepartmentDuplicate() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			Department = new Departmentpage();
			home.NAvMenu("Companies");
			home.NAvMenu("Departments");
			home.NavArrowclose();
			home.AddNewButton();
			Department.AddCompanyDropdown();
			Thread.sleep(2000);
			home.Dropdown(prop.getProperty("AddCompanyDropdowns"));
			Department.AddVerticalDropdown();
			home.Dropdown(prop.getProperty("AddVerticalDropdown"));
			Department.AddDepartmentName(prop.getProperty("DeparmentName"), prop.getProperty("DeparmentCode"));
			Department.AddDepartmentDescription(prop.getProperty("DeparmentDescription"));
			home.Submit();
			Thread.sleep(3000);
			Assert.assertTrue(home.Search_value("DUPLICATE"));
			logger.logPass("Department : Duplicates Not taking");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
			
	 }
	
	@Test(priority=3)
	 public void AddingDepartmentwithblank() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			Thread.sleep(5000);
			home.NAvMenu("Companies");
			home.NAvMenu("Departments");
			home.NavArrowclose();
			home.AddNewButton();
			home.SubmitDisabled();
			logger.logPass("Adding New Department with blank fields:- Submit button Disabled as expected for blank fields");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
			
	 }
	
	@Test(priority=4)
	 public void DepartmentDropdowns() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			Department = new Departmentpage();
			Thread.sleep(5000);
			home.NAvMenu("Companies");
			home.NAvMenu("Departments");
			home.NavArrowclose();
			Department.CompanyDropdown();
			home.Dropdown(prop.getProperty("AddCompanyDropdowns"));
			Assert.assertTrue(home.Search_value(prop.getProperty("AddCompanyDropdowns")));
			Thread.sleep(3000);
			logger.logPass("Deparments: Company dropdown Working 'selected value displaying in grid'");
			Department.VerticalDropdown();
			home.Dropdown(prop.getProperty("VerticalDropdownValue"));
			Assert.assertTrue(home.Search_value(prop.getProperty("VerticalDropdownValue")));
			logger.logPass("Deparments: Vertical Dropdown Working 'selected value displaying in grid'");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}		
	 }
	
	@Test(priority=5)
	public void DepartmentSearch() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			Department = new Departmentpage();
			Thread.sleep(5000);
			home.NAvMenu("Companies");
			home.NAvMenu("Departments");
			home.NavArrowclose();
			home.Search(prop.getProperty("DeparmentSearchValue"));
			Thread.sleep(3000);
			Assert.assertTrue(home.Search_value(prop.getProperty("DeparmentSearchValue")));
			logger.logPass("Search With Valid Department : The search results include the element that matched the search term.");
			home.Search("bnsdvsddjbms");
			Thread.sleep(3000);
			Assert.assertTrue(home.Search_value("No Data Available"));
			logger.logPass("Search With In Valid Department : Act name not displayed");
			home.SearchClear();
			home.Search("Ama");
			Thread.sleep(3000);
			Assert.assertTrue(home.Search_value("Ama"));
			logger.logPass("Search With Partial Department Name : Dispalying Acts");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=6)
	public void DepartmentPageEdit() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			Department = new Departmentpage();
			Thread.sleep(5000);
			home.NAvMenu("Companies");
			home.NAvMenu("Departments");
			home.NavArrowclose();
			Thread.sleep(5000);
			home.Search(prop.getProperty("DeparmentCode"));
			Thread.sleep(3000);
			home.Edit(prop.getProperty("DeparmentCode"));
			Department.AddDepartmentDescription("bdhd");
			home.Submit();
			Thread.sleep(4000);
			Assert.assertTrue(home.Update());
			logger.logPass("Act Page : Edit is Working");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=7)
	public void DepartmentPageView() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			Department = new Departmentpage();
			Thread.sleep(5000);
			home.NAvMenu("Companies");
			home.NAvMenu("Departments");
			home.NavArrowclose();
			Thread.sleep(5000);
			home.Search(prop.getProperty("DeparmentCode"));
			home.View(prop.getProperty("DeparmentCode"));
			Assert.assertTrue(home.ActionsViewDisplayed(prop.getProperty("DeparmentCode")));
			logger.logPass("Department Page : View is working ");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=8)
	public void DepartmentPageDelete() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			Department = new Departmentpage();
			Thread.sleep(5000);
			home.NAvMenu("Companies");
			home.NAvMenu("Departments");
			home.NavArrowclose();
			Thread.sleep(5000);
			home.Search(prop.getProperty("DeparmentCode"));
			home.Delete(prop.getProperty("DeparmentCode"));
			Thread.sleep(2000);
			home.Yes();
			Thread.sleep(2000);
			Assert.assertTrue(home.Search_value("deleted successfully."));
			logger.logPass("Department Page : Delete is working ");
		} catch (Exception e) {
			logger.logFail("An exception occurred:"+e.getMessage());
		}
	}
	
	@Test(priority=9)
	public void Pagination() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			home.NAvMenu("Companies");
			home.NAvMenu("Departments");
			home.NavArrowclose();
			home.Pagination("Next");
			Thread.sleep(2000);
			Assert.assertTrue(home.Pageshowing("51"));
			logger.logPass("pagination is working Navigate to next page");
			home.Pagination("Previous");
			Thread.sleep(2000);
			Assert.assertTrue(home.Pageshowing("1"));
			logger.logPass("pagination is working Navigate to Previous page");
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