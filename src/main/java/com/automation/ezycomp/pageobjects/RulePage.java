package com.automation.ezycomp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

import com.automation.ezycomp.base.TestBase;

public class RulePage extends TestBase{
	
	public JavascriptExecutor jsExecutor;

	public RulePage(){
	    	PageFactory.initElements(driver, this);
	    }
	 
//	public ScrollUtils(WebDriver driver) {
//        this.driver = driver;
//        this.jsExecutor = (JavascriptExecutor) driver;
//    }
//	
	 public void scrollDownByPixels(int pixels) {
	        jsExecutor.executeScript("window.scrollBy(0, arguments[0])", pixels);
	    }
	 
	 public void scrollToBottom() {
	        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    }
	
	 @FindBy(xpath="(//input[@type='text'])[1]")
	WebElement TypeDropdown;
	 
			 
	@FindBy(xpath=".//textarea[@placeholder='Enter Rule Name']")
	WebElement EnterRuleName;
	
	@FindBy(xpath=".//textarea[@placeholder='Enter Description']")
	WebElement EnterDescription;
	
	@FindBy(xpath="(//div)[553]")
	WebElement AddType;
	
	@FindBy(xpath=".//input[@placeholder='Enter Section No.']")
	WebElement EnterSectionNo;
	
	@FindBy(xpath=".//input[@placeholder='Enter Rule No.']")
	WebElement EnterRule;
	
	@FindBy(xpath=".//textarea[@placeholder='Enter Unique Identifier']")
	WebElement EnterUniqueIdentifier;
	
	
	
	public void TypeDropdownClick() throws InterruptedException { 
		TypeDropdown.click();
	  }
	
	
	public void EnterRuleName(String Value) throws InterruptedException {
		EnterRuleName.sendKeys(Value);
		EnterDescription.sendKeys(Value);
	  }
	
	public void TypeClick() throws InterruptedException { 
		AddType.click();
	  }
	
	public void EnterRuleNo(String Value, String Rule, String Unique) throws InterruptedException {
		EnterSectionNo.sendKeys(Value);
		EnterRule.sendKeys(Rule);
		EnterUniqueIdentifier.sendKeys(Unique);
	  }
	

}
