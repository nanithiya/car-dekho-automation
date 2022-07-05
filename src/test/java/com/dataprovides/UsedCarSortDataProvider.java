package com.dataprovides;

import org.testng.annotations.DataProvider;

public class UsedCarSortDataProvider {
	
	@DataProvider(name = "SortDP")
	public static Object[][] SortDP(){
		Object[][] data = { {"Price - High to Low"} };
		return data;
	}
}
