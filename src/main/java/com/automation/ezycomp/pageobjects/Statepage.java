package com.automation.ezycomp.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.ezycomp.base.TestBase;

public class Statepage extends TestBase {
	public Statepage(){
    	PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath = "//input[@placeholder='Enter State Name']")
    WebElement Statename;
	
	@FindBy(xpath = "//input[@placeholder='Enter State Code']")
    WebElement Statecode;
	
	
	 public String StateAdd(String username,String password) {
		 Statename.sendKeys(username);
		 Statecode.sendKeys(password);
		return username;
	 }
	 
	 public String StateEdit(String username) {
		 Statename.sendKeys(username);
		return username;
	 }
	 
	    

}
