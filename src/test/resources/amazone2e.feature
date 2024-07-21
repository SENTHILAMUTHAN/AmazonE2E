Feature: Amazon End-to-End Shopping

  Scenario: Filter and add product to cart
    Given I am on the Amazon home page
    When I navigate to Fashion and  then to Mens
    And I filter products by price range ₹1,000 - ₹5,000
    And I select brands Allen Solly and Puma
    Then I verify the number of search results
    And I add the second product to cart
    And I verify the cart count has increased
