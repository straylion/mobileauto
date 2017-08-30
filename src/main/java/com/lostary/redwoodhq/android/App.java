package com.lostary.redwoodhq.android;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class App {

	public static AppiumDriver<WebElement> Driver;

	// start device and open already-installed application
	public void openApp(HashMap<String, String> params) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		switch (params.get("APK Name")) {
		case "danlu_store":
			capabilities.setCapability("appPackage", "cn.com.dhc.danlu");
			capabilities.setCapability("appActivity", ".usercenter.activity.LoginActivity");
			break;
		case "danlu_dealer":
			capabilities.setCapability("appPackage", "com.danlu.client.business");
			capabilities.setCapability("appActivity", "com.danlu.client.business.ui.activity.SplashActivity_");
			break;
		default:
			capabilities.setCapability("appPackage", "cn.com.dhc.danlu");
			capabilities.setCapability("appActivity", ".usercenter.activity.LoginActivity");
		}

		// set android device
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", params.get("Device Name"));
		capabilities.setCapability("platformVersion", params.get("Platform Version"));
		capabilities.setCapability("newCommandTimeout", 240);
        

		// initialize
		try {
			Driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// install application and open it
	public void installApp(HashMap<String, String> params) {
		String path = params.get("APK Name") + ".apk";
		File app = new File(path);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		switch (params.get("APK Name")) {
		case "danlu_store":
			capabilities.setCapability("appPackage", "cn.com.dhc.danlu");
			capabilities.setCapability("appActivity", ".activity.SplashActivity");
			break;
		case "danlu_dealer":
			capabilities.setCapability("appPackage", "com.danlu.client.business");
			capabilities.setCapability("appActivity", "com.danlu.client.business.ui.activity.SplashActivity_");
			break;
		default:
			capabilities.setCapability("appPackage", "cn.com.dhc.danlu");
			capabilities.setCapability("appActivity", ".activity.SplashActivity");
		}

		// set android device
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", params.get("Device Name"));
		capabilities.setCapability("app", app.getAbsolutePath());
		// initialize
		try {
			Driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

