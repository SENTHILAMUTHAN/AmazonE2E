package org.step;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class AmazonE2Estep {

    private WebDriver driver;
    private String mainWindowHandle;

    @Given("I am on the Amazon home page")
    public void openAmazonWebsite() {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
    }

    @When("I navigate to Fashion and  then to Mens")
    public void navigateToFashion() {
        driver.findElement(By.xpath("//a[text()='Fashion']")).click();
        driver.findElement(By.xpath("(//a[@class='nav-a nav-hasArrow'])[2]")).click();
    }

    @And("I filter products by price range ₹1,000 - ₹5,000")
    public void filterByPriceRange() {
        WebElement pricerange = driver.findElement(By.xpath("//li[@class='a-spacing-micro']//span[text()='₹1,000 - ₹5,000']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pricerange);
        pricerange.click();
    }

    @And("I select brands Allen Solly and Puma")
    public void selectBrands() {
        driver.findElement(By.xpath("//li[@aria-label='Allen Solly']//i[@class='a-icon a-icon-checkbox']")).click();
        driver.findElement(By.xpath("//li[@id='p_123/256097']//i[@class='a-icon a-icon-checkbox']")).click();
    }

    @Then("I verify the number of search results")
    public void verifySearchResults() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@data-component-type='s-search-results']//div[@class='a-section a-spacing-base a-text-center']")));

        List<WebElement> results = driver.findElements(By.xpath("//span[@data-component-type='s-search-results']//div[@class='a-section a-spacing-base a-text-center']"));

        System.out.println("Number of results occurring on the 1st page ---->" + results.size());
        Assert.assertTrue("Number of results should be greater than 0", results.size() > 0);
    }

    @And("I add the second product to cart")
    public void addSecondProductToCart() throws InterruptedException {
        List<WebElement> results = driver.findElements(By.xpath("//span[@data-component-type='s-search-results']//div[@class='a-section a-spacing-base a-text-center']"));

        // Initially checking that the cart is empty
        WebElement cartCount = driver.findElement(By.xpath("//div[@id='nav-cart-count-container']//span[@id='nav-cart-count']"));
        System.out.println("Initial Cart Count: " + cartCount.getText());

        if (results.size() > 1) {
            WebElement secondResult = results.get(1).findElement(By.xpath(".//a"));
            secondResult.click();
        } else {
            System.out.println("There are less than two elements in the results.");
            driver.quit();
            return;
        }

        mainWindowHandle = driver.getWindowHandle();

        // Wait for the new tab to open and switch to it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if (!mainWindowHandle.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Adding sleep to ensure the page loads properly
        Thread.sleep(5000);

        // Checking the URL to confirm navigation
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        try {
            // Adding debug information before clicking
            System.out.println("Product details page loaded.");

            // Wait for the "Add to Cart" button to be visible and clickable
            WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='a-box-group']//span[@class='a-button-inner']//input[@id='add-to-cart-button']")));
            System.out.println("Add to Cart button is visible now.");

            addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
            System.out.println("Add to Cart button is clickable now.");

            // Clicking the "Add to Cart" button
            addToCartButton.click();
            System.out.println("Clicked on Add to Cart button.");
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

    @And("I verify the cart count has increased")
    public void verifyCartCount() {
        WebElement finalCartCount = driver.findElement(By.xpath("//div[@id='nav-cart-count-container']//span[@id='nav-cart-count']"));
        System.out.println("Final Cart Count: " + finalCartCount.getText());
        Assert.assertTrue("Cart count should be greater than 0", Integer.parseInt(finalCartCount.getText()) > 0);
    }
}

