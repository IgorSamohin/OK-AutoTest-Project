package Pages.Notes;

import Pages.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;

public class NoteLayerPage extends BasePage {

    private static final By FORWARD_LOCATOR = By.xpath("//*[@id='mtLayerForward']");
    private static final By BACK_LOCATOR = By.xpath("//*[@id='mtLayerBack']");
    private static final By CLOSE_LOCATOR = By.xpath("//*[contains(@class,'media-layer') and contains(@class,'close')]");
    private static final By DELETE_POST_BUTTON = By.xpath("//*[@id='hook_Block_ShortcutMenu']//a[contains(@hrefattrs,'deleteButton')]");
    private static final By ARROW_DOWN_LOCATOR = By.xpath("//*[@class='mlr_top_ac']");
    private boolean deleted = false;
    public final boolean LAST, FIRST;

    public NoteLayerPage(WebDriver driver) {
        super(driver);
        new Actions(driver).pause(100).build().perform();
        LAST = !driver.findElement(FORWARD_LOCATOR).getAttribute("class").contains("__active");
        FIRST = !driver.findElement(BACK_LOCATOR).getAttribute("class").contains("__active");
        System.out.println(LAST);
        System.out.println(FIRST);
    }

    public NoteLayerPage forward(){
        click(FORWARD_LOCATOR);
        return new NoteLayerPage(driver);
    }

    public NoteLayerPage back(){
        click(BACK_LOCATOR);
        return this;
    }

    public NotesPage close(){
        click(CLOSE_LOCATOR);
        return new NotesPage(driver);
    }

    public NotesPage deleteAll(){
        delete();
        if (!LAST)
            return forward().deleteAll();
        else
            return close();
    }

    public NoteLayerPage delete(){
        if (deleted)
            return this;

        new Actions(driver)
                .moveToElement(driver.findElement(ARROW_DOWN_LOCATOR))
                .build()
                .perform();
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOf(driver.findElement(DELETE_POST_BUTTON)))
                .click();
        deleted = true;

        return this;
    }


}
