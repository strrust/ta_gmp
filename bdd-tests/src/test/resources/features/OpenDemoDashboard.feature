Feature: Open ReportPortal dashboard

  Background:
    Given I load dashboards
    And Dashboards table contains only demo dashboard

  Scenario: User opens demo dashboard
    When I open demo dashboard
    Then Dashboard is opened
    And Dashboard contains widgets
