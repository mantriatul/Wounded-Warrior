@Web

Feature: Verify Program Page Functionality

  @Program_TC_01 @program
  Scenario Outline:Verify Program Detail page content (Text, Share and Request info Button ) after Login of Warrior, FSM User
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    And Navigate to Program Page
    Then Verify Program title is visible
    Then verify share and back button on Program page

    Examples:
      |TestData|
      |Testdata2|

  @Program_TC_02 @program
  Scenario Outline:Verify Warrior, FSM User able to view Share and Back button on Program detail page
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    And Navigate to Program Page
    And click on share button
    Then verify success message shown after clicking copy link
    Then click on share button
    And verify search field visible inside share popup
    Then click On back button

    Examples:
      |TestData|
      |Testdata2|

  @Program_TC_03 @program
  Scenario Outline:Verify Warrior, FSM (Sender) User able to view the Shared Program link on his Message list
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    And Navigate to Program Page
    And click on share button
    And click on first user to share the article
    And click on yes button on confirmation popup
    Then verify User navigated to message listing page
    And verify Program name ,date and image visibility
    And Verify Description link on latest message is clickable
    Then send a "test message" in inbox input field

    Examples:
      |TestData|
      |Testdata2|


  @Program_TC_04 @program
  Scenario Outline:Verify after Share of Article with other Warrior, FSM User (Receiver) able to view the Shared Program link on his Message list
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  Secondary User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    And Navigate to Program Page
    And click on share button
    And click on user "Abhinav Srivastava" to share article
    And click on yes button on confirmation popup
    Then verify User navigated to message listing page
    And Logout from the Account
    Then User login to the Wounded Warrior
    And Navigate on messages page
    And click on new message received from the sender id "Example UATWarrior1"
    And verify Program name ,date and image visibility
    And Verify Description link on latest message is clickable
    Then send a "test message" in inbox input field

    Examples:
      |TestData|
      |Testdata2|

  @Program_TC_05 @program
  Scenario Outline:Verify Cancel and Yes button functionality on Share Pop-up when confirmation message will appears
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    And Navigate to Program Page
    And click on share button
    And click on first user to share the article
    Then Click on cancel button
    Then click on first user to share the article
    And click on yes button on confirmation popup
    Then verify User navigated to message listing page
    Examples:
      |TestData|
      |Testdata2|

  @Program_TC_06 @program
  Scenario Outline:Verify Message Counter (Receiver) functionality when a Program link Shared with other Warrior, FSM User
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And clear the new message from message notification field
    And Logout from the Account
    And  Secondary User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    And Navigate to Program Page
    And click on share button
    And click on user "Abhinav Srivastava" to share article
    And click on yes button on confirmation popup
    Then verify User navigated to message listing page
    And Logout from the Account
    Then User login to the Wounded Warrior
    Then Verify message pill got an increment

    Examples:
      |TestData|
      |Testdata2|

  @Program_TC_11 @program
  Scenario Outline:Verify Warrior or FSM User able to view You May Be Interested Section that is visible at the Bottom of the Program Detail Page
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    And Navigate to Program Page
    And Scroll down to You May Be Interested Section
    Then verify arrow button clickable for related items
    Then verify content of Card inside program related item
    Then Navigate to Program page by clicking on its title

    Examples:
      |TestData|
      |Testdata2|


  @Program_TC_12 @program
  Scenario Outline:Verify Warrior, FSM User able to share Program link with People
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    And Navigate to Program Page
    And click on share button
    Then verify success message shown after clicking copy link
    And Navigate on people page
    And Navigate to profile section of first connection
    Then Navigate to Message Input page
    And Send the  program copied link to the user
    Examples:
      |TestData|
      |Testdata2|
