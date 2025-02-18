package com.mytechnotalent.StepDefs;

import com.mytechnotalent.pages.LoginPage;
import com.mytechnotalent.utils.ConfigReader;
import com.mytechnotalent.utils.SecretReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Objects;
import static org.testng.AssertJUnit.assertTrue;

public class LoginStepDefs {
    WebDriver driver = Hooks.driver;
    LoginPage loginPage = new LoginPage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        String expectedUrl = ConfigReader.getProperty("BASE_URL") + ConfigReader.getProperty("LOGIN_PAGE_URL");

        if (!Objects.equals(driver.getCurrentUrl(), expectedUrl)) {
            driver.get(expectedUrl);
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getEmailField()));

        assertTrue("User is not on the login page.", Objects.requireNonNull(driver.getCurrentUrl()).
                contains(expectedUrl));
    }

    @When("the user enters valid username and password")
    public void theUserEntersValidUsernameAndPassword() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getEmailField()));
        loginPage.enterUsername(SecretReader.getProperty("TEST_USERNAME"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getPasswordField()));
        loginPage.enterPassword(SecretReader.getProperty("TEST_PASSWORD"));
    }

    @And("clicks the login button")
    public void clicksTheLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginButton()));
        loginPage.clickLoginButton();
    }

    @Then("the user should be redirected to the account page")
    public void theUserShouldBeRedirectedToTheAccountPage() {
        String expectedUrl = ConfigReader.getProperty("BASE_URL") + ConfigReader.getProperty("ACCOUNT_PAGE_URL");

        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        assert Objects.equals(driver.getCurrentUrl(), expectedUrl)
                : "Login failed, user not redirected.";
    }
}