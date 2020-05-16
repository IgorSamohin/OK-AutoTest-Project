package Pages.Music;

import Pages.BasePages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MusicMainPage extends MusicBasePage {
    private final By MY_MUSIC_BUTTON_XPATH = By.xpath("//*[@class='content_menu __60o4ct']//*[@data-l='t,library']");
    private final By MUSIC_LIST_XPATH = By.xpath("//wm-tracks-list2//wm-track");
    private final By SONG_ADD_XPATH = By.xpath(".//*[@data-l='t,track']//*[@data-l='t,add']");
    private final By SONG_REMOVE_XPATH = By.xpath(".//*[@data-l='t,track']//*[@data-l='t,remove']");

    public MusicMainPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnMyMusic() { //TODO add try catch
        click(MY_MUSIC_BUTTON_XPATH);
    }

    public List<WebElement> getMusicList() {
        return driver.findElements(MUSIC_LIST_XPATH);
    }

    public void addTrackToFavorite(WebElement element) {
        element.findElement(SONG_ADD_XPATH).click();
    }

    public void removeTrackFromFavorite(WebElement element) {
        element.findElement(SONG_REMOVE_XPATH).click();
    }
}
