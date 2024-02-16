package com.automation.ezycomp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.ezycomp.base.TestBase;

public class ActivityPag  extends TestBase{
	
	HomePage_SuperAdmin home;
	
	public ActivityPag() {
		PageFactory.initElements(driver, this);
	}
	
// dropdowns
	
	@FindBy(xpath=".//input[@id='react-select-2-input']")
	WebElement TypeDropdown;
	
	@FindBy(xpath=".//input[@id='react-select-3-input']")
	WebElement PeriodicityDropdown;
	
	@FindBy(xpath=".//input[@id='react-select-4-input']")
	WebElement CalendarTypeDropDown;
	
	// Add Functionality
	
	@FindBy(xpath=".//textarea[@placeholder='Enter Activity']")
	WebElement EnterActivityName;
	
	@FindBy(xpath=".//input[@id='react-select-6-input']")
	WebElement AddActivityType;
	
	@FindBy(xpath=".//input[@id='react-select-7-input']")
	WebElement AddPeridiocity;
	
	
	@FindBy(xpath=".//input[@id='react-select-8-input']")
	WebElement AddCalendarTypeDropDown;
	
	
	

	public void Establishment() throws InterruptedException {
		  TypeDropdown.click(); 
	  }

	public void PeriodicityDropdown() throws InterruptedException {
		PeriodicityDropdown.click();  
	  }
	
	public void CalendarTypeDropDown() throws InterruptedException {
		CalendarTypeDropDown.click();  
	  }
	
	public void EnterActivityName(String Value) throws InterruptedException {
		EnterActivityName.sendKeys(Value);  
	  }
	
	public void AddActivityType() throws InterruptedException { 
		AddActivityType.click();
	  }
	
	public void AddPeridiocity() throws InterruptedException { 
		AddPeridiocity.click();
	  }
	
	public void AddCalendarTypeDropDown() throws InterruptedException { 
		AddCalendarTypeDropDown.click();
	  }
}
