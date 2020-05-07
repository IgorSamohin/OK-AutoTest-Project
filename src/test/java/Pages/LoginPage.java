package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static UserMainPage doLogin(WebDriver driver, String login, String password) {
        driver.findElement(By.id("field_email")).clear();
        driver.findElement(By.id("field_email")).sendKeys(login); // "technopolisbot"
        driver.findElement(By.id("field_password")).clear();
        driver.findElement(By.id("field_password")).sendKeys(password); //"technopolis16"
        driver.findElement(By.cssSelector("div.form-actions > div > input.button-pro.__wide")).click();
        UserMainPage userMainPage = new UserMainPage(driver);
        return userMainPage;
    }
}