package Tests;

import Pages.UserMainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageElements.MusicTrack;
import pageElements.MusicTrackList;
import pageElements.ToolBar;

import java.io.IOException;

public class MusicTest extends TestBase {
    private final String musicToSearch = "Кто пчелок уважает";

    @Override
    @Before
    public void setUp() {
        super.setUp();
        new UserMainPage(driver)
                .goToMusicMainPage()
                .clickOnMyMusic()
                .getMusicList()
                .deleteAllTracks();
        new ToolBar(driver)
                .clickOnUserMainPage();
    }

    @Test
    public void CorrectAdditionTrackInFavoriteTest() {
        MusicTrack musicTrack = (new UserMainPage(driver))
                .goToMusicMainPage()
                .search(musicToSearch)
                .getMusicList()
                .getTrack(0);

        String trackData = musicTrack.getText();
        musicTrack.addTrackToFavorite();
        new ToolBar(driver)
                .clickOnUserMainPage();

        Assert.assertTrue("The song has not been added",
                new UserMainPage(driver)
                        .goToMusicMainPage()
                        .clickOnMyMusic()
                        .isTrackPresent(trackData));
    }

    @Override
    @After
    public void tearDown() {
        new ToolBar(driver)
                .clickOnUserMainPage()
                .goToMusicMainPage()
                .clickOnMyMusic()
                .getMusicList()
                .deleteAllTracks();

        super.tearDown();
    }
}
