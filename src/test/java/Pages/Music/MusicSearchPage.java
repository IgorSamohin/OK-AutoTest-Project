package Pages.Music;

import Pages.BasePages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageElements.MusicTrackList;

public class MusicSearchPage extends MusicBasePage {
    private final By MUSIC_LIST_XPATH = By.xpath("//wm-tracks-list2//wm-track");

    public MusicSearchPage(WebDriver driver) {
        super(driver);
    }

    public MusicTrackList getMusicList() {
        return new MusicTrackList(driver);
    }
}
