@Web

Feature: Verify People Page Functionality

  @People_TC_01 @People
  Scenario Outline: Verify People Page Contents
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on People tab
    Then Verify contents on the people page


    Examples:
      |TestData |
      |Testdata3|

  @People_TC_02 @People
  Scenario Outline: Verify Informational text reads on People page.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on People tab
    Then Verify Informational text on People page


    Examples:
      |TestData |
      |Testdata3|

  @People_TC_03 @People
  Scenario Outline: Verify First time LoggedIn User (logged in user does not have connection) able to view Add(1), Connect(2), Chat (3) instructions and suggested connections should visible
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on People tab
    Then Verify instructions and suggested connections should visible


    Examples:
      |TestData |
      |Testdata3|

  @People_TC__06_07 @People
  Scenario Outline: Verify Logged in Warrior, FSM, or Teammate, can see the  suggested connection list of Warriors and Family Support Members only
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on People tab
    Then Verify People list includes Warriors and FSMs

    Examples:
      |TestData |
      |Testdata3|

  @People_TC_08 @People
  Scenario Outline:Verify Logged in Warrior or FSM, can see a list of my Connections , message them or see their information    Given Read the testdata "<TestData>" from excel file
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on People tab
    Then Verify user can able to view list of My Connections
    And Verify user can view details in My Connections list

    Examples:
      |TestData |
      |Testdata1|

  @People_TC_09 @People
  Scenario Outline:Verify logged in  Warrior, FSM, or Teammate find a specific person Warrior or FSM and connect with them
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on People tab
    Then Verify User should be able to search all other warriors and FSM
    And Verify the recent searches will be recommended in the search dropdown after search of any text
    And Verify Search match should be work on all potential First name and Last name

    Examples:
      |TestData |
      |Testdata1|

  @People_TC_11 @People
  Scenario Outline:Verify LoggedIn Warrior, FSM, or Teammate, can filter the list of People and find the people who I may know or who may have something in common with me.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on People tab
    Then Verify the visibility of filters  on the My Connections and Suggested For You sections, as well as Search Results
    And Verify Location option includes a list of US states
    And Verify user can apply Location filter in My connection
    And Verify user can apply Military Branch filter in suggested for you
    And Verify user can apply Location filter in Suggested for you

    Examples:
      |TestData |
      |Testdata3|

  @People_TC_12 @People
  Scenario Outline:Verify Loggedin user, can view an individual’s profile  and can see more about them and connect with them.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on People tab
    Then select profile picture in the list to view the Warrior Profile and verify profile details

    Examples:
      |TestData |
      |Testdata3|

  @People_TC_13_16 @People
  Scenario Outline:Verify Loggedin Warrior or FSM, can request to add another warrior or FSM as my connection  can communicate with them via Messaging and also check the pending connections
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on People tab
    And Verify user can able to remove the connection
    And user click on the "Messages" icon
    And Search the user
    And Verify once a connection is removed, users can still see any historical messages from before the connection removal, but cannot draft a new message to the removed connection
    And User click on People tab
    And Verify can able to connect with other user
    And Logout from the Account
    And Secondary User login to the Wounded Warrior
    Then verify that notification  count is visible on the notification icon
    And user click on the "Notifications" icon
   Then verify the connection request notifications
    And User click on People tab
    And "Approve" the "Vaishali" request
    And Verify connected individuals can then message each other from the My Connections list view or the Profile view


    Examples:
      |TestData |
      |Testdata1|

  @People_TC_14 @People
  Scenario Outline:Verify Logged in User  Warrior or FSM, can easily view any pending Connection requests and accept or reject them in order to curate my list of Connections
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on People tab
    And Verify can able to connect with other user
    And Logout from the Account
    And Secondary User login to the Wounded Warrior
    And User click on People tab
    Then Verify User first,last name and user profile picture
    And Verify Call to actions for Approve and Deny
    And "Approve" the "Vaishali" request

    Examples:
      |TestData |
      |Testdata1|

  @People_TC_15 @People
  Scenario Outline:Verify Logged in User  Warrior or FSM, can see the View All link for pending request when more than 3 request
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on People tab
    And Verify can able to connect with other user
    And Logout from the Account
    And user enters the emailaddress as "example.uat2@warrior.com"
    And user enters the password as "ExampleUat1!"
    And user clicks on the signin button
    And User click on People tab
    And Verify can able to connect with other user
    And Logout from the Account
    And user enters the emailaddress as "example.uat3@warrior.com"
    And user enters the password as "ExampleUat1!"
    And user clicks on the signin button
    And User click on People tab
    And Verify can able to connect with other user
    And Logout from the Account
    And user enters the emailaddress as "abhinav.srivastava@testingxperts.com"
    And user enters the password as "Testing@123"
    And user clicks on the signin button
    And User click on People tab
    And Verify can able to connect with other user
    And Logout from the Account
    And Secondary User login to the Wounded Warrior
    And User click on People tab
    Then Verify view all link is visible when more than 3 request pending
    And "Approve" the "Vaishali" request
    And "Approve" the "Abhinav" request
    And "Deny" the "UATWarrior2" request
    And "Deny" the "UATWarrior3" request


    Examples:
      |TestData |
      |Testdata1|

  @People_TC_17 @People
  Scenario Outline:Verify LoggedIn User  Warrior, FSM can send message another individual that connected with User and can start a conversation with them.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And Secondary User login to the Wounded Warrior
    And User click on People tab
    Then Verify user can initiate the message from the My Connections list view or the Profile view
    And Logout from the Account
    And User login to the Wounded Warrior
    Then verify that notification  count is visible on the notification icon
    And user click on the "Notifications" icon
    And verify the connection request notifications
    And verify that message count is visible on the message icon
    And user click on the "Messages" icon
    Then verify the unread messages is present and click on the unread messages

    Examples:
      |TestData |
      |Testdata1|


  @People_TC_18 @People
  Scenario Outline:Verify LoggedIn User  Warrior or FSM, access when user set his privacy status as Private.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
   And Go to the Account
    And User set privacy status as "private"
    And User click on Groups tab
    And Private users will see a banner on the Groups page notifying them that their privacy settings reduce their ability to interact with Groups and discussions
   And Logout from the Account
    And Secondary User login to the Wounded Warrior
    And User click on People tab
    And Private users will not show up in People searches
    And Logout from the Account
    And User login to the Wounded Warrior
    And User click on People tab
   And Verify connected individuals can then message each other from the My Connections list view or the Profile view
   And User click on People tab
    And Verify user can able to remove the connection
    And Private users will not able to send connection request
    And Go to the Account
    And User set privacy status as "visible"
    And User click on People tab
    And Verify can able to connect with other user
    And Logout from the Account
    And Secondary User login to the Wounded Warrior
    And User click on People tab
    And "Approve" the "Vaishali" request



    Examples:
      |TestData |
      |Testdata1|


  @People_TC_19 @People
  Scenario Outline:Verify LoggedIn User  Warrior, FSM can send message another individual that connected with User and can start a conversation with them.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on People tab
    Then Verify Show More Button functionality on People page


    Examples:
      |TestData |
      |Testdata3|










