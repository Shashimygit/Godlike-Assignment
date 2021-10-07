Feature: Check price on search results page and cart page

  Scenario Outline: Compare price on search results page and cart page
    Given "https://www.amazon.in/" page is loaded on browser
    When <username> and <password> is entered
    And signin button is clicked
    And "Ducati" search text is entered in search box
    And search button is clicked
    And item price on search results page is checked
    And item is clicked
    And item detail page is displayed
    And add to cart button is clicked
    Then item is added to cart
    And item price on cart page is checked
    And browser is closed

    Examples: 
      | username                      | password    |
      | testfirsttestlast01@gmail.com | myamazon01! |
