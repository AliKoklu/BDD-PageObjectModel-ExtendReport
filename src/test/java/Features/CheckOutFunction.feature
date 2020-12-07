Feature: CheckOutFunction

  @Regression
  Scenario: Checkout

#    In the hooks class there is a before and after method
#    I am handling all the navigating to website and entering username password steps there.

    And Click on an element in the "LandingPage"
      | computersMenuButton   |
      | desktopsUnderComputer |

    And Click on an element in the "ItemsPage"
      | ownExpensiveComputerItem |
      | mediumRadioButton        |
      | GB4                      |
      | OfficeSuite              |
      | addToCart                |
      | closeMessage             |
      | shoppingCart             |

    Then Verify "Edit" text is displayed

    And Click on an element in the "CheckoutPage"
      | termsofservice |
      | checkoutButton |
      | continueButton |
      | continueButton |
      | continueButton |
      | continueButton |
      | continueButton |
      | confirmButton  |

    Then Verify "Thank you" text is displayed




