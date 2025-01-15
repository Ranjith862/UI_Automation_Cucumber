package com.lao.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lao.webdriver_manager.DriverManager;

public class HomePage {

	private static HomePage homepageInstance;

	private HomePage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public static HomePage getInstance() {
		if (homepageInstance == null) {
			homepageInstance = new HomePage();
		}
		return homepageInstance;
	}

	@FindBy(xpath="//h6[text()='Dashboard']")
	private WebElement DASHBOARD_TEXT;
	
	@FindBy(linkText = "Directory")
	private WebElement DIRECTORY;

	@FindBy(xpath = "//span[text()='Time']")
	private WebElement TIMESHEET;

	public String getDashBoardText() {
		return DASHBOARD_TEXT.getText();
	}
	public void clickDirectory() {
		DIRECTORY.click();
	}

	public void clickTime() {
		TIMESHEET.click();
	}

}
