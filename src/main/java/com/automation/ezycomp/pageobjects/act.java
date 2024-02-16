package com.automation.ezycomp.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.ezycomp.base.TestBase;

public class act  extends TestBase{
	HomePage_SuperAdmin home;

	
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement Type;
	
	public act() {
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath=".//input[@id='react-select-2-input']")
	WebElement TypeDropdown;
	
	@FindBy(xpath="//div[contains(@id,'listbox')]//div[contains(text(),'CLRA')]")
	WebElement TypeDropdownValue;
	
	@FindBy(xpath="(.//div[contains(text(),'CLRA')])[2]")
	WebElement Clra;
	
	@FindBy(xpath=".//input[@id='react-select-3-input']")
	WebElement LawDropdown;
	
	@FindBy(xpath="//div[contains(@id,'listbox')]//div[contains(text(),'Labour Laws')]")
	WebElement LawDropdownValue;
	
	@FindBy(xpath="(.//div[contains(text(),'Labour Laws')])[2]")
	WebElement LawDropdownValues;
	
	@FindBy(xpath=".//button[contains(text(),'Actions')]")
	WebElement ActionsButton;
	
	@FindBy(xpath=".//span[contains(text(),'Add New')]")
	WebElement ActionsButtonAdd;
	
	@FindBy(xpath=".//textarea[@placeholder='Enter Act Name']")
	WebElement EnterActName;
	
	@FindBy(xpath=".//input[@id='react-select-5-input']")
	WebElement AddType;
	
	@FindBy(xpath=".//input[id='react-select-15-input']")
	WebElement EstablishmentType;
	
	
	@FindBy(xpath="//div[contains(@id,'listbox')]//div[contains(text(),'CLRA')]")
	WebElement AddTypes;
	
	@FindBy(xpath=".//input[@id='react-select-6-input']")
	WebElement AddActLawDropdown;
	
	@FindBy(xpath="//div[contains(@id,'listbox')]//div[contains(text(),'Labour Laws')]")
	WebElement AddActLawDropdowns;
	
	@FindBy(xpath="input[type='file']")
	WebElement Choosefile;
	
	@FindBy(xpath="div[role='grid'] div:nth-child(2) div:nth-child(1) div:nth-child(1) div:nth-child(1) div:nth-child(1) div:nth-child(1)")
	WebElement SortingElements;
	

	public void Establishment() throws InterruptedException {
		  TypeDropdown.click(); 
	  }
	
	//TypeDropdownValue.click();
	
	public boolean EstablishmentVerfication() throws InterruptedException {
		return Clra.isDisplayed();  
	  }
	
	public void LawDropdown() throws InterruptedException {
		  LawDropdown.click();  
	  }
	
	public boolean LawVerfication() throws InterruptedException {
		return LawDropdownValues.isDisplayed();  
	  }
	
	public void ActionClick() throws InterruptedException {
		  ActionsButton.click(); 
	  }
	
	public void ActionsAdd() throws InterruptedException {
		  ActionsButtonAdd.click();  
	  }
	
	public void EnterActName(String Value) throws InterruptedException {
		EnterActName.sendKeys(Value);  
	  }
	
	public void TypeClick() throws InterruptedException { 
		AddType.click();
	  }
	
	public void EstablishmentType() throws InterruptedException { 
		EstablishmentType.click();
	  }
	
     
	public void LawClick() throws InterruptedException { 
		AddActLawDropdown.click();
	  }
	
//	public void Sorting() throws InterruptedException { 
//		List<WebElement> radioelemnts = sorting;
//		AddActLawDropdown.click();
//	  }
	
	
	
	
	
	
	//((JavascriptExecutor) driver).executeScript("document.getElementById('//id of element').setAttribute('attr', '10')");
	
	public void Choosefile(String Path) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("document.getElementByClassName('form-control is-valid').setAttribute('Value', Path)");
		//Choosefile. 
	  }
}
