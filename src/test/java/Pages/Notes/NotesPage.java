package Pages.Notes;

import Pages.BasePages.*;
import Pages.UserMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NotesPage extends OkPage {

    private static final By COMMENT_BUTTON_LOCATOR = By.xpath("//*[contains(@data-location,'CommentWidget')]");
    private static final By ARROW_DOWN_LOCATOR = By.xpath("//*[@class='feed_menu_ic']");
    private static final By POST_LOCATOR = By.xpath("//*[@tsid='userStatusShares']");

    public NotesPage(WebDriver driver) {
        super(driver);
    }

    public NotesCommentPage commentFirstNote() {
        driver.get(driver.findElement(COMMENT_BUTTON_LOCATOR).getAttribute("href"));
        return new NotesCommentPage(driver);
    }

    public NotesPostPage createNote() {
        driver.get("https://ok.ru/post");
        return new NotesPostPage(driver);
    }

    public NotesPage deleteAllNotes() {
        try{
            driver.findElement(POST_LOCATOR).click();
        }catch (NoSuchElementException e){
            return this;
        }

        return new NoteLayerPage(driver).deleteAll();
    }


}
