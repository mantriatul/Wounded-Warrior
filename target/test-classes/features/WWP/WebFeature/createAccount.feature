@Web

Feature: Verify Create Account Functionality

  @CreateAccount_Tc_01 @CreateAccount
  Scenario Outline: Verify the Create Account Link on the Login Page of WDX
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User click on create account


    Examples:
      |TestData|
      |Testdata1|


  @CreateAccount_Tc_02 @CreateAccount
  Scenario Outline: Verify Create Account fields for Warrior, FSM, or Teammate
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


  @CreateAccount_Tc_03
  Scenario Outline:Verify the Create (Link) Account functionality for Warriors, Teammates Users by filling required details on WDX.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User click on create account
    And user enter "First name" as "vaishali"
    And user enter "Last name" as "Tomar"
    And user enter "Email" as "vaishali.tomar@testingxperts.com"
    And User clicks on continue button and verify

    Examples:
      |TestData|
      |Testdata1|

  @CreateAccount_Tc_12_14
  Scenario Outline: Verify Choose Password fields for (Create Link) Account
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User click on create account
    And user enter "First name" as "vaishali"
    And user enter "Last name" as "Tomar"
    And user enter "Email" as "vaishali.tomar@testingxperts.com"
    And User clicks on continue button and verify
    And Open to the outlook and Get URL to reset password
    Then Click on Reset the password & Verify the fields

    Examples:
      |TestData|
      |Testdata1|

  @CreateAccount_Tc_15
  Scenario Outline: Verify Term, Condition and Privacy Policy Links is Clickable on Choose Password page
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User click on create account
    And user enter "First name" as "vaishali"
    And user enter "Last name" as "Tomar"
    And user enter "Email" as "vaishali.tomar@testingxperts.com"
    And User clicks on continue button and verify
    And Open to the outlook and Get URL to reset password
    Then Verify Privacy policy & term & conditions fields
    Examples:
      |TestData|
      |Testdata1|

  @CreateAccount_Tc_161718
  Scenario Outline: Verify password created successfully when password and retype password is correct and same.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User click on create account
    And user enter "First name" as "vaishali"
    And user enter "Last name" as "Tomar"
    And user enter "Email" as "vaishali.tomar@testingxperts.com"
    And User clicks on continue button and verify
    And Open to the outlook and Get URL to reset password
    Then Verify password created successfully
    And Launch the Home page

    Examples:
      |TestData|
      |Testdata1|



  @CreateAccount_Tc_19
  Scenario Outline:Verify Continue to Homepage Button functionality when the Warriors, FSM and Teammates User click on Continue to Homepage Button
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User click on create account
    And user enter "First name" as "raj"
    And user enter "Last name" as "singh"
    And user enter "Email" as "tesing@gmail.com"
    And User clicks on continue button
    Then verify error msg when user is not registered in wwp

    Examples:
      |TestData|
      |Testdata1|
