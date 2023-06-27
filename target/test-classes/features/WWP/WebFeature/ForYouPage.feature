@Web

Feature: Verify Default view on For you Page

  @ForYou_Tc01 @foryou
  Scenario Outline: Verify LoggedIn Users Warrior, FSM  default redirection on the For You Page
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    Then user can view the default view

    Examples:
      | TestData  |
      | Testdata2 |

  @ForYou_Tc02 @foryou
  Scenario Outline:Verify For You page contents for LoggedIn Users Warrior and FSM .
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    Then verify homepage header menu are clickable
    And verify homepage banner is visible
    And verify filters are clickable on For You

    Examples:
      | TestData  |
      | Testdata2 |

  @ForYou_Tc03 @foryou
  Scenario Outline:Verify the WWP logo in the top left of the header and it link back Users  to For You Page. .
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And click on the WWP logo


    Examples:
      | TestData  |
      | Testdata2 |


  @ForYou_Tc04 @foryou
  Scenario Outline:Verify LoggedIn Users Warrior, FSM Header Menu options and their redirecation .
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    Then verify homepage header menu are clickable


    Examples:
      | TestData  |
      | Testdata2 |


  @ForYou_Tc05 @foryou
  Scenario Outline:Verify LoggedIn Users Warrior, FSM Banner Image, text and when Users redirected to the For You page..
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    Then verify content on Homepage Banner with username "Abhinav"


    Examples:
      | TestData  |
      | Testdata2 |

  @ForYou_Tc07 @foryou
  Scenario Outline:Verify LoggedIn Users Warrior, FSM Content filters is clickable on the For You Page.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And verify filters are clickable on For You
    Then click on update my interests On For you page

    Examples:
      | TestData  |
      | Testdata2 |


  @ForYou_Tc08 @foryou
  Scenario Outline:Verify LoggedIn Users Warrior, FSM can Filter the content by clicking All Filter option on the For You Page
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    Then Click on show more button
    Then Verify Category Name on ForYou Filters page

    Examples:
      | TestData  |
      | Testdata2 |


  @ForYou_Tc09 @foryou
  Scenario Outline:Verify LoggedIn Users All Filter option display different types of Cards in to a single Category..
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    Then Click on show more button
    Then Verify Category Name on ForYou Filters page
    And Verify Arrow Button clickable if records more than 3
    And Verify Event,Program,Article is clickable on category slider
    And verify Read more link on article is clickable
#    And verify date on the events on for you page




    Examples:
      | TestData  |
      | Testdata2 |


  @ForYou_TC10 @foryou
  Scenario Outline:
  Verify LoggedIn Users Arrow Button option is visible and sliding on the For You Page when all filter applied. .
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    Then Click on show more button
    And Verify Arrow Button clickable if records more than 3
    And Event,Program,Article is visible under category slider
    And click on the card under category




    Examples:
      | TestData  |
      | Testdata2 |

  @ForYou_TC13 @foryou
  Scenario Outline:Verify LoggedIn Users Warrior, FSM Event Cards listing are organized in to a Single Category on Apply of Near Me
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    Then Click on near me filter




    Examples:
      | TestData  |
      | Testdata2 |


  @ForYou_TC20 @foryou
  Scenario Outline:Verify LoggedIn Users Near Me Location filter option by selecting City, State and Range.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    Then Click on near me filter
    And  Enter city "atlanta" in "City" field
    And Enter city "GA" in "State" field
    And Select Range "50" in range field
    Then Click on Apply Button on near me filter
    And Verify Event are visible
    And Navigate to event details page by clicking on event title


    Examples:
      | TestData  |
      | Testdata2 |



  @ForYou_TC21 @foryou
  Scenario Outline:Verify LoggedIn Users City, State and mile Range drop down options and validations on click of apply button
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    Then Click on near me filter
    And Enter city "India" in "City" field
    And Enter city "delhi" in "State" field
    Then Click on Apply Button on near me filter
    And verify 'please adjust filter' showing on
    And click on apply filter without selecting city and state
    And verify range options in range dropdown are "5","10","50","100"



    Examples:
      | TestData  |
      | Testdata2 |


  @ForYou_TC22 @foryou
  Scenario Outline:Verify LoggedIn Users Warrior, FSM,  Near me filter, Rest and Apply button functionality.

    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    Then Click on near me filter
    And  Enter city "jacksonville" in "City" field
    And Enter city "FL" in "State" field
    And Select Range "50" in range field
    Then Click on Apply Button on near me filter
    And verify events displayed as per the search as "FL"
    And Verify Arrow Button clickable if records more than 3
    And Event,Program,Article is visible under category slider
    And click on the card under category



    Examples:
      | TestData  |
      | Testdata2 |


  @ForYou_Tc23 @foryou
  Scenario Outline:  Verify LoggedIn Users Warrior, FSM, Virtual Filter option working on the (For You) Page.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    Then Click on Virtual filter
    And Verify Arrow Button clickable if records more than 3
    And Event,Program,Article is visible under category slider
    And click on the card under category


    Examples:
      | TestData  |
      | Testdata2 |





  @ForYou_Tc24 @foryou
  Scenario Outline:Verify Show More Button is visible when page size is full loaded Cards.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    Then Click on show more button

    Examples:
      | TestData  |
      | Testdata2 |


  @ForYou_Tc25 @foryou
  Scenario Outline:Verify LoggedIn Users Warrior, FSM Update My Interest on the For You page
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    Then click on update my interests On For you page
    Then Verify user can update my interest section
    And Navigate to For You Page
    And click on 'All' Filter on for you page
    Then Click on show more button
    And count the categories present on for you page
    And Navigate To account management page
    And click on view link to Navigate to "My Interests" page
    Then unselect all the checkboxes under benefit and services
    And Navigate to For You Page
    And click on 'All' Filter on for you page
    And Click on show more button
    Then Verify category count got updated after changing my interest page
    And setting the checkboxes under benefits services to default

    Examples:
      | TestData  |
      | Testdata2 |










