package com.dataprovides;

import org.testng.annotations.DataProvider;

public class UsedCarCityDataProvider {
	
	@DataProvider(name = "CityDP")
	public static Object[][] CityDP(){
		Object[][] data = { {"Bangalore"} };
		return data;
	}
}
