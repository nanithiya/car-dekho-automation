package com.web.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	public static WebDriver driver = null;
	public static WebDriverWait wait;

	public PageBase(WebDriver driver) {
		driver.manage().window().maximize();
		PageBase.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
}
