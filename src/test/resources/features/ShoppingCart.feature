Feature: Shopping Cart
  Background:
    Given the user is logged in
  Scenario: The user adds a MacBook to the shopping cart
    Given the user is on the account page
    When the user navigates to the "Desktop" menu
    And selects the "PC(0)" menu item
    And clicks the "Continue" button
    And selects the "MacBook" product
    And clicks "Add to Cart"
    Then the shopping cart should display "1 item(s) - $500.00" in the checkout button