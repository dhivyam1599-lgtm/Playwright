Feature: CartPage

  Background:
    Given User logins to Swag Labs Portal


    Scenario:Verify whether the user is able to add products in cart and checkout
      When user adds "Sauce Labs Backpack" to the cart
      When User navigates to cart page
      Then user should see 1 products
      And User should be able to remove the selected "Sauce Labs Backpack" items
      Then User Clicks the Checkout Button

  Scenario:Verify whether the user is able to add two products in cart and checkout
    When user adds "Sauce Labs Backpack" to the cart
    When user adds "Sauce Labs Bike Light" to the cart
    When User navigates to cart page
    Then User should be able to view the cart page
    Then user should see 2 products
    And User should be able to remove the selected "Sauce Labs Backpack" items
    Then User Clicks the Checkout Button

  Scenario:Verify that user can remove an item from the cart
    When user adds "Sauce Labs Bike Light" to the cart
    When User navigates to cart page
    Then User should be able to view the cart page
    Then user should see 1 products
    And User removes the product that was added to cart

  Scenario:Verify that the user can navigate to the product page after adding items to the cart
    When user adds "Sauce Labs Backpack" to the cart
    When User navigates to cart page
    Then User should be able to view the cart page
    Then user should see 1 products
    And User Clicks the Continue Button