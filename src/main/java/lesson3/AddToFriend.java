package lesson3;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.midi.Soundbank;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class AddToFriend {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.livejournal.com");

        WebElement webElement1 = driver.findElement(By.xpath("//a[contains(@class, \"s-header-item__link--login\")]"));
        webElement1.click();
        WebElement webElement2 = driver.findElement(By.id("user"));
        webElement2.click();
        webElement2.sendKeys("dariyiii");
        WebElement webElement3 = driver.findElement(By.id("lj_loginwidget_password"));
        webElement3.click();
        webElement3.sendKeys("Jj2801");
        WebElement webElement4 = driver.findElement(By.name("action:login"));
        webElement4.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();}
        WebElement webElement5 = driver.findElement(By.cssSelector(".cat-widget__col--2 > .cat-widget__card-wrap:nth-child(1) .post-card-- > .post-card__link"));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();}
        webElement5.click();
        WebElement webElement6 = driver.findElement(By.xpath("//*[@class=\"mdspost-follow__friend-text\"]"));
        webElement6.click();
        WebElement webElement7 = driver.findElement(By.xpath("//input[@class=\"b-flatbutton\"]"));
        webElement7.click();
}}
