package com.automation.ezycomp.pageobjects;

import lombok.Value;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.ezycomp.base.TestBase;

public class Audit extends TestBase {
	
	@FindBy(xpath = ".//h4[text()='Home']")
    WebElement Homepage;
	
	@FindBy(xpath ="(.//span[@class='sidenav-item-icon'])[1]")
	WebElement NavDoubleright;

	@FindBy(xpath = "(.//div[@class='d-flex flex-row align-items-center w-100'])[3]")
	WebElement Auditmanagement;
	
	@FindBy(xpath="//span[normalize-space()='Audit Schedule']")
	WebElement Auditschedule;
	
	public WebElement DropDownValue(String value) {
		return driver.findElement(By.xpath("//div[contains(@id,'listbox')]//div[contains(text(),'"+value+"')]"));
	}
	
	public void Dropdown(String value) {
		  DropDownValue(value).click();
	  }
	
	@FindBy(xpath="//input[@id='react-select-2-input']")
	 WebElement companydop;
	
	@FindBy(xpath="//input[@id='react-select-3-input']")
	 WebElement asscompdop;
	
	@FindBy(xpath="//input[@id='react-select-4-input']")
	 WebElement locdop;
	
	@FindBy(xpath="//input[@id='react-select-5-input']")
	 WebElement actdop;
	
	@FindBy(xpath="//input[@class='rmdp-input']")
	 public WebElement month;
	
	@FindBy(xpath="//button[normalize-space()='Export']")
	 WebElement Exportbtn;
	 
	@FindBy(xpath=".//button[@class='btn btn-outline-secondary px-4 btn btn-outline-secondary']")
	 WebElement Resetbtn;
	
	@FindBy(xpath=".//button[@class='px-4 btn btn-primary']")
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
		actdop.click();
	}

	public void scrollIntoView(WebElement Xpath ) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",  new Object[] { Xpath});
	}
	public void month(String Value) {
		month.click();
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
