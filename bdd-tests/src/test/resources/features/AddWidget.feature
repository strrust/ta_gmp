@widget
Feature: Add widget to dashboard
  User should be able to add widget to dashboard

  Background:
    Given I load dashboards
    And Dashboards table contains only demo dashboard
    And I open demo dashboard

  Scenario Outline: User adds widget to dashboard
    When I add widget <widgetType> with default parameters
    And I open demo dashboard
    Then Dashboard contains created widget <widgetType> with correct parameters

    Examples:
      | widgetType          |
      | "overallStatistics" |
      | "activityStream"    |
      | "launchesTable"     |
