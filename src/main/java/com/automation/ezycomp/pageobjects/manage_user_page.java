package com.automation.ezycomp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.ezycomp.base.TestBase;

public class manage_user_page extends TestBase{
	
	
	
//	manage users
	
	
	
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
	
	@FindBy(xpath=".//input[@id='react-select-4-input']")
	WebElement Role;
	
	@FindBy(xpath=".//input[@id='react-select-2-input']")
	WebElement ManageRole;
	
	@FindBy(xpath="//div[contains(@id,'listbox')]//div[contains(text(),'Admin')]")
	WebElement role_dropdowns;
	
	@FindBy(xpath=".//div[contains(text(),'added successfully')]")
	WebElement sucess;
	
	@FindBy(xpath=".//div[contains(text(),'deleted successfully')]")
	WebElement delete_sucess;
	
	@FindBy(xpath=".//div[contains(text(),'already exists')]")
	WebElement exists;
	
	@FindBy(xpath=".//button[contains(text(),'Submit')]")
	WebElement SubmitButton;
	
	@FindBy(xpath=".//button[@class='px-3 text-nowrap me-3 btn btn-primary']")
	WebElement export;
	
	@FindBy(xpath=".//div[@class='input-group']/input")
	WebElement search_input;
	
	@FindBy(xpath="(.//div[@class=' css-19bb58m'])[1]")
	WebElement dropdown;
	
	@FindBy(xpath = ".//a[contains(text(),'Home')]")
	WebElement homebtn;
	
	
	
	@FindBy(xpath="(.//div[text()='tillu'])[1]")
	WebElement tillu;
	
	
	public manage_user_page(){
    	PageFactory.initElements(driver, this);
    }
	
	
	
//	for manage users
	
	

	
	public void select_values() throws InterruptedException {
		ManageRole.sendKeys("admin");
		Thread.sleep(2000);
		role_dropdowns.click();
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
	
	public void edit_details(String fullname) {
		FullName.sendKeys(fullname);
	
	}
	
	public void clearing() {
		FullName.click();
		FullName.clear();
		
	}
	

	
	public void select_value() throws InterruptedException {
		Role.click();
	}
	
	
	
	public void Submitbtn() {
		SubmitButton.click();
	}
	
	public boolean createdsucces() {
		return sucess.isDisplayed();
	}
	
	public boolean deletesucces() {
		return delete_sucess.isDisplayed();
	}
	
	public boolean already_exists() {
		return exists.isDisplayed();
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
	
	
	
	public boolean tilluname() {
		return tillu.isDisplayed();
	}
	
	public void tillunames() {
		tillu.click();
	}

}
