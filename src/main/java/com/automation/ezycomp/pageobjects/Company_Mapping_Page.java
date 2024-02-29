package com.automation.ezycomp.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.ezycomp.base.TestBase;
//import com.automation.ezycomp.testcases.Robot;

public class Company_Mapping_Page extends TestBase {
	
//	company mapping
	
	@FindBy(xpath=".//span[text()='Company Mapping']")
	WebElement U_companymapping;
	
	@FindBy(xpath=".//input[@type = 'text']")
	WebElement U_role_dd;
	
	@FindBy(xpath=".//button[@class = 'px-4 ms-auto text-nowrap btn btn-primary']")
	WebElement U_add_user_location;
	
	@FindBy(xpath="(.//div[@class = ' css-19bb58m'])[2]")
	WebElement U_company_dd;
	
	@FindBy(xpath="(.//div[@class = ' css-19bb58m'])[3]")
	WebElement U_ass_company_dd;
	
	@FindBy(xpath="//body/div[@role='dialog']/div[@class='modal-dialog drawer']/div[@class='modal-content']/div[@class='modal-body']/div[@class='d-flex flex-column h-100']/div[@class='UserManagement_locationsList__2pdQs d-flex flex-column']/div[1]")
	WebElement location_1;
	
	@FindBy(xpath="//div[@class='UserManagement_locationsList__2pdQs d-flex flex-column']//div[2]")
	WebElement location_2;
	
	@FindBy(xpath="//div[contains(@class,'tabulator-table')]//div[@tabulator-field='count']//a")
	WebElement counts;
	
	private List<WebElement> location() {
		return driver.findElements(By.xpath("//div[@class='UserManagement_locationsList__2pdQs d-flex flex-column']//div[@class='d-flex flex-column']"));
	}
	
	private List<WebElement> selected_location() {
		return driver.findElements(By.xpath("//div[@class='UserManagement_locationsList__2pdQs d-flex flex-column']//span[@class='icon icon-check-circle-o  text-lg ']"));
	}
	
	public List<WebElement> headerData() {
		return driver.findElements(By.xpath("//div[contains(@class,'UserManagement_locationDetails')]"));
	}
	
	@FindBy(xpath=".//div[contains(@class,'tabulator-tableholder')]//div[@class='tabulator-table']")
	WebElement display;
	
	
	public Company_Mapping_Page() {
		PageFactory.initElements(driver, this);
	}
	
//	public WebElement counts(String value) {
//		return driver.findElement(By.xpath("//div[contains(@class,'tabulator-table')]//div//href[contains(text(),'"+value+"')]"));
//	}
	
	
//	company mapping
	
	public void Company_mapping() {
		U_companymapping.click();
	}
	
	public void Role_dropdown(String value) {
		U_role_dd.sendKeys(value);
	}
	
	public void Add_location() {
		U_add_user_location.click();
	}
	
	public void company() {
		U_company_dd.click();
	}
	
	public void Ass_company() {
		U_ass_company_dd.click();
	}
	
	public void location1() {
		location_1.click();
	}
	
	public void location2() {
		location_2.click();
	}
	
	public void locationSelect(String cnt) {
		//
		int c = 0;
		if(cnt=="all") {
			c=location().size();
		}
		else {
			c = Integer.parseInt(cnt);
		}
		
		for(int i =0; i<c; i++) {
			location().get(i).click();
		}
	}
	
	public int locationsSelected() {
		
		return selected_location().size();
	}
	public int location_count() {
		int count = headerData().size();
		return count;
	}
	
	public String get_location_count() {
		return counts.getText();
	}
	
	
	public boolean data_checking() {
		return display.isDisplayed();
	}
	
	

}
