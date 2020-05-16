package Pages.Groups;

import Pages.OkPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class GroupPage extends OkPage {
    private final By GROUP_FAST_PREFERENCES_BUTTON_LOCATOR = By.xpath("//*[contains(@class, 'u-menu_a toggle-dropdown')]");
    private final By DELETE_OPTION_LOCATOR = By.xpath("//*[contains(@class, 'svg-ic svg-ico_trash_16 null')]/parent::*/parent::*");
    private final By DELETE_SUBMIT_BUTTON_LOCATOR = By.xpath("//*[contains(@data-l, 't,confirm')]");

    private final By GROUP_NAME_LOCATOR =  By.xpath("//*[contains(@class, 'group-name_t')]");
    private final By GROUP_DESCRIPTION_LOCATOR =  By.xpath("//*[contains(@data-module, 'GroupInfoPanel')]");
    private final By GROUP_TYPE_LOCATOR =  By.xpath("//*[contains(@class, 'group-name_info')]");

    public GroupPage(WebDriver driver) {
        super(driver);
    }

    public GroupMainPage deleteGroup(){
        click(GROUP_FAST_PREFERENCES_BUTTON_LOCATOR);
        driver.findElement(DELETE_OPTION_LOCATOR).click();
        //clickWithMouse(DELETE_OPTION_LOCATOR); //todo why it is not working??
        click(DELETE_SUBMIT_BUTTON_LOCATOR);
        return (new GroupMainPage(driver));
    }

    public String getGroupName(){
        return driver.findElement(GROUP_NAME_LOCATOR).getText();
    }

    public String getGroupDescription(){
        return driver.findElement(GROUP_DESCRIPTION_LOCATOR).getText();
    }

    public boolean isPublicGroup(){
        return (driver.findElement(GROUP_TYPE_LOCATOR).getText().equals("Публичная страница"));
    }
}
