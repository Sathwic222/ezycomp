package com.automation.ezycomp.pageobjects;

import lombok.Value;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.ezycomp.base.TestBase;

public class Audit extends TestBase {

	@FindBy(xpath = ".//h4[text()='Home']")
	WebElement Homepage;

	@FindBy(xpath = "(.//span[@class='sidenav-item-icon'])[1]")
	WebElement NavDoubleright;

	@FindBy(xpath = "(.//div[@class='d-flex flex-row align-items-center w-100'])[3]")
	WebElement Auditmanagement;

	@FindBy(xpath = "//span[normalize-space()='Audit Schedule']")
	WebElement Auditschedule;

	public WebElement DropDownValue(String value) {
		return driver.findElement(By.xpath("//div[contains(@id,'listbox')]//div[contains(text(),'" + value + "')]"));
	}

	public void Dropdown(String value) {
		DropDownValue(value).click();
	}

	@FindBy(xpath = "(//input[@role='combobox'])[1]")
	WebElement companydop;

	@FindBy(xpath = "(//input[@role='combobox'])[2]")
	WebElement asscompdop;

	@FindBy(xpath = "(//input[@role='combobox'])[3]")
	WebElement locdop;

	@FindBy(xpath = "(//input[@role='combobox'])[4]")
	WebElement actdop;

	@FindBy(xpath = "//input[@name='month']")
	public
	WebElement monthbox;

	@FindBy(xpath = "//div[contains(@class,'rmdp-day')]//span[text()='January']")
	public WebElement Calmonth;

	@FindBy(xpath = "//button[normalize-space()='Export']")
	WebElement Exportbtn;

	@FindBy(xpath = ".//button[@class='btn btn-outline-secondary px-4 btn btn-outline-secondary']")
	WebElement Resetbtn;

	@FindBy(xpath = ".//button[@class='px-4 btn btn-primary']")
	WebElement Importbtn;

	public Audit() {
		PageFactory.initElements(driver, this);
	}

	public void Homepage() {
		Homepage.click();
	}

	public void NavDoubleright() {
		NavDoubleright.click();
	}

	public void Auditmanagement() {
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

	public void scrollIntoView(WebElement Xpath) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", new Object[]{Xpath});
	}

	public void month() {
		monthbox.click();
		Calmonth.click();
		Actions act = new Actions(driver);
		//act.doubleClick(Calmonth).perform();
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


//----------------------------------------------------------

	public void GenerateAuditSchedule() throws InterruptedException {


		Homepage();
		Auditmanagement();
		Thread.sleep(3000);
		Auditschedule();
		Thread.sleep(3000);
		companydop("Filpkart");
		Dropdown("Filpkart");
		Thread.sleep(3000);
		asscompdop("BigSales");
		Dropdown("BigSales");
		Thread.sleep(3000);
		locdop("AutoMatIom (TG-HYD-AUDO)");
		Dropdown("AutoMatIom (TG-HYD-AUDO)");
		Thread.sleep(3000);
		// audit.actdop("Display,Returns,Audit");

		// audit.Dropdown("Display,Returns,Audit");

		scrollIntoView(monthbox);
		Thread.sleep(3000);
		month();
		Exportbtn();
		Thread.sleep(5000);



	}

}
