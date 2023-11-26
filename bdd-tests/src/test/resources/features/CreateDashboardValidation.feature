Feature: Create report portal dashboard
  System should validate parameters when creating dashboard

  Background:
    Given I load dashboards

  Scenario Outline: User receives error if creates dashboard with wrong parameters
    When I create dashboard with name <name> and description <description>
    Then User receives dashboard creation error with message <messageType>
    And I load dashboards
    And Dashboards table contains only demo dashboard

    Examples:
      | name             | description | messageType             |
      | ""               | "test-desc" | "emptyName"             |
      | "d1"             | "test-desc" | "nameWithIncorrectSize" |
      | "DEMO DASHBOARD" | "test-desc" | "existedName"           |
