package com.automation.ezycomp.testcases;

import com.automation.ezycomp.base.TestBase;

import com.automation.ezycomp.functionLabrary.ReportLog;
import com.automation.ezycomp.pageobjects.*;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

import static junit.framework.Assert.assertTrue;

public class Associate_Company_Testcase extends TestBase {

    LoginPage loginpage;
    HomePage_SuperAdmin home;
    ReportLog logger;
    Companies Company;
    CompaniesAddnew managecompany;

    AssociateCompanies associateCompanies;

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
            associateCompanies = new AssociateCompanies();
            managecompany = new CompaniesAddnew();
            Company = new Companies();
            logger.logInfo("clicking on Associate companies in companies ");
            home.NAvMenu("Companies");
            home.NAvMenu("Manage Companies");
            Thread.sleep(3000);
            managecompany.addneww();
            Thread.sleep(3000);
            logger.logInfo("Entering Company Details");
            associateCompanies.companycode("salt");
            associateCompanies.isassociatecomp();
            Thread.sleep(3000);
            associateCompanies.Parentcompdop("Filpkart");
            associateCompanies.Dropdown("Filpkart");

            //company.copyAssociatecompany();
            associateCompanies.companyname("BigSale");
            associateCompanies.businesstypedop("IT");
            associateCompanies.Dropdown("IT");
            associateCompanies.website("www.filpkartsales.com");
            associateCompanies.scrollIntoView(associateCompanies.esttypedop);
            Thread.sleep(5000);
            associateCompanies.esttypedop("Factory");
            associateCompanies.Dropdown("Factory");
            Thread.sleep(3000);
            associateCompanies.statusdop("Active");
            associateCompanies.Dropdown("Active");
            associateCompanies.empdop("1-100");
            associateCompanies.Dropdown("1-100");
            //Thread.sleep(3000);
            // company.scrollIntoView(company.Logoupload);
            associateCompanies.Logoupload("C:\\Users\\sathw\\OneDrive\\Pictures\\download (3).png");
            Thread.sleep(5000);
            associateCompanies.create();
            Thread.sleep(2000);
            assertTrue(home.CreatedSucees());
            Thread.sleep(3000);
            //company.save();
            associateCompanies.savenxt();
            // spoc details---------------------------------
            logger.logInfo("Entering SPOC Details");
            Thread.sleep(5000);
            associateCompanies.address("Maharastra");
            associateCompanies.statedop();
            associateCompanies.Dropdown("Maharashtra");
            Thread.sleep(3000);
            associateCompanies.citydop();
            associateCompanies.Dropdown("Mumbai");
            associateCompanies.countrydop();
            associateCompanies.Dropdown("India");
            associateCompanies.contactno();
            associateCompanies.compemail();
            associateCompanies.name();
            associateCompanies.designation();
            associateCompanies.department();
            associateCompanies.contactpermob();
            associateCompanies.contactperemail();
            Thread.sleep(5000);
            associateCompanies.save();
            Thread.sleep(3000);
            associateCompanies.savenext();

            // Statutory Details
            logger.logInfo("Entering Statutory Details");
            Thread.sleep(5000);
            associateCompanies.Pannumber();
            associateCompanies.Tannumber();
            associateCompanies.FullName();
            associateCompanies.pansurname();
            associateCompanies.pandesignation();
            associateCompanies.panmobile();
            associateCompanies.panemail();
            associateCompanies.panplace();
            Thread.sleep(2000);
            associateCompanies.gstnumbr();
            associateCompanies.save();
            Thread.sleep(3000);
            associateCompanies.savenext();


            // SMTP Details
            logger.logInfo("Entering SMTP Details");
            Thread.sleep(6000);
            associateCompanies.email();
            associateCompanies.passwrd();
            associateCompanies.hos();
            Thread.sleep(2000);
            associateCompanies.por();
            associateCompanies.Dropdown("465");
            Thread.sleep(2000);
            associateCompanies.save();
            associateCompanies.Saveclose();
            logger.logPass("shown as per given");
        } catch (Exception e) {
            logger.logFail("Login functionality for super admin is failed" + e.getMessage());

        }
    }
 // Filtering parent company and click add btn
        @Test(priority = 2)
        public void Addasso_comp () throws InterruptedException, IOException {
            try {

                loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
                home = new HomePage_SuperAdmin();
                associateCompanies = new AssociateCompanies();
                logger.logInfo("clicking on Associate companies in companies ");
                home.NAvMenu("Companies");
                associateCompanies.Associatecompaniess("Click the Associate Companies");
               // Random randomGenerator = new Random();
                //int randomInt = randomGenerator.nextInt(1000);
                //String CompanyName = "Test Company" + randomInt;
                associateCompanies.parent("Filpkart");
                associateCompanies.Dropdown("Filpkart");
                Thread.sleep(3000);
                associateCompanies.actinbtn();
                associateCompanies.addnew();
                logger.logInfo("Entering Company Details");
                associateCompanies.companycode("CompanyCode");
                Thread.sleep(3000);
                //company.copyAssociatecompany();
                associateCompanies.companyname("CompanyName");
                associateCompanies.businesstypedop("IT");
                associateCompanies.Dropdown("IT");
                associateCompanies.website("www.filpkartsales.com");
                associateCompanies.scrollIntoView(associateCompanies.esttypedop);
                Thread.sleep(5000);
                associateCompanies.esttypedop("Factory");
                associateCompanies.Dropdown("Factory");
                Thread.sleep(3000);
                associateCompanies.statusdop("Active");
                associateCompanies.Dropdown("Active");
                associateCompanies.empdop("1-100");
                associateCompanies.Dropdown("1-100");
                //Thread.sleep(3000);
                // company.scrollIntoView(company.Logoupload);
                associateCompanies.Logoupload("C:\\Users\\sathw\\OneDrive\\Pictures\\download (3).png");
                Thread.sleep(5000);
                associateCompanies.create();
                Thread.sleep(2000);
                assertTrue(home.CreatedSucees());
                Thread.sleep(3000);
                //company.save();
                associateCompanies.savenxt();
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


