@Web

Feature: Verify messages functionality

  @Messages_01 @messages
  Scenario Outline: Verify Logged in User Warrior or FSM,  can browse a summarized list of all past message threads  to respond quickly by clicking on it
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And user click on the "Messages" icon
    Then user is able to see the list of messages
    Then Verify on Click of message user should redirect to the respective page of user profile


    Examples:
      | TestData  |
      | Testdata1 |

  @Messages_02 @messages
  Scenario Outline: Verify LoggedIn User Warrior or FSM, can search past messages by keyword that may appear in the body of the message, or by name of sender/recipient of the message
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And user click on the "Messages" icon
    Then verify the search functionality of messages
    Then Verify Search does not include the body of messages to the resource center


    Examples:
      | TestData  |
      | Testdata1 |


  @Messages_03 @messages
  Scenario Outline: Verify Logged in User Warrior or FSM,  can browse a summarized list of all past message threads  to respond quickly by clicking on it
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And user click on the "Messages" icon
    And user click on the new message button
    Then user is able to send the list of all the connections
    Then user is able to send the message to multiple connections



    Examples:
      | TestData  |
      | Testdata1 |

  @Messages_05 @messages

  Scenario Outline: Verify Logged In User Warrior or FSM,  can receive a notification of a new message when user not actively using  the WDX
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
   And Secondary User login to the Wounded Warrior
    And user click on the "Messages" icon
    And user can able to send a message to different user
    And Logout from the Account
    And User login to the Wounded Warrior
    Then verify that notification  count is visible on the notification icon
    And user click on the "Notifications" icon
    Then verify the unread notifications

    Examples:
      | TestData  |
      | Testdata1 |

  @Messages_04 @messages

  Scenario Outline: Verify Logged in User Warrior or FSM, can view unread messages and new message that user need to respond.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    Then verify that message count is visible on the message icon
    And user click on the "Messages" icon
    Then verify the unread messages is present and click on the unread messages
    Examples:
      | TestData  |
      | Testdata1 |



  @Messages_06 @messages
  Scenario Outline:Verify Logged in User  Warrior or FSM,  able to flag a direct

    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And user click on the "Messages" icon
    Then verifies the flag functionality




    Examples:
      | TestData  |
      | Testdata1 |