package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MusicMainPage extends OkPage{
    private final By MY_MUSIC_BUTTON_XPATH = By.xpath("//*[@class = 'content_menu __60o4ct']//*[@data-l = 't,library']");
    public MusicMainPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnMyMusic() { //TODO add try catch
        click(MY_MUSIC_BUTTON_XPATH);
    }
}
