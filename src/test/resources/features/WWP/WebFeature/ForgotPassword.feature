@Web

Feature: Verify Forgot Password Functionality

  @ForgotPassword_Tc_01
  Scenario Outline: Verify Warrior User able to view the Forgot Password link on Login Page.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User click on Forgot Password


    Examples:
      |TestData|
      |Testdata1|


  @ForgotPassword_Tc_02
  Scenario Outline: Verify Forgot Password validation with Warrior User on blank of Email/ Username field
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User click on Forgot Password
    And User click on Reset Button
    Then verify "Email/Username" is required

    Examples:
      |TestData|
      |Testdata1|

  @ForgotPassword_Tc_03
  Scenario Outline:  Verify Warrior User can opt forgot Password help using Email.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User click on Forgot Password
    And user enter "Email/Username" as "vaishali.tomar@testingxperts.com"
    And User click on Reset Button and verify


    Examples:
      |TestData|
      |Testdata1|


  @ForgotPassword_Tc_04_06
  Scenario Outline: Verify reset Password link & Choose Password fields for forgot password
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User click on Forgot Password
    And user enter "Email/Username" as "vaishali.tomar@testingxperts.com"
    And User click on Reset Button and verify
    And Open to the outlook and Get URL to reset password
    Then Click on Reset the password & Verify the fields

    Examples:
      |TestData|
      |Testdata1|

  @ForgotPassword_Tc_07
  Scenario Outline: Verify Term, Condition and Privacy Policy Links is Clickable on Choose Password page
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User click on Forgot Password
    And user enter "Email/Username" as "vaishali.tomar@testingxperts.com"
    And User click on Reset Button and verify
    And Open to the outlook and Get URL to reset password
    Then Verify Privacy policy & term & conditions fields
    Examples:
      |TestData|
      |Testdata1|

  @ForgotPassword_Tc_08091011
  Scenario Outline: Verify password created successfully when password and retype password is correct and same.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User click on Forgot Password
    And user enter "Email/Username" as "vaishali.tomar@testingxperts.com"
    And User click on Reset Button and verify
    And Open to the outlook and Get URL to reset password
    Then Verify password created successfully
    And Launch the Home page
    And Logout the user
    And User login to the Wounded Warrior

    Examples:
      |TestData|
      |Testdata1|







