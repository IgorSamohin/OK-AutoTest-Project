package Pages.Groups;

import Pages.BasePages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewGroupPreferencesPage extends BasePage {
    protected int EXPLICIT_WAIT_TIME_IN_M_SEC = 500;
    private static final By GROUP_NAME_LOCATOR = By.xpath("//*[contains(@id, 'field_name')]");
    private static final By GROUP_DESCRIPTION_LOCATOR = By.xpath("//*[contains(@id, 'field_description')]");

    private static final By CREATE_BUTTON_LOCATOR = By.xpath("//*[contains(@data-l, 't,confirm')]");

    public NewGroupPreferencesPage(WebDriver driver) {
        super(driver);
    }

    public void enterGroupName(String groupName){
        for (char c : groupName.toCharArray()) {
            new WebDriverWait(driver, 0, EXPLICIT_WAIT_TIME_IN_M_SEC);
            driver.findElement(GROUP_NAME_LOCATOR)
                    .sendKeys(String.valueOf(c));
        }
    }

    public void enterGroupDescription(String groupDescription){
        WebElement descriptionArea = driver.findElement(GROUP_DESCRIPTION_LOCATOR);
        click(GROUP_DESCRIPTION_LOCATOR);
        for (char c : groupDescription.toCharArray()) {
            new WebDriverWait(driver, 0, EXPLICIT_WAIT_TIME_IN_M_SEC);
            descriptionArea.sendKeys(String.valueOf(c));
        }
    }

    public GroupPage createGroup(){
        click(CREATE_BUTTON_LOCATOR);
        return (new GroupPage(driver));
    }
}
