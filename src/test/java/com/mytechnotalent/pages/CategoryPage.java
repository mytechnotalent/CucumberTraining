package com.mytechnotalent.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage {
    private final WebDriver driver;

    private final By continueButton = By.xpath("//a[text()='Continue']");

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}
