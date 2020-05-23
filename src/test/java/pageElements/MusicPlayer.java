package pageElements;

import Pages.Music.MusicSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MusicPlayer {
    private WebDriver driver;
    protected int EXPLICIT_WAIT_TIME_IN_M_SEC = 50;

    private final By MUSIC_SEARCH_FIELD_LOCATOR = By.xpath("//*[@class='wm-app_sticky-wrapper __28uh5f']//*[@data-l='t,search-input']");


    public MusicPlayer(WebDriver driver) {
        this.driver = driver;
    }

    public MusicSearchPage search(String musicToSearch) {
        WebElement searchPanel = driver.findElement(MUSIC_SEARCH_FIELD_LOCATOR);

        for (char c : musicToSearch.toCharArray()) {
            new Actions(driver)
                    .pause(EXPLICIT_WAIT_TIME_IN_M_SEC)
                    .build()
                    .perform();
            searchPanel.sendKeys(String.valueOf(c));
        }
        searchPanel.sendKeys(String.valueOf("\n"));
        return (new MusicSearchPage(driver));
    }
}
