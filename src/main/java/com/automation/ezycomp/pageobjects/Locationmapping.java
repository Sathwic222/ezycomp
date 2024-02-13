package com.automation.ezycomp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.ezycomp.base.TestBase;

public class Locationmapping extends TestBase {
	
	@FindBy(xpath = ".//h4[text()='Home']")
    WebElement Homepage;
	
	@FindBy(xpath ="(.//span[@class='sidenav-item-icon'])[1]")
	WebElement NavDoubleright;

    @FindBy(xpath ="(.//div[@class='d-flex flex-row align-items-center w-100'])[2]")
     WebElement Companieslist;
    
    @FindBy(xpath="(.//span[@class=\"sidenav-item-label\"])[12]")
     WebElement locmap;
    
    public WebElement DropDownValue(String value) {
		return driver.findElement(By.xpath("//div[contains(@id,'listbox')]//div[contains(text(),'"+value+"')]"));
	}
	
	public void Dropdown(String value) {
		  DropDownValue(value).click();
	  }
	
    @FindBy(xpath="(.//div[@class=\" css-13cymwt-control\"])[1]")
    WebElement compdop ;
    	
    @FindBy(xpath="(.//div[@class=\" css-13cymwt-control\"])[2]")
    WebElement asscompdop ;
    
    @FindBy(xpath=".//button[@class=\"dropdown-toggle show btn btn-primary\"]")
     WebElement actionbtn;

    @FindBy(xpath=".//span[contains(text(),'Add New')]")
	WebElement ActionsButtonAdd;
    
    @FindBy(xpath="//div[@id=\"react-select-15-placeholder\"]")
     WebElement statedrop ;
    
    @FindBy(xpath="(.//div[@class=\"input-group\"])[5]")
     WebElement citydrop;
    
    @FindBy(xpath=".//input[@name=\"locationName\"]")
    WebElement locname;
    
    @FindBy(xpath=".//input[@name=\"locationCode\"]")
    WebElement loccode;
   
    @FindBy(xpath=".//input[@name=\"contactPersonName\"]")
    WebElement conpername ;
   
    @FindBy(xpath=".//input[@name=\"contactPersonMobile\"]")
    WebElement mobile;
   
    @FindBy(xpath=".//input[@name=\"contactPersonEmail\"]")
    WebElement email;
   
    @FindBy(xpath=".//textarea[@name=\"address\"]")
    WebElement address ;
   
    
    @FindBy(xpath=".//button[@class=\"px-4 btn btn-primary\"]")
    WebElement submitbtn ;
     
    @FindBy(xpath=".//button[@class=\"btn btn-outline-secondary px-4 btn btn-outline-secondary\"]")
     WebElement cancelbtn;
    
    
    public Locationmapping() {
    	PageFactory.initElements(driver, this);
    }
    
    public void Homepage() {
    	Homepage.click();
    }
    public void NavDoubleright() {
    	NavDoubleright.click();
    }
    public void Companieslist() {
    	Companieslist.click();
    }
    public void locmap() {
    	locmap.click();
    }
    public void compdop() {
    	compdop.sendKeys("ETV AndhraPradesh");
    }
    public void asscompdop() {
    	asscompdop.sendKeys("ETV News");
    }
    public void actionbtn() {
    	actionbtn.click();
    }
    public void ActionsButtonAdd() {
    	ActionsButtonAdd.click();
    }
    public void statedrop() {
    	statedrop.sendKeys("Maharashtra");
    }
    public void citydrop() {
    	citydrop.sendKeys("Barshi");
    }
    public void locname() {
    	locname.sendKeys("Safari");
    }
    public void loccode() {
    	loccode.sendKeys("sfia");
    }
    public void conpername() {
    	conpername.sendKeys("Munna");
    }
    public void mobile() {
    	mobile.sendKeys("9900776655");
    }
    public void email() {
    	email.sendKeys("munnna12@gmail.com");
    }
    public void address() {
    	address.sendKeys("1-12,ravind colony,anderi,mumbai");
    }
    public void submitbtn() {
    	submitbtn.click();
    }
   public void cancelbtn() {
	   cancelbtn.click();
   
	
}
    
}

