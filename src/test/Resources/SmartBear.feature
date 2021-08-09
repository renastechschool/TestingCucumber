Feature: Testing Scenarios for Smart Bear Application

@SanityTest
Scenario: SmartBear Login
  Given user is on the login page
  When user enters username as "Tester" and password as "test"
  Then user is loggedin

  @SanityTest
  Scenario: Check View all Orders
    Given user is on View all orders page
    When user views the title as "List of All Orders"
    Then view all orders page loads successfully

  @SanityTest
  Scenario: Check View all Products
    Given user is on View all products page
    When user views the title as "List of Products"
    Then view all products page loads successfully

  @SanityTest
  Scenario: Check Add Orders
    Given user is on Add orders page
    When user views the title as "Order"
    Then Add orders page loads successfully


    @RegressionTest
    Scenario: Users creates a new order
      Given user is on Add orders page
      When user enters all the information and click on Process button
      | Product | FamilyAlbum |
      | Quantity | 10         |
      | Customer Name | Noel Dsouza |
      | Street        | 123 st      |
      | City          | Mississauga |
      | State         | ON          |
      | Zip           | 12345       |
      | Card          | Visa  |
      | Card Number   | 0123456789 |
      | Expiry Date   | 01/01      |
      Then order is added successfully
