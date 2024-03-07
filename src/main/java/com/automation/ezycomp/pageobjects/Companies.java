package com.automation.ezycomp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.automation.ezycomp.base.TestBase.driver;

public class Companies {

    @FindBy(xpath=".//h4[text()='Home']")
    WebElement Homepage;
    @FindBy(xpath ="(.//span[@class='sidenav-item-icon'])[1]")
    WebElement NavDoubleright;

    @FindBy(xpath ="(.//div[@class='d-flex flex-row align-items-center w-100'])[2]")
    WebElement Companieslist;

    @FindBy(xpath ="(.//span[@class='sidenav-item-label'])[10]")
    WebElement ManageCompanies;

    @FindBy(xpath =".//input[@class='form-control']")
    WebElement Search;

    @FindBy(xpath=".//button[@class='px-3 ms-auto text-nowrap btn btn-primary']")
    WebElement AddNewBtn;

    public Companies() {
        PageFactory.initElements(driver, this);

    }

    public boolean homePageVerfication() {

        return Homepage.isDisplayed();
    }
    public void Rightarrow() {
        NavDoubleright.click();
    }

    public void Companieslist() {
        Companieslist.click();
    }

    public void ManageCompanies() {
        ManageCompanies.click();
    }

    public void Search(String Filpkart) {
        Search.sendKeys(Filpkart);
    }

    public void AddNewBtn() {
        AddNewBtn.click();
    }























}







