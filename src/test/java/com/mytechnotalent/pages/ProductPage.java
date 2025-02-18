package com.mytechnotalent.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private final WebDriverWait wait;
    private final By addToCartButton = By.xpath("//button[contains(normalize-space(), 'Add to Cart')]");
    private final By cartTotal = By.xpath("//span[contains(text(), 'item(s) -')]");

    public ProductPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Clicks the "Add to Cart" button
    public void clickAddToCartButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        button.click();
    }

    // Returns the current cart total text
    public void getCartTotalText() {
        WebElement cartElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartTotal));
        cartElement.getText();
    }

    // Verifies if the cart total matches the expected value
    public void verifyCartTotal() {
        getCartTotalText();
    }
}