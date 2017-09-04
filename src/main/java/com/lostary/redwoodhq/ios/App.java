package com.lostary.redwoodhq.ios;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class App {

	public static AppiumDriver<MobileElement> Driver;

	// start device and open already-installed application
	public static void openApp(HashMap<String, String> params) {
		File app = new File("/Users/dltest/Downloads/DLzdd.app");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "10.3");
		capabilities.setCapability("deviceName", "iPhone 7");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("udid", "e4a9e33369bba3ded2a77868bbd0fadc32f98b2c");
		capabilities.setCapability("newCommandTimeout", 900);
		// capabilities.setCapability("bundleId", "com.YYYYYY.XXXXXX");
		capabilities.setCapability("autoAcceptAlerts", true);
		capabilities.setCapability("noReset", true);

		try {
			Driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		Driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	// install application and open it
	public static void installApp(HashMap<String, String> params) {
		// String path = params.get("APP Name") + ".app";
		// File app = new File(path);
		File app = new File("//Users//dltest//Downloads//DLzdd.app");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "10.3");
		capabilities.setCapability("deviceName", "iPhone 7");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("udid", "e4a9e33369bba3ded2a77868bbd0fadc32f98b2c");
		capabilities.setCapability("newCommandTimeout", 900);
		// capabilities.setCapability("bundleId", "com.YYYYYY.XXXXXX");
		// capabilities.setCapability("autoAcceptAlerts", true);
		capabilities.setCapability("noReset", true);

		try {
			Driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		Driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

}
