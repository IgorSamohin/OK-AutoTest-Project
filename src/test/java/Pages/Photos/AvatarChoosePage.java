package Pages.Photos;

import Pages.BasePages.BasePage;
import Pages.UserMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AvatarChoosePage extends BasePage {

    private static final By IMAGE_LOCATOR = By.xpath("//*[contains(@id,'photos')]//img");
    private static final By SUBMIT_LOCATOR = By.xpath("//button[@type='submit']");

    public AvatarChoosePage(WebDriver driver) {
        super(driver);
    }

    public UserMainPage chooseImage(){
        click(IMAGE_LOCATOR);
        click(SUBMIT_LOCATOR);
        new Actions(driver).pause(500).build().perform();
        return new UserMainPage(driver);
    }

}
