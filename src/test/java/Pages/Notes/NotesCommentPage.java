package Pages.Notes;

import Pages.OkPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotesCommentPage extends OkPage {

    private static final By COMMENT_LOCATOR = By.xpath("//input[@uid='uidClickSimpleInput']");

    public NotesCommentPage(WebDriver driver) {
        super(driver);
    }

    public boolean areCommentsDisabled(){
        return driver.findElement(COMMENT_LOCATOR).getAttribute("disabled").equals("true");
    }
}
