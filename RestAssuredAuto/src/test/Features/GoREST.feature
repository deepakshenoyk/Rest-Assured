Feature: Feature file to test the Go Rest APIs

  Scenario Outline: Test the GET Users API
    Given The Go Rest API for GET call
    When the API is triggered for <UserId>
    Then Validate the Response code <responseCode>
    And Validate the response contains the "<Name>" and "<EmailID>" and "<Gender>" and "<Status>"
    Examples:
      | UserId | responseCode | Name         | EmailID               | Gender | Status   |
      | 2044   | 200          | Onake Obavva | Onake.Obavva@15ce.com | female | active   |
      | 1932   | 200          | sree         | sree789@gmail.com     | female | inactive |

  Scenario Outline: Test the CREATE User API
    Given The Go Rest API for POST call
    When the API is triggered with "<Name>" and "<Gender>" and "<EmailID>" and "<Status>" as body
    Then Validate the Response code <responseCode>
    And Validate the response contains the "<Name>" and "<EmailID>" and "<Gender>" and "<Status>"

    Examples:
      | responseCode | Name           | EmailID                     | Gender | Status |
      | 201          | Neeraj Chopras | Neeraj.Chopra1@Olympics.com | male   | active |