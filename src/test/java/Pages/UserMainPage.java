package Pages;

import Pages.Groups.GroupMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class UserMainPage extends OkPage {
    private static final By USER_PROPERTIES_WINDOW_XPATH = By.xpath("//*[@class='ucard-mini toolbar_ucard js-toolbar-menu']");
    private static final By USER_LOGOUT_XPATH = By.xpath("//*[@data-l='t,logoutCurrentUser']");
    private static final By CONFIRM_EXIT = By.xpath("//*[@data-l='t,confirm']");

    private static final By GROUP_LOCATOR = By.xpath("//*[contains(@data-l, 't,userAltGroup')]");

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage doLogout() {
        driver.findElement(USER_PROPERTIES_WINDOW_XPATH).click();
        driver.findElement(USER_LOGOUT_XPATH).click();
        driver.findElement(CONFIRM_EXIT).click();
        return (new LoginPage(driver));
    }

    public GroupMainPage goToGroupPage(){
        click(GROUP_LOCATOR);
        return (new GroupMainPage(driver));
    }
}