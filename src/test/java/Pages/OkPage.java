package Pages;

import org.openqa.selenium.WebDriver;
import pageElements.ToolBar;

public class OkPage extends BasePage {
    protected ToolBar toolBar;

    public OkPage(WebDriver driver) {
        super(driver);
        toolBar = new ToolBar(driver);
    }
}
