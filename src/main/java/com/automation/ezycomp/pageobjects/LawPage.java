package com.automation.ezycomp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.ezycomp.base.TestBase;

public class LawPage extends TestBase{
	
	 public LawPage(){
	    	PageFactory.initElements(driver, this);
	    }
	 
	@FindBy(xpath = ".//input[@name='username']")
    WebElement Username1;
	
	public WebElement Actions(String value) {
		return driver.findElement(By.xpath("//div[text()='"+value+"']/../../..//span[@title='Edit']"));
	}

}
