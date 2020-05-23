package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MusicTrackList {
    private WebDriver driver;
    private List<WebElement> list;
    private final By MUSIC_LIST_XPATH = By.xpath("//wm-tracks-list2//wm-track");

    public MusicTrackList(WebDriver driver) {
        this.driver = driver;
        list = driver.findElements(MUSIC_LIST_XPATH);
    }

    public MusicTrack getTrack(int index) {
        return new MusicTrack(driver, list.get(index));
    }

    public int size() {
        return list.size();
    }

    public void deleteAllTracks() {
        if (list.size() > 0) {
            for (WebElement track : list) {
                new MusicTrack(driver, track)
                        .removeTrackFromFavorite();
            }
        }
    }
}
