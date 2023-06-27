@Web

Feature: Verify Account Page Functionality

  @Account_management_TC01_06  @account
  Scenario Outline: Verify User can update initial quiz entries using my interest section
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And Navigate To account management page
    And click on view link to Navigate to "My Interests" page
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
      |TestData|
      |Testdata2|


  @Account_management_TC02  @account
  Scenario Outline: Verify Logged-in User can view statistics and a list of prior programs and events.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And Navigate To account management page
    And click on view link to Navigate to "My Events" page
    Then Verify categories available on events page


    Examples:
      |TestData|
      |Testdata2|

  @Account_management_TC03  @account
  Scenario Outline:Verify Logged in User can edit my personal contact information to keep WWP updated with my current email, phone number, and mailing address.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And Navigate To account management page
    And click on view link to Navigate to "My Contact Info" page
    Then verify field validation for "Email"
    And click on back link
    And verify field validation for "Mobile Phone"
    And click on back link
    And Verify state names "Armed Forces Europe" , "Armed Forces Pacific" , "Armed Forces Central and South Americas"
    Then verify email can be updated to "abhinav1.srivastava@testingxperts.com"
    And resetting email to default "abhinav.srivastava@testingxperts.com"
  Then verify mobile number is "2013333333" can be updated
    Then Verify Address can be updated By changing street to "Ganges"


    Examples:
      |TestData|
      |Testdata2|

  @Account_management_TC04  @account
  Scenario Outline:Verify Logged in User can view and edit my public facing information (photo, text, privacy) for the other Users in the community.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And Navigate To account management page
    And Navigate to About Me page
    Then Verify User can type free text for About Me section
    Then Verify 'View Privacy Link' functionality on about me page

    Examples:
      |TestData|
      |Testdata2|


  @Account_management_TC05  @account
  Scenario Outline:Verify Logged in User can set my preferences for communications from WDX and WWP to controle where the user get messages and notifications.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And Navigate To account management page
    And click on update link to Navigate to Notifications page
    Then Verify Email notification settings


    Examples:
      |TestData|
      |Testdata2|


  @Account_management_TC09  @account1
  Scenario Outline:Verify Logged in User can choose privacy settings for my account and manage security parameters change password, profile visibility according to my preferences.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And  User login to the Wounded Warrior
    And Navigate To account management page
    And click on update link to Navigate to "Privacy Settings" page
    Then verify functionality of Go Private Radio Button
    And Navigate To account management page
    And click on update link to Navigate to "Privacy Settings" page
    Then verify functionality of Stay Visible Radio Button
    And Navigate To account management page
    And click on update link to Navigate to "Privacy Settings" page
    And click on Lean More link
    Then verify popup is visible
    And click on update password link
    And Open to the outlook and Get URL to reset password
    Then Verify password reset successfully




    Examples:
      |TestData|
      |Testdata1|
