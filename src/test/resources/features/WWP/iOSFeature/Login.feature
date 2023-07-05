@IOS
Feature: Login with Valid Credentials.

  #@Login
    #Steps are incomplete
  Scenario Outline: Verify Click functionality for Veterans crisis Help Line
    Given Read the testdata "<TestData>" from excel file
    When User launches the application on iOS "<deviceName>"
    When User clicks on veterans crisis helpline number on ios
    Examples:
      | TestData |deviceName|
      |testdata1| iPhone 12_14.1|

  @Login
  Scenario Outline: Verify that logo is visible on homepage
    Given Read the testdata "<TestData>" from excel file
    When User launches the application on iOS "<deviceName>"
    Then Logo is visible on ios
    Examples:
      | TestData |deviceName|
      |testdata1| iPhone 12_14.1|

  @Login
  Scenario Outline: Verify login page text, labels, links and buttons
    Given Read the testdata "<TestData>" from excel file
    When User launches the application on iOS "<deviceName>"
    Then Verify login page text, labels, links and buttons on ios


    Examples:
      | TestData |deviceName|
      |testdata1| iPhone 12_14.1|

  @Login
  Scenario Outline: Verify the User login Validation with blank fields.
    Given Read the testdata "<TestData>" from excel file
    When User launches the application on iOS "<deviceName>"
    And Click on signIn Button
    Then user unable to login with blank field on ios

    Examples:
      | TestData |deviceName|
      |testdata1| iPhone 12_14.1|

  @Login
  Scenario Outline: Verify that user is able to login to the app
    Given Read the testdata "<TestData>" from excel file
    When User launches the application on iOS "<deviceName>"
    And Enter Username and Password into the input box as "atul.mantri@testingxperts.com" and "Test@1234"
    And Click on signIn Button
    Then User should navigate to home page
    Examples:
      | TestData |deviceName|
      |testdata1| iPhone 12_14.1|

  @Login
  Scenario Outline: Verify the password masking functionality during the login
    Given Read the testdata "<TestData>" from excel file
    When User launches the application on iOS "<deviceName>"
    Then Verify the password masking functionality on ios
    Examples:
      | TestData |deviceName|
      |testdata1| iPhone 12_14.1|

  @Login
  Scenario Outline: Verify the User login Validation with invalid credentials.
    Given Read the testdata "<TestData>" from excel file
    When User launches the application on iOS "<deviceName>"
    And user clicks on login button with invalid credentials as "ahhsdsdds" and "trrrppp" on ios
    Then user unable to login with invalid credentials on ios
    Examples:
      | TestData |deviceName|
      |testdata1| iPhone 12_14.1|