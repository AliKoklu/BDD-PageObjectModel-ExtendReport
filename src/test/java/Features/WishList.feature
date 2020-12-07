Feature: WishList

  @Regression
  Scenario: Add and remove from the wishlist

    And Click on an element in the "LandingPage"
      | ApparelAndShoes |

    And Click on an element in the "ItemsPage"
      | BlueAndGreenSneakers |
      | addtowishList        |
      | closeMessage         |
      | wishListButton       |

    Then Verify "Blue and green Sneaker" text is displayed

    And Click on an element in the "CheckoutPage"
      | removeButton     |
      | updateCartButton |

    Then Verify "The wishlist is empty!" text is displayed




