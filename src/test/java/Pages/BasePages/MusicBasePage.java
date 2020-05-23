package Pages.BasePages;

import Pages.Music.MusicSearchPage;
import Pages.Music.MyMusicPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.yaml.snakeyaml.error.MarkedYAMLException;
import pageElements.MusicMenu;
import pageElements.MusicPlayer;
import pageElements.MusicTrack;

import java.util.List;

public abstract class MusicBasePage extends OkPage {
    private MusicPlayer musicPlayer;
    private MusicMenu musicMenu;

    public MusicBasePage(WebDriver driver) {
        super(driver);
        musicPlayer = new MusicPlayer(driver);
        musicMenu = new MusicMenu(driver);
    }

    public MusicSearchPage search(String musicToSearch) {
        return musicPlayer.search(musicToSearch);
    }

    public MyMusicPage clickOnMyMusic() { //TODO add try catch
        return musicMenu.clickOnMyMusic();
    }
}
