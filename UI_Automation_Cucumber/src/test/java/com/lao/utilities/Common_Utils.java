package com.lao.utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.lao.constants.Constants;
import com.lao.step_definitions.Common_Step_Def;
import com.lao.webdriver_manager.DriverManager;

public class Common_Utils {

	private static Common_Utils commonutilsInstance;

	private Common_Utils() {

	}

	public static Common_Utils getInstance() {
		if (commonutilsInstance == null) {
			commonutilsInstance = new Common_Utils();
		}
		return commonutilsInstance;
	}

	public void loadProperties() throws IOException {
		FileReader filereader = new FileReader("src/test/resources/config.properties");
		Properties properties = new Properties();
		properties.load(filereader);
		Constants.APP_URL = properties.getProperty("APP_URL");
		Constants.BROWSER = properties.getProperty("Browser");
		Constants.USERNAME = properties.getProperty("UserName");
		Constants.PASSWORD = properties.getProperty("Password");
		Constants.CHROME_DRIVER_PATH = properties.getProperty("ChromeDriverLocation");
		Constants.FIREFOX_DRIVER_PATH = properties.getProperty("FirefoxDriverLocation");

	}

	public void takeScreenshort() {
		// Take screenshot
		File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

		// Save screenshot to a file
		try {
			FileUtils.copyFile(screenshot, new File(Common_Step_Def.getScenarioName()+ ".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
