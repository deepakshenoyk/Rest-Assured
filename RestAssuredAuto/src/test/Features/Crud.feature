Feature: Crud Functionality

  Scenario: Insert Data
    Given the base url is "https://reqres.in"
    And the body is "{"name":"morpheus","job":"leader"}"
    When the "POST" request "/api/users"
    Then verify that the status is "201"
    And the response contains "morpheus"