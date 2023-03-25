package org.example.lesson4.lesson5;


import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyTestSuite extends AbstractTest {


    @Test
    @Order(1)
    void newPost() throws InterruptedException {

        WebElement webElement5 = getDriver().findElement(By.xpath("//span[@class=\"s-header-item-post--long\"]"));
        webElement5.click();
        WebElement webElement6 = getDriver().findElement(By.xpath("//textarea[@class=\"text-0-2-179\"]"));
        webElement6.click();
        webElement6.sendKeys("test");
        WebElement webElement7 = getDriver().findElement(By.xpath("//*[@class=\"public-DraftStyleDefault-block public-DraftStyleDefault-ltr\"]"));
        webElement7.click();
        webElement7.sendKeys("test");
        WebElement webElement8 = getDriver().findElement(By.xpath("//*[@class=\"reset-0-2-89 root-0-2-91 rootSmall-0-2-94 textSemibold-0-2-101 backgroundBlue-0-2-104 textWithDropDownIcon-0-2-115\"]"));
        webElement8.click();
        WebElement webElement9 = getDriver().findElement(By.xpath("//footer[@class=\"footer-0-2-264 root-0-2-339\"]"));
        webElement9.click();
        Assertions.assertEquals("test: dariyiii — ЖЖ", getDriver().getTitle(), "Сообщение не записано");

    }

    @Test
    @Order(2)
    void deletePost() throws InterruptedException {

        WebElement webElement5 = getDriver().findElement(By.xpath("//span[contains(@class, \"s-nav-item__name\")]"));
        webElement5.click();
        WebElement webElement6 = getDriver().findElement(By.xpath("//a[.=\"test\"]"));
        webElement6.click();
        WebElement webElement7 = getDriver().findElement(By.xpath("//*[@class=\"svgicon svgicon svgicon--more\"]"));
        webElement7.click();
        WebElement webElement8 = getDriver().findElement(By.xpath("//*[.=\"Редактировать запись\"]"));
        webElement8.click();
        WebElement webElement9 = getDriver().findElement(By.xpath("//*[@class=\"item-0-2-256 itemRed-0-2-257\"]"));
        webElement9.click();
        WebElement webElement10 = getDriver().findElement(By.xpath("//button[@class=\"reset-0-2-89 root-0-2-91 backgroundBlue-0-2-104\"]"));
        webElement10.click();
        Assertions.assertEquals("dariyiii — ЖЖ", getDriver().getTitle(), "Сообщение не удалено");

    }

    @Test
    void addToFriend() throws InterruptedException {
        Thread.sleep(10000);
        WebElement webElement5 = getDriver().findElement(By.cssSelector(".cat-widget__col--2 > .cat-widget__card-wrap:nth-child(1) .post-card-- > .post-card__link"));
        Thread.sleep(10000);
        webElement5.click();
        Actions scroll = new Actions(getDriver());
        scroll.scrollToElement(getDriver().findElement(By.xpath("//*[@class=\"mdspost-follow__friend-text\"]"))).click(getDriver().findElement(By.xpath("//*[@class=\"mdspost-follow__friend-text\"]"))).build().perform();
//        WebElement webElement6 = getDriver().findElement(By.xpath("//*[@class=\"mdspost-follow__friend-text\"]"));
//        webElement6.click();
        Actions scroll2 = new Actions(getDriver());
        scroll2.scrollToElement(getDriver().findElement(By.xpath("//input[@class=\"b-flatbutton\"]"))).click(getDriver().findElement(By.xpath("//input[@class=\"b-flatbutton\"]"))).build().perform();
//        WebElement webElement7 = getDriver().findElement(By.xpath("//input[@class=\"b-flatbutton\"]"));
//        webElement7.click();
        Assertions.assertEquals("Добавлен в список!", getDriver().getTitle(), "Не удалось добавить в друзья");

    }
    @Test
    void makeAComment() throws InterruptedException {
        Thread.sleep(10000);
        WebElement webElement5 = getDriver().findElement(By.xpath("//a[contains(@class,\"s-header-item__link--friends\")]"));
        webElement5.click();
        WebElement webElement6 = getDriver().findElement(By.xpath("//span[@lj-ml=\"friendsfeed.link.reply\"]"));
        Actions moveToElement = new Actions(getDriver());
        moveToElement.moveToElement(webElement6).moveToElement((getDriver().findElement(By.xpath("//*[@id=\"body6849\"]")))).click((getDriver().findElement(By.xpath("//*[@id=\"body6849\"]")))).sendKeys("test1").sendKeys(Keys.ENTER).build().perform();
        Assertions.assertEquals("Лента dariyiii", getDriver().getTitle(), "Не удалось добавить комментарий");
        Assertions.assertTrue(getDriver().findElement(By.xpath("//div[contains(@class,\"quick-comment-entryunit__comment\")]")).getText().equals("test1"), "Не удалось добавить  комментарий");


}}
