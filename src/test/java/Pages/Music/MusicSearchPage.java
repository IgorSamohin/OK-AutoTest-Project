package Pages.Music;

import Pages.BasePages.*;
import org.openqa.selenium.WebDriver;
import pageElements.MusicTrackList;

public class MusicSearchPage extends MusicBasePage {
    public MusicSearchPage(WebDriver driver) {
        super(driver);
    }

    public MusicTrackList getMusicList() {
        return new MusicTrackList(driver);
    }
}
