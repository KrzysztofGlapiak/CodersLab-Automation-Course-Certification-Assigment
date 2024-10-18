Feature: Adding New Address
  test

  Scenario Outline: user adds a new address
    Given user logged in
    When user clicks "Create new address"
    And User fills the new address form: <alias>, <address>, <city>, <zip>, <country>, <phone>
    Then new address will be added and will be visible
    And address will be deleted
    And close browser

    Examples:
      | alias | address       | city     | zip    | country        | phone     |
      | Dom   | 123 Main St   | Warsaw   | 00-001 | United Kingdom | 123456789 |