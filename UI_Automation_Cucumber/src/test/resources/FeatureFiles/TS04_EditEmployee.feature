@edittheemployee @smoke @all @employeeCRUD
Feature: This feature is to verify the edit functionality

  @edit @smoke
  Scenario Outline: This scenario is to verify the edit function
    Given the user is in pim page
    When the user enters employee name "<OldName>"
    And click on the search button, the record will be visible
    And the user clicks on edit icon
    And the user edit the name as "<UpdatedName>"
    And the user clicks the save button
    And the user navigate to employee list
    And search with the updated name as "<UpdatedName>"
    Then the system should be displayed the updated name

    Examples: 
      | OldName            | UpdatedName    |
      | Test12345 DemoTest | AutomationDemo |
