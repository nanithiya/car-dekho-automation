package com.dataprovides;

import org.testng.annotations.DataProvider;

public class UsedCarBudgetDataProvider {
	
	@DataProvider(name = "BudgetOptionDP")
	public static Object[][] BudgetOptionDP(){
		Object[][] data = { {"2 - 5 Lakh"} };
		return data;
	}
}
