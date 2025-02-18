package com.mytechnotalent.StepDefs;

import com.mytechnotalent.pages.AccountPage;
import com.mytechnotalent.pages.CategoryPage;
import com.mytechnotalent.pages.HomePage;
import com.mytechnotalent.pages.ProductPage;
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
    CategoryPage categoryPage = new CategoryPage(driver);
    HomePage homePage = new HomePage(driver);
    ProductPage productPage = new ProductPage(driver);
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

    @When("the user navigates to the Desktop menu")
    public void theUserNavigatesToTheMenu() {
        accountPage.clickDesktopMenu();
    }

    @And("clicks the PC menu item")
    public void clicksThPCMenuItem() {
        accountPage.clickPCMenuItem();
    }

    @And("clicks the Continue button")
    public void clicksTheContinueButton() {
        categoryPage.clickContinueButton();
    }

    @And("clicks the MacBook product")
    public void clicksTheProduct() {
        homePage.clickMacBookLink();
    }

    @When("clicks Add to Cart")
    public void clicks() {
        productPage.clickAddToCartButton();
    }

    @Then("the shopping cart should display 1 item\\(s) - $500.00 in the checkout button")
    public void theShoppingCartShouldDisplayItemS$InTheCheckoutButton() {
        productPage.verifyCartTotal();
    }

    @And("the user clears the shopping cart")
    public void theUserClearsTheShoppingCart() {
        productPage.clearCart();
    }

    @Then("the shopping cart should be empty")
    public void theShoppingCartShouldBeEmpty() {
        assertTrue("The shopping cart is not empty!", productPage.isCartEmpty());
    }
}
