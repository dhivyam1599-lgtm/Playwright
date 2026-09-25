Feature: Products

  Background:
    Given User logins to Swag Labs Portal

  Scenario: Select a product by Name
    Then user should see the products title
    When user filters products by "Price (low to high)"
    When user adds "Sauce Labs Backpack" to the cart

  Scenario: Select the first product by sort order
    Then user should see the products title
    When user filters products by "Name (Z to A)"
    Then User selects the first product
    And User adds the product to cart

  Scenario: Select the last product by sort order
    Then user should see the products title
    When user filters products by "Price (low to high)"
    Then User selects the last product
    And User adds the product to cart

  Scenario: Select multiple products
    Then user should see the products title
    When user filters products by "Name (Z to A)"
    Then User selects the first product
    And User adds the product to cart
    Then User go backs to Product Page
    When user adds "Sauce Labs Backpack" to the cart

    Scenario: Verify whether the user is able to add products and remove products
      Then user should see the products title
      When user adds "Sauce Labs Backpack" to the cart
      When user filters products by "Name (Z to A)"
      Then User selects the first product
      And User adds the product to cart
      And User removes the product that was added to cart
