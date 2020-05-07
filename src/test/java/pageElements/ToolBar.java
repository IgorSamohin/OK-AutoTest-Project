package pageElements;

import Pages.MusicMainPage;
import Pages.UserMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ToolBar {
    private WebDriver driver;
    private final By GO_TO_MAIN_PAGE_BUTTON_LOCATOR = By.xpath("");
    private final By GO_TO_MUSIC_MAIN_PAGE_BUTTON_LOCATOR = By.xpath("//*[@class='toolbar_nav']//*[@data-l='t,music']//*[@data-l='musicLayerContainer,0.0.118']");


    public ToolBar(WebDriver driver){
        this.driver = driver;
    }
    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected UserMainPage clickOnUserMainPage(){
        click(GO_TO_MUSIC_MAIN_PAGE_BUTTON_LOCATOR);
        return (new UserMainPage(driver));
    }

    protected MusicMainPage clickOnMusicMainPage(){
        click(GO_TO_MAIN_PAGE_BUTTON_LOCATOR);
        return (new MusicMainPage(driver)); // TODO add driver
    }

}
