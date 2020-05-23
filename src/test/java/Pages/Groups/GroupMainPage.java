package Pages.Groups;

import Pages.BasePages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupMainPage extends OkPage {
    private static final By CREATE_NEW_GROUP_LOCATOR = By.xpath("//*[contains(@class, 'button-pro __wide __light __ic')]");

    public GroupMainPage(WebDriver driver) {
        super(driver);
    }

    public ChooseNewGroupTypeLayer createNewGroup() {
        click(CREATE_NEW_GROUP_LOCATOR);
        return (new ChooseNewGroupTypeLayer(driver));
    }
}
