@HR
Feature: HRAdministration page

  @addUser
  Scenario Outline: Add user and check if user is displayed in Users section
    Given User landed on HRM home page <url>
    Then Login with username <username> and password <password>
    Then Click on Users 
    Then Click on Add icon and enter all details in Add User window <employeename> <username1> <password1> <confirmpassword> and click on Save button
    Then Click on Filter Option and search username <username1>
    And Verify if user is added
    
    Examples: 
    | url                                           | username | password    | employeename | username1 | password1 | confirmpassword |
    |                                               |          |             | Alex         | 299501    | Apex@1995 | Apex@1995       |
      
  @deleteUser
  Scenario Outline: Add user and check if user is displayed in Users section
    Given User landed on HRM home page <url>
    Then Login with username <username> and password <password>
    Then Click on Users 
    Then Click on Filter Option and search username <username1>
    And Delete user <username1> from Users section
    
    Examples: 
   | url                                           | username | password    | employeename | username1 | password1 | confirmpassword |
   |                                               |          |             | Alex         | 299501    | Apex@1995 | Apex@1995       |
      