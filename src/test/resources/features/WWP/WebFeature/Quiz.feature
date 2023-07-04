@Web

Feature: Verify Quiz Page Functionality

  @Quiz_TC_01 @Quiz
  Scenario Outline: Verify the Welcome Page content for the users Warrior, FSM when they log in for the first time.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    Then Verify contents on the Quiz page


    Examples:
      |TestData |
      |Testdata1|

  @Quiz_TC_02 @Quiz1
  Scenario Outline:Verify the Call Help Line number is clickable on Welcome page, for the users Warrior and FSM
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    Then User clicks on veterans crisis helpline number on Quiz page


    Examples:
      |TestData |
      |Testdata1|

  @Quiz_TC_03 @Quiz
  Scenario Outline: Verify Quiz Get Started Button functionality by Clicking on it.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    Then Verify On Click of Get Started Button A first Quiz should appears
    And  Verify Quiz Title,back button & page counting
    And Verify Skip this Questions Button is Clickable and hiding Questions
    And User click on back button
    And Select "Getting outside" from "Connection" page
    And Select "Gaming" from "Connection" page


    Examples:
      |TestData |
      |Testdata1|

  @Quiz_TC_04 @Quiz
  Scenario Outline: Verify Logged in Users Warriors or FSMs First Quiz (Connection) options when User Click on Get Started Button
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    Then Verify On Click of Get Started Button A first Quiz should appears
    And  Verify Quiz Title,back button & page counting
    And Verify Skip this Questions Button is Clickable and hiding Questions
    And User click on back button
    And Select "Getting outside" from "Connection" page
    And Select "Sporting events" from "Connection" page
    And Select "Family activities" from "Connection" page
    And Select "Entertainment" from "Connection" page
    And Select "Gaming" from "Connection" page
    And Verify Continue Button Clickable on Click of it open next Quiz


    Examples:
      |TestData |
      |Testdata1|

  @Quiz_TC_05 @Quiz
  Scenario Outline: Verify Logged in Users Warriors or FSMs, Second Quiz (Benefits of Services)options when user Click on Continue Button
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    Then Verify On Click of Get Started Button A first Quiz should appears
    And Skip "First Quiz" activites
    And Verify Skip this Questions Button is Clickable and hiding Questions
    And User click on back button
    And Select "Understand my available benefits" from "Benefits Services" page
    And Select "Apply for VA benefits and file claims" from "Benefits Services" page
    And Verify Continue Button Clickable on Click of it open next Quiz


    Examples:
      |TestData |
      |Testdata1|

  @Quiz_TC_06 @Quiz
  Scenario Outline: Verify Logged in Users Warriors or FSMs, Third Quiz (Finance & Employment) option when User Click on Continue Button
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    Then Verify On Click of Get Started Button A first Quiz should appears
    And Skip "First Quiz" activites
    And Skip "Second Quiz" activites
    And Verify Skip this Questions Button is Clickable and hiding Questions
    And User click on back button
    And Select "Find a job" from "Employment and Financial Wellness" page
    And Select "Prepare for job interviews and update resume" from "Employment and Financial Wellness" page
    And Select "Get career counseling" from "Employment and Financial Wellness" page
    And Select "Better manage my money" from "Employment and Financial Wellness" page
    And Verify Continue Button Clickable on Click of it open next Quiz


    Examples:
      |TestData |
      |Testdata1|

  @Quiz_TC_07 @Quiz
  Scenario Outline: Verify Logged in Users Warriors or FSMs, Fourth Quiz (Mental Health) options when User click on Continue Button
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    Then Verify On Click of Get Started Button A first Quiz should appears
    And Skip "First Quiz" activites
    And Skip "Second Quiz" activites
    And Skip "Third Quiz" activites
    And Verify Skip this Questions Button is Clickable and hiding Questions
    And User click on back button
    And Select "Reduce stress and anxiety" from "Mental and Brain Health" page
    And Select "Manage traumatic brain injury" from "Mental and Brain Health" page
    And Select "Talk to someone" from "Mental and Brain Health" page
    And Select "Work on my relationship skills" from "Mental and Brain Health" page
    And Select "Stay present and mindful" from "Mental and Brain Health" page
    And Verify Continue Button Clickable on Click of it open next Quiz


    Examples:
      |TestData |
      |Testdata1|

  @Quiz_TC_08 @Quiz
  Scenario Outline: Verify Logged in Users Warriors or FSMs, Fifth Quiz (Physical  Health & Wellness) options when it appears on Click of Continue Button
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    Then Verify On Click of Get Started Button A first Quiz should appears
    And Skip "First Quiz" activites
    And Skip "Second Quiz" activites
    And Skip "Third Quiz" activites
    And Skip "Fourth Quiz" activites
    And Select "Eat healthier" from "Physical Health and Wellness" page
    And Select "Sleep better" from "Physical Health and Wellness" page
    And Select "Start exercising and improve fitness" from "Physical Health and Wellness" page
    And Select "Get personalized coaching" from "Physical Health and Wellness" page
    And Verify Continue Button Clickable on Click of it open next Quiz


    Examples:
      |TestData |
      |Testdata1|

  @Quiz_TC_0910 @Quiz
  Scenario Outline: Verify Logged in Users Warriors or FSMs Privacy Setting (Preferences) for first time logged in User and Verify Success message after Privacy Setting (Preferences) for first time logged in Users Warriors or FSMs
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    Then Verify On Click of Get Started Button A first Quiz should appears
    And  Verify Quiz Title,back button & page counting
    And Select "Getting outside" from "Connection" page
    And Select "Sporting events" from "Connection" page
    And Select "Family activities" from "Connection" page
    And Select "Entertainment" from "Connection" page
    And Select "New hobbies" from "Connection" page
    And Select "Gaming" from "Connection" page
    And Select "Couples and date nights" from "Connection" page
    And Select "Joining a peer support group" from "Connection" page
    And Verify Continue Button Clickable on Click of it open next Quiz
    And Select "Understand my available benefits" from "Benefits Services" page
    And Select "Apply for VA benefits and file claims" from "Benefits Services" page
    And Verify Continue Button Clickable on Click of it open next Quiz
    And Select "Find a job" from "Employment and Financial Wellness" page
    And Select "Prepare for job interviews and update resume" from "Employment and Financial Wellness" page
    And Select "Get career counseling" from "Employment and Financial Wellness" page
    And Select "Better manage my money" from "Employment and Financial Wellness" page
    And Verify Continue Button Clickable on Click of it open next Quiz
    And Select "Reduce stress and anxiety" from "Mental and Brain Health" page
    And Select "Manage traumatic brain injury" from "Mental and Brain Health" page
    And Select "Talk to someone" from "Mental and Brain Health" page
    And Select "Work on my relationship skills" from "Mental and Brain Health" page
    And Select "Stay present and mindful" from "Mental and Brain Health" page
    And Verify Continue Button Clickable on Click of it open next Quiz
    And Select "Eat healthier" from "Physical Health and Wellness" page
    And Select "Sleep better" from "Physical Health and Wellness" page
    And Select "Start exercising and improve fitness" from "Physical Health and Wellness" page
    And Select "Get personalized coaching" from "Physical Health and Wellness" page
    And Verify Continue Button Clickable on Click of it open next Quiz
    Then Verify Privacy setting content
    And set Privacy setting as "Go private"
    And set Privacy setting as "Stay visible"
    And click on continue button after updating privacy setting

    


    Examples:
      |TestData |
      |Testdata1|

  @Quiz_TC_11 @Quiz
  Scenario Outline: Verify Continue to Home Page Button functionality after the Quiz answer and Privacy Setting for the loggedin  Users Warriors or FSMs
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    Then Verify contents on the Quiz page
    And click on skip all the question
    And set Privacy setting as "Stay visible"
    And click on continue button after updating privacy setting
    And click on Homepage
    And user can view the default view



    Examples:
      |TestData |
      |Testdata1|

  @Quiz_TC_12 @Quiz
  Scenario Outline: Verify programs, events and services visibility for Logged in Users Warriors or FSMs when any Quiz question skipped or all Quiz questions skipped.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    Then Verify contents on the Quiz page
    And click on skip all the question
    And set Privacy setting as "Stay visible"
    And click on continue button after updating privacy setting
    And click on Homepage
    And user can view the default view
    And click on 'All' Filter on for you page
    Then Click on show more button
    And Check the categories present on for you page



    Examples:
      |TestData |
      |Testdata1|

  @Quiz_TC_13 @Quiz
  Scenario Outline: Verify Logged in Users Warriors or FSMs , profile should not be visible in Community when profile setting is private and User cannot be searched by any other user.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    Then Verify contents on the Quiz page
    And click on skip all the question
    And set Privacy setting as "Go private"
    And click on continue button after updating privacy setting
    And click on Homepage
    And user can view the default view
    And User click on Groups tab
    And Private users will see a banner on the Groups page notifying them that their privacy settings reduce their ability to interact with Groups and discussions
    And Logout from the Account
    And Secondary User login to the Wounded Warrior
    And User click on People tab
    And Private users will not show up in People searches
    And Logout from the Account
    And User login to the Wounded Warrior
    And Go to the Account
    And User set privacy status as "visible"




    Examples:
      |TestData |
      |Testdata1|