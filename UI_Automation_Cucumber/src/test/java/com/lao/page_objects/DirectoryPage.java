package com.lao.page_objects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.lao.webdriver_manager.DriverManager;

public class DirectoryPage {
	private static DirectoryPage directoryPageInstance;

	private DirectoryPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public static DirectoryPage getInstance() {
		if (directoryPageInstance == null) {
			directoryPageInstance = new DirectoryPage();
		}
		return directoryPageInstance;
	}

	@FindBy(xpath = "(//div[@tabindex='0'])[1]")
	private WebElement JOBTITLE_DROPDOWN;

	@FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]")
	private WebElement CFO; // Here, There is no option tagname to select so I used absolute XPATH

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement SEARCH_BUTTON;

	@FindBy(xpath = "//p[text()='Peter Mac Anderson ']")
	private WebElement NAME;

	public void clickJTDropDown() {
		JOBTITLE_DROPDOWN.click();
	}

	public void clickCFO() {
		Actions action = new Actions(DriverManager.getDriver());
		action.moveToElement(CFO).perform();
		action.doubleClick(CFO).perform();
	}

	public void clickSearchBtn() {
		SEARCH_BUTTON.click();
	}

	public String getName() {
		return NAME.getText();
	}
}
