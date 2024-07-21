# Amazon E-commerce Automation with Selenium and Cucumber

This project automates the process of navigating to the Amazon website, filtering products, selecting a specific product, adding it to the cart, and verifying the cart count using Selenium WebDriver and Cucumber framework.

## Overview

The automation script performs the following tasks:

### Setup:
- Launch the browser and maximize the window.
- Open the Amazon India website.

### Navigation and Filtering:
- Navigate to the Fashion section and then to the Men's category.
- Filter products by a specific price range.
- Select specific brands (Allen Solly and Puma).

### Product Selection and Cart Verification:
- Verify the number of search results.
- Add the second product from the search results to the cart.
- Verify the cart count has increased after adding the product.

## Key Features
- Developed automated scripts using the Cucumber framework to navigate through the Amazon website and perform various actions.
- Implemented Page Object Model (POM) design pattern for efficient web element management.
- Utilized JavaScriptExecutor for smooth scrolling to specific elements.
- Ensured robust test script design with appropriate waits and exception handling.
- Verified the cart count to ensure that the product has been added successfully.

## Prerequisites
- Java Development Kit (JDK)
- Apache Maven
- Cucumber
- Selenium WebDriver

## Project Structure
- `AmazonE2Estep.java`: Contains step definitions for the Cucumber features.
- `AmazonE2E.feature`: Cucumber feature file containing the scenarios to be automated.

## Detailed Explanation of Test Methods

### `openAmazonWebsite()`
- Launches the Chrome browser and maximizes the window.
- Opens the Amazon India website.

### `navigateToFashion()`
- Navigates to the Fashion section from the homepage.
- Further navigates to the Men's category.

### `filterByPriceRange()`
- Filters products by the price range ₹1,000 - ₹5,000 using JavaScriptExecutor for scrolling.

### `selectBrands()`
- Selects the brands Allen Solly and Puma using checkbox elements.

### `verifySearchResults()`
- Verifies the number of search results on the first page.
- Asserts that the number of results is greater than zero.

### `addSecondProductToCart()`
- Checks the initial cart count to ensure it's empty.
- Clicks on the second product from the search results to view its details.
- Switches to the new tab opened for the product details page.
- Waits for the "Add to Cart" button to be clickable and then clicks it.

### `verifyCartCount()`
- Verifies the cart count has increased after adding the product.
- Asserts that the cart count is greater than zero.

## Dependencies
- Java Development Kit (JDK)
- Apache Maven
- Cucumber
- Selenium WebDriver



## Conclusion
This project demonstrates the use of Selenium WebDriver and Cucumber for automating end-to-end scenarios on the Amazon website. 
