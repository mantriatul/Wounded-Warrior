@Web
Feature: verify Resource and support page


  @Rc&supp_02 @Rc&Supp
  Scenario Outline:Verify Logged In User  Warrior, FSM, or Teammate  can see the phone number for the resource center and their available time for phone calls.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    Then user navigate to the "For You" page
    And user click on the "Support" icon
    Then Verify that "Monday - Friday 9am - 9pm EST" is present
    Then verify that telephone number is clickable

    Examples:
      | TestData  |
      | Testdata1 |

  @Rc&supp_03 @Rc&Supp
  Scenario Outline:Verify logged in User Warrior, or FSM  can Live Chat with the Resource Center during available hours.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    Then user navigate to the "For You" page
    And user click on the "Support" icon
    And user click on the "Start a live chat" link
    Then verify that "firstName" is present
    Then verify that "lastName" is present
    Then verify that "email" is present
    Then verify that "Chat Now" is clickable

    Examples:
      | TestData  |
      | Testdata1 |

  @Rc&supp_04 @Rc&Supp
  Scenario Outline:Verify Logged In user Warrior, FSM, or Teammate  can send a message to the Resource Center and view the response and conversation thread in my Messages section
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    Then user navigate to the "For You" page
    And user click on the "Support" icon
    And user click on the "Send us a message" link
    And user enter the message as "this a new message"
    Then click on the "Send Message" button
    Then verified the message

    Examples:
      | TestData  |
      | Testdata1 |


  @Rc&supp_05 @Rc&Supp
  Scenario Outline:Verify Logged in User Warrior, FSM, or Teammate  can view operating hours for the Resource Center, for phone call or Live Chat.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    Then user navigate to the "For You" page
    And user click on the "Support" icon
    Then Verify that "Monday - Friday 9am - 7pm EST" is present

    Examples:
      | TestData  |
      | Testdata1 |

  @Rc&supp_06 @Rc&Supp
  Scenario Outline:Verify the LoggedIn User Warrior, FSM, or Teammate can view a list of Frequently Asked Questions for the Resource Center
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    Then user navigate to the "For You" page
    And user click on the "Support" icon
    Then verify that faq questions part

    Examples:
      | TestData  |
      | Testdata1 |





