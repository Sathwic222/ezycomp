package com.automation.ezycomp.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import com.automation.ezycomp.utils.ExcelOperations;
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
			Thread.sleep(3000);
	        audit.companydop("Filpkart");
	        audit.Dropdown("Filpkart");
            Thread.sleep(3000);
	        audit.asscompdop("BigSales");
	        audit.Dropdown("BigSales");
			Thread.sleep(3000);
	        audit.locdop("AutoMatIom (TG-HYD-AUDO)");
	        audit.Dropdown("AutoMatIom (TG-HYD-AUDO)");
			Thread.sleep(3000);
	       // audit.actdop("Display,Returns,Audit");

	       // audit.Dropdown("Display,Returns,Audit");

	        home.scrollIntoView(audit.monthbox);
			Thread.sleep(3000);
	        audit.month();

	        audit.Exportbtn();
			Thread.sleep(5000);

			String path = System.getProperty("user.dir") + "\\externalFiles\\downloadFiles\\FILP-BSAL-TG-HYD-AUDO.xlsx";
			ExcelOperations ex = new ExcelOperations(path);
			String sheetName = "Activities";
			int rowcount = ex.getRowcount(sheetName);
			int colcount = ex.getColcount(sheetName);

			for(int i = 1; i<=rowcount; i++) {
				ex.writeSingleCellVCalue(path, sheetName, i, 18, "08-03-2024");
				ex.writeSingleCellVCalue(path, sheetName, i, 19, "18-03-2024");
			}
	        
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

