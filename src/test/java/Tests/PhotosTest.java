package Tests;

import Pages.UserMainPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

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
