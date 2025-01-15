@verifycfoname @smoke @all
Feature: This feature is to get the CFO name from the OrangeHRM app

  @getcfoname @smoke
  Scenario: This test is to verify the CFO name
    Given the user is on Home Page
    When the user clicks on the directory option from the Menu bar
    And the user selects teh job title as CFO from the drop down
    And clicks the search button
    Then the user should see the CFO name as "Peter Mac Anderson" 
    

