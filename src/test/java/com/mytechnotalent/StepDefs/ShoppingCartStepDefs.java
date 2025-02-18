package com.mytechnotalent.StepDefs;

import com.mytechnotalent.pages.AccountPage;
import com.mytechnotalent.utils.ConfigReader;
import com.mytechnotalent.utils.LoginHelper;
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

public class ShoppingCartStepDefs {
    WebDriver driver = Hooks.driver;
    private final LoginHelper loginHelper = new LoginHelper(driver);
    AccountPage accountPage = new AccountPage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        loginHelper.loginIfNeeded();
    }

    @Given("the user is on the account page")
    public void theUserIsOnTheAccountPage() {
        String expectedUrl = ConfigReader.getProperty("BASE_URL") + ConfigReader.getProperty("ACCOUNT_PAGE_URL");
        if (!Objects.equals(driver.getCurrentUrl(), expectedUrl)) {
            driver.get(expectedUrl);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountPage.getMyAccountHeader()));
        assertTrue("User is not on the account page.", Objects.requireNonNull(driver.getCurrentUrl()).
                contains(expectedUrl));
    }

    @When("the user navigates to the {string} menu")
    public void theUserNavigatesToTheMenu(String arg0) {
    }

    @And("selects the {string} menu item")
    public void selectsTheMenuItem(String arg0) {
    }

    @And("clicks the {string} button")
    public void clicksTheButton(String arg0) {
    }

    @And("selects the {string} product")
    public void selectsTheProduct(String arg0) {
    }

    @And("clicks {string}")
    public void clicks(String arg0) {
    }

    @Then("the shopping cart should display {string} in the checkout button")
    public void theShoppingCartShouldDisplayInTheCheckoutButton(String arg0) {
    }

}
