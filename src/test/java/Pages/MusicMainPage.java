package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MusicMainPage extends OkPage{
    private final String MY_MUSIC_BUTTON_XPATH = "//*[@class = 'content_menu __60o4ct']//*[@data-l = 't,library']";
    public MusicMainPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnMyMusic() { //TODO add try catch
        click(By.xpath(MY_MUSIC_BUTTON_XPATH));
    }
}
