package Pages.Groups;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewGroupPreferencesPage extends BasePage {
    protected int EXPLICIT_WAIT_TIME_IN_M_SEC = 500;
    private static final By GROUP_NAME_LOCATOR = By.xpath("");
    private static final By GROUP_DESCRIPTION_LOCATOR = By.xpath("");

    private static final By CREATE_BUTTON_LOCATOR = By.xpath("");

    public NewGroupPreferencesPage(WebDriver driver) {
        super(driver);
    }

    public void enterGroupName(String groupName){
        String currText = "";
        for (char c : groupName.toCharArray()) {
            new WebDriverWait(driver, 0, EXPLICIT_WAIT_TIME_IN_M_SEC)
                    .until(ExpectedConditions.textToBe(GROUP_NAME_LOCATOR, currText));
            driver.findElement(GROUP_NAME_LOCATOR)
                    .sendKeys(String.valueOf(c));
            currText += String.valueOf(c);
        }
        driver.findElement(GROUP_NAME_LOCATOR)
                .sendKeys("\n");
    }

    public void enterGroupDescription(String groupDescription){
        String currText = "";
        for (char c : groupDescription.toCharArray()) {
            new WebDriverWait(driver, 0, EXPLICIT_WAIT_TIME_IN_M_SEC)
                    .until(ExpectedConditions.textToBe(GROUP_DESCRIPTION_LOCATOR, currText));
            driver.findElement(GROUP_DESCRIPTION_LOCATOR)
                    .sendKeys(String.valueOf(c));
            currText += String.valueOf(c);
        }
        driver.findElement(GROUP_DESCRIPTION_LOCATOR)
                .sendKeys("\n");
    }

    public GroupPage createGroup(){
        click(CREATE_BUTTON_LOCATOR);
        return (new GroupPage(driver));
    }
}
