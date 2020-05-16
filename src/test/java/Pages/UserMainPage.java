package Pages;

import Pages.Notes.NotesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class UserMainPage extends OkPage {
    private static final String USER_PROPERTIES_WINDOW_XPATH = "//*[@class='ucard-mini toolbar_ucard js-toolbar-menu']";
    private static final String USER_LOGOUT_XPATH = "//*[@data-l='t,logoutCurrentUser']";
    private static final String CONFIRM_EXIT = "//*[@data-l='t,confirm']";
    private static final By NOTES_LOCATOR = By.xpath("//a[@data-l='t,userStatuses']");

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage doLogout() {
        driver.findElement(By.xpath(USER_PROPERTIES_WINDOW_XPATH)).click();
        driver.findElement(By.xpath(USER_LOGOUT_XPATH)).click();
        driver.findElement(By.xpath(CONFIRM_EXIT)).click();
        return (new LoginPage(driver));
    }

    public NotesPage goToNotesPage(){
        click(NOTES_LOCATOR);
        return new NotesPage(driver);
    }

}