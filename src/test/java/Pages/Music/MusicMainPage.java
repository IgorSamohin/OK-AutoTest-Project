package Pages.Music;

import Pages.BasePages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageElements.MusicMenu;

import java.util.List;

public class MusicMainPage extends MusicBasePage {
    private final By MUSIC_LIST_XPATH = By.xpath("//wm-tracks-list2//wm-track");

    public MusicMainPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getMusicList() {
        return driver.findElements(MUSIC_LIST_XPATH);
    }
}
