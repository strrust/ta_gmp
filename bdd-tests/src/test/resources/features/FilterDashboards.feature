@filter
Feature: Filter ReportPortal dashboards
  User should be able to filter report portal dashboards

  Background:
    Given I load dashboards

  Scenario Outline: User filters RP dashboards
    When I filter dashboards by name <searchingQuery>
    Then Dashboards table contains dashboards matches <searchingQuery>

    Examples:
      | searchingQuery   |
      | "DEMO DASHBOARD" |
      | "DEMO"           |
      | "BOA"            |
      | "dashboard"      |
      | "mo dAS"         |
