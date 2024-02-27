package com.automation.ezycomp.pageobjects;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import com.automation.ezycomp.base.TestBase;
import java.util.*;


public class HomePage_SuperAdmin extends TestBase {

	@FindBy(xpath = ".//h4[text()='Home']")
	WebElement Homepage;

	@FindBy(xpath = "//span[@title='double-right']//*[name()='svg']")
	WebElement NavOpen;

	@FindBy(xpath = "//span[@title='double-left']//*[name()='svg']")
	WebElement Navhide;

	@FindBy(xpath = "//a[@href='/masters/act']")
	WebElement Master;

	@FindBy(xpath = "//a[@href='/masters/law']//span")
	WebElement Law;

	@FindBy(xpath = "//span[normalize-space()='Act']")
	WebElement acts;

	@FindBy(xpath = "//span[normalize-space()='Activity']")
	WebElement Activity;

	@FindBy(xpath = "//span[normalize-space()='Rule']")
	WebElement Rule;

	@FindBy(xpath = "//span[normalize-space()='State']")
	WebElement State;


	public WebElement Menu(String value) {
		return driver.findElement(By.xpath("//span[normalize-space()='"+value+"']"));
	}

	@FindBy(xpath = "//button[normalize-space()='Add New']")
	WebElement Addnew;

	@FindBy(xpath = "//button[normalize-space()='Export']")
	WebElement Export;


	@FindBy(xpath = "//input[@placeholder='Enter Law Name']")
	WebElement Lawname;

	@FindBy(xpath = "//textarea[@placeholder='Enter Description']")
	WebElement Description;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement Submit;

	@FindBy(xpath = "//button[normalize-space()='Close']")
	WebElement Close;

	@FindBy(xpath = "//button[normalize-space()='Yes']")
	public WebElement Yes;

	@FindBy(xpath = "//div[contains(text(),'created successfully')]")public
	WebElement Success;

	@FindBy(xpath = "//div[@class='input-group']/input")
	WebElement Search_Input;






	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
	WebElement Type;

	@FindBy(xpath = "//div[contains(text(),'already exists')]")
	public
	WebElement Duplicate;

	@FindBy(xpath = "//div[contains(text(),'updated successfully.')]")
	public WebElement UpdateSuccess;

//	 public WebElement Wait(WebElement Xpath) {
//		 Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//		    wait.until(d -> Xpath.isDisplayed());
//
//	    }

	public WebElement waitForElement(WebElement Xpath) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		wait.until(d -> Xpath.isDisplayed());
		return Xpath;
	}

	public void scrollIntoView(WebElement Xpath) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",  new Object[] { Xpath});
	}

	public WebElement Show(String value) {
		return driver.findElement(By.xpath("//span[contains(text(),'"+value+"')]"));
	}

	public WebElement Page(String value) {
		return driver.findElement(By.xpath("//span[@title='"+value+"']"));
	}

	public WebElement Searchvalue(String value) {
		return driver.findElement(By.xpath("//div[contains(text(),'"+value+"')]"));
	}

	public WebElement DropDownValue(String value) {
		return driver.findElement(By.xpath("//div[contains(@id,'listbox')]//div[contains(text(),'"+value+"')]"));
	}

	public WebElement ActionsEdit(String value) {
		return driver.findElement(By.xpath("//div[text()='"+value+"']/../../..//span[@title='Edit']"));
	}

	public WebElement ActionsView(String value) {
		return driver.findElement(By.xpath("//div[text()='"+value+"']/../../..//span[@title='View']"));
	}

	public WebElement ActionsDelete(String value) {
		return driver.findElement(By.xpath("//div[text()='"+value+"']/../../..//span[@title='Delete']"));
	}

	public WebElement ActionsViewDisplay(String value) {
		return driver.findElement(By.xpath("//div[@class='modal-body']/../../..//div[contains(text(),'"+value+"')]"));
	}

	public WebElement Button(String value) {
		return driver.findElement(By.xpath("//button[normalize-space()='"+value+"']"));
	}

//	public WebElement Input(String value) {
//		return driver.findElement(By.xpath("//input[@placeholder='"+value+"']\""));
//	}




	public HomePage_SuperAdmin() throws InterruptedException {
		PageFactory.initElements(driver, this);
		waitForElement(Homepage);
		NavOpen.click();
	}

	public boolean homePageVerfication() {

		return Homepage.isDisplayed();
	}

	public void NavArrowopen() {
		NavOpen.click();
	}

	public void Masters() {
		Master.click();
	}

	public void Lawopen() {
		Law.click();
	}

	public void act() {
		acts.click();
	}

	public void Activity() {
		Activity.click();
	}

	public void Rule() {
		Rule.click();
	}



	public void NavArrowclose() {
		Navhide.click();
	}


	public void AddNewButton() {
		Addnew.click();
	}

	public void ExportButton() {
		Export.click();
	}

	public String Law(String username,String password) {
		Lawname.sendKeys(username);
		Description.sendKeys(password);
		return username;
	}
	public void Submit() {
		Submit.click();
	}

	public void Close() {
		Close.click();
	}

	public void Yes() {
		Yes.click();
	}

	public boolean SubmitEnabled() {
		return Submit.isEnabled();
	}
	public boolean CreatedSucees() {
		return Success.isDisplayed();
	}
	public boolean AlreadyExixts() {
		return Duplicate.isDisplayed();
	}

	public boolean Update() {
		return UpdateSuccess.isDisplayed();
	}

	public void Search(String value) {
		Search_Input.sendKeys(value);
	}

	public void SearchClear() {
		Search_Input.clear();;
	}


	public boolean Search_value(String value) {
		return Searchvalue(value).isDisplayed();
	}

	public boolean ActionsViewDisplayed(String value) {
		return ActionsViewDisplay(value).isDisplayed();
	}

	public void Dropdown(String value) {
		DropDownValue(value).click();
	}

	public void State() {
		State.click();
	}

	public void Establishment(String value, Keys enter) throws InterruptedException {
		Type.click();
		Thread.sleep(2000);
		Type.sendKeys(value);
	}

	public void NAvMenu(String value) {
		Menu(value).click();
	}

	public void Edit(String value) {
		ActionsEdit(value).click();
	}

	public void View(String value) {
		ActionsView(value).click();
	}

	public void Delete(String value) {
		ActionsDelete(value).click();
	}

	public void NameEdit(String username) {
		Description.sendKeys(username);
	}

	public void ButtonYes(String value) {
		Button(value).click();
	}

	public void Pagination(String value) {
		Page(value).click();
	}

	public boolean Pageshowing(String value) {
		return Show(value).isDisplayed();
	}

	public WebElement Action(String value,String Text) {
		return driver.findElement(By.xpath("//div[text()='"+value+"']/../../..//span[@title='"+Text+"']"));
	}

	public void Actions(String value,String Text) {
		Action(value, Text).click();
	}

//	  public void InputValue(String value, String name) {
//		  Input(value).sendKeys(name);
//		 }



	public boolean SearchElement(String value) {
		return Searchvalue(value).isDisplayed();
	}

	public WebElement view_text(String value) {
		return driver.findElement(By.xpath(".//label[contains(text(),'"+value+"')]"));
	}

	public void search_valued(String value) {
		view_text(value).isDisplayed();
	}

	@FindBy(xpath=".//div[contains(text(),'successfully')]")
	WebElement updated_sucessfully;

	public void updated() {
		updated_sucessfully.isDisplayed();
	}


	public void ActionsAdd(String value) throws InterruptedException {
		ActionsButtonAdd(value).click();
	}

	public WebElement ActionsButtonAdd(String value) {
		return driver.findElement(By.xpath(".//span[contains(text(),'"+value+"')]"));
	}

	@FindBy(xpath="//div[contains(@class,'custom-tabulator-footer')]//span[contains(text(),'Showing')]")
	WebElement DataCount;


	public int Showing() throws InterruptedException {
		String result = DataCount.getText();
		String[] arrOfStr = result.split("of");
		String[] count = arrOfStr[1].split("records");
		String cnt = count[0].replace(",","").trim();
		return Integer.parseInt(cnt);
	//	return Integer.parseInt(DataCount.getText().split("of")[1].split("records")[0].replace(",", "").trim());

	}

	public List<WebElement> headerData() {
		return driver.findElements(By.xpath("//div[@class='tabulator-header']//div[@class='tabulator-col-title']"));
	}

	public List<WebElement> rowData() {
		return driver.findElements(By.xpath("//div[contains(@class,'tabulator-row')]"));
	}

	public List<WebElement> rowValue(int index) {
		return driver.findElements(By.xpath("//div[contains(@class,'tabulator-row')]["+index+"]//div[@class='ellipse two-lines']"));
	}

	//div[contains(@class,'tabulator-row')][1]//div[@class='ellipse two-lines']

	public Iterator<Object[]> getTableData() throws Exception{
		int colcount = headerData().size();
		int rowcount = rowData().size();

		List<Object[]> ls = new ArrayList<Object[]>();
//		iterate thru each row
		for(int iRow=1;iRow<=rowcount;iRow++){
			Object[] obj = new Object[1];
//			create a map
			Map<String, String> hm = new HashMap<String, String>();
//			column iteration
			for(int iCol=0;iCol<colcount-1;iCol++){

				String key=headerData().get(iCol).getText();
				String val= rowValue(iRow).get(iCol).getText();
				hm.put(key, val);
			}	//			column iteration
			obj[0]=hm;
			ls.add(obj);
			//}
		}
		return ls.iterator();
	}

	public boolean compareListColumnCount(Iterator<Object[]> tblData, Iterator<Object[]> xlData){

		Object tbl = tblData.next()[0];
		Object xl = xlData.next()[0];

		Map<String, String> xlmap = new HashMap<>();
		Map<String, String> tblmap = new HashMap<>();

		xlmap = ((HashMap) xl);
		tblmap = ((HashMap) tbl);

		if(tblmap.keySet().size() == xlmap.keySet().size()){
			return true;
		}

		return false;

	}

	public boolean compareListColumnValues(Iterator<Object[]> tblData, Iterator<Object[]> xlData) {

		Object tbl = tblData.next()[0];
		Object xl = xlData.next()[0];

		Map<String, String> xlmap = new HashMap<>();
		Map<String, String> tblmap = new HashMap<>();

		xlmap = ((HashMap) xl);
		tblmap = ((HashMap) tbl);

		if (tblmap.keySet().equals(xlmap.keySet())) {
			return true;
		}
		return false;
	}

	public boolean compareColumnNames(Iterator<Object[]> xlData, String[] col) {

		//Object tbl = tblData.next()[0];
		Object xl = xlData.next()[0];

		Map<String, String> xlmap = new HashMap<>();
		//Map<String, String> tblmap = new HashMap<>();

		xlmap = ((HashMap) xl);
		//tblmap = ((HashMap) tbl);

		List<String> l = new ArrayList<>();
		l.addAll(Arrays.asList(col));

		if(xlmap.keySet().containsAll(l)){
			return true;
		}
		return false;
	}


}
