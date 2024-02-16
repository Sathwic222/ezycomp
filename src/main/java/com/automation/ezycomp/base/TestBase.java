package com.automation.ezycomp.base;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/automation/ezycomp/config/config.properties");
		    prop.load(ip);		
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			ChromeOptions Options = new ChromeOptions();
			Options.setBinary("C:\\Users\\DELL\\Desktop\\ezycomp\\ezycomp\\Drivers\\New folder\\chrome-win64\\chrome.exe");
			driver = new ChromeDriver(Options); 
		}
		else if(browserName.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"");	
			driver = new FirefoxDriver(); 			
		}
		else if(browserName.equals("Edge")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
	}
}
