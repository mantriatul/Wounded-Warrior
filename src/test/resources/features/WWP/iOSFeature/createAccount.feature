@IOS
Feature: Verify Create Account Functionality

  @CreateAccount
  Scenario Outline: Verify the Create Account Link on the Login Page of WDX
    Given Read the testdata "<TestData>" from excel file
    When User launches the application on iOS "<deviceName>"
    And User click on create account on ios app

    Examples:
      |TestData|deviceName|
      |testdata1|iPhone 12_14.1|

  @CreateAccount
  Scenario Outline: Scenario Outline: Verify Create Account fields for Warrior, FSM, or Teammate
    Given Read the testdata "<TestData>" from excel file
    When User launches the application on iOS "<deviceName>"
    And User click on create account on ios app
    And Verify create account fields on ios app
    And user enter "First name." as "Atul" on ios app
    And user enter "Email" as "Atulmantri1994@gmail.com" on ios app
    And User clicks on continue button on ios app
    Then verify last name is required on ios app

    Examples:
      |TestData|deviceName|
      |testdata1|iPhone 12_14.1|

  @CreateAccount
  Scenario Outline:Verify the Create (Link) Account functionality for Warriors, Teammates Users by filling required details on WDX.
    Given Read the testdata "<TestData>" from excel file
    When User launches the application on iOS "<deviceName>"
    And User click on create account on ios app
    And Verify create account fields on ios app
    And user enter "First name." as "Atul" on ios app
    And user enter "Last name." as "Mantri" on ios app
    And user enter "Email" as "atul.mantri@testingxperts.com" on ios app
    And User clicks on continue button on ios app
    Then Verify Create Account functionality


    Examples:
      |TestData|deviceName|
      |testdata1|iPhone 12_14.1|