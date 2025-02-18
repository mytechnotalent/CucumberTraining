package com.mytechnotalent.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    WebDriver driver;

    private final By myAccountHeader = By.xpath("//h2[text()='My Account']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getMyAccountHeader() {
        return myAccountHeader;
    }
}
