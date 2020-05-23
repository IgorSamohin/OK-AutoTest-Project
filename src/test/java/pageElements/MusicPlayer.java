package pageElements;

import Pages.Music.MusicSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MusicToolBar {
    private WebDriver driver;
    protected int EXPLICIT_WAIT_TIME_IN_M_SEC = 500;

    private final By MUSIC_SEARCH_FIELD_LOCATOR = By.xpath(""); //todo


    public MusicToolBar(WebDriver driver){
        this.driver = driver;
    }

    public MusicSearchPage search(String musicToSearch){
        WebElement searchPanel = driver.findElement(MUSIC_SEARCH_FIELD_LOCATOR);

        for (char c : musicToSearch.toCharArray()) {
            new WebDriverWait(driver, 0, EXPLICIT_WAIT_TIME_IN_M_SEC);
            searchPanel.sendKeys(String.valueOf(c));
        }
        return (new MusicSearchPage(driver));
    }
}
