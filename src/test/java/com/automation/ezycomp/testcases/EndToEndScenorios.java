package com.automation.ezycomp.testcases;

import com.automation.ezycomp.base.TestBase;
import com.automation.ezycomp.functionLabrary.ReportLog;
import com.automation.ezycomp.pageobjects.*;
import junit.framework.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertTrue;

public class EndToEndScenorios extends TestBase {

    LoginPage loginpage;
    HomePage_SuperAdmin home;
    ReportLog logger;
    Companies Company;
    CompaniesAddnew company;
    AssociateCompanies associateComp;

    Locationmapping mapping;
    Audit audit;


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
    public void Valid_endtoend_audit() throws InterruptedException, IOException {
        try {
            loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
            home = new HomePage_SuperAdmin();
            //Company = new Companies();
            company = new CompaniesAddnew();
            associateComp = new AssociateCompanies();
            mapping = new Locationmapping();
            audit = new Audit();
            logger.logInfo("Entering username and password");
            logger.logInfo("clicking on manage companies in companies ");

            // Create new Company
            home.NAvMenu("Companies");
            home.NAvMenu("Manage Companies");
            Thread.sleep(5000);
            logger.logInfo("Entering Company Details");
            //String companyName = company.CreateCompany();
            String companyName = "Test Company457";
            Thread.sleep(2000);
            //Assert.assertTrue(home.CreatedSucees());
            Thread.sleep(3000);

            // Create Associate Company
//            home.NAvMenu("Companies");
//            home.NAvMenu("Associate Companies");
            logger.logInfo("Entering Company Details");
            String AssociateComp = associateComp.CreateAssociateCompany(companyName);
            Thread.sleep(2000);
            assertTrue(home.CreatedSucees());
            Thread.sleep(3000);

            //Mappings

            mapping.createLocMapping(companyName,AssociateComp);
            Thread.sleep(2000);
            assertTrue(home.CreatedSucees());
            Thread.sleep(3000);


            // Audit

            audit.GenerateAuditSchedule();
            Thread.sleep(2000);
            assertTrue(home.CreatedSucees());
            Thread.sleep(3000);

        } catch (Exception e) {
            logger.logFail("Login functionality for super admin is failed" + e.getMessage());

        }
    }





            @Test(priority = 3)
            public void Add_comp_endtoend () throws InterruptedException, IOException {
                try {
                    loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
                    home = new HomePage_SuperAdmin();

                    mapping = new Locationmapping();
                    logger.logInfo("Entering username and password");
                    mapping.Homepage();
                    //mapping.NavDoubleright();
                    mapping.Companieslist();
                    mapping.locmap();
                    Thread.sleep(3000);
                    mapping.compdop("Filpkart");
                    mapping.Dropdown("Filpkart");
                    Thread.sleep(3000);
                    mapping.asscompdop("BigSales");
                    mapping.Dropdown("BigSales");

                    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                    mapping.actionbtn();
                    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                    mapping.ActionsButtonAdd();
                    mapping.statedrop("Telangana");
                    mapping.Dropdown("Telangana");
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    mapping.citydrop("Hyderabad");
                    mapping.Dropdown("Hyderabad");

                    mapping.locname("AutoMatIom");
                    mapping.loccode("audo");
                    mapping.conpername("munna");
                    mapping.mobile("7890123453");
                    mapping.email("sathwic222@gmail.com");
                    mapping.address("1-12,ravind colony,anderi,mumbai");
                    Thread.sleep(5000);
                    mapping.submitbtn();
                    //Assert.assertTrue();
                    logger.logPass("Add location for company is passed");
                } catch (Exception e) {
                    logger.logFail("Add location for company is failed" + e.getMessage());
                }

            }
                @Test(priority=4)
                public void login()  throws InterruptedException, IOException {
                    try {
                        loginpage = new LoginPage(prop.getProperty("Superadmin"), prop.getProperty("password"));
                        home = new HomePage_SuperAdmin();
                        audit = new Audit();
                        Thread.sleep(2000);
                        audit.Homepage();
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

                        logger.logPass("Audit Schedule will generated for month is passed");
                    } catch (Exception e) {
                        logger.logFail("Audit Schedule will generated for month is failed"+e.getMessage());

                    }
                }




        @AfterMethod
        public void tearDown () {
            driver.quit();

        }
        @AfterSuite
        public void endTestSuite () {
            logger.endTestSuite();
        }

    }










