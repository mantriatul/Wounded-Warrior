@Web

Feature: Verify Default view on For you Page

  @ForYou_Tc01
  Scenario Outline: Verify the Default view on For you Page
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And user enters "Email/Username" as "abhinav.srivastava@testingxperts.com"
    And user enters "Password" as "Testing@123"
    And user clicks on login button
    Then user can view the default view

    Examples:
      | TestData  |
      | Testdata1 |

  @ForYou_Tc02
  Scenario Outline: Verify For You page contents when User login and redirected to the For You page.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And user enters "Email/Username" as "abhinav.srivastava@testingxperts.com"
    And user enters "Password" as "Testing@123"
    And user clicks on login button
    Then verify homepage header menu are clickable
    And verify homepage banner is visible
    And verify filters are clickable on For You

    Examples:
      | TestData  |
      | Testdata1 |

  @ForYou_Tc03
  Scenario Outline: Verify For Your Header Menu options when User login and redirected to the For You page.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And user enters "Email/Username" as "abhinav.srivastava@testingxperts.com"
    And user enters "Password" as "Testing@123"
    And user clicks on login button
    Then verify homepage header menu are clickable


    Examples:
      | TestData  |
      | Testdata1 |


  @ForYou_Tc04
  Scenario Outline:Verify For You Banner when User login and redirected to the For You page.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And user enters "Email/Username" as "abhinav.srivastava@testingxperts.com"
    And user enters "Password" as "Testing@123"
    And user clicks on login button
    Then verify content on Homepage Banner with username "Abhinav"


    Examples:
      | TestData  |
      | Testdata1 |
