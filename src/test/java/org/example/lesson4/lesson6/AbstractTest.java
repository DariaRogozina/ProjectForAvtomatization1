package org.example.lesson4.lesson6;
import io.github.bonigarcia.wdm.WebDriverManager;
import lesson6.MyTestPackage.LoginPage;
import lesson6.MyTestPackage.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import lesson7.MyWebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import java.time.Duration;

public class AbstractTest {

//    static WebDriver webDriver;
    static EventFiringWebDriver eventDriver;

    @BeforeAll
    static void setDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.setPageLoadTimeout(Duration.ofSeconds(10));


//        webDriver = new ChromeDriver(options);
//        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        eventDriver = new EventFiringWebDriver(new ChromeDriver(options));
        eventDriver.register(new MyWebDriverEventListener());

        eventDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Assertions.assertDoesNotThrow( ()-> eventDriver.navigate().to("https://www.livejournal.com"),
                "Страница не доступна");

            new MainPage(eventDriver).clicksignIn();
//            Assertions.assertTrue(webDriver.getTitle().equals("BBC – Sign in"), "страница входа недоступна");
            new LoginPage(eventDriver)
                    .setLogin("dariyiii")
                    .setPassword("Jj2801")
                    .loginIn();
//            Assertions.assertTrue(webDriver.findElement(By.xpath("//span[contains(@class, \"  s-nav-item__name\")]")).getText().equals("dariyiii"));

        }

//    @BeforeEach
//    void initMainPage(){
//        Assertions.assertDoesNotThrow( ()-> getWebDriver().navigate().to("https://www.livejournal.com"),
//                "Страница не доступна");
//        Assertions.assertTrue(true);

//    }

    @AfterAll
    public static void exit(){

        if(eventDriver !=null) eventDriver.quit();
    }
    @AfterEach
    public void checkBrowser(){
        List<LogEntry> allLogRows = getWebDriver().manage().logs().get(LogType.BROWSER).getAll();
        if(!allLogRows.isEmpty()){

            if (allLogRows.size() > 0 ) {
                allLogRows.forEach(logEntry -> {
                    System.out.println(logEntry.getMessage());
                });

            }

        }

    }

    public WebDriver getWebDriver(){
        return this.eventDriver;
    }
}
