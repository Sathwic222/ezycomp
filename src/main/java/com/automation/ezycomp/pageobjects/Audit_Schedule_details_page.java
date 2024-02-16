package com.automation.ezycomp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.ezycomp.base.TestBase;

public class Audit_Schedule_details_page extends TestBase {
	
	

	

	

//	Audit schedule details
	
	@FindBy(xpath=".//span[text()='Audit Management']")
	WebElement A_audit;
	
	@FindBy(xpath=".//span[text()='Audit Schedule Details']")
	WebElement A_Audit_SD;
	
	@FindBy(xpath="(//input[@id='react-select-2-input'])[1]")
	WebElement A_company;
	
	@FindBy(xpath="(//div[@class=' css-19bb58m'])[2]")
	WebElement A_ass_company;
	
	@FindBy(xpath="(//div[@class=' css-19bb58m'])[3]")
	WebElement A_location;
	
	@FindBy(xpath=".//span[@class='ms-2']")
	WebElement A_advance_search;
	
	@FindBy(xpath=".//input[@name='monthYear']")
	WebElement A_monthyear;
	
	@FindBy(xpath=".//span[text()='July']")
	WebElement A_month;
	
	@FindBy(xpath=".//input[@name='dueDate']")
	WebElement A_duedate;
	
	@FindBy(xpath=".//span[text()='21']")
	WebElement A_date;
	
	@FindBy(xpath="(.//div[@class=' css-19bb58m'])[5]")
	WebElement A_activity;
	
	@FindBy(xpath="(.//div[@class=' css-19bb58m'])[6]")
	WebElement A_Audit;
	
	@FindBy(xpath=".//button[text()='Submit']")
	WebElement A_submit;
	
	@FindBy(xpath="(//div[contains(@class,'tabulator-table')]//input[contains(@aria-label,'Select Row')])[1]")
	WebElement A_checkbox;
	
	@FindBy(xpath="(//div[contains(@class,'tabulator-table')]//input[contains(@aria-label,'Select Row')])[2]")
	WebElement A_checkbox1;
	
	@FindBy(xpath="(//div[contains(@class,'tabulator-table')]//span[@title='Delete'])[1]")
	WebElement A_delete;
	
	@FindBy(xpath="//div[@class='ms-auto']")
	WebElement A_bulkdelete;
	
	@FindBy(xpath="(.//button[@type='button'])[15]")
	WebElement A_yes;
	
	
	public Audit_Schedule_details_page() {
		PageFactory.initElements(driver, this);
	}
	
	public void Audit_Management() {
		A_audit.click();
	}
	
	public void A_S_Details() {
		A_Audit_SD.click();
	}
	
	public void Audit_company() {
		A_company.click();
	}
	
	public void Audit_ass_company() {
		A_ass_company.click();
	}
	
	public void Audit_location() {
		A_location.click();
	}
	
	public void Advance() {
		A_advance_search.click();
	}
	
	public void month_year() {
		A_monthyear.click();
	}
	
	public void month() {
		A_month.click();
	}
	
	public void checkbox() {
		A_checkbox.click();
		A_checkbox1.click();
	}
	
	public void sub() {
		A_submit.click();
	}
	
	public void delete() {
		A_delete.click();
	}
	
	public void Bulk_deleted() {
		A_bulkdelete.click();
	}
	
	public void yes() {
		A_yes.click();
	}
	
	
	

}
