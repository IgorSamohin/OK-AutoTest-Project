package Tests;

import Pages.LoginPage;
import Pages.MusicMainPage;
import Pages.UserMainPage;
import Tools.TechnopolisBot;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.fail;

public class TestBase {

    WebDriver driver;
    private String baseUrl = "https://ok.ru";
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
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

    @Test
    public void sometest(){
        try {
            (new MusicMainPage(driver)).clickOnMyMusic();
        }catch(Exception e) {
            System.out.println("yep");
        }
    }
}
/**TODO переделать ожидания
 *
 * ~✔ Тест 1 Проверка добавления музыки в мою музыку
 * Тест 2 Проверка изменения фотографии пользователя
 *      *
        *driver.findElement(туть локатор кнопки добавления)
 *         .sendKeys("туть обсолютный путь");
 *      *
 *
 * Тест 3 У созданной с параметром "отключить комментирование" заметки отключенно комментирование
 *      *Сделать переход на заметки (возможно, с помощью еще одного пэйджа) из user main page
 *      *Добавить пэйдж заметок
 *          *нажатие на новую заметку
 *      *Добавить пэйдж новой заметеи
 *          *методы заполнения полей
 *          *метод выбора критериев
 *          *submit
 *      *Добваить пэйдж комментирования
 *
 * Тест 4 Проверка корректного создания группы
 *      *Сделать пэйдж групп
 *          *создание новой группы
 *      *Добавить пэйдж выбора группы
 *          *нажатие на нужную группу
 *      *Добавить пэйдж создания группы
 *          *методы заполнения полей
 *      *Добавить пэйдж группы
 *          *метод удаления группы
 *
 * Тест 5 Редактирование информации о себе
 *
 * Тест 6 ~Проверка отправки сообщений (Но нужен 2 бот)
 *
 * Тест 7 Можна не надо?
 * Тест 8 Можна не надо?
 * Тест 9 Можна не надо?
 * Тест 10 Можна не надо?
  */
