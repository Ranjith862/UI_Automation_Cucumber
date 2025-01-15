package com.lao.step_definitions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.lao.constants.Constants;
import com.lao.page_objects.LoginPage;
import com.lao.utilities.Common_Utils;
import com.lao.webdriver_manager.DriverManager;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Common_Step_Def {

	private static String scenarioName;
	// public static boolean isLoggedIn = false; // track login status

	public static String getScenarioName() {
		return scenarioName;
	}

	@Before
	public void beforeScenario(Scenario scenario) {
		try {
			scenarioName = scenario.getName();
			Common_Utils.getInstance().loadProperties();
			if (DriverManager.getDriver() == null) {
				DriverManager.launchBrowser();
				DriverManager.getDriver().manage().window().maximize();
				DriverManager.getDriver().manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
				// isLoggedIn = true; // Set login status to true
				login();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void login() {
		try {
			// Login:
			DriverManager.getDriver().get(Constants.APP_URL);
			LoginPage.getInstance().enterUserName(Constants.USERNAME);
			LoginPage.getInstance().enterPassword(Constants.PASSWORD);
			LoginPage.getInstance().clickLoginBtn();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			File sourcePath = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");
		}
	}

	@AfterAll
	public static void afterScenario() {
		try {
			DriverManager.quitBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
