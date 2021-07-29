Feature: Login Scenarios

  @Monthly
  Scenario Outline: Valid User Login
    Given User is on the login page
    When user enter username as <Username> and password as <Password> and clicks on login button
    Then user is given access to the system

    Examples:
    | Username | Password |
    | Noel     | Dsouza   |
    | ABCD     | XYZ      |
    | QWERT    | ASDF     |
    | 12345    | 0000     |

  @Daily
  Scenario: invalid User Login
    Given User is on the login page
    When user enter credentials
    Then user is not given access to the system

  @Weekly
    Scenario: User Registration
      Given User is on the registration page
      When user enters all the details on the page
      | noel | dsouza | a@b.com | 12345678 | Toronto | Canada |
      Then user is registered to the system

    @Daily
      Scenario: Scenario 1
        Given User is on page one
        When user enters values in page one
        Then user reaches page two
  @Daily
  Scenario: Scenario 2
    Given User is on page two
    When user enters values in page two
    Then user reaches page three
  @Weekly
  Scenario: Scenario 3
    Given User is on page three
    When user enters values in page three
    Then user reaches page four
  @Weekly
  Scenario: Scenario 4
    Given User is on page four
    When user enters values in page four
    Then user reaches page five

  @Monthly
  Scenario: Scenario 5
    Given User is on page five
    When user enters values in page five
    Then user reaches page six