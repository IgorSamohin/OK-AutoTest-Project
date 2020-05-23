package pageElements;

import Pages.BasePages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MusicMenu extends BasePage {
    private WebDriver driver;

    private final By MY_MUSIC_BUTTON_XPATH = By.xpath("//*[@class='content_menu __60o4ct']//*[@data-l='t,library']");


    public MusicMenu(WebDriver driver) {
        super(driver);
    }

    public MyMusicPage clickOnMyMusic() { //TODO add try catch
        click(MY_MUSIC_BUTTON_XPATH);
    }
}
