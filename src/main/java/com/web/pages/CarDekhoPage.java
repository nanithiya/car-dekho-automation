package com.web.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CarDekhoPage extends PageBase {
	public static String appURL = "https://www.cardekho.com";
	
	@FindBy(xpath = "//*[@id=\"HometopBanner\"]/div[2]/div/div[1]/ul/li[2]")
	WebElement usedCarButton;
	
	@FindBy(xpath="//*[@id=\"ucBudget\"]")
	WebElement dropdownBudget;
	
	@FindBy(xpath="//*[@id=\"budCityName\"]")
	WebElement dropdownCity;
	
	@FindBy(xpath="//*[@id=\"used_budget\"]/div/ul/li[3]/button")
	WebElement searchButton;
	
	@FindBy(xpath="//*[@data-track-component=\"Breadcrumb\"]/span[3]/span")
	WebElement BreadcrumbTitle;
	
	@FindBy(xpath="//*[@id=\"sortbyName\"]")
	WebElement dropdownSortBy;
	
	@FindBy(xpath = "//li[@data-value='Price - High to Low']")
	WebElement sortByOption;
	
	@FindBy(xpath = "//div[contains(@class,\"assuredby\")]/ul/li[2]")
	WebElement categoryFilterOption;
	
	@FindBy(xpath = "//div[contains(@id,\"carList\")][5]")
	WebElement carCard;
	
	@FindBy(xpath = "//div[@class=\"tabbingLpanel\"]/div[2]")
	WebElement carReportLink;
	
	
	@FindBy(xpath ="//div[contains(@class,\"overviewCArd\")]/div/div/h2")
	WebElement CarDetailsTitle;
	
	@FindBy(xpath ="//div[contains(@class,\"inspectionReport\")]/div/div/h2")
	WebElement CarReportTitle;
	
	@FindBy(xpath ="//li[contains(@class,\"photoIc\")]/img")
	WebElement CarImage;
	
	@FindBy(xpath ="//div[@class = 'imageSection gsc_container']/div[1]/h2[@class = 'title'][1]")
	WebElement CarImagePageTitle;
	
	public CarDekhoPage(WebDriver driver) {
		super(driver);
	}
	
	public void OpenCarDekhoUrl() {
		driver.navigate().to(appURL);
	}
	
	public String GetHomePageTitle() {
		return driver.getTitle();
	}
	
	public void ClickUsedCar() {
		wait.until(ExpectedConditions.elementToBeClickable(usedCarButton));
		usedCarButton.click();
	}
	
	public void SelectBudgetFromDropDown(String budget) {
		wait.until(ExpectedConditions.visibilityOf(dropdownBudget));
		dropdownBudget.click();
		
		String budgetOption = "//li[@data-value='"+ budget + "']";
		driver.findElement(By.xpath(budgetOption)).click();
	}
	
	public String GetSelectedBudgetOption() {
		return dropdownBudget.getAttribute("value");
	}
	
	public void SelectCityFromDropDown(String city) {
		wait.until(ExpectedConditions.visibilityOf(dropdownCity));
		dropdownCity.click();
		
		String cityOption = "//li[@data-value='" +  city+ "']";
		driver.findElement(By.xpath(cityOption)).click();
	}
	
	public String GetSelectedCityOption() {
		return dropdownCity.getAttribute("value");
	}
	
	public void ClickSearchButton() {
		wait.until(ExpectedConditions.visibilityOf(searchButton));
		searchButton.click();
		wait.withTimeout(Duration.ofSeconds(10));
	}
	
	public String GetUserCarPageTitle() {
		wait.until(ExpectedConditions.visibilityOf(BreadcrumbTitle));
		return BreadcrumbTitle.getText();
	}
	
	public void SelectSortByOptionFromDropDown(String option) {
		wait.until(ExpectedConditions.visibilityOf(dropdownSortBy));
		dropdownSortBy.click();

		String sortByOption = "//li[@data-value='" + option + "']";
		driver.findElement(By.xpath(sortByOption)).click();
		wait.withTimeout(Duration.ofSeconds(30));	
		categoryFilterOption.click();
	}
	
	public String GetSelectedSortByOption() {
		return dropdownSortBy.getAttribute("value");
	}
	
	public void SelectCar() {
		wait.until(ExpectedConditions.visibilityOf(carCard));
		carCard.click();
	}
	
	public String GetCarDetailsPageTitle() {
		wait.until(ExpectedConditions.visibilityOf(CarDetailsTitle));
		return CarDetailsTitle.getText();
	}
	
	public void SelectReport() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", carReportLink);
	}
	
	public String GetCarReportSectionTitle() {
		wait.until(ExpectedConditions.visibilityOf(CarReportTitle));
		return CarReportTitle.getText();
	}
	
	public void clickCarImage() {	
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", CarImage);
	}
	
	public String CarImagePageTitle() {
		wait.until(ExpectedConditions.visibilityOf(CarImagePageTitle));
		return CarImagePageTitle.getText();
	}
}