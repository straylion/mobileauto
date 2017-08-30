package com.lostary.redwoodhq.android;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class Verification {

	/* !----Assert.assertEquals(actual, expected, message);----! */

	/**
	 * 
	 * @param params
	 */
	public void activity(HashMap<String, String> params) {
		String message = "ERROR! Current Activity is NOT " + params.get("Activity");
		Assert.assertEquals(((AndroidDriver<?>) App.Driver).currentActivity(), params.get("Activity"), message);
		System.out.println("Current Activity is " + params.get("Activity"));
	}

	/**
	 * 
	 * @param params
	 */
	public void text(HashMap<String, String> params) {
		WebElement element = Elements.find(params, App.Driver);
		String message = "ERROR! Text is NOT " + params.get("Text");
		Assert.assertEquals(element.getText(), params.get("Text"), message);
		System.out.println("Element " + params.get("ID") + " \'s Text is" + params.get("Text"));
	}

	/**
	 * 
	 * @param params
	 */
	public void textContain(HashMap<String, String> params) {
		WebElement element = Elements.find(params, App.Driver);
		String message = "ERROR! Text do NOT contain " + params.get("Text");
		Assert.assertTrue(element.getText().contains(params.get("Text")), message);
		System.out.println("element " + params.get("ID") + "\'s Text contains" + params.get("Text"));
	}

	/**
	 * 
	 * @param params
	 */
	public void checkbox(HashMap<String, String> params) {
		WebElement element = Elements.find(params, App.Driver);
		String message = "ERROR! Checkbox is NOT checked.";
		Assert.assertEquals(element.isSelected(), params.get("Is Checked").equals("true"), message);
		System.out.println("Checkbox " + params.get("ID") + "is Checked.");
	}

	/**
	 * 
	 * @param params
	 */
	public void isExisted(HashMap<String, String> params) {
		List<WebElement> elements = Elements.findAll(params, App.Driver);
		String message = "ERROR! Element is NOT existed: " + params.get("ID");
		Assert.assertNotEquals(elements.size(), 0, message);
		System.out.println("Element " + params.get("ID") + " is existed.");
	}

	/**
	 * 
	 * @param params
	 */
	public void notExisted(HashMap<String, String> params) {
		List<WebElement> elements = Elements.findAll(params, App.Driver);
		String message = "ERROR! Element is Existed: " + params.get("ID");
		Assert.assertEquals(elements.size(), 0, message);
		System.out.println("Element " + params.get("ID") + " is not existed.");
	}

	/**
	 * 
	 * @param params
	 */
	public void attribute(HashMap<String, String> params) {
		WebElement element = Elements.find(params, App.Driver);
		String message = "ERROR! Attribute Value is NOT " + params.get("Value");
		Assert.assertEquals(element.getAttribute(params.get("Attribute Name")), params.get("Value"), message);
		System.out.println(
				"Element " + params.get("ID") + " \'s " + params.get("Attribute Name") + "is" + params.get("Value"));
		// return element.getAttribute(params.get("Attribute Name")); //返回该元素 特定属性名的属性值
	}

}
