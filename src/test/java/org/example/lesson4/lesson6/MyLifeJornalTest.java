package org.example.lesson4.lesson6;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lesson6.MyTestPackage.AccountPage;
import lesson6.MyTestPackage.MainPage;
import lesson6.MyTestPackage.MyFriendsPage;
import lesson6.MyTestPackage.PostPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class MyLifeJornalTest extends AbstractTest {

    @Test
    @Order(1)
    @Description("Создаем запись в журнале")
    @Severity(SeverityLevel.CRITICAL)
    void writeToBlogTest() throws InterruptedException {
        Thread.sleep(10000);
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.clickwriteToBlog();
        PostPage postPage = new PostPage(getWebDriver());
        postPage.headerAreaText();
        postPage.messageAreaText();
        postPage.clickSetAndPblish();
        postPage.clickpublish();
        Thread.sleep(10000);
        Assertions.assertEquals("test: dariyiii — ЖЖ", getWebDriver().getTitle(), "Сообщение не записано");
    }

    @Test
    @Order(2)
    @Description("Удаляем  запись из журнала")
    @Severity(SeverityLevel.CRITICAL)
    void deletePostTest() throws InterruptedException {
        Thread.sleep(10000);
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.clickaccount();
        AccountPage accountPage = new AccountPage(getWebDriver());
        accountPage.clickPostTest();
        accountPage.clickPostSetting();
        accountPage.clickEditPost();
        accountPage.clickDeletePost();
        accountPage.clickDeleteAllert();
        Assertions.assertEquals("dariyiii — ЖЖ", getWebDriver().getTitle(), "Сообщение не удалено");
    }
    @Test
    @Description("Создаем комментарий")
    @Severity(SeverityLevel.NORMAL)
    void makeAComment() throws InterruptedException {
        Thread.sleep(10000);
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.clickFriendsButton();
        MyFriendsPage myFriendsPage = new MyFriendsPage(getWebDriver());
        myFriendsPage.makeAComment();
        Assertions.assertTrue(getWebDriver().findElement(By.xpath("//div[contains(@class,\"quick-comment-entryunit__comment\")]")).getText().equals("test3"), "Не удалось добавить  комментарий");

    }}