@Web

Feature: Verify Article Page Functionality

  @Article_TC01 @article
  Scenario Outline: Verify Article Detail page content (Text, Share and Request info Button )
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    Then Navigate to Article page
    And verify article title,image or video
    And verify share and back button on article page


    Examples:
      |TestData|
      |Testdata2|


  @Article_TC02 @article
  Scenario Outline:Verify Partner Article detail page Share and Back button functionality.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    Then Navigate to Article page
    And click on share button
    Then verify success message shown after clicking copy link
    Then click on share button
    And verify search field visible inside share popup
    Then click On back button


    Examples:
      |TestData|
      |Testdata2|



  @Article_TC03 @article
  Scenario Outline:Verify User able to view the Article link on his Message list
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    Then Navigate to Story Article page
    And click on share button
    And click on first user to share the article
    And click on yes button on confirmation popup
    Then verify User navigated to message listing page
    And verify article name ,date and image visibility
    And Verify Read more link on latest message is clickable
    Then send a "test message" in inbox input field



    Examples:
      |TestData|
      |Testdata2|

  @Article_TC04 @article
  Scenario Outline:Verify after Share of Article with other Warrior able to view the Shared Article link on his Message list .
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  Secondary User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    Then Navigate to Story Article page
    And click on share button
    And click on user "Abhinav Srivastava" to share article
    And click on yes button on confirmation popup
    Then verify User navigated to message listing page
    And Logout from the Account
    Then User login to the Wounded Warrior
    And Navigate on messages page
    And click on new message received from the sender id "Example UATWarrior1"
    And verify article name ,date and image visibility
    And Verify Read more link on latest message is clickable
    Then send a "test message" in inbox input field


    Examples:
      |TestData|
      |Testdata2|





  @Article_TC05 @article
  Scenario Outline:Verify Cancel and Yes button functionality on Share Pop-up when confirmation message will appears.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    Then Navigate to Story Article page
    And click on share button
    And click on first user to share the article
    Then Click on cancel button
    Then click on first user to share the article
    And click on yes button on confirmation popup
    Then verify User navigated to message listing page

    Examples:
      |TestData|
      |Testdata2|

  @Article_TC06 @article
  Scenario Outline:Verify Message Counter functionality when a Partner Service Shared with other Warrior, FSM User
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And clear the new message from message notification field
    And Logout from the Account
    And  Secondary User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    Then Navigate to Story Article page
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







  @Article_TC07 @article
  Scenario Outline:Verify You May Be Interested Section that is visible at the Bottom of the Article.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    Then Navigate to Story Article page
    And Scroll down to Related events
    Then verify arrow button clickable for related items
    Then verify content of card article inside related item
    Then Navigate to article page by clicking on its title

    Examples:
      |TestData|
      |Testdata2|


  @Article_TC08 @article
  Scenario Outline:Verify Read More Link on the Article Cards.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    Then Navigate to Story Article page
    And verify article title,image or video
    And verify share and back button on article page

    Examples:
      |TestData|
      |Testdata2|

  @Article_TC09 @article
  Scenario Outline:Verify Warrior, FSM User able to share Article  link with People .
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And click on 'All' Filter on for you page
    Then Navigate to Story Article page
    And click on share button
    Then verify success message shown after clicking copy link
    And Navigate on people page
    And Navigate to profile section of first connection
    Then Navigate to Message Input page
    And Send the copied link to the user

    Examples:
      |TestData|
      |Testdata2|