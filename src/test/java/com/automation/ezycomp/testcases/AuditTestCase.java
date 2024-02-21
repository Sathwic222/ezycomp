package com.automation.ezycomp.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.automation.ezycomp.base.TestBase;
import com.automation.ezycomp.functionLabrary.ReportLog;
import com.automation.ezycomp.pageobjects.Audit;
import com.automation.ezycomp.pageobjects.HomePage_SuperAdmin;

import com.automation.ezycomp.pageobjects.LoginPage;

public class AuditTestCase extends TestBase {

	LoginPage loginpage;
	HomePage_SuperAdmin home; 
	ReportLog logger;
	Audit audit;
	
	@BeforeSuite
	public void TestSuite() {
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
	public void login()  throws InterruptedException, IOException {
		try {
			loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
			home = new HomePage_SuperAdmin();
			loginpage = new LoginPage();
			audit = new Audit();
			Thread.sleep(2000);
			audit.Homepage();
			//audit.NavDoubleright();
			
	        audit.Auditmanagement();
	        Thread.sleep(3000);
	        
	        audit.Auditschedule();

	        audit.companydop("Etv AndhraPradesh");
			Thread.sleep(3000);
	        audit.Dropdown("Etv AndhraPradesh");
            Thread.sleep(3000);
	        audit.asscompdop("Etv Win");
			Thread.sleep(3000);
	        audit.Dropdown("Etv Win");
			Thread.sleep(3000);
	        audit.locdop("World (MH-AG-WRD)");
			Thread.sleep(3000);
	        audit.Dropdown("World (MH-AG-WRD)");
			Thread.sleep(3000);
	       // audit.actdop("Display,Returns,Audit");

	       // audit.Dropdown("Display,Returns,Audit");

	        home.scrollIntoView(audit.month);
	        audit.month("Feb, 2024");

	        audit.Exportbtn();
			Thread.sleep(5000);
	        
	        logger.logPass("Audit Schedule will generated for month is passed");
		} catch (Exception e) {
			logger.logFail("Audit Schedule will generated for month is failed"+e.getMessage());
			
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

