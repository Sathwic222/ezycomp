package com.automation.ezycomp.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automation.ezycomp.base.TestBase;

public class HomePage_SuperAdmin extends TestBase {
	
	@FindBy(xpath = ".//h4[text()='Home']")
    WebElement Homepage;
	
//	manage users
	
	@FindBy(xpath=".//span[@class='icon icon-double-right  px-3 px-2 ']")
	WebElement Arroww;
	
	@FindBy(xpath=".//span[text()='User Management']")
	WebElement UserManagement;
	
	
	@FindBy(xpath=".//span[text()='Manage Users']")
	WebElement ManageUsers;
	
	@FindBy(xpath=".//button[@class='px-3 ms-auto text-nowrap btn btn-primary']")
	WebElement AddNewbutton;
	
	@FindBy(xpath=".//input[@name='name']")
	WebElement FullName;
	
	@FindBy(xpath=".//input[@name='userName']")
	WebElement Username;
	
	@FindBy(xpath=".//input[@name='email']")
	WebElement Email;
	
	@FindBy(xpath=".//input[@name='role']")
	WebElement Role;
	
	//.//div[text()='Select Role']
	
	//(.//div[@class=" css-13cymwt-control"])[3]
	
	@FindBy(xpath=".//input[@name='email']")
	WebElement SubmitButton;
	
	@FindBy(xpath=".//button[@class='px-3 text-nowrap me-3 btn btn-primary']")
	WebElement export;
	
	@FindBy(xpath=".//div[@class='input-group']/input")
	WebElement search_input;
	
	@FindBy(xpath="(.//div[@class=' css-19bb58m'])[1]")
	WebElement dropdown;
	
	@FindBy(xpath = ".//a[contains(text(),'Home')]")
	WebElement homebtn;
	
	@FindBy(xpath=".//div[contains(text(),'created successfully')]")
	WebElement sucess;
	
	@FindBy(xpath="(.//div[text()='tillu'])[1]")
	WebElement tillu;
	
//	company mapping
	
	@FindBy(xpath=".//span[text()='Company Mapping']")
	WebElement U_companymapping;
	
	@FindBy(xpath=".//div[@class = ' css-13cymwt-control']")
	WebElement U_role_dd;
	
	@FindBy(xpath=".//button[@class = 'px-4 ms-auto text-nowrap btn btn-primary']")
	WebElement U_add_user_location;
	
	@FindBy(xpath="(.//div[@class = ' css-19bb58m'])[2]")
	WebElement U_company_dd;
	
	@FindBy(xpath="(.//div[@class = ' css-19bb58m'])[3]")
	WebElement U_ass_company_dd;
	
//	email templates
	
	@FindBy(xpath=".//span[text()='Email & Notifications']")
	WebElement Email_Notification;
	
	@FindBy(xpath=".//span[text()='Email Templates']")
	WebElement email_templates;
	
	@FindBy(xpath=".//button[@class='px-3 ms-auto text-nowrap btn btn-primary']")
	WebElement E_addnew;
	
	@FindBy(xpath="(.//div[@class=' css-13cymwt-control'])[1]")
	WebElement E_Template;
	
	@FindBy(xpath="(.//div[@class=' css-19bb58m'])[2]")
	WebElement E_company;
	
	@FindBy(xpath=".//textarea[@name='subject']")
	WebElement E_subject;
	
	@FindBy(xpath=".//input[@name='emailCC']")
	WebElement E_email_cc;
	
	@FindBy(xpath="(.//div[@class='ql-editor ql-blank'])[1]")
	WebElement E_emailbody;
	
	@FindBy(xpath="(.//div[@class='ql-editor ql-blank'])[2]")
	WebElement E_signature;
	
	@FindBy(xpath=".//button[@class='px-4 ms-3 btn btn-primary']")
	WebElement E_create;
	
	@FindBy(xpath=".//div[contains(text(),'added successfully')]")
	WebElement E_added_sucessfully;
	
//	Audit schedule details
	
	@FindBy(xpath=".//span[text()='Audit Management']")
	WebElement A_audit;
	
	@FindBy(xpath=".//span[text()='Audit Schedule Details']")
	WebElement A_Audit_SD;
	
	@FindBy(xpath="(.//div[@class=' css-19bb58m'])[1]")
	WebElement A_company;
	
	@FindBy(xpath="(.//div[@class=' css-19bb58m'])[2]")
	WebElement A_ass_company;
	
	@FindBy(xpath="(.//div[@class=' css-19bb58m'])[3]")
	WebElement A_location;
	
	@FindBy(xpath=".//span[text()='Advance Search']")
	WebElement A_advance_search;
	
	@FindBy(xpath=".//input[@name='monthYear']")
	WebElement A_monthyear;
	
	@FindBy(xpath=".//span[text()='August']")
	WebElement A_month;
	
	@FindBy(xpath=".//input[@name='dueDate']")
	WebElement A_duedate;
	
	@FindBy(xpath=".//span[text()='21']")
	WebElement A_date;
	
	@FindBy(xpath="(.//div[@class=' css-19bb58m'])[5]")
	WebElement A_activity;
	
	@FindBy(xpath="(.//div[@class=' css-19bb58m'])[6]")
	WebElement A_Audit;
	
	@FindBy(xpath=".//button[text()='Submit']")
	WebElement A_submit;
	
	
	
	
	
	
	
	
	
//	for manage users
	public HomePage_SuperAdmin() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean homePageVerfication() {
		
		return Homepage.isDisplayed();
	}
	
	public void Arrow() {
		Arroww.click();
	}
		
	public void UserManagements() {
		UserManagement.click();
	}
	
	public void ManageUser() {
		ManageUsers.click();
	}
	

	public void AddNewBtn() {
		AddNewbutton.click();
	}
	
	public void Addingdetails(String fullname,String username, String email) {
		FullName.sendKeys(fullname);
		Username.sendKeys(username);
		Email.sendKeys(email);
	}
	
	public void Rolefield(String value) {
		//Role.click();
		Role.sendKeys(value);
//		Select dropdown = new Select(Role);
//		dropdown.selectByVisibleText(value);
	}
	
	public void Submitbtn() {
		SubmitButton.click();
	}
	
	public void exportbtn() {
		export.click();
	}
	
	public void search(String value) {
		search_input.sendKeys(value);
	}
	
	public void dropdowns(){
		dropdown.click();
	}
	public void dropdowns1(String value) {
		dropdown.sendKeys(value);
		dropdown.sendKeys(Keys.ENTER);
	}

	
	public void home() {
		homebtn.click();
		}
	
	public boolean createdsucces() {
		return sucess.isDisplayed();
	}
	
	public boolean tilluname() {
		return tillu.isDisplayed();
	}
	
	public void tillunames() {
		tillu.click();
	}
	
	

//	company mapping
	
	public void Company_mapping() {
		U_companymapping.click();
	}
	
	public void Role_dropdown(String value) {
		U_role_dd.sendKeys(value);
		U_role_dd.sendKeys(Keys.ENTER);
	}
	
	public void Add_location() {
		U_add_user_location.click();
	}
	
	public void company(String value) {
		U_company_dd.sendKeys(value);
		U_company_dd.sendKeys(Keys.ENTER);
	}
	
	public void Ass_company(String value) {
		U_ass_company_dd.sendKeys(value);
		U_ass_company_dd.sendKeys(Keys.ENTER);
	}
	
//	email templates
	
	public void emailNotifications() {
		Email_Notification.click();
	}
	
	public void email_temp() {
		email_templates.click();
	}
	
	public void AddNew_button() {
		E_addnew.click();
	}
	
	public void Template_type(String value){
		E_Template.sendKeys(value);
		E_Template.sendKeys(Keys.ENTER);
	}
	
	public void email_company(String value) {
		E_company.sendKeys(value);
		E_company.sendKeys(Keys.ENTER);
	}
	
	public void Email_subject(String value) {
		E_subject.sendKeys(value);
	}
	
	public void Email_cc(String value) {
		E_email_cc.sendKeys(value);
	}
	
	public void Email_body(String value) {
		E_emailbody.sendKeys(value);
	}
	
	public void Email_signature(String value) {
		E_signature.sendKeys(value);
	}
	
	public void create() {
		E_create.click();
	}
	
	public boolean added_sucessfully() {
		return sucess.isDisplayed();
	}	
	
	
	
	
	
	
	
	
	
	

		
    
	
	
	

}
