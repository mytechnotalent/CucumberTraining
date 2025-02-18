package com.mytechnotalent.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private final WebDriverWait wait;

    private final By macBookLink = By.xpath("(//*[@id='content']//div[contains(@class, 'product-thumb')]/div[@class='caption']/h4/a[text()='MacBook'])[1]");

    public HomePage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickMacBookLink() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(macBookLink));
        element.click();
    }
}
