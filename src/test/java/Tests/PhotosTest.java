package Tests;

import Pages.LoginPage;
import Pages.UserMainPage;
import Tools.TechnopolisBot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class PhotosTest extends TestBase {

    private final String imageFile = "src/test/java/dog-perch.jpg";

    @Override
    @Before
    public void setUp(){
        super.setUp();
        new UserMainPage(driver)
                .goToPhotosPage()
                .deleteAll()
                .clickOnUserMainPage();
    }


    @Test
    public void photoTest() {

        File fileToLoad = new File(imageFile);
        UserMainPage userPage = new UserMainPage(driver);
        Assert.assertFalse("Фото было загружено до теста", userPage.hasAvatar());

        Assert.assertTrue("Фото не было загружено",
        userPage
                .goToPhotosPage()
                .uploadPhoto(fileToLoad.getAbsolutePath(), 3000)
                .clickOnUserMainPage()
                .changeAvatar()
                .chooseImage()
                .hasAvatar()
        );
    }

}
