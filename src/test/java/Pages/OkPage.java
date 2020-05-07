package Pages;

import org.openqa.selenium.WebDriver;

public class OkPage extends BasePage {
    protected ToolBar toolBar;

    public OkPage(WebDriver driver) {
        super(driver);
        toolBar = new ToolBar(driver);
    }
}
