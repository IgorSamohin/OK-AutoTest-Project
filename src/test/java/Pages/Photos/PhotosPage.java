package Pages.Photos;

import Pages.BasePages.OkPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class PhotosPage extends OkPage {

    private static final By ALL_PHOTOS_LOCATOR = By.xpath("//*[@class='photo-sc']//img");
    private static final By UPLOAD_LOCATOR = By.xpath("//input[contains(@data-context,'USER_PHOTO')]");

    private List<WebElement> AllPhotos;

    public PhotosPage(WebDriver driver) {
        super(driver);
    }

    public PhotosPage uploadPhoto(String path, long timeToLoadMillis){
        driver.findElement(UPLOAD_LOCATOR).sendKeys(path);
        new Actions(driver).pause(timeToLoadMillis).build().perform();
        return this;
    }

    public PhotoLayerPage openPhoto(int photoNumber) {
        AllPhotos.get(photoNumber - 1).click();
        return new PhotoLayerPage(driver);
    }

    public PhotosPage deleteAll() {
        while (AllPhotos.size() != 0){
            openPhoto(1)
                    .delete()
                    .close();
            refresh();
        }
        return this;
    }

    @Override
    protected void init(){
        AllPhotos = driver.findElements(ALL_PHOTOS_LOCATOR);
    }


}
