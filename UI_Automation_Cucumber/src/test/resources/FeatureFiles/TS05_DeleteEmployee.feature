@deletetheemployee @smoke @all @employeeCRUD
Feature: This feature is to delete the existing employee

  @delete @smoke
  Scenario: This scenario is to delete the employee
    Given the user in PIM page
    When the user enters employee name as "AutomationDemo"
    And click on the search button, the record should be visible
    And the user clicks on delete icon
    And the validation message will open
    Then click on Yes,Delete button the user should be delete
