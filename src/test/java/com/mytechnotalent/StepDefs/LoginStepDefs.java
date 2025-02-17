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

public class LoginStepDefs {
    WebDriver driver = Hooks.driver;
    LoginPage loginPage = new LoginPage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getEmailField()));
        loginPage.enterUsername(SecretReader.getProperty("TEST_USERNAME"));
    }

    @When("the user enters valid username and password")
    public void theUserEntersValidUsernameAndPassword() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getPasswordField()));
        loginPage.enterPassword(SecretReader.getProperty("TEST_PASSWORD"));
    }

    @And("clicks the login button")
    public void clicksTheLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginButton()));
        loginPage.clickLoginButton();
    }

    @Then("the user should be redirected to the homepage")
    public void theUserShouldBeRedirectedToTheHomepage() {
        String expectedUrl = ConfigReader.getProperty("BASE_URL") + ConfigReader.getProperty("HOME_PAGE_ROUTE");
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        assert Objects.equals(driver.getCurrentUrl(), expectedUrl)
                : "Login failed, user not redirected.";
    }
}