package com.automation.ezycomp.pageobjects;


import com.automation.ezycomp.functionLabrary.ReportLog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.ezycomp.base.TestBase;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Locationmapping extends TestBase {



    ReportLog logger;





    @FindBy(xpath=".//span[@title='Edit']")
    WebElement edit;

    @FindBy(xpath=".//span[@title='Delete']")
    WebElement delete;

    @FindBy(xpath=".//span[@title='View']")
    WebElement view;
	
	@FindBy(xpath = ".//h4[text()='Home']")
    WebElement Homepage;
	
	@FindBy(xpath ="(.//span[@class='sidenav-item-icon'])[1]")
	WebElement NavDoubleright;

    @FindBy(xpath ="(.//div[@class='d-flex flex-row align-items-center w-100'])[2]")
     WebElement Companieslist;
    
    @FindBy(xpath="(.//span[@class='sidenav-item-label'])[12]")
     WebElement locmap;
    
    public WebElement DropDownValue(String value) {
		return driver.findElement(By.xpath("//div[contains(@id,'listbox')]//div[contains(text(),'"+value+"')]"));
	}
	
	public void Dropdown(String value) {
		  DropDownValue(value).click();
	  }

	//label//small[text()='Company']/../..//input[contains(@id,'react-select-')]
    @FindBy(xpath="(//input[@role='combobox'])[1]")
    WebElement compdop ;
    	
    @FindBy(xpath="(//input[@role='combobox'])[2]")
    WebElement asscompdop ;
    
    @FindBy(xpath="//button[normalize-space()='Actions']")
     WebElement actionbtn;

    @FindBy(xpath=".//span[contains(text(),'Add New')]")
	WebElement ActionsButtonAdd;
    
    @FindBy(xpath="//input[@id='react-select-5-input']")
     WebElement statedrop ;
    
    @FindBy(xpath=".//input[@id='react-select-6-input']")
     WebElement citydrop;
    
    @FindBy(xpath=".//input[@name='locationName']")
    WebElement locname;
    
    @FindBy(xpath=".//input[@name='locationCode']")
    WebElement loccode;
   
    @FindBy(xpath=".//input[@name='contactPersonName']")
    WebElement conpername ;
   
    @FindBy(xpath=".//input[@name='contactPersonMobile']")
    WebElement mobile;
   
    @FindBy(xpath=".//input[@name='contactPersonEmail']")
    WebElement email;
   
    @FindBy(xpath=".//textarea[@name='address']")
    WebElement address ;
   
    
    @FindBy(xpath="//button[text()='Submit']")
    WebElement submitbtn ;
     
    @FindBy(xpath="//button[text()='Cancel']")
     WebElement cancelbtn;

   // ---------------------------
    @FindBy(xpath="(//input[@placeholder='Search'])[1]")
     WebElement search;

    @FindBy(xpath="(//span[@title='Edit'])[1]")
    WebElement editbtn;

    @FindBy(xpath="//span[@title='Delete']")
    WebElement deletebtn;

    @FindBy(xpath="(//span[@title='View'])[1]")
    WebElement viewbtn;







    //--------------------------------------------
    public Locationmapping() {
    	PageFactory.initElements(driver, this);
    }


    public void edit(String Value) {
        edit.click();
    }

    public void delete(String Value) {
        delete.click();
    }
    public void view(String Value) {
        view.click();
    }

  //  ---------------------------------------------
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
    public void compdop(String Value) {
    	compdop.sendKeys(Value);
    }
    public void asscompdop(String Value) {
    	asscompdop.sendKeys(Value);
    }




    public void actionbtn() {
    	actionbtn.click();
    }
    public void ActionsButtonAdd() {
    	ActionsButtonAdd.click();
    }
    public void statedrop(String Value) {

        statedrop.sendKeys(Value);
    }
    public void citydrop(String Value) {
    	citydrop.sendKeys(Value);
    }
    public String locname(String value){
        locname.sendKeys(value);
        return value;
    }
    public String locname(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        String LocName = "Avatar"+randomInt;
        locname.sendKeys("LocName");
        return LocName;
    }

    public String loccode(String value){
        loccode.sendKeys(value);
        return value;
    }
    public String locationcode (){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(10);
        String LocCode = "avtr"+randomInt;
        loccode.sendKeys("LocCode");
        return LocCode;
    }

    public void conpername(String Value) {

        conpername.sendKeys(Value);
    }
    public void mobile(String Value) {
    	mobile.sendKeys(Value);
    }
    public void email(String Value) {
    	email.sendKeys(Value);
    }
    public void address(String Value) {
    	address.sendKeys(Value);
    }
    public void submitbtn() {
    	submitbtn.click();
    }
   public void cancelbtn() {
	   cancelbtn.click(); }

       public void search(String Value) {
           search.sendKeys(Value);
       }
       public void delete() {
           deletebtn.click();
       }
       public void edit() {
           editbtn.click();
       }

       public void view() {
           viewbtn.click();
       }


       public String createLocMapping(String CompanyName,String AssociateCompName){
           Random randomGenerator = new Random();
           int randomInt = randomGenerator.nextInt(1000);
           String LocName = "Avatar" + randomInt;
           logger.logInfo("Entering username and password");
           Homepage();
           Companieslist();
           locmap();
           driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
           compdop(CompanyName);
           Dropdown(CompanyName);
           driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
          asscompdop(AssociateCompName);
          Dropdown(AssociateCompName);

           driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
           actionbtn();
           driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
           ActionsButtonAdd();
           statedrop("Telangana");
           Dropdown("Telangana");
           driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
           citydrop("Hyderabad");
           Dropdown("Hyderabad");

           locname("");
           loccode("");
           conpername("munna");
           mobile("7890123453");
           email("sathwic222@gmail.com");
           address("1-12,ravind colony,anderi,mumbai");
         //  Thread.sleep(5000);
          submitbtn();
          return LocName;
       }
	
}
    


