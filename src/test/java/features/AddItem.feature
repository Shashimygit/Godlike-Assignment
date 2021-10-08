Feature: Add ducati product to cart

  Scenario Outline: Adding a ducati product to cart page
    Given "https://www.amazon.in/" page is loaded on browser
    When <username> and <password> is entered
    And signin button is clicked
    And "Ducati" search text is entered in search box
    And search button is clicked
    And item is clicked
    And item detail page is displayed
    And add to cart button is clicked
    Then item is added to cart
    And item is removed from cart
    And browser is closed


    Examples: 
      | username                      | password    |
      | testfirsttestlast01@gmail.com | myamazon01! |