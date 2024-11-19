Feature: ItemPurchase
  test

  Scenario: User buys an T-shirt
    Given user logged in to shop
    When user selects a product
    And user adds items to the cart
    Then user place order
    And order confirmation screenshot is taken
    And browser closes