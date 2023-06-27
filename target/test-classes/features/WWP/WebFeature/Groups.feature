@Web

Feature: Verify Groups Page Functionality

@Group_TC_01 @Group
Scenario Outline: Verify First time LoggedIn User (or Logged In User not Joined any Group) able to view the Groups listing on the page
Given Read the testdata "<TestData>" from excel file
When User navigates to the url
And User login to the Wounded Warrior
And User click on Groups tab
And Check My group exist or not
Then Verify contents on the Groups page


Examples:
|TestData |
|Testdata1|


  @Group_TC_02 @Group
  Scenario Outline: Verify First time Loggedin Warrior , FSM User (or  User has not Joined any Group) able to  view informational text that advises User, how to use the Groups when User is not following a Group
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on Groups tab
    And Check My group exist or not
    Then Verify able to view informational text


    Examples:
      |TestData |
      |Testdata1|

  @Group_TC_03 @Group
  Scenario Outline: Verify First time LoggedIn User(or User has  not Joined any Group) able to view Suggested Group list below the Search Box
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on Groups tab
    And Check My group exist or not
    Then Verify user able to view Suggested Group list below the Search Box
    And click on any listed groups & verify details


    Examples:
      |TestData |
      |Testdata1|



  @Group_TC_04 @Group
  Scenario Outline: Verify LoggedIn User list of available Groups Category wise.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on Groups tab
    And Check My group exist or not
    And Verify groups on "Creative" category
    And Verify groups on "Hobbies" category
    And Verify groups on "Shared Experience" category
   And Verify groups on "Sports & Exercise" category
    And Verify groups on "Regional" category



    Examples:
      |TestData |
      |Testdata1|

  @Group_TC_05 @Group
  Scenario Outline:Verify First time LoggedIn User(or User has  not Joined any Group) able to Join or follow the Group from Suggested List or different Group Category.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on Groups tab
    And Check My group exist or not
    And Search the "Travel" group
    And Follow the group
    Then Verify "Travel" group updated in my group list

    Examples:
      |TestData |
      |Testdata1|

  @Group_TC_07 @Group
  Scenario Outline:Verify Loggedin User Warrior or FSM,  able to view a list of My Followed/Joined Groups under the My Groups Section
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on Groups tab
    Then user is able to see the groups in the my groups tab
    Then user is able to see the activities in the recent tab

    Examples:
      | TestData  |
      | Testdata1 |

  @Group_TC_08 @Group
  Scenario Outline:Verify Loggedin User Warrior or FSM,  able to Create and View the Post on the Joined Group.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on Groups tab
    Then click on the group present in the my groups tab
    Then Verify Post Shared by other User or loggedin user
    And Delete the post
    Examples:
      | TestData  |
      | Testdata1 |

  @Group_TC_09_10 @Group
  Scenario Outline: Verify Loggedin User Warrior or FSM,  able to , Like , Unlike and Add , Edit, Delete the post and comment and Flagging  of the Group post and comments
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on Groups tab
    Then click on the group present in the my groups tab
    Then verify the comment action
    Then verify the flag action
    Then verify the like and unlike action
    Then verify the edit and delete icon

    Examples:
      | TestData  |
      | Testdata1 |

  @Group_TC_06 @Group
  Scenario Outline: Verify LoggedIn User able to Unfollow the User after follow of a Group
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And select "Travel" group in my group list
    And Unfollow the group
    Then Verify unfollow "Travel" group updated in my group list

    Examples:
      |TestData |
      |Testdata1|

  @Group_Tc_11 @Group
  Scenario Outline:Verify loggedin User Warrior or FSM able to view a snapshot of recent discussions from My different Groups.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on Groups tab
    And Check My group exist or not
    And Search the "Books and Reading" group
    And Follow the group
    And click on the Back button
    And click on the All groups
    And Search the "Arts and crafts" group
    And Follow the group
    And click on the Back button
    And click on the All groups
    And Search the "Alaska" group
    And Follow the group
    And click on the Back button
    Then Verify and Check User can select a discussion, which opens the group
    Then Verify and Check User can also select show more
    Then verify the summary cards




    Examples:
      | TestData  |
      | Testdata1 |

  @Group_Tc_12_13 @Group
  Scenario Outline:Verify logged in User Warrior or FSM, able to create post and comment, like, dislike, and flag in group discussion  or post threads  without following  or joining a Group community.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on Groups tab
    And click on the All groups
    And enter the "Adaptive Sports" group name in searchbox and click on submit button
    And click on the first group present in the All groups
    Then verify the comment action
    Then verify the flag action
    Then verify the like and unlike action
    Then verify the edit and delete icon in the all groups

    Examples:
      | TestData  |
      | Testdata1 |

  @Group_TC_14 @Group
  Scenario Outline: Verify LoggedIn User Warrior or FSM,  can add audio-visual content in group discussion threads to participate in the community or Group
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on Groups tab
    And click on the All groups
    And enter the "Adaptive Sports" group name in searchbox and click on submit button
    And click on the first group present in the All groups
    And click on the create post
    Then Image should be uploaded in group
    And click on the create post
    Then Verify image should not be uploaded when image size exceed to 1MB

    Examples:
      |TestData |
      |Testdata1|

  @Group_Tc_15 @Group
  Scenario Outline:Verify Loggedin User Warrior, FSM, or Teammate, able to flag and report inappropriate content to maintain the guidelines of the Community areas.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on Groups tab
    And click on the All groups
    And enter the "Adaptive Sports" group name in searchbox and click on submit button
    And click on the first group present in the All groups
    Then click on the flag action
    Then click on the radio button
    Then enter the "this is not a valid comment" in the textarea
    Then click on the "Submit" button
    Then verifies the success message


    Examples:
      | TestData  |
      | Testdata1 |

  @Group_Tc_20 @Group
  Scenario Outline:Verify Warrior, FSM User able to share Group Card with People
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on Groups tab
    And click on the All groups
    And enter the "Adaptive Sports" group name in searchbox and click on submit button
    And click on the first group present in the All groups
    Then click on the share button
    Then verifies the copy link
    Then  search "Example UATWarrior1" and view the suggested people list
    Then click on the Back and verifies the group page

    Examples:
      | TestData  |
      | Testdata1 |

  @Group_Tc_21 @Group
  Scenario Outline:  Verify Warrior, FSM (Sender) User able to view the Group Card on his Message list
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on Groups tab
    And click on the All groups
    And enter the "Adaptive Sports" group name in searchbox and click on submit button
    And click on the first group present in the All groups
    And click on the share button
    And click on user "Example UATWarrior1" to share Group card
    And click on yes button on confirmation popup
    Then verifies the details

    Examples:
      | TestData  |
      | Testdata1 |

  @Group_Tc_22_24 @Group
  Scenario Outline:  Verify after Share of Article with other Warrior, FSM User (Receiver) able to view the Shared Article link on his Message list and message counter functionality
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And Secondary User login to the Wounded Warrior
    And User click on Groups tab
    And click on the All groups
    And enter the "Adaptive Sports" group name in searchbox and click on submit button
    And click on the first group present in the All groups
    And click on the share button
    And click on user "Vaishali Tomar" to share Group card
    And click on yes button on confirmation popup
    And Logout from the Account
    And User login to the Wounded Warrior
    Then verify that message count is visible on the message icon
    And user click on the "Messages" icon
    Then verify the unread messages is present
    And click on new message received from the sender id "Example UATWarrior1"
    Then verifies the details

    Examples:
      | TestData  |
      | Testdata1 |

  @Group_Tc_23 @Group
  Scenario Outline: Verify Cancel and Yes button functionality on Share Pop-up when confirmation message will appears
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on Groups tab
    And click on the All groups
    And enter the "Adaptive Sports" group name in searchbox and click on submit button
    And click on the first group present in the All groups
    And click on the share button
    And click on user "Example UATWarrior1" to share Group card
    And Click on cancel button
    And click on user "Example UATWarrior1" to share Group card
    And click on yes button on confirmation popup
    Then verifies the details

    Examples:
      | TestData  |
      | Testdata1 |

  @Group_Tc_25 @Group
  Scenario Outline: Verify Warrior, FSM User able to share Group link with People
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on Groups tab
    And click on the All groups
    And enter the "Adaptive Sports" group name in searchbox and click on submit button
    And click on the first group present in the All groups
    And click on the share button
    Then verify success message shown after clicking copy link
    And Navigate on people page
    And Navigate to profile section of first connection
    Then Navigate to Message Input page
    And Send the copied link to the other user

    Examples:
      | TestData  |
      | Testdata1 |

  @Group_Tc_26 @Group
  Scenario Outline: Verify Warrior, FSM User able to share Group link with People
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    And User click on Groups tab
    And click on the All groups
    And enter the "Adaptive Sports" group name in searchbox and click on submit button
    And click on the first group present in the All groups
    And Scroll down to Related events
    Then verify arrow button clickable for related items
    And verify content of group card inside related item
    And Navigate to article page by clicking on its title


    Examples:
      | TestData  |
      | Testdata1 |


