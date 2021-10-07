Feature: Search for ducati products in amazon webpage

  Scenario Outline: Search an item in amazon webpage
    Given "https://www.amazon.in/" page is loaded on browser
    When <username> and <password> is entered
    And signin button is clicked
    And "Ducati" search text is entered in search box
    And search button is clicked
    Then search results are displayed
    And browser is closed


    Examples: 
      | username                      | password    |
      | testfirsttestlast01@gmail.com | myamazon01! |