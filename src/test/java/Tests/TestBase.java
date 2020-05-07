package Tests;

import Pages.LoginPage;
import Pages.UserMainPage;
import Tools.TechnopolisBot;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class TestBase {

    WebDriver driver;
    private String baseUrl = "https://ok.ru";
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/dk?st.cmd=anonymMain&st.layer.cmd=PopLayerClose");

        new LoginPage(driver)
                .doLogin(new TechnopolisBot());
    }


    @After
    public void tierDown(){
        driver.get(baseUrl);
        new UserMainPage(driver)
                .doLogout();
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
