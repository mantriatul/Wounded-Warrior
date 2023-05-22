@Web

Feature: Verify Login Page Functionality

  @Login_TC_01
  Scenario Outline: Verify Click functionality for Veterans crisis Help Line
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    When User clicks on veterans crisis helpline number


    Examples:
      |TestData|
      |Testdata1|


  @Login_TC_02
  Scenario Outline: Verify that logo is visible on homepage
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    Then Logo is visible


    Examples:
      |TestData|
      |Testdata1|

  @Login_TC_03
  Scenario Outline: Verify login page text, labels, links and buttons
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    Then Verify login page text, labels, links and buttons


    Examples:
      |TestData|
      |Testdata1|

  @Login_TC_04
  Scenario Outline: Verify the User login Validation with blank fields.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And user clicks on login button
    Then user unable to login with blank field



    Examples:
      |TestData|
      |Testdata1|


  @Login_TC_07
  Scenario Outline: Verify the User login Validation with invalid credentials.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And user clicks on login button with invalid credentials as "ahhsdsdds" and "trrrppp"
    Then user unable to login with invalid credentials



    Examples:
      |TestData|
      |Testdata1|



  @Login_TC_05
  Scenario Outline: Verify that the user is able to Login with valid credentials
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior

    Examples:
      |TestData |
      |Testdata1|

