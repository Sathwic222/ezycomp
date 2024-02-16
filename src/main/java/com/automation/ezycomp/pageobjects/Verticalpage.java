package com.automation.ezycomp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

import com.automation.ezycomp.base.TestBase;

public class Verticalpage extends TestBase{
	
	public JavascriptExecutor jsExecutor;

	public Verticalpage(){
	    	PageFactory.initElements(driver, this);
	    }
	
	 @FindBy(xpath="(//input[@type='text'])[1]")
	WebElement CompanyDropdown;
	 
			 
	 @FindBy(xpath="(//input[@type='text'])[4]")
	WebElement InAddCompanyDropdown;
	 
	@FindBy(xpath="//input[@placeholder='Enter Vertical Name']")
	WebElement EnterVerticalName;
	
	@FindBy(xpath="//input[@placeholder='Enter Vertical Code']")
	WebElement EnterVerticalCode;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Description']")
	WebElement EnterVerticalDescription;
	
	
	public void CompanyDropdown() throws InterruptedException { 
		CompanyDropdown.click();
	  }
	
	public void InAddCompanyDropdown() throws InterruptedException { 
		InAddCompanyDropdown.click();;
	  }
	
	public void EnterVerticalName(String Value, String Code) throws InterruptedException {
		EnterVerticalName.sendKeys(Value);
		EnterVerticalCode.sendKeys(Code);
	  }
	
	public void EnterVerticalDescription(String Value) throws InterruptedException { 
		EnterVerticalDescription.sendKeys(Value);
	  }
	
	

}