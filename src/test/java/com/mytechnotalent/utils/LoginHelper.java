package com.mytechnotalent.utils;

import com.mytechnotalent.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class LoginHelper {

    private final WebDriver driver;
    private final LoginPage loginPage;
    private final WebDriverWait wait;

    public LoginHelper(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void loginIfNeeded() {
        String baseUrl = ConfigReader.getProperty("BASE_URL");
        String accountPageUrl = baseUrl + ConfigReader.getProperty("ACCOUNT_PAGE_URL");
        String loginPageUrl = baseUrl + ConfigReader.getProperty("LOGIN_PAGE_URL");

        // If already logged in, do nothing
        if (Objects.equals(driver.getCurrentUrl(), accountPageUrl)) {
            return;
        }

        // Navigate to Login Page
        driver.get(loginPageUrl);

        // Perform login
        loginPage.enterUsername(SecretReader.getProperty("TEST_USERNAME"));
        loginPage.enterPassword(SecretReader.getProperty("TEST_PASSWORD"));
        loginPage.clickLoginButton();

        // Wait until login is successful
        wait.until(ExpectedConditions.urlToBe(accountPageUrl));

        // Ensure login was successful
        assert Objects.equals(driver.getCurrentUrl(), accountPageUrl) : "Login failed, user not redirected.";
    }
}