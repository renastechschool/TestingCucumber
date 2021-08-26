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

  @RegressionTest
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




      @Temp
      Scenario: Login with POM
        Given The user wants to enter username
        Then The user wants to enter password






        @Temp2
      Scenario: Verify that complete order
        Given The user wants to enter username
        Then The user wants to enter password
        Then The user wants to go to order page
        And The user wants to enter Product Information
           | product | FamilyAlbum  |
           | Quantity | 15          |
        And The user wants to set Address Information
           | Customer name |Erkan        |
           | Street        | 123 Address |
           | City          | Toronto     |
           | State         | Ontario     |
           | Zip           | M2R2B8      |
        And The user wants to enter Payment Information
           |Card       | visa               |
           |CardNo     | 123456789123456789 |
           |Expire date| 12/26              |
        Then The user wants process






          @SO
      Scenario Outline:
        Given The user wants to enter username
        Then The user wants to enter password
        Then The user wants to go to order page
        And The user wants to enter Product Information as "<productInfo>"
        And The user wants to enter Payment Information as "<card>" and "<CardNo>" and "<EDate>"

      Examples:
        |productInfo|card |CardNo            |EDate|
        |MyMoney    |visa |123456789123456789|12/26|
        |FamilyAlbum|visa |123424234223432389|11/27|
        |ScreenSaver|visa |123456789123456789|10/23|




         @AssertionExample
      Scenario: Verify That ScreenAver price and discount are displayed correctly
        Given The user wants to enter username
        Then The user wants to enter password
        Then The user wants to view all products
        Then The user wants to verify data are correct
            | Product name| ScreenSaver|
            | Price	      | $20        |
            | Discount    | 10%        |












