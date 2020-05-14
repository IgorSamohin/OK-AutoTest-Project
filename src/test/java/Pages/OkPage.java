package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageElements.ToolBar;

public class OkPage extends BasePage {
    private ToolBar toolBar;

    public OkPage(WebDriver driver) {
        super(driver);
        toolBar = new ToolBar(driver);
    }

    protected UserMainPage clickOnUserMainPage(){
        return toolBar.clickOnUserMainPage();
    }

    protected MusicMainPage clickOnMusicMainPage(){
        return toolBar.clickOnMusicMainPage();
    }
}
