package com.automation.ezycomp.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.ezycomp.base.TestBase;

public class Departmentpage  extends TestBase{
	
	HomePage_SuperAdmin home;
	
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement Type;
	
	public Departmentpage() {
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="(//input[@role='combobox'])[1]")
	WebElement CompanyDropdown;
	
	@FindBy(xpath="(//input[@role='combobox'])[2]")
	WebElement VerticalDropdown;
	
	@FindBy(xpath="(//input[@type='text'])[5]")
	WebElement AddCompanyDropdown;
	
	@FindBy(xpath="(//input[@type='text'])[6]")
	WebElement AddVerticalDropdown;
	
	
	@FindBy(xpath=".//input[@placeholder='Enter Department Name']")
	WebElement AddDepartmentName;
	
	@FindBy(xpath=".//input[@placeholder='Enter Department Code']")
	WebElement AddDepartmentCode;
	
	@FindBy(xpath=".//textarea[@placeholder='Enter Description']")
	WebElement AddDepartmentDescription;
	
	
	
	

	public void CompanyDropdown() throws InterruptedException {
		CompanyDropdown.click(); 
	  }
	
	public void VerticalDropdown() throws InterruptedException {
		VerticalDropdown.click(); 
	  }
	
	public void AddCompanyDropdown() throws InterruptedException {
		AddCompanyDropdown.click();  
	  }
	
	public void AddVerticalDropdown() throws InterruptedException {
		AddVerticalDropdown.click();  
	  }
	
	public void AddDepartmentName(String Value, String Code) throws InterruptedException {
		AddDepartmentName.sendKeys(Value); 
		AddDepartmentCode.sendKeys(Code);
	  }
	
	public void AddDepartmentDescription(String Value) throws InterruptedException {
		AddDepartmentDescription.sendKeys(Value);  
	  }
	
}
