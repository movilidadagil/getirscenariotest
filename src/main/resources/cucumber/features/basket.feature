Feature: Basket functionality
  As a user of Getir
  In order to manage my basket
  I want to be able to add and delete products in my basket

  Scenario: Add and delete product from basket
    Given I am a logged in user of Getir
    When  I add a product related with KisiselBakim
    And  I add a product related with EvBakim
    Then Those products should be seen in basket
    And  I delete the products in basket
    Then Those products should not be seen in basket
