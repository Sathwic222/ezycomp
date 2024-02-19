package com.automation.ezycomp.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.ezycomp.base.TestBase;

public class Notification_page extends TestBase{
	
	@FindBy(xpath=".//span[text()='Notification Templates']")
	WebElement Notifications;
	
	@FindBy(xpath="//span[normalize-space()='Add New']")
	WebElement N_Addnew;
	
	@FindBy(xpath="(//div[contains(@class,' css-13cymwt-control')])[4]")
	WebElement Template_types;
	
	@FindBy (xpath="(//div[contains(@class,'css-19bb58m')])[5]")
	WebElement Companys;
	
	@FindBy(xpath=".//textarea[@name='title']")
	WebElement Titles;
	
	@FindBy(xpath=".//textarea[@name='message']")
	WebElement messages;
	
	@FindBy(xpath="//button[@class='px-4 btn btn-primary']")
	WebElement Submits;
	
	@FindBy(xpath=".//div[contains(text(),'successfully')]")
	WebElement created_successfully;
	
	@FindBy(xpath="(//div[contains(@class,'css-19bb58m')])[1]")
	WebElement Template;
	
	@FindBy(xpath="(//div[contains(@class,'css-19bb58m')])[2]")
	WebElement companies;
	
	@FindBy(xpath="(//input[@placeholder='Search'])[1]")
	WebElement searchs;
	
	@FindBy(xpath="(.//div[contains(text(),'Adding Mapping')])[2]")
	WebElement addmapings;
	
	@FindBy(xpath="(.//div[contains(text(),'SN Reddy LTD')])[2]")
	WebElement snreddy;
	
	@FindBy(xpath=".//div[contains(text(),'DUPLICATE')]")
	WebElement d_exists;
	
	
	
	public Notification_page(){
    	PageFactory.initElements(driver, this);
    }
	
	public void Notification() {
		Notifications.click();
	}
	
	public void  Addnew () {
		N_Addnew.click();
	}
	
	public void Template() {
		Template_types.click();
	}
	
	public void Company() {
		Companys.click();
	}
	
	public void Title(String value) {
		Titles.sendKeys(value);
	}
	
	public void Message(String value) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", messages);
		Thread.sleep(2000);
		messages.sendKeys(value);
	}
	
	public void submit() {
		Submits.click();
	}
	
	public boolean successfull() {
		return created_successfully.isDisplayed();
	}
	
	public void Template_dd() {
		Template.click();
	}
	
	public void company_dd() {
		companies.click();
	}
	
	public void Search(String value) {
		searchs.sendKeys(value);
	}
	
	public boolean Addmaping() {
		return addmapings.isDisplayed();
	}
	
	public boolean country_dd() {
		return snreddy.isDisplayed();
	}
	
	public boolean duplicate() {
		return d_exists.isDisplayed();
	}
	
}
