package Pages.BasePages;

import Pages.Music.MusicSearchPage;
import org.openqa.selenium.WebDriver;
import pageElements.MusicToolBar;

public class MusicBasePage extends OkPage {
    private MusicToolBar musicToolBar;

    public MusicBasePage(WebDriver driver) {
        super(driver);
    }

    public MusicSearchPage search(String musicToSearch){
        return musicToolBar.search(musicToSearch);
    }
}
