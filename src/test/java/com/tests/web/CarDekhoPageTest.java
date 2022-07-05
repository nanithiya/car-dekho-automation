package com.tests.web;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

import com.dataprovides.UsedCarBudgetDataProvider;
import com.dataprovides.UsedCarCityDataProvider;
import com.dataprovides.UsedCarSortDataProvider;
import com.validators.Validator;
import com.web.pages.CarDekhoPage;

public class CarDekhoPageTest extends BaseWebTest{
	CarDekhoPage cdPage;
	public String HomePageTitle = "CarDekho: New Cars, Car Prices, Buy & Sell Used Cars in India";
	public String BudgetOption = "2 - 5 Lakh";
	public String CityOption = "Bangalore";
	public String SortByOption = "Price - High to Low";
	public String CarDetailsPageTitle = "Car Overview";
	public Set<String> CarImagePageTitles = new HashSet<String>(Arrays.asList(
		     new String[] { "Images", "360 View",  "Exterior", "Interior"}
			));
	public String ReportTitle = "Expert Inspection Report";
	
	@Test(priority = 1, description = "Open CarDekho URL")
	public void OpenCarDekhoUrlTest() {
		cdPage = new CarDekhoPage(driver);
		cdPage.OpenCarDekhoUrl();
		String expectedTitle = cdPage.GetHomePageTitle();
		Validator.ValidateStringsEqual(expectedTitle, HomePageTitle);
	}
	
	@Test(priority =2, description = "Select Budget range", dataProvider = "BudgetOptionDP", dataProviderClass = UsedCarBudgetDataProvider.class)
	public void SelectBudgetRangeTest(String budget) {
		cdPage.ClickUsedCar();
		cdPage.SelectBudgetFromDropDown(budget);
		String expectedBudgetSelection = cdPage.GetSelectedBudgetOption();
		Validator.ValidateStringsEqual(expectedBudgetSelection, budget);
	}
	
	@Test(priority =3, description = "Select City range", dataProvider = "CityDP", dataProviderClass = UsedCarCityDataProvider.class)
	public void SelectCityTest(String city) {
		cdPage.SelectCityFromDropDown(city);
		String expectedCitySelection = cdPage.GetSelectedCityOption();
		Validator.ValidateStringsEqual(expectedCitySelection, city);
	}
	
	@Test(priority =4, description = "Navigate to used cars page", dataProvider = "CityDP", dataProviderClass = UsedCarCityDataProvider.class)
	public void NavigateToUsedCarPageTest(String city) {
		cdPage.ClickSearchButton();
		String expectedTitle = cdPage.GetUserCarPageTitle();
		Validator.ValidateResultWithErrMessage(expectedTitle.contains(city), "Invalid city selected/page loaded");
	}
	
	@Test(priority =5, description = "Sort by price (High to Low)", dataProvider = "SortDP", dataProviderClass = UsedCarSortDataProvider.class)
	public void SortByPriceTest(String sortOption) {
		cdPage.SelectSortByOptionFromDropDown(sortOption);
		String expectedSortBySelection = cdPage.GetSelectedSortByOption();
		Validator.ValidateStringsEqual(expectedSortBySelection, sortOption);
	}
	
	@Test(priority =6, description = "Select car")
	public void SelectCarTest() {
		cdPage.SelectCar();
		String expectedCarDetailsPageTitle =cdPage.GetCarDetailsPageTitle();
		Validator.ValidateStringsEqual(expectedCarDetailsPageTitle, CarDetailsPageTitle);
	}
	
	@Test(priority =7, description = "Select Report")
	public void SelectReportTest() {
		cdPage.SelectReport();
		String expectedCarReportTitle =cdPage.GetCarReportSectionTitle();
		Validator.ValidateResultWithErrMessage(expectedCarReportTitle.contains(ReportTitle), "Report section is not loaded");
	}
	
	@Test(priority =8, description = "Show the Car Image")
	public void clickCarImageTest() {
		cdPage.clickCarImage();
		String expectedCarImagePageTitle =cdPage.CarImagePageTitle();
		Validator.ValidateResultWithErrMessage(CarImagePageTitles.contains(expectedCarImagePageTitle), "Invalid page loaded");
	}
}
