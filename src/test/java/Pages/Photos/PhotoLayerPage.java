package Pages.Photos;

import Pages.BasePages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PhotoLayerPage extends BasePage {

    private static final By DELETE_LOCATOR = By.xpath("//*[@data-activate='deletePhoto']");

    //проблемы с двумя версиями. В экстренном случае удалить "and not(contains(@class,'v2'))"
    private static final By CLOSE_LOCATOR = By.xpath("//*[contains(@class,'photo-layer_close') and not(contains(@class,'v2'))]");
    private boolean deleted = false;

    public PhotoLayerPage(WebDriver driver) {
        super(driver);
    }

    public PhotosPage close(){
        click(CLOSE_LOCATOR);
        return new PhotosPage(driver);
    }

    public PhotoLayerPage delete(){
        if (deleted)
            return this;

        click(DELETE_LOCATOR);
        deleted = true;
        return this;
    }
}
