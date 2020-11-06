Feature: Validating Cogmento CRM Login Page
  		As a User i want to authorized only with valid Username and Password

  @Sanity
  Scenario: Validating username and Password field using Postive TestData's
    Given I am in Cogmento CRM Login Page
    When I enter valid username and Password
    Then Verify the user Cogmento CRM HomePage

  @Smoke
  Scenario: Verify Cogmento CRM Login Page username and Password field using Negative TestData's
    Given I am in Cogmento CRM Login Page
    When I Enter invalid Username and Password
    Then I will be in Cogmento CRM HomePage
