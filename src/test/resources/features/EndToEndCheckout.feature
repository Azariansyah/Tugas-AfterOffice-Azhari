Feature: Successfully Checkout the order

  Background:
    Given Buyer landing to ecommerce

  Scenario: Create Order Positive Case
    Given Buyer logged to website
    When Buyer add product to Cart
    And Navigate to cart and checkout
    And Fill checkout information
    Then Buyer click complete purchase

  Scenario: User Order Multiple Item
    Given Buyer logged to website
    When Buyer add multiple product to Cart
    And Navigate to cart and checkout
    And Fill checkout information
    Then Buyer click complete purchase

    Scenario: Verify Button Continue Shopping is Working Properly
      Given Buyer logged to website
      When Buyer add product to Cart
      Then Buyer return to product list page



  Scenario Outline: Create Order Positive Case With Payload
    Given Buyer logged to website username "<username>" and password "<password>"
    When Buyer add product "<item>" to Cart
    And Navigate to cart and checkout
    And Fill checkout information setFirstName "<setFirstName>" setLastName "<setLastName>" PostalCode "<setPostalCode>"
    Then Buyer click complete purchase

    Examples:
      | username      | password     | item              | setFirstName | setLastName | setPostalCode |
      | standard_user | secret_sauce | addToCartBackPack | John         | Doe         | 12345         |
      | visual_user   | secret_sauce | addToCartBackPack | John         | Doe         | 12345         |