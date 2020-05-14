package Pages;


import Tools.TechnopolisBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By LOGIN_BUTTON = By.cssSelector("div.form-actions > div > input.button-pro.__wide");
    private final By LOGIN_FIELD = By.id("field_email");
    private final By PASSWORD_FIELD = By.id("field_password");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public UserMainPage doLogin(TechnopolisBot user) {
        return doLogin(user.LOGIN, user.PASSWORD);
    }

    public UserMainPage doLogin(String login, String password) {
        driver.findElement(LOGIN_FIELD).clear();
        driver.findElement(LOGIN_FIELD).sendKeys(login);

        driver.findElement(PASSWORD_FIELD).clear();
        driver.findElement(PASSWORD_FIELD).sendKeys(password);

        driver.findElement(LOGIN_BUTTON).click();

        return new UserMainPage(driver);
    }
}