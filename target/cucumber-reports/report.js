$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/amazone2e.feature");
formatter.feature({
  "name": "Amazon End-to-End Shopping",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Filter and add product to cart",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I am on the Amazon home page",
  "keyword": "Given "
});
formatter.match({
  "location": "AmazonE2Estep.openAmazonWebsite()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to Fashion and  then to Mens",
  "keyword": "When "
});
formatter.match({
  "location": "AmazonE2Estep.navigateToFashion()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I filter products by price range ₹1,000 - ₹5,000",
  "keyword": "And "
});
formatter.match({
  "location": "AmazonE2Estep.filterByPriceRange()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select brands Allen Solly and Puma",
  "keyword": "And "
});
formatter.match({
  "location": "AmazonE2Estep.selectBrands()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify the number of search results",
  "keyword": "Then "
});
formatter.match({
  "location": "AmazonE2Estep.verifySearchResults()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add the second product to cart",
  "keyword": "And "
});
formatter.match({
  "location": "AmazonE2Estep.addSecondProductToCart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify the cart count has increased",
  "keyword": "And "
});
formatter.match({
  "location": "AmazonE2Estep.verifyCartCount()"
});
formatter.result({
  "status": "passed"
});
});