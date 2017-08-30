package com.lostary.redwoodhq.android;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

/**
 * Use resource-id and xpath
 * 
 * @author stray
 *
 */
public class Elements {

	/**
	 * 
	 * @param params
	 * @param Driver
	 * @return
	 */
	public static WebElement find(HashMap<String, String> params, AppiumDriver<?> Driver) {
		WebElement foundElement = null;
		switch (params.get("ID Type")) {
		case "ID":
			foundElement = Driver.findElement(By.id(Elements.getP(params.get("ID"))));
			break;
		case "XPATH":
			foundElement = Driver.findElement(By.xpath(Elements.getP(params.get("ID"))));
			break;
		default:
			foundElement = Driver.findElement(By.id(Elements.getP(params.get("ID"))));
		}
		return foundElement;
	}

	/**
	 * 
	 * @param params
	 * @param Driver
	 * @return
	 */
	public static List<WebElement> findAll(HashMap<String, String> params, AppiumDriver<WebElement> Driver) {
		List<WebElement> foundElements = null;
		switch (params.get("ID Type")) {
		case "ID":
			foundElements = Driver.findElements(By.id(Elements.getP(params.get("ID"))));
			break;
		case "XPATH":
			foundElements = Driver.findElements(By.xpath(Elements.getP(params.get("ID"))));
			break;
		default:
			foundElements = Driver.findElements(By.id(Elements.getP(params.get("ID"))));
		}
		return foundElements;
	}

	/**
	 * Read properties
	 * 
	 * @param filePath
	 * @return
	 */
	public static Properties readProperties(File filePath) {
		Properties p = new Properties();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
			p.load(br);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}

	/**
	 * read key-value (param-pr)
	 * 
	 * @param param
	 * @return
	 */
	public static String getP(String param) {
		File filePath = new File("elementpath.properties");
		Properties p = readProperties(filePath);
		String pr = p.getProperty(param);
		return pr;
	}
}
