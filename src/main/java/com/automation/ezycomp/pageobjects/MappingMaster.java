package com.automation.ezycomp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.ezycomp.base.TestBase;


public class MappingMaster extends TestBase  {
	
	private static final String masters = null;

	
   
   @FindBy(xpath =".//span[@class=\"sidenav-item-icon\"][1]")
   WebElement Navbar;
   
   @FindBy(xpath=".//a[@href=\"/masters/act\"]")
   WebElement Masters;
   
   
   
   public MappingMaster(){
   PageFactory.initElements(driver, this);
   }
    public void Rightnav(String value) {
   	Navbar.click();
   	}
   	public void masters(String value) {
   	Masters.click();
   	}
   	}
   	
   
    
  
	

