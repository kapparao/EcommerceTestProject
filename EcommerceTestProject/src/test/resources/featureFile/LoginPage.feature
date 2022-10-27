Feature: Login Page Feature  

   Scenario: Login Already Registered User
    Given User should be in Login Page
    And User able to Enter userName "k18apparao@gmail.com"
    And User able to Enter password "Readonly@18"
    When User Click the Signin button
    Then User should Land the My account Page