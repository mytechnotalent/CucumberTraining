package com.mytechnotalent.StepDefs;

import com.mytechnotalent.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(ConfigReader.getProperty("BASE_URL") + ConfigReader.getProperty("LOGIN_PAGE_ROUTE"));
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}