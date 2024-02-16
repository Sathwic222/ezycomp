package com.automation.ezycomp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.automation.ezycomp.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(xpath = ".//input[@name='username']")
     WebElement Username1;
    
    @FindBy(xpath = ".//input[@name='password']")
    WebElement Password2;
    
    @FindBy(xpath = ".//button[@type='submit']")
    WebElement LoginButton;
    
    public LoginPage(){
    	PageFactory.initElements(driver, this); 	
    }
    
    public LoginPage(String username,String password){
    	PageFactory.initElements(driver, this); 
    	Username1.sendKeys(username);
    	Password2.sendKeys(password);
    	LoginButton.click();
    }
    
    
//  public boolean login(String username,String password) {
//	  boolean isLoggedIn = false;
//	  try {
//		  Username1.sendKeys(username);
//		  Password2.sendKeys(password);
//		  LoginButton.click();
//		  isLoggedIn=true;
//		  wait(5000);
//	  } catch (Exception e) {
//		  logFai
    public void login(String username,String password) {
    	Username1.sendKeys(username);
    	Password2.sendKeys(password);
    }  
    
    public void loginbtn() {
    	LoginButton.click();
    }

}
