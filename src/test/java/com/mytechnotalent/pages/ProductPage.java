package com.mytechnotalent.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.mytechnotalent.StepDefs.Hooks.driver;

public class ProductPage {
    private final WebDriverWait wait;
    private final By addToCartButton = By.xpath("//button[contains(normalize-space(), 'Add to Cart')]");
    private final By cartTotal = By.xpath("//span[contains(text(), 'item(s) -')]");
    private final By cartButton = By.xpath("//*[@id='cart']/button");
    private final By cartItems = By.xpath("//*[@id='cart']/ul/li[1]/table/tbody/tr");
    private final By deleteCartButtons = By.xpath("//*[@id='cart']/ul/li[1]/table/tbody/tr/td[5]/button");
    private final By emptyCartMessage = By.xpath("//*[contains(text(), 'Your shopping cart is empty')]");

    public ProductPage(WebDriver driver1, WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAddToCartButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        button.click();
    }

    public void getCartTotalText() {
        WebElement cartElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartTotal));
        cartElement.getText();
    }

    public void verifyCartTotal() {
        getCartTotalText();
    }

    public void clickCartButton() {
        driver.findElement(cartButton).click();
    }

    public void clearCart() {
        clickCartButton();

        List<WebElement> items = driver.findElements(cartItems);
        while (!items.isEmpty()) {
            for (WebElement deleteButton : driver.findElements(deleteCartButtons)) {
                deleteButton.click();
            }
            items = driver.findElements(cartItems);
        }
    }

    public boolean isCartEmpty() {
        clickCartButton();
        return !driver.findElements(emptyCartMessage).isEmpty();
    }
}