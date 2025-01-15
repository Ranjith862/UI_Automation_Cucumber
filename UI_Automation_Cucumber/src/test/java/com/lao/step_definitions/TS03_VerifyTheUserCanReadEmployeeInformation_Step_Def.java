package com.lao.step_definitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.lao.page_objects.PIMPage;
import com.lao.webdriver_manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TS03_VerifyTheUserCanReadEmployeeInformation_Step_Def {

	PIMPage pim = PIMPage.getInstance();
	WebDriver driver = DriverManager.getDriver();

	@Given("the user is in dashboard page")
	public void the_user_is_in_dashboard_page() {
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

	@When("the user clicks the PIM link from menu bar")
	public void the_user_clicks_the_PIM_link_from_menu_bar() {
		try {
			pim.clickOnPim();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@When("the user enters the existing employee name {string}")
	public void the_user_enters_the_existing_employee_name(String employeeName) {
		try {
			pim.enterEmpName(employeeName);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@When("click on the search button")
	public void click_on_the_search_button() {
		try {
			pim.clickSearchButton();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Then("the system should be display the record")
	public void the_system_should_be_display_the_record() {
		try {
			String empRecord = pim.getEmpRecordName();
			Assert.assertTrue("Not Equals", empRecord.contains("Id"));

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
