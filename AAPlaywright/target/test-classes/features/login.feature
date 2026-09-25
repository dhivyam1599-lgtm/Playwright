Feature: Login

  Scenario Outline: Successful Login
    Given User logins to Swag labs website
    When User enters valid username "<username>"
    And User enters valid password "secret_sauce"
    Then User clicks the Login Button
    And Verify the Page title "Swag Labs"
    Examples:
      | username  |
      | standard_user|
      | error_user|
      | visual_user  |

  Scenario Outline: Invalid password
    Given User logins to Swag labs website
    When User enters valid username "<username>"
    And User enters valid password "secret_sauces"
    Then User clicks the Login Button
  And Verify the login error "Epic sadface: Username and password do not match any user in this service"
    Examples:
      | username  |
      | standard_user|
      | error_user|
      | visual_user  |

  Scenario Outline: Invalid username
    Given User logins to Swag labs website
    When User enters valid username "<username>"
    And User enters valid password "secret_sauce"
    Then User clicks the Login Button
    And Verify the login error "Epic sadface: Username and password do not match any user in this service"
    Examples:
      | username  |
      | Dhivya_001|
      | Aruna_002|

  Scenario Outline: Invalid Title
    Given User logins to Swag labs website
    When User enters valid username "<username>"
    And User enters valid password "secret_sauce"
    Then User clicks the Login Button
    And Verify the Page title "Swag Lab"
    Examples:
      | username  |
      | standard_user|
      | error_user|
      | visual_user  |