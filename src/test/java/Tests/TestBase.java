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
    protected UserMainPage userMainPage;
    private String baseUrl = "https://ok.ru";
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl + "/dk?st.cmd=anonymMain&st.layer.cmd=PopLayerClose");
        userMainPage = new LoginPage(driver)
                .doLogin(new TechnopolisBot());
    }

    @After
    public void tearDown() {
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
/*TODO переделать ожидания
 * ✔ Тест 1 Проверка добавления музыки в мою музыку
 * ✔ Тест 2 Проверка изменения фотографии пользователя
 * *
 * Тест 3✔ У созданной с параметром "отключить комментирование" заметки отключенно комментирование
 * *✔Сделать переход на заметки (возможно, с помощью еще одного пэйджа) из user main page
 * *✔Добавить пэйдж заметок
 * *✔нажатие на новую заметку
 * *✔Добавить пэйдж новой заметеи
 * *✔методы заполнения полей
 * *✔метод выбора критериев
 * *✔submit
 * *✔Добваить пэйдж комментирования
 * *✔Написать тест
 * *
 * ✔Тест 4 Проверка корректного создания группы
 * ✔*Сделать пэйдж групп
 * ✔*создание новой группы
 * ✔*Добавить пэйдж выбора группы
 * ✔*нажатие на нужную группу
 * ✔ *Добавить пэйдж создания группы
 * ✔ *методы заполнения полей
 * ✔*Добавить пэйдж группы
 * ✔ *метод удаления группы
 * ✔*Написать тест
 * *
 * Тест 5 Редактирование информации о себе
 * *
 * Тест 6 ~Проверка отправки сообщений (Но нужен 2 бот)
 * *
 * Тест 7 Можна не надо?
 * Тест 8 Можна не надо?
 * Тест 9 Можна не надо?
 * Тест 10 Можна не надо?
 */
