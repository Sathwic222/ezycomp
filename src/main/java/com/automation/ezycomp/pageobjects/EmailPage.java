package com.automation.ezycomp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.ezycomp.base.TestBase;

public class EmailPage extends TestBase {
	
//	email templates
	
	@FindBy(xpath=".//span[text()='Email & Notifications']")
	WebElement Email_Notification;
	
	@FindBy(xpath=".//span[text()='Email Templates']")
	WebElement email_templates;
	
	@FindBy(xpath=".//button[@class='px-3 ms-auto text-nowrap btn btn-primary']")
	WebElement E_addnew;
	
	@FindBy(xpath="(//input[@type='text'])[1]")
	WebElement E_Template;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	WebElement E_company;
	
	@FindBy(xpath=".//textarea[@name='subject']")
	WebElement E_subject;
	
	@FindBy(xpath=".//input[@name='emailCC']")
	WebElement E_email_cc;
	
	@FindBy(xpath="//div[contains(@data-placeholder,'Enter Email Body')]/p")
	WebElement E_emailbody;
	
	@FindBy(xpath="//div[contains(@data-placeholder,'Enter Email Signature')]/p")
	WebElement E_signature;
	
	@FindBy(xpath=".//button[@class='px-4 ms-3 btn btn-primary']")
	WebElement E_create;
	
	@FindBy(xpath=".//div[contains(text(),'added successfully')]")
	WebElement E_added_sucessfully;
	
	@FindBy(xpath="//input[@id='react-select-2-input']")
	WebElement Temp_type_drop;
	
	@FindBy(xpath="(.//div[contains(text(),'User Creation')])[2]")
	WebElement texts;
	
	
	@FindBy(xpath="//input[@id='react-select-11-input']")
	WebElement C_dropdown;
	
	
	
	
	
	
	public EmailPage(){
    	PageFactory.initElements(driver, this);
    }
	
//	email templates
	
	public void emailNotifications() {
		Email_Notification.click();
	}
	
	public void emails_type() {
		email_templates.click();
	}
	
	public void AddNew_button() {
		E_addnew.click();
	}
	
	public void Template_type(){
		E_Template.click();
	}
	
	public void email_company() {
		E_company.click();
	}
	
	public void Email_subject(String value) {
		E_subject.sendKeys(value);
	}
	
	public void Email_cc(String value) {
		E_email_cc.sendKeys(value);
	}
	
	public void Email_body(String value) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", E_emailbody);
		Thread.sleep(2000);
		E_emailbody.sendKeys(value);
	}
	
	public void Email_signature(String value) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", E_signature);
		Thread.sleep(2000);
		E_signature.sendKeys(value);
	}
	
	public void create() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", E_create);
		Thread.sleep(2000);
		E_create.click();
	}
	
	public void created() {
		E_create.isDisplayed();
	}
	
	
	
	public void Type_t_drop() {
		Temp_type_drop.click();
	}
	
	public boolean texting() {
		return texts.isDisplayed();
	}
	
	public void Comp_drop() {
		C_dropdown.click();
	}
	
	public boolean checking() {
		return texts.isDisplayed();
	}
	
	
	
//	public boolean added_sucessfully() {
//		return success.isDisplayed();
//	}	
	

}
