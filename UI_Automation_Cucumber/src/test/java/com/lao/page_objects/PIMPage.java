package com.lao.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.lao.webdriver_manager.DriverManager;

public class PIMPage {

	private static PIMPage piminstance;

	private PIMPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public static PIMPage getInstance() {
		if (piminstance == null) {
			piminstance = new PIMPage();
		}
		return piminstance;
	}

	public Actions actions;

	@FindBy(xpath = "//span[text()='PIM']")
	private WebElement PIM_LINK;

	// Add Employee
	@FindBy(linkText = "Add Employee")
	private WebElement ADDEMPLOYEE_LINK;

	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement EMPLOYEE_FIRSTNAME;

	@FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]/div[2]/input")
	private WebElement EMPLOYEE_LASTNAME;

	@FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")
	private WebElement SAVE_BTN;

	@FindBy(linkText = "Personal Details")
	private WebElement PERSONAL_DETAILS;

	// Employee List
	@FindBy(xpath = "//label[contains(text(),'Employee Name')]/parent::div/following-sibling::div/descendant::input")
	private WebElement EMPLOYEE_NAME;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement SEARCH_BUTTON;

	@FindBy(xpath = "//div[text()='Id']")
	private WebElement EMPLOYEE_RECORD;

	// For EDIT Employee 1st Save button
	@FindBy(xpath = "(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[1]")
	private WebElement EDIT_ICON;

	@FindBy(xpath = "(//button[@type='submit'])[1]")
	private WebElement EDIT_SAVEBUTTON;

	// For DELETE Employee
	@FindBy(xpath = "(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[2]")
	private WebElement DELETE_ICON;

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--card-title']")
	private WebElement DELETE_TITLECARD;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")
	private WebElement DELETE_BUTTON;

	public void clickOnPim() {
		PIM_LINK.click();
	}

	public void clickOnAddEmployee() {
		ADDEMPLOYEE_LINK.click();
	}

	public void enterFirstName(String firstName) {
		EMPLOYEE_FIRSTNAME.clear();
		EMPLOYEE_FIRSTNAME.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		EMPLOYEE_LASTNAME.clear();
		EMPLOYEE_LASTNAME.sendKeys(lastName);
	}

	public void clickSavebtn() {
		SAVE_BTN.click();
	}

	public String getPersonalDetailsText() {
		return PERSONAL_DETAILS.getText();
	}

	public void clickSearchButton() {
		SEARCH_BUTTON.click();
	}

	public String getEmpRecordName() {
		return EMPLOYEE_RECORD.getText();
	}

	// For Edit
	public void clickOnEditIcon() {
		EDIT_ICON.click();
	}

	public void enterEmpName(String employeeName) {
		EMPLOYEE_NAME.clear();
		EMPLOYEE_NAME.sendKeys(employeeName);
	}

	public void clickSavebtnOneWhenEdit() {
		actions = new Actions(DriverManager.getDriver());
		actions.doubleClick(EDIT_SAVEBUTTON);
		// EDIT_SAVEBUTTON.click();
	}

	// For Delete
	public void clickDeleteIcon() {
		DELETE_ICON.click();
	}

	public String getTitleCardName() {
		return DELETE_TITLECARD.getText();
	}

	public void clickDeleteButton() {
		if (DELETE_BUTTON.isEnabled()) {
			actions.doubleClick(DELETE_BUTTON);
			// DELETE_BUTTON.click();
		} else {
			System.out.println("Delete button is not visible");
		}
	}
}
