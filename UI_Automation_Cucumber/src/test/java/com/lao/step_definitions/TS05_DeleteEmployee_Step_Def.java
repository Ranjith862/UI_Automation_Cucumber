package com.lao.step_definitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.lao.page_objects.PIMPage;
import com.lao.webdriver_manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TS05_DeleteEmployee_Step_Def {
	PIMPage pim = PIMPage.getInstance();
	WebDriver driver = DriverManager.getDriver();

	@Given("the user in PIM page")
	public void the_user_in_pim_page() {
		try {
			pim.clickOnPim();
			String pageURL = driver.getCurrentUrl();
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

	@When("the user enters employee name as {string}")
	public void the_user_enters_employee_name_as(String employeeName) {
		try {
			pim.enterEmpName(employeeName);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@When("click on the search button, the record should be visible")
	public void click_on_the_search_button_the_record_should_be_visible() {
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

	@When("the user clicks on delete icon")
	public void the_user_clicks_on_delete_icon() {
		try {
			pim.clickDeleteIcon();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@When("the validation message will open")
	public void the_validation_message_will_open() {
		try {
			String deleteValidation = pim.getTitleCardName();
			if (deleteValidation.contains("Are you Sure")) {
				System.out.println("Validation message open");
			} else {
				System.out.println("Validation message not open");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Then("click on Yes,Delete button the user should be delete")
	public void click_on_yes_delete_button_the_user_should_be_delete() {
		try {
			pim.clickDeleteButton();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

}
