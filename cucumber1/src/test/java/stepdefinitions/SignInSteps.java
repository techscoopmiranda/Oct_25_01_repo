package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInSteps {
	WebDriver driver;

    @Given("the user is on the Amazon.in sign-in page")
    public void user_on_signin_page() {
    	System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\Chrome drivers\\chromedriver_129.exe"); 
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();
        
    }

    @When("the user enters valid credentials")
    public void user_enters_credentials() {
        WebElement emailField = driver.findElement(By.id("ap_email"));
        emailField.sendKeys("techscoopbymiranda@gmail.com");

        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        WebElement passwordField = driver.findElement(By.id("ap_password"));
        passwordField.sendKeys("Learningbuddy2024#");

        WebElement signInButton = driver.findElement(By.id("signInSubmit"));
        signInButton.click();
    }

    @Then("the user should see the dashboard")
    public void user_sees_dashboard() {
        // Add verification to ensure dashboard is displayed
        String title = driver.getTitle();
        assert title.contains("Amazon");
    }
}
