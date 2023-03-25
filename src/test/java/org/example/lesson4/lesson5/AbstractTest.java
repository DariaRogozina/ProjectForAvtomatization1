package org.example.lesson4.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {

    private static WebDriver driver;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.livejournal.com");
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://www.livejournal.com"));
        Assertions.assertTrue(getDriver().getTitle().contains("Главное — ЖЖ"), "страница входа недоступна");
        WebElement webElement1 = getDriver().findElement(By.xpath("//a[contains(@class, \"s-header-item__link--login\")]"));
        webElement1.click();
        WebElement webElement2 = getDriver().findElement(By.id("user"));
        webElement2.click();
        webElement2.sendKeys("dariyiii");
        WebElement webElement3 = getDriver().findElement(By.id("lj_loginwidget_password"));
        webElement3.click();
        webElement3.sendKeys("Jj2801");
        WebElement webElement4 = getDriver().findElement(By.name("action:login"));
        webElement4.click();
    }

    @BeforeEach
    void goTo(){
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://www.livejournal.com"));
        Assertions.assertTrue(getDriver().getTitle().contains("Главное — ЖЖ"), "страница входа недоступна");
    }



    @AfterAll
    static void close(){
        //driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
