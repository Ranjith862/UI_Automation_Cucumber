package com.lao.step_definitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.lao.page_objects.PIMPage;
import com.lao.webdriver_manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TS04_EditEmployee_Step_Def {

	PIMPage pim = PIMPage.getInstance();
	WebDriver driver = DriverManager.getDriver();

	@Given("the user is in pim page")
	public void the_user_is_in_pim_page() {
		try {
			pim.clickOnPim();
			String pageURL = DriverManager.getDriver().getCurrentUrl();
			if (pageURL.contains("PIM")) {
				System.out.println("User is in PIM page");
			} else {
				System.out.println("User not in PIM page");
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@When("the user enters employee name {string}")
	public void the_user_enter_employee_name(String searchEmpName) {
		try {
			pim.enterEmpName(searchEmpName);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@When("click on the search button, the record will be visible")
	public void click_on_the_search_button_the_record_will_be_visible() {
		try {
			// click on the search button
			pim.clickSearchButton();
			// To check the record is visible or not
			String empRecord = PIMPage.getInstance().getEmpRecordName();
			if (empRecord.contains("Id")) {
				System.out.println("Record found: " + empRecord);
			} else {
				System.out.println("Record not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@When("the user clicks on edit icon")
	public void the_user_clicks_on_edit_icon() {
		try {
			pim.clickOnEditIcon();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@When("the user edit the name as {string}")
	public void the_user_edit_the_name_as(String updateName) {
		try {
			pim.enterFirstName(updateName);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@When("the user clicks the save button")
	public void the_user_clicks_the_save_button() {
		try {
			pim.clickSavebtnOneWhenEdit();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@When("the user navigate to employee list")
	public void the_user_navigate_to_employee_list() {
		try {
			pim.clickOnPim();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@When("search with the updated name as {string}")
	public void search_with_the_updated_name(String updatedName) {
		try {
			pim.enterEmpName(updatedName);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Then("the system should be displayed the updated name")
	public void the_system_should_be_displayed_the_updated_name() {
		try {

			String empRecord = pim.getEmpRecordName();
			Assert.assertTrue("Not Equals", empRecord.contains("Id"));

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

}
