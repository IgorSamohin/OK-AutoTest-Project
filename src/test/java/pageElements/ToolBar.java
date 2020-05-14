package pageElements;

import Pages.MusicMainPage;
import Pages.UserMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToolBar {
    private WebDriver driver;
    protected int EXPLICIT_WAIT_TIME_IN_SECONDS = 1;
    private final By GO_TO_MAIN_PAGE_BUTTON_LOCATOR = By.xpath("");
    private final By GO_TO_MUSIC_MAIN_PAGE_BUTTON_LOCATOR = By.xpath("//*[@class='toolbar_nav']//*[@data-l='t,music']//*[@data-l='musicLayerContainer,0.0.118']");


    public ToolBar(WebDriver driver){
        this.driver = driver;
    }
    private void click(By locator) {
        new WebDriverWait(driver, EXPLICIT_WAIT_TIME_IN_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(locator))
                .click();
    }

    public UserMainPage clickOnUserMainPage(){
        new WebDriverWait(driver, EXPLICIT_WAIT_TIME_IN_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(GO_TO_MUSIC_MAIN_PAGE_BUTTON_LOCATOR))
                .click();
        return (new UserMainPage(driver));
    }

    public MusicMainPage clickOnMusicMainPage(){
        new WebDriverWait(driver, EXPLICIT_WAIT_TIME_IN_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(GO_TO_MAIN_PAGE_BUTTON_LOCATOR))
                .click();
        return (new MusicMainPage(driver)); // TODO add driver
    }


}
