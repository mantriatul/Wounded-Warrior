@Web

Feature: Verify Service Page Functionality

  @Service_TC_01 @service
  Scenario Outline: Verify Partner Service Detail page content (Text, Share and Request info Button ) after Login
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    And Navigate to Service Page
    Then Verify Service title is visible
    Then verify share and back button on Service page

    Examples:
      |TestData|
      |Testdata2|

  @Service_TC_02 @service
  Scenario Outline: Verify Warrior, FSM User able to view Share and Back button on Partner Service detail page
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    And Navigate to Service Page
    And click on share button
    Then verify success message shown after clicking copy link
    Then click on share button
    And verify search field visible inside share popup
    Then click On back button


    Examples:
      |TestData|
      |Testdata2|

  @Service_TC_03 @service
  Scenario Outline:Verify Warrior, FSM (Sender) User able to view the Shared Partner Service link on his Message list
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    And Navigate to Service Page
    And click on share button
    And click on first user to share the article
    And click on yes button on confirmation popup
    Then verify User navigated to message listing page
    And verify service name ,date and image visibility
    And Verify Description link on latest message is clickable
    Then send a "test message" in inbox input field


    Examples:
      |TestData|
      |Testdata2|


  @Service_TC_04 @service
  Scenario Outline:Verify after Share of Partner Service with other Warrior, FSM User (Receiver) able to view the Shared Partner Service link on his Message list
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  Secondary User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    And Navigate to Service Page
    And click on share button
    And click on user "Abhinav Srivastava" to share article
    And click on yes button on confirmation popup
    Then verify User navigated to message listing page
    And Logout from the Account
    Then User login to the Wounded Warrior
    And Navigate on messages page
    And click on new message received from the sender id "Example UATWarrior1"
    And verify service name ,date and image visibility
    And Verify Description link on latest message is clickable
    Then send a "test message" in inbox input field

    Examples:
      |TestData|
      |Testdata2|

  @Service_TC_05 @service
  Scenario Outline:Verify Cancel and Yes button functionality on Share Pop-up when confirmation message will appears
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    And Navigate to Service Page
    And click on share button
    And click on first user to share the article
    Then Click on cancel button
    Then click on first user to share the article
    And click on yes button on confirmation popup
    Then verify User navigated to message listing page
    Examples:
      |TestData|
      |Testdata2|


  @Service_TC_06 @service
  Scenario Outline:Verify Message Counter functionality when a Partner Service link Shared with other Warrior, FSM User
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And clear the new message from message notification field
    And Logout from the Account
    And  Secondary User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    And Navigate to Service Page
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


  @Service_TC_11 @service
  Scenario Outline:Verify You May Be Interested Section that is visible at the Bottom of the Program Detail Page
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    And Navigate to Service Page
    And Scroll down to You May Be Interested Section
    Then verify arrow button clickable for related items
    Then verify content of Card inside Service related item
    Then Navigate to Service page by clicking on its title

    Examples:
      |TestData|
      |Testdata2|


  @Service_TC_12 @service
  Scenario Outline:Verify Warrior, FSM User able to share Service link with People
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    And Navigate to Service Page
    And click on share button
    Then verify success message shown after clicking copy link
    And Navigate on people page
    And Navigate to profile section of first connection
    Then Navigate to Message Input page
    And Send the  Service copied link to the user
    Examples:
      |TestData|
      |Testdata2|