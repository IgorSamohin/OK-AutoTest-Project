package Pages.Groups;

import Pages.OkPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupPage extends OkPage {
    private final By GROUP_FAST_PREFERENCES_BUTTON_LOCATOR = By.xpath("//*[contains(@class, 'u-menu_a toggle-dropdown')]");
    private final By DELETE_OPTION_LOCATOR = By.xpath("//*[contains(@class, 'svg-ic svg-ico_trash_16 null')]/..");
    private final By DELETE_SUBMIT_BUTTON_LOCATOR = By.xpath("//*[contains(@data-l, 't,confirm')]");


    public GroupPage(WebDriver driver) {
        super(driver);
    }

    public GroupMainPage deleteGroup(){
        click(GROUP_FAST_PREFERENCES_BUTTON_LOCATOR);
        click(DELETE_OPTION_LOCATOR);
        click(DELETE_SUBMIT_BUTTON_LOCATOR);
        return (new GroupMainPage(driver));
    }
}
