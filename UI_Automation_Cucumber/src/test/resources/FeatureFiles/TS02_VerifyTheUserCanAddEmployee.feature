@verifyemployee @smoke @all @employeeCRUD
Feature: This feature is to add and check the employee

  @addemployee @smoke
  Scenario: Verify that the user can add a new employee
    Given the user is on the OrangeHRM dashboard page
    When the user clicks on PIM option from the menu bar
    And the user clicks on the Add employee
    And the user enters "Test12345" and "DemoTest"
    And the user clicks on the Save button
    Then the user should be navigated to personal details page
