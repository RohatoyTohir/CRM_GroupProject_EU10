@wip
Feature: Company Structure Management
  As a user, I should be able to use functions on Company Structure under Employee menu.

  User types are: Helpdesk user, HR user, Marketing user
  For the scenarios in this feature file,user is expected to be on the login page

  Background:
    Given User loads the website

  @NEXTBASE10-389
  Scenario Outline: "<user_type>" user should be able to display company structure
    When User "<user_type>" logs to home page
    When User clicks on "Employees" button
    Then User sees "Company Structure" header

    Examples:
      | user_type |
      | HR        |
      | Helpdesk  |
      | Marketing |

  @NEXTBASE10-390
  Scenario Outline: "<user_type>" user should be able to add a department from the company structure

    Given User "<user_type>" logs to home page
    When User clicks on "Employees" button
    Then User sees "Company Structure" header
    When User clicks on the "Add Department" button
    When User types department name "Marketing" for the department text field
    When User clicks on the "Add" button on next window
    Then User sees the department column "Marketing" on the Company Structure page

    Examples:
      | user_type |
      | HR        |

  @NEXTBASE10-391
  Scenario: Hr user should be able to select a parent department from the department dropdown

    Given User "HR" logs to home page
    When User clicks on "Employees" button
    Then User sees "Company Structure" header
    When User clicks on the "Add Department" button
    When User selects a parent department " .  . Marketing" from parent dropdown
    Then User sees parent department " .  . Marketing" in the parent department dropdown

  @NEXTBASE10-392
  Scenario: Hr user should be able to close add department modal at any time

    Given User "HR" logs to home page
    When User clicks on "Employees" button
    Then User sees "Company Structure" header
    When User clicks on the "Add Department" button
    When User sees "Add department" modal
    Then User clicks on close button
    Then User can not see  add Department modal button

  @NEXTBASE10-393
  Scenario Outline: Helpdesk and marketing users can not change company structure

    When User "<user_type>" logs to home page
    When User clicks on "Employees" button
    Then User does not see Add department button

    Examples:
      | user_type |
      | Helpdesk  |
      | Marketing |

  @NEXTBASE10-394
  Scenario Outline: "<user_type>" user should be able to see error message
  "Section name is not specified" from Company Structure (Negative test case)

    Given User "<user_type>" logs to home page
    When User clicks on "Employees" button
    Then User sees "Company Structure" header
    When User clicks on the "Add Department" button
    When User clicks on the "Add" button on next window
    Then User sees error message "Section name is not specified." on the add Department page

    Examples:
      | user_type |
      | HR        |

