Feature: Automation Practice website Testing

  @SmokeTest
  Scenario: Search for an item
    Given user is on the home page
    When user enter <item> in the search box and clicks on search button
    Then search results are displayed to the user with value <item>

    Examples:
    | item |
    | SHIRT |
    | DRESS |

  @SmokeTest
  Scenario: Add item to cart
    Given results are displayed to the user
    When user clicks on the search button and enters details
    Then user can add the item to cart

    @SmokeTest
    Scenario: Search for items - DataTable
      Given user is on the home page
      When user enters details to search
      | SHIRT |
      | DRESS |
      Then results are displayed based on his search
      | SHIRT |
      | DRESS |