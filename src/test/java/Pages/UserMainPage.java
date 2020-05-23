package Pages;

import Pages.Groups.GroupMainPage;
import Pages.BasePages.*;
import Pages.Music.MusicMainPage;
import Pages.Notes.NotesPage;
import Pages.Photos.AvatarChoosePage;
import Pages.Photos.PhotosPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UserMainPage extends OkPage {
    private static final By USER_PROPERTIES_WINDOW_LOCATOR = By.xpath("//*[@class='ucard-mini toolbar_ucard js-toolbar-menu']");
    private static final By USER_LOGOUT_LOCATOR = By.xpath("//*[@data-l='t,logoutCurrentUser']");
    private static final By CONFIRM_EXIT = By.xpath("//*[@data-l='t,confirm']");

    private static final By GROUP_LOCATOR = By.xpath("//*[contains(@data-l, 't,userAltGroup')]");
    private static final By NOTES_LOCATOR = By.xpath("//a[@data-l='t,userStatuses']");
    private static final By PHOTOS_LOCATOR = By.xpath("//a[@data-l='t,userPhotos']");

    private static final By AVATAR_LOCATOR = By.xpath("//*[@class='entity-avatar']");


    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    public AvatarChoosePage changeAvatar(){
        click(AVATAR_LOCATOR);
        return new AvatarChoosePage(driver);
    }

    public LoginPage doLogout() {
        driver.findElement(USER_PROPERTIES_WINDOW_LOCATOR).click();
        driver.findElement(USER_LOGOUT_LOCATOR).click();
        driver.findElement(CONFIRM_EXIT).click();
        return (new LoginPage(driver));
    }

    public GroupMainPage goToGroupPage() {
        click(GROUP_LOCATOR);
        return (new GroupMainPage(driver));
    }

    public NotesPage goToNotesPage() {
        click(NOTES_LOCATOR);
        return new NotesPage(driver);
    }

    public PhotosPage goToPhotosPage(){
        click(PHOTOS_LOCATOR);
        return new PhotosPage(driver);
    }


    public boolean hasAvatar(){
        WebElement avatar = driver.findElement(AVATAR_LOCATOR);
        return avatar.findElements(By.xpath(".//img")).size() == 1;
    }

    public MusicMainPage goToMusicMainPage() {
        return clickOnMusicMainPage();
    }

}