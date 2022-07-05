package com.validators;

import org.testng.Assert;


public class Validator {

	public static void ValidateStringsEqual(String actual, String expected) {
		Assert.assertEquals(actual, expected);
	}
	
	public static void ValidateResultWithErrMessage(Boolean result, String message) {
		Assert.assertTrue(result, message);
	}
}
