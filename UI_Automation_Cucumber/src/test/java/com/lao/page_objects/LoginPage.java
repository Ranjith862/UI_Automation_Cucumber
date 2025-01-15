package com.lao.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.lao.webdriver_manager.DriverManager;

public class LoginPage {
	// Singleton design pattern
	private static LoginPage loginInstance;

	private LoginPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public static LoginPage getInstance() {
		if (loginInstance == null) {
			loginInstance = new LoginPage();
		}
		return loginInstance;
	}

	@FindBy(name = "username")
	private WebElement USERNAME;

	@FindBy(name = "password")
	private WebElement PASSWORD;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement LOGINBUTTON;

	public void enterUserName(String username) {
		USERNAME.clear();
		USERNAME.sendKeys(username);
	}

	public void enterPassword(String password) {
		PASSWORD.clear();
		PASSWORD.sendKeys(password);
	}

	public void clickLoginBtn() {
		LOGINBUTTON.click();
	}

}
