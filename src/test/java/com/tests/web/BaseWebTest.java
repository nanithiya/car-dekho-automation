package com.tests.web;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class BaseWebTest {
	public static WebDriver driver = null;
	   
	public BaseWebTest() {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		Map<String, Object> prefs = new HashMap<String, Object>();
		    
		//add key and value to map as follow to switch off browser notification
		//Pass the argument 1 to allow and 2 to block
		prefs.put("profile.default_content_setting_values.notifications", 2);
		    
		//Create an instance of ChromeOptions 
		ChromeOptions options = new ChromeOptions();		   
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
