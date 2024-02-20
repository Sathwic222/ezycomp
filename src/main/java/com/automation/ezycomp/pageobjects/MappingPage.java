package com.automation.ezycomp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.ezycomp.base.TestBase;
import com.automation.ezycomp.functionLabrary.ReportLog;

public class MappingPage  extends TestBase{
	
	LoginPage loginpage;
	HomePage_SuperAdmin home; 
	ReportLog logger;
	act actss;
	MappingPage Map;
	
	public MappingPage() {
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="(//input[@role='combobox'])[1]")
	WebElement StateDropdown;
	
	@FindBy(xpath="(//input[@role='combobox'])[2]")
	WebElement TypeDropdown;
	
	@FindBy(xpath="//a[normalize-space()='Add New']")
	WebElement Add;
	
	
	@FindBy(xpath="//body//div[@role='dialog']//div//div//div//div//div//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]")
	WebElement EnterStateType;
	
	@FindBy(xpath="(//input[@type='text'])[6]")
	WebElement EnterActName;
	
	@FindBy(xpath="(//input[@type='text'])[7]")
	WebElement EnterRuleName;
	
	@FindBy(xpath="(//input[@type='text'])[8]")
	WebElement EnterActivityName;
	
	@FindBy(xpath="(//input[@type='text'])[9]")
	WebElement EnterStateName;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement NextButton;
	
	@FindBy(xpath="//button[normalize-space()='Previous']")
	WebElement BackButton;
	
	
	@FindBy(xpath="//textarea[@placeholder='Enter Compliance Description']")
	WebElement ComplianceDescription;
	
	
	@FindBy(xpath="(//input[@role='combobox'])[4]")
	WebElement RiskDropdown;
			
	@FindBy(xpath="(//*[name()='svg'])[22]")
	WebElement AuditTypeDropDown;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Proof Of Compliance.']")
	WebElement ProofOfCompliance;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Penalty']")
	WebElement EnterPenalty;
	
	@FindBy(xpath="//input[@type='number']")
	WebElement MaxPenaltyAmount;

	@FindBy(xpath="(//input[@name='impriosonment'])[1]")
	WebElement impriosonmentTickBox;

	@FindBy(xpath=".//a[contains(text(),'Export')]")
	WebElement MappingExport;


			


	public void StateDropdown(){
		StateDropdown.click(); 
	  }
	
	public void TypeDropdown(){
		TypeDropdown.click(); 
	  }
	
	public void Add(){
		Add.click(); 
	  }
// add functions
	
	public void EnterStateType()  {
		EnterStateType.click(); 
	  }
	
	public void EnterActName(String Value)  {
		EnterActName.sendKeys(Value); 
	  }
	
	public void EnterRuleName(String Value)  {
		EnterRuleName.sendKeys(Value); 
	  }
	
	public void EnterActivityName(String Value)  {
		EnterActivityName.sendKeys(Value); 
	  }
	
	public void EnterStateName(){
		EnterStateName.click(); 
	  }
	
	public void NextButton(){
		NextButton.click(); 
	  }
	
	public void BackButton(){
		BackButton.click(); 
	  }
	
	
	public void ComplianceDescription(String Value)  {
		ComplianceDescription.sendKeys(Value); 
	  }
	
	public void RiskDropdown()  {
		RiskDropdown.click(); 
	  }
	
	public void AuditTypeDropDown()  {
		AuditTypeDropDown.click(); 
	  }
	
	public void ProofOfCompliance(String Value)  {
		ProofOfCompliance.sendKeys(Value); 
	  }
	
	public void EnterPenalty(String Value)  {
		EnterPenalty.sendKeys(Value); 
	  }
	
	public void MaxPenaltyAmount(String Value)  {
		MaxPenaltyAmount.sendKeys(Value); 
	  }
	
	public void impriosonmentTickBox()  {
		impriosonmentTickBox.click();
	  }

	public void MappingExportButton()  {
		MappingExport.click();
	}
	
	public void EnteringMappingDetails() throws InterruptedException  {
		home = new HomePage_SuperAdmin();
		actss = new act();
		Map = new MappingPage();
		actss.ActionClick();
		Map.Add();
		Map.EnterStateType();
		home.Dropdown("State");
		Map.EnterActName("testings");
		Thread.sleep(3000);
		home.Dropdown("testings");
		Map.EnterRuleName("123");
		Thread.sleep(3000);
		home.Dropdown("123");
		Map.EnterActivityName("123");
		Thread.sleep(3000);
		home.Dropdown("123");
		Map.EnterStateName();
		Thread.sleep(3000);
		home.Dropdown("Bihar");
		Thread.sleep(3000);
		Map.NextButton();
		Thread.sleep(3000);
	  }
	
	
	
	
	
	@FindBy(xpath="(//*[name()='svg'])[22]")
	WebElement Activity;
	
	public void Activity()  {
		AuditTypeDropDown.click(); 
	  }
	
	
	
	
}
