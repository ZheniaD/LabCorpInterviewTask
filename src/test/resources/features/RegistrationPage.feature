Feature:

  Scenario: Customer registration verification (positive)
    Given Customer goes to the registration page
    Then Customer enters the following information
      | fistName | Zhenia                   |
      | lastName | Derbush                  |
      | email    | zhenia.derbush@gmail.com |
      | text     | Test                     |
      | phone    | +120669638293            |
    And Customer clicks submit button
    Then Verify Customer ID is generated
    And Check proper customer message "Please Note Down Your CustomerID" is displayed
    And Check the Customer ID is not empty and contains only numbers

  Scenario: Customer registration verification (negative)
    Given Customer goes to the registration page
    Then Customer enters the following information
      | fistName | Zhenia                   |
      | lastName | Derbush                  |
      | email    | zhenia.derbush@gmail |
      | text     | Test                     |
      | phone    | +14206696E            |
    Then Verify warning message "Email-ID is not valid" is displayed when invalid email format
    And  Verify warning message "Special characters are not allowed" is displayed when Mobile Number is not numeric
