package com.automation.ezycomp.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

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
	
	@Test(priority=1)
	 public void login() throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			loginpage = new LoginPage();
			mapping= new Locationmapping();
			logger.logInfo("Entering username and password");
			mapping.Homepage();
			mapping.NavDoubleright();
			mapping.Companieslist();
			mapping.locmap();
			Thread.sleep(3000);
			mapping.compdop();
	
			mapping.asscompdop();
			mapping.actionbtn();
			mapping.ActionsButtonAdd();
			mapping.statedrop();
			mapping.citydrop();
			mapping.locname();
			mapping.loccode();
			mapping.conpername();
			mapping.mobile();
			mapping.email();
			mapping.address();
			mapping.submitbtn();
			
			
			
			
			//Assert.assertTrue();
			logger.logPass("Add location for company is passed");
		} catch (Exception e) {
			logger.logFail("Add location for company is failed"+e.getMessage());
			
		}
		
	}
}
