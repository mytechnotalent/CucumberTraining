package com.mytechnotalent.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    private final By emailField = By.id("input-email");
    private final By passwordField = By.id("input-password");
    private final By loginButton = By.xpath("//input[@value='Login']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterUsername(String username) {
        driver.findElement(emailField).sendKeys(username);
    }
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    public By getEmailField() {
        return emailField;
    }
    public By getPasswordField() {
        return passwordField;
    }
    public By getLoginButton() {
        return loginButton;
    }
}