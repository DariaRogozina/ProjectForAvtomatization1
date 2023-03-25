package lesson6.MyTestPackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
public class LoginPage extends AbstractPage{
    @FindBy(id = "user")
    private WebElement login;

    @FindBy(id = "lj_loginwidget_password")
    private WebElement password;

//    @FindBy(id="password-input")
//    private WebElement passwordInput;

    @FindBy(name = "action:login")
    private WebElement submit;


    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void loginIn(){
        this.submit.click();
    }

    public LoginPage setLogin(String login){
        this.login.sendKeys(login);
        return this;
    }

    public LoginPage setPassword(String password){
        this.password.click();
        this.password.sendKeys(password);
        return this;
    }
}
