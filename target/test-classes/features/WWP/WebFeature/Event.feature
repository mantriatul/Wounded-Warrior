@Web

Feature: Verify Event Page Functionality

  @EventTc_02 @Event
  Scenario Outline:Verify Warrior, FSM User can view Event Cards displays under the each Category.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    Then Verify event cards details


    Examples:
      |TestData |
      |TestData1|


  @EventTc_03 @Event
  Scenario Outline: Verify Event Cards and Event title redirection when Warrior, FSM User click on Event Card or title
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    Then Verify Event card title is clickable


    Examples:
      |TestData |
      |TestData1|

  @EventTc_04
  Scenario Outline:Verify Warrior , FSM User can view the Event Details page contents such as Event Date, Time, Register to Join Button and related Event Gallary.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And Verify Event card title is clickable
    And Verify Event Details page Contents such as Event Date, Time, Register Buttons and related Event

    Examples:
      |TestData |
      |TestData1|


  @EventTc_05 @Event
  Scenario Outline: Verify Event detail page Share and Back button functionality.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And Verify Event card title is clickable
    And click on the share button
    Then verifies the copy link
    Then  search "Example UATWarrior1" and view the suggested people list
    Then click on the Back and verifies the foryou page


    Examples:
      |TestData |
      |TestData1|

  @EventTc_06 @Event
  Scenario Outline:Verify Warrior, FSM (Sender) User able to view the Shared Event link on his Message list
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And Verify Event card title is clickable
    And click on the share button
    And click on user "Example UATWarrior1" to share Event card
    And click on yes button on confirmation popup
    Then verifies the Event details
    And send a "test Message" in inbox input field


    Examples:
      |TestData |
      |TestData1|

  @EventTc_07_09 @Event
  Scenario Outline:Verify after Share of Article with other Warrior, FSM User (Receiver) able to view the Shared Event link on his Message list
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And Secondary User login to the Wounded Warrior
    And Verify Event card title is clickable
    And click on the share button
    And click on user "Vaishali Tomar" to share Event card
    And click on yes button on confirmation popup
    And Logout from the Account
    And User login to the Wounded Warrior
    Then verify that message count is visible on the message icon
    And user click on the "Messages" icon
    Then verify the unread messages is present
    And click on new message received from the sender id "Example UATWarrior1"
    Then verifies the Event details
    And send a "test Message" in inbox input field


    Examples:
      |TestData |
      |TestData1|

  @EventTc_08 @Event
  Scenario Outline:Verify Cancel and Yes button functionality on Share Pop-up when confirmation message will appears
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And Verify Event card title is clickable
    And click on the share button
    And click on user "Example UATWarrior1" to share Event card
    And Click on cancel button
    And click on user "Example UATWarrior1" to share Event card
    And click on yes button on confirmation popup
    Then verifies the Event details

    Examples:
      |TestData |
      |TestData1|

  @EventTc_41 @Event
  Scenario Outline:Verify Warrior,FSM User able to share Event link with People
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And Verify Event card title is clickable
    And click on the share button
    Then verify success message shown after clicking copy link
    And Navigate on people page
    And Navigate to profile section of first connection
    Then Navigate to Message Input page
    And Send the copied link to the other user

    Examples:
      |TestData |
      |TestData1|