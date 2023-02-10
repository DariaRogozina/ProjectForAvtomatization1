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
public class NewPost {
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
        WebElement webElement5 = driver.findElement(By.xpath("//span[@class=\"s-header-item-post--long\"]"));
        webElement5.click();
        WebElement webElement6 = driver.findElement(By.xpath("//textarea[@class=\"text-0-2-179\"]"));
        webElement6.click();
        webElement6.sendKeys("test");
        WebElement webElement7 = driver.findElement(By.xpath("//*[@class=\"public-DraftStyleDefault-block public-DraftStyleDefault-ltr\"]"));
        webElement7.click();
        webElement7.sendKeys("test");
        WebElement webElement8 = driver.findElement(By.xpath("//*[@class=\"reset-0-2-89 root-0-2-91 rootSmall-0-2-94 textSemibold-0-2-101 backgroundBlue-0-2-104 textWithDropDownIcon-0-2-115\"]"));
        webElement8.click();
        WebElement webElement9 = driver.findElement(By.xpath("//*[.=\"Опубликовать\"]"));
        webElement9.click();

        // driver.quit();
    }

}
