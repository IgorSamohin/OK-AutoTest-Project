package Pages.Groups;

import Pages.OkPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupMainPage extends OkPage {
    private static final By CREATE_NEW_GROUP_LOCATOR = By.xpath(""); //TODO

    public GroupMainPage(WebDriver driver) {
        super(driver);
    }

    public ChooseNewGroupTypeLayer createNewGroup(){
        click(CREATE_NEW_GROUP_LOCATOR);
        return (new ChooseNewGroupTypeLayer(driver));
    }
}
