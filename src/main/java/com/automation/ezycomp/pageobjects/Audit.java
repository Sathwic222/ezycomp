package com.automation.ezycomp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.ezycomp.base.TestBase;

public class Audit extends TestBase {
	
	@FindBy(xpath = ".//h4[text()='Home']")
    WebElement Homepage;
	
	@FindBy(xpath ="(.//span[@class='sidenav-item-icon'])[1]")
	WebElement NavDoubleright;

	@FindBy(xpath = "(.//div[@class=\"d-flex flex-row align-items-center w-100\"])[3]")
	WebElement Auditmanagement;
	
	@FindBy(xpath="(.//a[@href=\"/auditSchedule/importExport\"])[2]")
	WebElement Auditschedule;
	
	public WebElement DropDownValue(String value) {
		return driver.findElement(By.xpath("//div[contains(@id,'listbox')]//div[contains(text(),'"+value+"')]"));
	}
	
	public void Dropdown(String value) {
		  DropDownValue(value).click();
	  }
	
	@FindBy(xpath="(.//div[@class=\" css-13cymwt-control\"])[1]")
	 WebElement companydop;
	
	@FindBy(xpath="(//div[@class=\"input-group\"])[2]")
	 WebElement asscompdop;
	
	@FindBy(xpath="(.//div[@class=\"input-group\"])[3]")
	 WebElement locdop;
	
	@FindBy(xpath="(.//div[@class=\" css-13cymwt-control\"])[2]")
	 WebElement actdop;
	
	@FindBy(xpath=".//input[@value=\"Dec, 2023\"]")
	 WebElement month; 
	
	@FindBy(xpath=".//button[@class=\"ms-4 px-4 btn btn-primary\"]")
	 WebElement Exportbtn;
	 
	@FindBy(xpath=".//button[@class=\"btn btn-outline-secondary px-4 btn btn-outline-secondary\"]")
	 WebElement Resetbtn;
	
	@FindBy(xpath=".//button[@class=\"px-4 btn btn-primary\"]")
	 WebElement Importbtn;
	
	public Audit () {
    	PageFactory.initElements(driver, this);
    }
	
	public void Homepage() {
		Homepage.click();
	}
	
	public void NavDoubleright() {
		NavDoubleright.click();
	}
	public void Auditmanagement () {
		Auditmanagement.click();
	}
	public void Auditschedule() {
		Auditschedule.click();
	}
	
	public void companydop(String Value) {
		companydop.sendKeys(Value);
	}
	public void asscompdop(String Value) {
		asscompdop.sendKeys(Value);
	}
	public void locdop(String Value) {
		locdop.sendKeys(Value);
	}
	public void actdop(String Value) {
		actdop.sendKeys(Value);
	}
	public void month() {
		month.sendKeys("Dec,2023");
	}
	public void Exportbtn() {
		Exportbtn.click();
	}
	public void Resetbtn() {
		Resetbtn.click();
	}
	public void Importbtn() {
		Importbtn.click();
	}
    
	

}
