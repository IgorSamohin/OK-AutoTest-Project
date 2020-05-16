package Pages.Notes;

import Pages.BasePages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotesPostPage extends BasePage {

    private static final By SETTINGS_BUTTON_LOCATOR = By.xpath("//span[contains(@class,'settings')]");
    private static final By DISABLE_COMMENTS_LOCATOR = By.xpath(".//input[contains(@name, 'toggleComments')]/../*[contains(@class,'irc_l')]");
    private static final By TEXT_FIELD_LOCATOR = By.xpath("//*[contains(@class,'posting-handler')]");
    private static final By POSTING_SUBMIT_BUTTON_LOCATOR = By.xpath("//*[contains(@class, 'posting_submit')]");

    public NotesPostPage(WebDriver driver) {
        super(driver);
    }

    public NotesPage sendPost(){
        click(POSTING_SUBMIT_BUTTON_LOCATOR);
        return new NotesPage(driver);
    }

    public NotesPostPage disableComments() {
        openSettings();
        click(DISABLE_COMMENTS_LOCATOR);
        return this;
    }

    public NotesPostPage writePost(String text) {
        click(TEXT_FIELD_LOCATOR);
        type(text, TEXT_FIELD_LOCATOR);
        return this;
    }

    private void openSettings() {
        click(SETTINGS_BUTTON_LOCATOR);
    }

}
