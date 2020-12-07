Feature: AddressFunctionality

  @Regression
  Scenario: Add remove address
    And Click on an element in the "LandingPage"
      | myAccount |

    And Click on an element in the "ProfilePage"
      | Addresses    |
      | AddNewButton |

    And Enter the value in the element in the "ProfilePage"
      | FirstNameInput   | Ali                         |
      | LastNameInput    | Koklu                       |
      | EmailInput       | muhammetali.koklu@gmail.com |
      | CityInput        | Harrison                    |
      | Address1Input    | 123 main                    |
      | ZipCodeInput     | 07029                       |
      | PhoneNumberInput | 8625478989                  |

    And Select dropdown and value in the dropdown in the "ProfilePage"
      | CountryDropdown | United States |
      | StateDropdown   | New Jersey    |

    And Click on an element in the "ProfilePage"
      | saveButton |

    Then Verify "Ali Koklu" text is displayed

    And Click on the "Ali Koklu" element delete button

