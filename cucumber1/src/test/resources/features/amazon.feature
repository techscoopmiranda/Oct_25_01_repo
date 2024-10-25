Feature: Amazon Sign In and Product Search

  Scenario: User signs in and searches for a product
    Given the user is on the Amazon.in sign-in page
    When the user enters valid credentials
    And the user clicks the sign-in button
    Then the user should see the dashboard
    When the user searches for "laptop"
    Then the title of the search results page should contain "laptop"
    
 