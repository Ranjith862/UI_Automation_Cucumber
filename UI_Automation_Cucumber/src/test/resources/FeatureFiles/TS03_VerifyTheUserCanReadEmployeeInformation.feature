@verifyemployeinfo @smoke @all @employeeCRUD
Feature: This feature is to check the previously added employee is there or not

  @retrive @smoke
  Scenario: This scenario is to verify the emoployee information
    Given the user is in dashboard page
    When the user clicks the PIM link from menu bar
    And the user enters the existing employee name "Test12345 DemoTest"
    And click on the search button
    Then the system should be display the record
