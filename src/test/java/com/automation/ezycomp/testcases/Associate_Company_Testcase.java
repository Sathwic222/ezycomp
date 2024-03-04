package com.automation.ezycomp.testcases;

import com.automation.ezycomp.base.TestBase;

import com.automation.ezycomp.functionLabrary.ReportLog;
import com.automation.ezycomp.pageobjects.AssociateCompanies;
import com.automation.ezycomp.pageobjects.Companies;
import com.automation.ezycomp.pageobjects.HomePage_SuperAdmin;
import com.automation.ezycomp.pageobjects.LoginPage;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

import static junit.framework.Assert.assertTrue;

public class Associate_Company_Testcase extends TestBase {

    LoginPage loginpage;
    HomePage_SuperAdmin home;
    ReportLog logger;
    Companies Company;

    AssociateCompanies company;

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
    @Test(priority = 1)
    public void AddAssCompanyWithValidDetails() throws InterruptedException, IOException {
        try {

            loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
            home = new HomePage_SuperAdmin();
            company = new AssociateCompanies();
            logger.logInfo("clicking on manage companies in companies ");
            home.NAvMenu("Companies");
            home.NAvMenu("Manage Companies");
            company.addbutton();
            logger.logInfo("Entering Company Details");
            company.companycode("bsal");
            company.Associatecompany();
            Thread.sleep(3000);
            company.Parentcompdop("Filpkart");
            company.Dropdown("Filpkart");

            //company.copyAssociatecompany();
            company.companyname("BigSales");
            company.businesstypedop("IT");
            company.Dropdown("IT");
            company.website("www.filpkartsales.com");
            company.scrollIntoView(company.esttypedop);
            Thread.sleep(5000);
            company.esttypedop("Factory");
            company.Dropdown("Factory");
            Thread.sleep(3000);
            company.statusdop("Active");
            company.Dropdown("Active");
            company.empdop("1-100");
            company.Dropdown("1-100");
            //Thread.sleep(3000);
           // company.scrollIntoView(company.Logoupload);
            company.Logoupload("C:\\Users\\sathw\\OneDrive\\Pictures\\download (3).png");
            Thread.sleep(5000);
            company.create();
            Thread.sleep(2000);
            assertTrue(home.CreatedSucees());
            Thread.sleep(3000);
            //company.save();
            company.savenxt();
            // spoc details---------------------------------
            logger.logInfo("Entering SPOC Details");
            Thread.sleep(5000);
            company.address("Maharastra");
            company.statedop();
            company.Dropdown("Maharashtra");
            Thread.sleep(3000);
            company.citydop();
            company.Dropdown("Mumbai");
            company.countrydop();
            company.Dropdown("India");
            company.contactno();
            company.compemail();
            company.name();
            company.designation();
            company.department();
            company.contactpermob();
            company.contactperemail();
            Thread.sleep(5000);
            company.save();
            Thread.sleep(3000);
            company.savenext();

            // Statutory Details
            logger.logInfo("Entering Statutory Details");
            Thread.sleep(5000);
            company.Pannumber();
            company.Tannumber();
            company.FullName();
            company.pansurname();
            company.pandesignation();
            company.panmobile();
            company.panemail();
            company.panplace();
            Thread.sleep(2000);
            company.gstnumbr();
            company.save();
            Thread.sleep(3000);
            company.savenext();


            // SMTP Details
            logger.logInfo("Entering SMTP Details");
            Thread.sleep(6000);
            company.email();
            company.passwrd();
            company.hos();
            Thread.sleep(2000);
            company.por();
            company.Dropdown("465");
            Thread.sleep(2000);
            company.save();
            company.Saveclose();
            logger.logPass("shown as per given");
        } catch (Exception e) {
            logger.logFail("Login functionality for super admin is failed" + e.getMessage());

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


