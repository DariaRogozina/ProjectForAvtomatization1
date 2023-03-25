package lesson6.MyTestPackage;
import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
public class AccountPage extends AbstractPage{
    @FindBy(xpath = "//a[.=\"test\"]")
    private WebElement postTest;
    @FindBy(xpath = "//*[@class=\"svgicon svgicon svgicon--more\"]")
    private WebElement postSetting;
    @FindBy(xpath = "//*[.=\"Редактировать запись\"]")
    private WebElement editPost;
    @FindBy(xpath = "//*[@class=\"item-0-2-256 itemRed-0-2-257\"]")
    private WebElement deletePost;
    @FindBy(xpath = "//button[@class=\"reset-0-2-89 root-0-2-91 backgroundBlue-0-2-104\"]")
    private WebElement deleteAllert;

        public AccountPage(WebDriver driver) {
        super(driver);
    }

    public AccountPage clickPostTest(){
        postTest.click();
        return this;
    }
    public AccountPage clickPostSetting() {
        postSetting.click();
        return this;
    }
    public AccountPage clickEditPost() {
        editPost.click();
        return this;
    }
    public AccountPage clickDeletePost() {
        deletePost.click();
        return this;
    }
    public AccountPage clickDeleteAllert() {
        deleteAllert.click();
        return this;
    }
}
