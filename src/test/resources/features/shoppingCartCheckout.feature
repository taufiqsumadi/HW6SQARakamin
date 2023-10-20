Feature: Shopping Cart Checkout

  Scenario: Users can checkout if they have selected a product
    Given the user can see the available products
    When the user adds products to the cart by clicking the Add to Cart
    And the user clicks on the cart icon in the top right side
    And the user clicks the Checkout
    Then the user should be directed to the checkout page