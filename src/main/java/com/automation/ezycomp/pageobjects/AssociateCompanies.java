package com.automation.ezycomp.pageobjects;

import com.automation.ezycomp.base.TestBase;
import com.automation.ezycomp.functionLabrary.ReportLog;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;


public class AssociateCompanies extends TestBase {

	ReportLog logger;
	CompaniesAddnew company;

	/// Sorting buttons
	@FindBy(xpath="(.//div[@class='tabulator-arrow'])[1]")
	WebElement compname;

	@FindBy(xpath="(.//div[@class='tabulator-arrow'])[2]")
	WebElement compcode;

	@FindBy(xpath="(.//div[@class='tabulator-arrow'])[3]")
	WebElement cont;

	@FindBy(xpath="(.//div[@class='tabulator-arrow'])[4]")
	WebElement mail;

	// -------------------------------------------------------------
	// Actions buttons

	@FindBy(xpath=".//span[@title='Edit']")
	WebElement edit;

	@FindBy(xpath=".//span[@title='Delete']")
	WebElement delete;

	@FindBy(xpath=".//span[@title='View']")
	WebElement view;



	@FindBy(xpath="(.//span[contains(@class,'icon-external-link')])[1]")
	WebElement websitenav;

	// POPs yes, NO

	@FindBy(xpath=".//button[text()='Yes']")
	WebElement yesbtn;

	@FindBy(xpath=".//button[text()='No']")
	WebElement nobtn;

	@FindBy(xpath="//button[text()='Close']")
	WebElement closebtn;




	// Company Details------------------------------------



	@FindBy(xpath = ".//h4[text()='Home']")
	WebElement Homepage;

	@FindBy(xpath ="(.//span[@class='sidenav-item-icon'])[1]")
	WebElement NavDoubleright;

	@FindBy(xpath ="(.//div[@class='d-flex flex-row align-items-center w-100'])[2]")
	WebElement Companieslist;

	@FindBy(xpath ="(.//span[@class='sidenav-item-label' ])[10]")
	WebElement ManageCompanies;

	@FindBy(xpath="//span[text()='Associate Companies']")
	WebElement Associatecompanies;

    @FindBy(xpath="(//input[@role='combobox'])[1]")
	WebElement percompdrop;
	@FindBy(xpath =".//input[@class='form-control']")
	WebElement Search;


	@FindBy(xpath=".//span[@title='download']")
	WebElement Exportbtn;

	@FindBy(xpath="//button[text()='Actions']")
	WebElement Actionsbtn;

	@FindBy(xpath="//span[@title='plus']")
    WebElement addnew;


	// Company Details---------------------------------

	@FindBy(xpath="//input[@name='code']")
	WebElement companycode;

	@FindBy(xpath=".//input[@id='isAssociateCompany']")
	WebElement isAsscompany;

	@FindBy(xpath="(//input[contains(@id,'react-select-')])[1]")
	WebElement Parentcompdop;

	@FindBy(xpath=".//input[@id='copyCompany']")
	WebElement copyAsscompany;

	@FindBy(xpath=".//input[@name='name']")
	WebElement companyname;

	public WebElement DropDownValue(String value) {
		return driver.findElement(By.xpath("//div[contains(@id,'listbox')]//div[contains(text(),'"+value+"')]"));
	}

	public void Dropdown(String value) {
		DropDownValue(value).click();
	}

	@FindBy(xpath="(//input[@role='combobox'])[2]")
	WebElement businesstypedop;

	@FindBy(xpath=".//input[@placeholder='Enter Website']")
	WebElement website;

	@FindBy(xpath="(//input[@role='combobox'])[3]") public
	WebElement esttypedop;

	@FindBy(xpath="(//input[@role='combobox'])[4]")
	WebElement statusdop;

	@FindBy(xpath="(//input[@role='combobox'])[5]")
	WebElement empdop;

	@FindBy(xpath=".//input[@name='file']")
	WebElement Logoupload;

	public void Logoupload1(String value) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Logoupload);
		Thread.sleep(2000);
		Logoupload.sendKeys(value);
	}

	@FindBy(xpath="//button[text()='Create']")
	WebElement create;

	// @FindBy(xpath=".//button[@class=\"btn btn-outline-secondary px-4 btn btn-outline-secondary\"]")
	//  WebElement backtolist;

	@FindBy(xpath="//button[text()='Save']")
	WebElement save;
	@FindBy(xpath="//button[text()='Save & Next']")
	WebElement savenxtbtn;

	// SPOC Details webelements

	@FindBy(xpath=".//textarea[@name='companyAddress']")
	WebElement address;

	@FindBy(xpath="(//input[@role='combobox'])[1]")
	WebElement statedop;

	@FindBy(xpath="(//input[@role='combobox'])[2]")
	WebElement citydop;

	@FindBy(xpath="(//input[@role='combobox'])[3]")
	WebElement countrydop;

	@FindBy(xpath=".//input[@name='contactNumber']")
	WebElement contactno;

	@FindBy(xpath=".//input[@name='email']")
	WebElement compemail;

	@FindBy(xpath="//input[@name='contactPersonName']")
	WebElement name;

	@FindBy(xpath=".//input[@name='contactPersonDesignation']")
	WebElement designation ;

	@FindBy(xpath=".//input[@name='contactPersonDepartment']")
	WebElement department ;

	@FindBy(xpath=".//input[@name='contactPersonMobile']")
	WebElement contactpermob ;

	@FindBy(xpath=".//input[@name='contactPersonEmail']")
	WebElement contactperemail ;

	@FindBy(xpath="//button[@class='px-4 btn btn-primary']")
	WebElement savebtn;

	@FindBy(xpath="//button[@class='px-4 ms-3 btn btn-primary']")
	WebElement savenextbtn;


	// statutorydetails WebElements

	//  TDS Details

	@FindBy(xpath=".//input[@name='pan']")
	WebElement Pannumber;

	@FindBy(xpath=".//input[@name='tan']")
	WebElement Tannumber;

	@FindBy(xpath=".//input[@name='pan_fullname']")
	WebElement FullName;

	@FindBy(xpath=".//input[@name='pan_surname']")
	WebElement pansurname;

	@FindBy(xpath=".//input[@name='pan_designation']")
	WebElement pandesignation;

	@FindBy(xpath=".//input[@name='pan_mobile']")
	WebElement panmobile;

	@FindBy(xpath=".//input[@name='pan_email']")
	WebElement panemail;

	@FindBy(xpath=".//input[@name='pan_place']")
	WebElement panplace;

	//PF Details//
	@FindBy(xpath=".//input[@name='pF_Ac_No']")
	WebElement PFaccountnumber;

	@FindBy(xpath=".//input[@name='pF_Base_Limit']")
	WebElement PFbaselimit;

	@FindBy(xpath=".//input[@name='pF_Deduction_Percent']")
	WebElement PFdeduction;

	@FindBy(xpath=".//input[@name='pF_Establishment_Code']")
	WebElement PFesbliscode;

	@FindBy(xpath=".//input[@name='pF_Establishment_Id']")
	WebElement PFesblisID;

	@FindBy(xpath=".//input[@name='eps']")
	WebElement PFeps ;

	@FindBy(xpath=".//input[@name='pF_Admin_Percentage']")
	WebElement PFadmin ;

	@FindBy(xpath=".//input[@name='pF']")
	WebElement PF ;

	@FindBy(xpath=".//input[@placeholder='Enter EDLI Admin %']")
	WebElement PFedliadmin;

	@FindBy(xpath=".//input[@placeholder='Enter % of EDLI']")
	WebElement PFedli ;

	@FindBy(xpath=".//input[@id='autoGeneratePF']")
	WebElement auto;

	@FindBy(xpath=".//input[@name='gstn_no']")
	WebElement gstnumbr;

	@FindBy(xpath=".//button[@class='px-4 btn btn-primary']")
	WebElement PFsave;

	@FindBy(xpath=".//button[@class='px-4 ms-3 btn btn-primary']")
	WebElement PFsavenxt;





	//SMTP DETAILS

	// @FindBy(xpath=".//input[@name='emailAddress']")
	// WebElement EmailAddress;

	@FindBy(xpath=".//input[contains(@name,'email')]")
	WebElement Email;


	@FindBy(xpath=".//input[@name='password']")
	WebElement Password;

	@FindBy(xpath=".//input[@name='host']")
	WebElement Host;

	@FindBy(xpath="//div[@class=' css-hlgwow']")
	WebElement Port;

	@FindBy(xpath=".//button[text()='Save']")
	WebElement Save;

	@FindBy(xpath=".//button[text()='Save & Close']")
	WebElement Saveclose;

	@FindBy(xpath=".//button[text()='Previous']")
	WebElement Previous;

	@FindBy(xpath=".//button[text()='Cancel']")
	WebElement Cancel;


    @FindBy(xpath="(//input[@role='combobox'])[1]")
	WebElement compdorp ;











	public AssociateCompanies() {
	PageFactory.initElements(driver, this);
	
    }

	// Sorting buttons--------------------------------------

	public void companyname () {
		compname.click();
	}


	public void compcode() {
		compcode.click();
	}
	public void cont() {
		cont.click();
	}
	public void mail() {
		mail.click();
	}


	// Action buttons-----------------------------

	public void edit(String Value) {
		edit.click();
	}

	public void delete(String Value) {
		delete.click();
	}
	public void view(String Value) {
		view.click();
	}



	public void webnav (String Value) {

		websitenav.click();
	}


	// pops yes , no

	public void yes() {
		yesbtn.click();
	}

	public void nobtn() {
		nobtn.click();
	}

	public void closbtn() {
		closebtn.click();
	}



	//-----------------------------------------------------------
	public void Rightarrow() {
		NavDoubleright.click();
	}

	public void Companieslist() {
		Companieslist.click();
	}

	public void ManageCompanies() {
		ManageCompanies.click();
	}

	public void Associatecompaniess(String value){
		Associatecompanies.click();
	}



	public void parent(String Value){
		percompdrop.sendKeys(Value);
		percompdrop.click();
	}
	// SEARCH //----------

	public void Search(String Value) {
		Search.sendKeys(Value);
	}

	public void Exportbtn () {
		Exportbtn.click();
	}

	public void actinbtn(){
		Actionsbtn.click();
	}
	public void addnew() {
		addnew.click();
	}

	public void companycode(String Visa) {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100);
		String CompanyCode = "dec"+ randomInt;
		companycode.sendKeys(CompanyCode);
	}

	public void isassociatecomp() {
		isAsscompany.click();
	}
	public void Parentcompdop(String Value){
		Parentcompdop.sendKeys(Value);
	}
	public void copyAssociatecompany() {
		copyAsscompany.click();
	}

	public void companyname(String Value) {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		String CompanyName = "Dev Company"+ randomInt;
		companyname.sendKeys(CompanyName);
	}

	public void businesstypedop(String Value) {
		//businesstypedop.click();
		//businesstypedop.clear();
		businesstypedop.sendKeys(Value);
	}

	public void website(String Value) {

		//website.clear();
		website.sendKeys(Value);
	}

	public void esttypedop(String Value) {
		esttypedop.click();
	}

	public void statusdop(String Value) {
		statusdop.click();
	}

	public void empdop(String Value) {
		empdop.click();
	}

	public void scrollIntoView(WebElement Xpath) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",  new Object[] { Xpath});
	}

	public void Logoupload(String Value) {
		Logoupload.sendKeys(Value);
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



	// SPOC details--------------------------------------------------------------------


	public void address(String value) {
		address.sendKeys(value);
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
		compemail.sendKeys("sathwic333@gmailcom");
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

	// Statutory Details--------------------------------------------------------------

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
		gstnumbr.sendKeys("22AAAAA0000A1Z5");
	}
	public void PFsave() {
		PFsave.click();
	}
	public void PFsavenxt() {
		PFsavenxt.click();
	}



	// SMTP Details--------------------------------------------------------------------

	public void email() {
		Email.sendKeys("sathwic333@gmail.com");
	}

	public void passwrd() {
		Password.sendKeys("Sathwic@1900");
	}
	public void hos() {
		Host.sendKeys("77777323");
	}

	public void por() {
		Port.click();;
	}

	public void save4() {
		save.click();

	}
	public void compdop(String value){
		compdorp.sendKeys(value);
	}

	public void Saveclose() {
		Saveclose.click();
	}


	public String CreateAssociateCompany(String CompName) throws InterruptedException {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100);
		String AssociateCompanyName = "Associate Comp"+ randomInt;

		company = new CompaniesAddnew();
		//company.addbutton();

		company.companycode("bsal");
		company.Associatecompany();
		Thread.sleep(3000);
		Parentcompdop.click();
		Thread.sleep(2000);
		company.Parentcompdop(CompName);
		Thread.sleep(5000);
		company.Dropdown(CompName);
		//company.copyAssociatecompany();
		company.companyname(AssociateCompanyName);
		company.businesstypedop("IT");
		company.Dropdown("IT");
		company.website("www.filpkartsales.com");
		company.scrollIntoView(esttypedop);
		Thread.sleep(5000);
		esttypedop("Factory");
		company.Dropdown("Factory");
		Thread.sleep(3000);
		statusdop("Active");
		Dropdown("Active");
		empdop("1-100");
		company.Dropdown("1-100");
		//Thread.sleep(3000);
		// company.scrollIntoView(company.Logoupload);
		company.Logoupload("C:\\Users\\sathw\\OneDrive\\Pictures\\download (3).png");
		Thread.sleep(5000);
		company.create();
		Thread.sleep(2000);


		return AssociateCompanyName;
	}

}



