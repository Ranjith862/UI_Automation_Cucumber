package com.lao.step_definitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.lao.page_objects.PIMPage;
import com.lao.webdriver_manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TS02_VerifyTheUserCanAddEmployee_Step_Def {
	PIMPage pim = PIMPage.getInstance();
	WebDriver driver = DriverManager.getDriver();

	@Given("the user is on the OrangeHRM dashboard page")
	public void the_user_is_on_the_orange_hrm_dashboard_page() {
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

	@When("the user clicks on PIM option from the menu bar")
	public void the_user_clicks_on_pim_option_from_the_menu_bar() {
		try {
			pim.clickOnPim();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@When("the user clicks on the Add employee")
	public void the_user_clicks_on_the_add_employee() {
		try {
			pim.clickOnAddEmployee();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@When("the user enters {string} and {string}")
	public void the_user_enters_and(String firstName, String lastName) {
		try {
			pim.enterFirstName(firstName);
			pim.enterLastName(lastName);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@When("the user clicks on the Save button")
	public void the_user_clicks_on_the_save_button() {
		try {
			pim.clickSavebtn();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Then("the user should be navigated to personal details page")
	public void the_user_should_be_navigated_to_personal_details_page() {
		try {
			String actualText = pim.getPersonalDetailsText();
			String expectedText = "Personal Details";
			Assert.assertEquals("Employee Not saved", actualText, expectedText);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

}
