package Pages.Music;

import Pages.BasePages.MusicBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageElements.MusicTrack;
import pageElements.MusicTrackList;

import java.util.List;

public class MyMusicPage extends MusicBasePage {
    private final String MUSIC_LIST_XPATH = "//wm-tracks-list2//wm-track";

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
