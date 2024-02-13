package com.automation.ezycomp.ezycomp;

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

public class NewLawTest extends TestBase {
    LoginPage loginpage;
    HomePage_SuperAdmin home; 
    ReportLog logger;

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

    @Test
    public void AddNewLaw() throws InterruptedException, IOException {
        try {
            loginpage = new LoginPage();
            home = new HomePage_SuperAdmin();

            logger.logInfo("Logging in as superadmin...");
            loginpage.login("superadmin@ezycomp.com", "test123");
            loginpage.loginbtn();
            Thread.sleep(5000);

            logger.logInfo("Navigating to a page...");
            home.NavArrow();
            logger.logInfo("Adding a new law...");
            home.Law("Tax", "this is the law");
            home.Submit();
            Thread.sleep(2000);
            boolean successMessageDisplayed = home.LawVerfication();
            if (successMessageDisplayed) {
                logger.logPass("Success message displayed.");
            } else {
                logger.logFail("Expected success message not found.");
            }

        } catch (Exception e) {
            logger.logFail("An exception occurred: " + e.getMessage());
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
