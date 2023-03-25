package lesson6.MyTestPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PostPage extends AbstractPage {
    @FindBy(xpath = "//textarea[@class=\"text-0-2-179\"]")
    private WebElement headerArea;
    @FindBy(xpath = "//*[@class=\"public-DraftStyleDefault-block public-DraftStyleDefault-ltr\"]")
    private WebElement messageArea;

    @FindBy(xpath = "//*[@class=\"reset-0-2-89 root-0-2-91 rootSmall-0-2-94 textSemibold-0-2-101 backgroundBlue-0-2-104 textWithDropDownIcon-0-2-115\"]")
    private WebElement setAndPublish;
    @FindBy(xpath = "//footer[@class=\"footer-0-2-264 root-0-2-339\"]")
    private WebElement publish;


    public PostPage(WebDriver driver) {
        super(driver);
    }

    public PostPage headerAreaText() {
        headerArea.click();
        headerArea.sendKeys("test");
        return this;
    }

    public PostPage messageAreaText() {
        messageArea.click();
        messageArea.sendKeys("test");
        return this;
    }

    public PostPage clickSetAndPblish() {
        setAndPublish.click();
        return this;
    }

    public PostPage clickpublish() {
        publish.click();
        return this;
    }
}
