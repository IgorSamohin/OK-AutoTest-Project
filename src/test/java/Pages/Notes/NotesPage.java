package Pages.Notes;

import Pages.BasePages.*;
import Pages.UserMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class NotesPage extends OkPage {

    private static final By COMMENT_BUTTON_LOCATOR = By.xpath("//*[contains(@data-location,'CommentWidget')]");
    private static final By ARROW_DOWN_LOCATOR = By.xpath("//*[@class='feed_menu_ic']");
    private static final By DELETE_POST_BUTTON = By.xpath("//*[@id='hook_Block_ShortcutMenu']//a[contains(@hrefattrs,'deleteButton')]");
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

    public NotesPage deleteLastNote() {
        new Actions(driver)
                .moveToElement(driver.findElement(POST_LOCATOR))
                .moveToElement(driver.findElement(ARROW_DOWN_LOCATOR))
                .pause(Duration.ofSeconds(2))
                .build()
                .perform();
        driver.findElement(DELETE_POST_BUTTON).click();

        return this;
    }

    public NotesPage deleteAllNotes() {

        while (driver.findElements(POST_LOCATOR).size() > 0) {
            deleteLastNote();
            driver.get(driver.getCurrentUrl());
        }
        return this;
    }


}
