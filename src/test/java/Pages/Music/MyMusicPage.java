package Pages.Music;

import Pages.BasePages.MusicBasePage;
import org.openqa.selenium.WebDriver;
import pageElements.MusicTrackList;

public class MyMusicPage extends MusicBasePage {
    public MyMusicPage(WebDriver driver) {
        super(driver);
    }

    public MusicTrackList getMusicList() {
        return new MusicTrackList(driver);
    }

    public boolean isTrackPresent(String trackData) {
        MusicTrackList list = new MusicTrackList(driver);
        for (int i = 0; i < list.size(); i++)
            if (trackData.equals(list.getTrack(i).getText()))
                return true;
        return false;
    }
}
