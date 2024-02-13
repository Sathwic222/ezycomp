package com.automation.ezycomp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.ezycomp.base.TestBase;

public class CompaniesAddnew extends TestBase {
	
	@FindBy(xpath = ".//h4[text()='Home']")
    WebElement Homepage;
	
	@FindBy(xpath ="(.//span[@class='sidenav-item-icon'])[1]")
	WebElement NavDoubleright;

    @FindBy(xpath ="(.//div[@class='d-flex flex-row align-items-center w-100'])[2]")
     WebElement Companieslist;

    @FindBy(xpath ="(.//span[@class=\"sidenav-item-label\"])[10]")
     WebElement ManageCompanies;

	@FindBy(xpath=".//button[@class=\"px-3 ms-auto text-nowrap btn btn-primary\"]")
	  WebElement addbtn;
	
	@FindBy(xpath=".//input[@class=\"form-control  text-uppercase\"]")
	  WebElement companycode;
	
	@FindBy(xpath=".//input[@id=\"isAssociateCompany\"]")
	  WebElement Asscompany;
	
	@FindBy(xpath=".//input[@id='copyCompany']")
	  WebElement copyAsscompany;
	
	@FindBy(xpath="(.//input[@class=\"form-control  \"])[1]")
	  WebElement companyname;
	
	public WebElement DropDownValue(String value) {
		return driver.findElement(By.xpath("//div[contains(@id,'listbox')]//div[contains(text(),'"+value+"')]"));
	}
	
	public void Dropdown(String value) {
		  DropDownValue(value).click();
	  }
	
	@FindBy(xpath="(.//div[@class=\" css-13cymwt-control\"])[1]")
	  WebElement businesstypedop;
	
	@FindBy(xpath=".//input[@placeholder=\"Enter Website\"]")
	  WebElement website;
	
	@FindBy(xpath="(.//div[@class=\" css-13cymwt-control\"])[2]")
	  WebElement esttypedop;
	
	@FindBy(xpath="(//input[@role='combobox'])[3]")
	  WebElement statusdop;
	
	@FindBy(xpath="(//input[@role='combobox'])[4]")
	  WebElement empdop;
	
	@FindBy(xpath=".//input[@name=\"file\"]")
	  WebElement Logoupload;
	
	public void Logoupload1(String value) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Logoupload);
		Thread.sleep(2000);
		Logoupload.sendKeys(value);
	}
	
	@FindBy(xpath=".//button[@type=\"button\"]")
	  WebElement create;
	
	// @FindBy(xpath=".//button[@class=\"btn btn-outline-secondary px-4 btn btn-outline-secondary\"]")
	    WebElement backtolist;
	    
	    @FindBy(xpath="//button[@class='px-4 btn btn-primary']")
	      WebElement save;
	    @FindBy(xpath="//button[@class='px-4 ms-3 btn btn-primary']")
	      WebElement savenxtbtn;
	
	// SPOC Details webelements
	
	@FindBy(xpath=".//textarea[@name=\"companyAddress\"]")
	  WebElement address;
	
	@FindBy(xpath="(.//div[@class=\" css-13cymwt-control\"])[1]")
	  WebElement statedop;
	
	@FindBy(xpath="(.//div[@class=\" css-13cymwt-control\"])[2]")
	  WebElement citydop;
	
	@FindBy(xpath="(.//div[@class=\" css-13cymwt-control\"])[3]")
	  WebElement countrydop;
	
	@FindBy(xpath=".//input[@name=\"contactNumber\"]")
	  WebElement contactno;
	
	 @FindBy(xpath=".//input[@name=\"email\"]")
	  WebElement compemail;
     
      @FindBy(xpath="//input[@name=\"contactPersonName\"]")
	  WebElement name;

	@FindBy(xpath=".//input[@name=\"contactPersonDesignation\"]")
	  WebElement designation ;
	
	@FindBy(xpath=".//input[@name=\"contactPersonDepartment\"]")
	  WebElement department ;
	
	@FindBy(xpath=".//input[@name=\"contactPersonMobile\"]")
	  WebElement contactpermob ;
	
	@FindBy(xpath=".//input[@name=\"contactPersonEmail\"]")
	  WebElement contactperemail ;
	
	@FindBy(xpath="//button[@class=\"px-4 btn btn-primary\"]")
	WebElement savebtn;
	
	@FindBy(xpath="//button[@class=\"px-4 ms-3 btn btn-primary\"]")
	WebElement savenextbtn;
	
	
	// statutorydetails WebElements
	
	//  TDS Details
	
	@FindBy(xpath=".//input[@class=\"form-control is-invalid text-uppercase\"]")
	WebElement Pannumber;
	
	@FindBy(xpath=".//input[@class=\"form-control  text-uppercase\"]")
	WebElement Tannumber;
	
	@FindBy(xpath=".//input[@class=\"form-control is-invalid \"]")
	WebElement FullName;
	
	@FindBy(xpath=".//input[@name=\"pan_surname\"]")
	WebElement pansurname;
	
	@FindBy(xpath=".//input[@name=\"pan_designation\"]")
	WebElement pandesignation;
	
	@FindBy(xpath=".//input[@name=\"pan_mobile\"]")
	WebElement panmobile;
	
	@FindBy(xpath=".//input[@name=\"pan_email\"]")
	WebElement panemail;
	
	@FindBy(xpath=".//input[@name=\"pan_place\"]")
	WebElement panplace;
	
	//PF Details//
	@FindBy(xpath=".//input[@name=\"pF_Ac_No\"]")
	WebElement PFaccountnumber;
	
	@FindBy(xpath=".//input[@name=\"pF_Base_Limit\"]")
	WebElement PFbaselimit;
	
	@FindBy(xpath=".//input[@name=\"pF_Deduction_Percent\"]")
	WebElement PFdeduction;
	 
	@FindBy(xpath=".//input[@name=\"pF_Establishment_Code\"]")
	WebElement PFesbliscode;
	
	@FindBy(xpath=".//input[@name=\"pF_Establishment_Id\"]")
	WebElement PFesblisID;
	
	@FindBy(xpath=".//input[@name=\"eps\"]")
	WebElement PFeps ;
	
	@FindBy(xpath=".//input[@name=\"pF_Admin_Percentage\"]")
	WebElement PFadmin ;
	
	@FindBy(xpath=".//input[@name=\"pF\"]")
	WebElement PF ;
	
	@FindBy(xpath=".//input[@placeholder=\"Enter EDLI Admin %\"]")
	WebElement PFedliadmin;
	
	@FindBy(xpath=".//input[@placeholder=\"Enter % of EDLI\"]")
	WebElement PFedli ;
	
	@FindBy(xpath=".//input[@id=\"autoGeneratePF\"]")
	WebElement auto;
	
	@FindBy(xpath=".//input[@name=\"gstn_no\"]")
	WebElement gstnumbr;
	
	@FindBy(xpath=".//button[@class=\"px-4 btn btn-primary\"]")
	WebElement PFsave;
	
	@FindBy(xpath=".//button[@class=\"px-4 ms-3 btn btn-primary\"]")
	WebElement PFsavenxt;
	
	
	
	
	
	
	
	
	
	
	
	
	public CompaniesAddnew() {
		PageFactory.initElements(driver, this);
	}
	public void Rightarrow() {
    	NavDoubleright.click();
	}
		
	public void Companieslist() {
		Companieslist.click();
	}
	
	public void ManageCompanies() {
		ManageCompanies.click();
	}
	
    public void addbutton() {
    	addbtn.click();
    }
    
    public void companycode(String Visa) {
    	companycode.sendKeys(Visa);
    }
    
    public void Associatecompany() {
    	Asscompany.click();
    }
    
    public void copyAssociatecompany() {
    	copyAsscompany.click();
    }
    
    public void companyname(String Virtusa) {
    	companyname.sendKeys(Virtusa);
    }
    
    public void businesstypedop() {
    	businesstypedop.click();
    }
    
   public void website(String Value) {
   website.sendKeys("www.virtusa.com");
    }

    public void esttypedop() {
    	esttypedop.click();
    }
    
    public void statusdop() {
    	statusdop.click();
    }
    
    public void empdop() {
    empdop.click();
    }
    
   public void Logoupload(String Value) {
	 Logoupload.sendKeys("C:\\Users\\sathw\\Downloads//download.png");
   }
   
   public void create() {
	   create.click();
   }
   
   public void sav() {
	   save.click();
   }
   
   public void savenxt() {
	   savenxtbtn.click();
   }
       
   
   
  // SPOC details
   
   
   public void address() {
	   address.sendKeys("Maharastra");
   }
   
   public void statedop() {
	   statedop.click();
   }
    public void citydop() {
    	citydop.click();
   }
    public void countrydop() {
    	countrydop.click();
    }
    public void contactno() {
    	contactno.sendKeys("9515927273");
    }
    
    public void compemail() {
    	compemail.sendKeys("sathwik@gmailcom");
    }
    
    public void name() {
    	name.sendKeys("Eclipse");
    }
    	public void designation() {
        	designation.sendKeys("Lead");
        
    }
    public void department() {
    		department.sendKeys("HR");
    }
    	
    public void contactpermob() {
    		contactpermob.sendKeys("9515923234");
    }
    	
    public void contactperemail() {
    		contactperemail.sendKeys("sathwic222@gmail.com");
    }
    
    public void save() {
    	savebtn.click();
    }
    
    public void savenext() {
    	savenextbtn.click();
    }
    
    // Statutory Details
    
    public void Pannumber() {
    	Pannumber.sendKeys("SERTF3456T");
    }
    public void Tannumber() {
    	Tannumber.sendKeys("RTGH78934R");
    }
    public void FullName() {
    	FullName.sendKeys("Munna");
    }
    public void pansurname() {
    	pansurname.sendKeys("s/o");
    }
    public void pandesignation() {
    	pandesignation.sendKeys("rt");
    }
    public void panmobile() {
    	panmobile.sendKeys("7897897890");
    }
    public void  panemail() {
    	 panemail.sendKeys("munn22@gmail.com");
    }
    public void panplace() {
    	panplace.sendKeys("hyd");
    }
    public void gstnumbr() {
    	gstnumbr.sendKeys("77988u98909990");
    }
    public void PFsave() {
    	PFsave.click();
    }
    public void PFsavenxt() {
    	PFsavenxt.click();
    }
    
    
    
}



