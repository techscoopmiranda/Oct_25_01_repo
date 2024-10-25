package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {
	WebDriver driver;

    public SearchSteps() {
        this.driver = Hooks.driver; // Assume Hooks sets up the driver
    }

    @When("the user searches for {string}")
    public void user_searches_for_product(String product) {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(product);
        searchBox.submit();
    }

    @Then("the title of the search results page should contain {string}")
    public void verify_search_results_title(String expectedTitle) {
        String actualTitle = driver.getTitle();
        assert actualTitle.toLowerCase().contains(expectedTitle.toLowerCase());
        driver.quit(); // Close the browser after test completion
    }
}
