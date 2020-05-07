package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class UserMainPage extends BasePage {
    private final String MUSIC_BUTTON_XPATH = "//*[@class='toolbar_nav']//*[@data-l='t,music']//*[@data-l='musicLayerContainer,0.0.118']";
    private static final String USER_PROPERTIES_WINDOW_XPATH = "//*[@class='ucard-mini toolbar_ucard js-toolbar-menu']";
    private static final String USER_LOGOUT_XPATH = "//*[@data-l='t,logoutCurrentUser']";
    private static final String CONFIRM_EXIT = "//*[@data-l='t,confirm']";

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnMusicButton() {
        click(By.xpath(MUSIC_BUTTON_XPATH));
    }

    public static void doLogout(WebDriver driver){
        driver.findElement(By.xpath(USER_PROPERTIES_WINDOW_XPATH)).click();
        driver.findElement(By.xpath(USER_LOGOUT_XPATH)).click();
        driver.findElement(By.xpath(CONFIRM_EXIT)).click();

    }
}