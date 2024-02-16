package com.automation.ezycomp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

import com.automation.ezycomp.base.TestBase;

public class CityPage extends TestBase{
	
	public JavascriptExecutor jsExecutor;

	public CityPage(){
	    	PageFactory.initElements(driver, this);
	    }
	
	 @FindBy(xpath="(//input[@type='text'])[1]")
	WebElement StateDropdown;
	 
			 
	@FindBy(xpath="//input[@placeholder='Enter City Name']")  //input[@placeholder='Enter City Name']
	WebElement EnterCityName;
	
	@FindBy(xpath="//input[@placeholder='Enter City Code']")
	WebElement EnterCityCode;
	
	@FindBy(xpath="//div[@role='dialog']//div//div//div//form//div//div//div//div//div//div//input[@type='text']")
	WebElement AddStateType;
	
	
	
	public void TypeDropdownClick() throws InterruptedException { 
		StateDropdown.click();
	  }
	
	
	public void EnterCityName(String Value, String Code) throws InterruptedException {
		EnterCityName.sendKeys(Value);
		EnterCityCode.sendKeys(Code);
	  }
	
	public void AddStateType() throws InterruptedException { 
		AddStateType.click();
	  }
	
	

}
