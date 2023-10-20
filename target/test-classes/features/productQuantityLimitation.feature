Feature: Product Quantity Limitation

  Scenario: Users cannot add quantity if they have selected a product
    Given i can see the available products
    And i adds products to the cart by clicking the Add to Cart
    When i clicks on the cart icon in the top right side
    Then i cannot fill product quantities