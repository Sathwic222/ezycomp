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
import com.automation.ezycomp.pageobjects.Locationmapping;
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
			loginpage = new LoginPage();
			home = new HomePage_SuperAdmin();
			loginpage = new LoginPage();
			audit = new Audit();
			logger.logInfo("Entering username and password");
			loginpage.login("superadmin@ezycomp.com", "test123");
			loginpage.loginbtn();
			Thread.sleep(5000);
			audit.Homepage();
			audit.NavDoubleright();
			
	        audit.Auditmanagement();
	        Thread.sleep(3000);
	        
	        audit.Auditschedule();
	        
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	        audit.companydop();
	        audit.Dropdown("Filpkart");
	        
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        audit.asscompdop();
	        audit.Dropdown("Filpkart Enterprises");
	        
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        audit.locdop();
	        audit.Dropdown("bell (KA-BEL-BEL)");
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        audit.actdop();
	        audit.Dropdown("Display,Returns,Audit");
	        
	        audit.month();
	        
	        audit.Exportbtn();
	        
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

