package Pages.BasePages;

import Pages.Music.*;
import Pages.UserMainPage;
import org.openqa.selenium.WebDriver;
import pageElements.ToolBar;

public class OkPage extends BasePage {
    private ToolBar toolBar;

    public OkPage(WebDriver driver) {
        super(driver);
        toolBar = new ToolBar(driver);
    }

    public UserMainPage clickOnUserMainPage(){
        return toolBar.clickOnUserMainPage();
    }

    public MusicMainPage clickOnMusicMainPage(){
        return toolBar.clickOnMusicMainPage();
    }
}
