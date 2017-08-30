package com.lostary.redwoodhq.android;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class Operation {

	/**
	 * clear element.
	 * 
	 * @param params
	 */
	public void clearElement(HashMap<String, String> params) {
		WebElement element = Elements.find(params, App.Driver);
		element.clear();
		System.out.println("Clear element " + params.get("ID"));
	}

	/**
	 * click element.
	 * 
	 * @param params
	 */
	public void clickElement(HashMap<String, String> params) {
		WebElement element = Elements.find(params, App.Driver);
		element.click();
		System.out.println("Click element " + params.get("ID"));
	}

	/**
	 * close application
	 * 
	 * @param params
	 */
	public void closeApp(HashMap<String, String> params) {
		if (App.Driver != null)
			App.Driver.closeApp();
		System.out.println("Close Current Application");
	}

	/**
	 * hide keyboard
	 * 
	 * @param params
	 */
	public void hideKeyboard(HashMap<String, String> params) {
		App.Driver.hideKeyboard();
		System.out.println("Hide Keyboard");
	}

	/**
	 * 
	 * @param params
	 */
	public void installApp(HashMap<String, String> params) {
		App.Driver.installApp(params.get("APK Name") + ".apk");
		System.out.println("Install another app: " + params.get("APK Name"));
	}

	/**
	 * open notification
	 * 
	 * @param params
	 */
	public void openNotification(HashMap<String, String> params) {
		((AndroidDriver<?>) App.Driver).openNotifications();
		System.out.println("Open Notification ");
	}

	/**
	 * press key code
	 * 
	 * @param params
	 */
	public void pressKeycode(HashMap<String, String> params) {
		((AndroidDriver<?>) App.Driver).pressKeyCode(Integer.parseInt(params.get("Key Code")));
		System.out.println("Press Key Code: " + params.get("Key Code"));
	}

	/**
	 * remove application
	 * 
	 * @param params
	 */
	public void removeApp(HashMap<String, String> params) {
		App.Driver.removeApp(params.get("Package Name"));
		System.out.println("Remove application: " + params.get("Package Name"));
	}

	/**
	 * reset current application
	 * 
	 * @param params
	 */
	public void resetApp(HashMap<String, String> params) {
		App.Driver.resetApp();
		System.out.println("Reset current application");
	}

	/**
	 * run in background 5s
	 * 
	 * @param params
	 */
	@SuppressWarnings("deprecation")
	public void runInBackground(HashMap<String, String> params) {
		App.Driver.runAppInBackground(5);
		System.out.println("Run application in background 5s");
	}

	/**
	 * send keys to element
	 * 
	 * @param params
	 */
	public void sendKeys(HashMap<String, String> params) {
		WebElement element = Elements.find(params, App.Driver);
		String text;
		switch (params.get("Text Type")) {
		case "User":
			try {
				InputStream is1 = new FileInputStream("User.xls");
				Map<String, String> map = this.readExcelContent(is1);
				text = map.get(params.get("Text"));
				element.sendKeys(text);
				System.out.println("Input to element " + params.get("ID") + " " + text);
			} catch (FileNotFoundException e) {
				System.out.println("Excel file doesn't exist!");
				e.printStackTrace();
			}
			break;
		case "Product":
			try {
				InputStream is2 = new FileInputStream("Product.xls");
				Map<String, String> map = this.readExcelContent(is2);
				text = map.get(params.get("Text"));
				element.sendKeys(text);
				System.out.println("Input to element " + params.get("ID") + " " + text);
			} catch (FileNotFoundException e) {
				System.out.println("Excel file doesn't exist!");
				e.printStackTrace();
			}
			break;
		case "Register":
			try {
				InputStream is3 = new FileInputStream("Register.xls");
				Map<String, String> map = this.readExcelContent(is3);
				text = map.get(params.get("Text"));
				element.sendKeys(text);
				System.out.println("Input to element " + params.get("ID") + " " + text);
			} catch (FileNotFoundException e) {
				System.out.println("Excel file doesn't exist!");
				e.printStackTrace();
			}
			break;
		case "Text":
			text = params.get("Text");
			element.sendKeys(text);
			System.out.println("Input to element " + params.get("ID") + " " + text);
			break;
		default:
			text = params.get("Text");
			element.sendKeys(text);
			System.out.println("Input to element " + params.get("ID") + " " + text);
		}
		// hideKeyboard(params);
	}

	/**
	 * start activity
	 * 
	 * @param params
	 */
	@SuppressWarnings("deprecation")
	public void startActivity(HashMap<String, String> params) {
		((AndroidDriver<?>) App.Driver).startActivity(params.get("Package"), params.get("Activity"));
		System.out.println("Start activity " + params.get("Activity"));
	}

	/**
	 * 
	 * @param params
	 */
	@SuppressWarnings("deprecation")
	public void swipe(HashMap<String, String> params) {
		int startX = Integer.parseInt(params.get("startX"));
		int startY = Integer.parseInt(params.get("startY"));
		int endX = Integer.parseInt(params.get("endX"));
		int endY = Integer.parseInt(params.get("endY"));
		App.Driver.swipe(startX, startY, endX, endY, 200);
	}

	/**
	 * 
	 * @param params
	 * @return
	 */
	public String getAttribute(HashMap<String, String> params) {
		WebElement element = Elements.find(params, App.Driver);
		String value = element.getAttribute(params.get("Attribute Name"));
		System.out.println("Element Attribute " + params.get("Attribute Name") + " is" + value);
		return value;
	}

	/**
	 * 
	 * @param params
	 * @return
	 */
	public String getContext(HashMap<String, String> params) {
		return App.Driver.getContext();
	}

	/**
	 * 
	 * @param params
	 * @return
	 */
	public String getCurrentActivity(HashMap<String, String> params) {
		return ((AndroidDriver<?>) App.Driver).currentActivity();
	}

	/* !----WAIT----! */

	/**
	 * wait x seconds
	 * 
	 * @param params
	 */
	public void wait(HashMap<String, String> params) {
		if (params.get("Seconds") != null) {
			try {
				Thread.sleep(Integer.parseInt(params.get("Seconds")) * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * wait for element until timeout
	 * 
	 * @param params
	 */
	public void waitForElement(HashMap<String, String> params) {
		int count = 10;
		while (count >= 0) {
			WebElement element = Elements.find(params, App.Driver);
			if (element != null && element.isDisplayed())
				break;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count--;
		}
		if (count <= 0) {
			System.out.println("Element was not found in 10 seconds.");
		}
	}

	/**
	 * 
	 * sleep the fixed time.
	 * 
	 */
	public void sleep() {
		try {
			Thread.sleep(2 * 1000);
		} catch (final InterruptedException e) {
			System.out.println("sleep " + e);
		}
	}

	/**
	 * read Excel
	 * 
	 * @param InputStream
	 * @return Map
	 */
	public Map<String, String> readExcelContent(InputStream is) {
		POIFSFileSystem fs;
		HSSFWorkbook wb = null;
		HSSFSheet sheet;
		HSSFRow row;
		Map<String, String> content = new HashMap<String, String>();
		String str = "";
		try {
			fs = new POIFSFileSystem(is);
			wb = new HSSFWorkbook(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheetAt(0);
		int rowNum = sheet.getLastRowNum();
		row = sheet.getRow(0);
		int colNum = row.getPhysicalNumberOfCells();
		for (int i = 0; i <= rowNum; i++) {
			row = sheet.getRow(i);
			int j = 0;
			while (j < colNum) {
				str = getCellFormatValue(row.getCell(j));
				content.put(row.getCell(0) + "." + sheet.getRow(0).getCell(j), str);
				j++;
			}
		}
		return content;
	}

	/**
	 * 
	 * @param cell
	 * @return
	 */
	private String getCellFormatValue(HSSFCell cell) {
		String cellvalue = "";
		if (cell != null) {
			switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_NUMERIC:
			case HSSFCell.CELL_TYPE_FORMULA: {
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					Date date = cell.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					cellvalue = sdf.format(date);
				} else {
					// change numeric to string
					DecimalFormat df = new DecimalFormat("0");
					cellvalue = df.format(cell.getNumericCellValue());
				}
				break;
			}
			case HSSFCell.CELL_TYPE_STRING:
				cellvalue = cell.getRichStringCellValue().getString();
				break;
			default:
				cellvalue = "";
			}
		} else {
			cellvalue = "";
		}
		return cellvalue;
	}

}
