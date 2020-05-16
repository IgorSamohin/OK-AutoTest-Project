package Pages.Groups;

import Pages.BasePages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChooseNewGroupTypeLayer extends BasePage {
    private static final By PAGE_LOCATOR = By.xpath("//*[contains(@data-l, 't,PAGE')]");

    public ChooseNewGroupTypeLayer(WebDriver driver) {
        super(driver);
    }

    public NewGroupPreferencesPage choosePublicPage(){
        click(PAGE_LOCATOR);
        return (new NewGroupPreferencesPage(driver));
    }
}
