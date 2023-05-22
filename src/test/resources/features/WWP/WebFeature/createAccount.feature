@Web

Feature: Verify Create Account Functionality

  @CreateAccount_Tc_01
  Scenario Outline: Verify the Create Account Link on the Login Page of WDX
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User click on create account


    Examples:
      |TestData|
      |Testdata1|


  @CreateAccount_Tc_02
  Scenario Outline: Verify the Create Account Link on the Login Page of WDX
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User click on create account
    And Verify create account fields
    And user enter "First name" as "abhinav"
    And user enter "Email" as "abhinav75812@gmail.com"
    And User clicks on continue button
    Then verify "Last name" is required



    Examples:
      |TestData|
      |Testdata1|