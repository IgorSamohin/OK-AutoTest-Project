package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public abstract class BasePage {
    protected WebDriver driver;
    protected ToolBar toolBar;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void type(String text, By locator) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void clickBy(By locator, int xOffSet, int yOffSet) {
        WebElement webElement = driver.findElement(locator);
        Actions builder = new Actions(driver);
        builder.moveToElement(webElement, xOffSet, yOffSet).click().build().perform();
    }
}