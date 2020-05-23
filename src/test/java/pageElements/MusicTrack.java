package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MusicTrack {
    private final By SONG_ADD_XPATH = By.xpath(".//*[@data-l='t,track']//*[@data-l='t,add']");
    private final By SONG_REMOVE_XPATH = By.xpath(".//*[@data-l='t,track']//*[@data-l='t,remove']");

    private WebElement track;
    private WebDriver driver;

    public MusicTrack(WebDriver driver, WebElement track) {
        this.driver = driver;
        this.track = track;
    }

    public void addTrackToFavorite() {
        new Actions(driver)
                .moveToElement(track)
                .build()
                .perform();
        track.findElement(SONG_ADD_XPATH).click();
    }

    public void removeTrackFromFavorite() {
        new Actions(driver)
                .moveToElement(track)
                .build()
                .perform();
        track.findElement(SONG_REMOVE_XPATH).click();
    }

    public String getText() {
        return track.getText();
    }

}
