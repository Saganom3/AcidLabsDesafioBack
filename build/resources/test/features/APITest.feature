@ALL
Feature: API Request

  @GET
  Scenario: GET
    Given I send a GET request to the https://jsonplaceholder.typicode.com URI
    Then I get a 200 status code

  @DELETE
  Scenario: DELETE
    Given I send a DELETE request to the https://jsonplaceholder.typicode.com URI
    Then I get a 200 status code confirming the deletion

  @CREATE
  Scenario: CREATE
    Given I send a CREATE request to the https://jsonplaceholder.typicode.com URI
    Then I get a 201 status code which confirms the creation