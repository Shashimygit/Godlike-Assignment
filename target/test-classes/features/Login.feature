Feature: Amazon login

  Scenario Outline: positive test to login to amazon webpage
    Given "https://www.amazon.in/" page is loaded on browser
    When <username> and <password> is entered
    And signin button is clicked
    Then Login is successful
    And Hi username is displayed
    And browser is closed

    Examples: 
      | username                      | password    |
      | testfirsttestlast01@gmail.com | myamazon01! |

