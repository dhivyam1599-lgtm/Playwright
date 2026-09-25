Feature: Checkout Process


  Background:
    Given User logins to Swag Labs Portal
    When user adds "Sauce Labs Backpack" to the cart
    When User navigates to cart page

  Scenario: Complete a full checkout successfully
    And I click the checkout button
    And I enter first name "John", last name "Doe", and zip code "12345"
    And I click the continue button
    And I click the finish button

  Scenario: Checkout shows validation error when no details entered

    And I click the checkout button
    And I click the continue button without entering details
    Then I should see the checkout error "Error: First Name is required"

  Scenario: Verify order summary before placing order

    And I click the checkout button
    And I enter first name "Jane", last name "Smith", and zip code "67890"
    And I click the continue button

