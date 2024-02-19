package com.automation.ezycomp.pageobjects;

import com.automation.ezycomp.functionLabrary.ReportLog;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.ezycomp.base.TestBase;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Common_methods  extends TestBase{

    ReportLog logger;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement Type;

    public Common_methods() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath=".//input[@id='react-select-2-input']")
    WebElement TypeDropdown;

    @FindBy(xpath="//div[@class='custom-tabulator-footer d-flex justify-content-between align-items-center w-100 undefined']//span[contains(text(),'Showing')]")
    WebElement Showing;

    public WebElement Page(String value) {
        return driver.findElement(By.xpath("//span[@title='"+value+"']"));
    }

    public WebElement waitForElement(WebElement Xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(d -> Xpath.isDisplayed());
        return Xpath;
    }

    public void Pagination(String value) {
        Page(value).click();
    }

    public boolean Pageshowing(String value) {
        return Show(value).isDisplayed();
    }
    public WebElement Show(String value) {
        return driver.findElement(By.xpath("//span[contains(text(),'"+value+"')]"));
    }

//    public void verifyPagination() throws IOException {
//        Pagination("Next");
//        waitForElement(Show("51 - 100"));
////        Thread.sleep(2000);
//        Assert.assertTrue(Pageshowing("51 - 100"));
//        logger.logPass("pagination is working Navigate to next page");
//        Pagination("Next");
//        waitForElement(Show("101 - 150"));
//        //Thread.sleep(2000);
//        Assert.assertTrue(home.Pageshowing("101 - 150"));
//        logger.logPass("pagination is working Navigate to next page");
//        home.Pagination("Previous");
//        waitForElement(Show("51 - 100"));
//        Assert.assertTrue(home.Pageshowing("51 - 100"));
//        logger.logPass("pagination is working Navigate to Previous page");
//    }

//div[@class='custom-tabulator-footer d-flex justify-content-between align-items-center w-100 undefined']//span[contains(text(),'Showing')]

    public void Choosefile(String Path) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("document.getElementByClassName('form-control is-valid').setAttribute('Value', Path)");
        //Choosefile.
    }
}
