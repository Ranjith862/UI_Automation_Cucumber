package com.lao.step_definitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.lao.page_objects.DirectoryPage;
import com.lao.page_objects.HomePage;
import com.lao.webdriver_manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TS01_VerifyCFOName_Step_Def {

	HomePage home = HomePage.getInstance();
	DirectoryPage directory = DirectoryPage.getInstance();
	WebDriver driver = DriverManager.getDriver();

	@Given("the user is on Home Page")
	public void the_user_is_on_Home_Page() {
		try {
			String url = driver.getCurrentUrl();
			if (url.contains("dashboard")) {
				System.out.println("Home page: " + url);
			} else {
				System.out.println("User not in home page");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@When("the user clicks on the directory option from the Menu bar")
	public void the_user_clicks_on_the_directory_option_from_the_menu_bar() {
		try {
			home.clickDirectory();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@When("the user selects teh job title as CFO from the drop down")
	public void the_user_selects_teh_job_title_as_from_the_drop_down() {
		try {
			directory.clickJTDropDown();
			directory.clickCFO();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@When("clicks the search button")
	public void clicks_the_search_button() {
		try {
			directory.clickSearchBtn();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Then("the user should see the CFO name as {string}")
	public void the_user_should_see_the_cfo_name_as(String expectedCFOName) {
		try {
			String actualMessage = directory.getName();
			if (expectedCFOName.equalsIgnoreCase(actualMessage)) {
				System.out.println("Record Found: " + actualMessage);
			} else {
				System.out.println("Record Not Found");
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
