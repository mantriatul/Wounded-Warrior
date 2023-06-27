@Web

Feature: validate the browse all page


  @BrowseAll_tc_01 @Browser_All
  Scenario Outline: Verify Browse All Content on Page
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    When user click on the "Browse All" page
    Then verify the content present on the Browse_All page


    Examples:
      | TestData  |
      | Testdata1 |


  @BrowseAll_tc_02_03 @Browser_All
  Scenario Outline:Verify the functionality of the search button on Browse All page
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    When user click on the "Browse All" page
    Then Validate search functionality

    Examples:
      | TestData  |
      | Testdata1 |

  @BrowseAll_tc_04 @Browser_All
  Scenario Outline: Verify when search result not matched and no result appears on the page.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    When user click on the "Browse All" page
    Then verify that search results should be clickable
    Examples:
      | TestData  |
      | Testdata1 |

  @BrowseAll_tc_05 @Browser_All
  Scenario Outline: Verify when search result not matched and no result appears on the page.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    When user click on the "Browse All" page
    Then verify the error messages
    Examples:
      | TestData  |
      | Testdata1 |

  @BrowseAll_tc_06 @Browser_All
  Scenario Outline: Verify Featured Category Cards on the page.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    When user click on the "Browse All" page
    Then Verify featured cards section
    Examples:
      | TestData  |
      | Testdata1 |

  @BrowseAll_tc_07 @Browser_All
  Scenario Outline:   Verify By  Interest section Cards on the Browse all page.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    When user click on the "Browse All" page
    Then verify interest card section
    Examples:
      | TestData  |
      | Testdata1 |

  @BrowseAll_tc_08 @Browser_All
  Scenario Outline: Verify View All button by Interest Cards on the Browse all page.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    When user click on the "Browse All" page
    When user clicks on the viewall button
    Then verify the text present in the viewall page
    Examples:
      | TestData  |
      | Testdata1 |

  @BrowseAll_tc_09 @Browser_All
  Scenario Outline: Verify Search by name functionality on the view all page
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    When user click on the "Browse All" page
    When user clicks on the viewall button
    Then validate the search_by_name_functioanlity by valid_search
    Then validate the search_b_name_functionality by invalid search
    Then validate the recent search is present or not after clicking on the search button
    Examples:
      | TestData  |
      | Testdata1 |


  @BrowseAll_tc_10 @Browser_All
  Scenario Outline: Verify Filter Option - List by Format, Invited, Location, Interest, and Date Range
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    When user click on the "Browse All" page
    When user clicks on the viewall button
    When click on the "Format" dropdown
    Then user is able to see all the value in the "Format" option
    When click on the "Invited" dropdown
    Then user is able to see all the value in the "Invited" option
    When  click on the "Location" dropdown
    Then user is able to see all the value in the "Location" option
    When  click on the "Interest" dropdown
    Then user is able to see all the value in the "Interest" option
    When  click on the "Date Range" dropdown
    Then user is able to see all the value in the "Date Range" option
    Examples:
      | TestData  |
      | Testdata1 |

  @BrowseAll_tc_11 @Browser_All1
  Scenario Outline: Verify Clear Filter and Apply Filter Button functionality on View all page.
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    When user click on the "Browse All" page
    When user clicks on the viewall button
    When click on the "Format" dropdown
    When user clicks on the "Virtual" checkbox
    When user clicks on the "Apply Filters" filter button
    Then verify the elements present or not
    When user clicks on the "Clear Filters" filter button
    When click on the "Invited" dropdown
    When user clicks on the "Alumni" checkbox
    When user clicks on the "Apply Filters" filter button
    Then verify the elements present or not
    When user clicks on the "Clear Filters" filter button
    When click on the "Location" dropdown
    When user enters the "FL" in the search field
    When user clicks on the "Apply Filters" filter button
    Then verify the elements present or not
    When user clicks on the "Clear Filters" filter button
    When click on the "Interest" dropdown
    When user clicks on the "Connect with peers" checkbox
    When user clicks on the "Apply Filters" filter button
    Then verify the elements present or not
    When user clicks on the "Clear Filters" filter button
    When  click on the "Date Range" dropdown
    When user enters "05-22-2023" in the startdate
    When user enters "06-26-2023" in the enddate
    When click on the date range dropdown
    When user clicks on the "Apply Filters" filter button
   Then verify the elements present or not
    When user clicks on the "Clear Filters" filter button
    When click on the "Invited" dropdown
    When user clicks on the "Alumni" checkbox
    When user clicks on the "Apply Filters" filter button

    Then verify the Event article should be clickable


    Examples:
      | TestData  |
      | Testdata1 |


  @BrowseAll_tc_12 @Browser_All

  Scenario Outline: Verify Show More Button functionality on View all page
    Given Read the testdata "<TestData>" from excel file
    When User navigates to the url
    And User login to the Wounded Warrior
    When user click on the "Browse All" page
    When user clicks on the viewall button
    When user clicks on the showmore button
    Examples:
      | TestData  |
      | Testdata1 |
