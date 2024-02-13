package com.automation.ezycomp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.ezycomp.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(xpath = ".//input[@name='username']")
     WebElement Username;
    
    @FindBy(xpath = ".//input[@name='password']")
    WebElement Password;
    
    @FindBy(xpath = ".//button[@type='submit']")
    WebElement LoginButton;
    
    public LoginPage(){
    	PageFactory.initElements(driver, this);
    }
    
    public void login(String username,String password) {
    	Username.sendKeys(username);
    	Password.sendKeys(password);
    }
    
    public void loginbtn() {
    	LoginButton.click();
    }

}
