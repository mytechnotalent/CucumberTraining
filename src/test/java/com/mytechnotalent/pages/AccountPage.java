package com.mytechnotalent.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private final WebDriver driver;

    private final By myAccountHeader = By.xpath("//h2[text()='My Account']");
    private final By desktopMenuButton = By.xpath("//a[text()='Desktops']");
    private final By pcMenuItem = By.xpath("//a[text()='PC (0)']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getMyAccountHeader() {
        return myAccountHeader;
    }

    public void clickDesktopMenu() {
        driver.findElement(desktopMenuButton).click();
    }

    public void clickPCMenuItem() {
        driver.findElement(pcMenuItem).click();
    }
}
