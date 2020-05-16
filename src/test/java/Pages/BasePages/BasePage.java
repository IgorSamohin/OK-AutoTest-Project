package Pages.BasePages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected int EXPLICIT_WAIT_TIME_IN_SECONDS = 1;
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void type(String text, By locator) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    protected void click(By locator) throws TimeoutException {
        new WebDriverWait(driver, EXPLICIT_WAIT_TIME_IN_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(locator))
                .click();
    }

    protected void clickWithMouse(By locator)  throws TimeoutException {
        WebElement element = (new WebDriverWait(driver, EXPLICIT_WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        Actions action = new Actions(driver);
        action.moveToElement(element)
                .click();
    }

    protected void clickBy(By locator, int xOffSet, int yOffSet)  throws TimeoutException {
        WebElement webElement = (new WebDriverWait(driver, EXPLICIT_WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
        Actions builder = new Actions(driver);
        builder.moveToElement(webElement, xOffSet, yOffSet).click().build().perform();
    }
}