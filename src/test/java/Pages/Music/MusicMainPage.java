package Pages.Music;

import Pages.OkPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MusicMainPage extends OkPage {
    private final By MY_MUSIC_BUTTON_XPATH = By.xpath("//*[@class='content_menu __60o4ct']//*[@data-l='t,library']");
    private final String MUSIC_LIST_XPATH = "//wm-tracks-list2//wm-track";
    private final String SONG_ADD_XPATH = ".//*[@data-l='t,track']//*[@data-l='t,add']";
    private final String SONG_REMOVE_XPATH = ".//*[@data-l='t,track']//*[@data-l='t,remove']";

    public MusicMainPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnMyMusic() { //TODO add try catch
        click(MY_MUSIC_BUTTON_XPATH);
    }

    public List<WebElement> getMusicList() {
        return driver.findElements(By.xpath(MUSIC_LIST_XPATH));
    }

    public void addTrackToFavorite(WebElement element) {
        element.findElement(By.xpath(SONG_ADD_XPATH)).click();
    }

    public void removeTrackFromFavorite(WebElement element) {
        element.findElement(By.xpath(SONG_REMOVE_XPATH)).click();
    }
}
