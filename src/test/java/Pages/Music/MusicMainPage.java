package Pages.Music;

import Pages.BasePages.*;
import org.openqa.selenium.WebDriver;
import pageElements.MusicTrackList;

public class MusicMainPage extends MusicBasePage {
    public MusicMainPage(WebDriver driver) {
        super(driver);
    }

    public MusicTrackList getMusicList() {
        return new MusicTrackList(driver);
    }
}
