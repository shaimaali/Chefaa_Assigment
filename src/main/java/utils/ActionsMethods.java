package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsMethods {
    protected WebDriver driver;
    public ActionsMethods(WebDriver driver){
        this.driver=driver;
    }
    protected WebElement webElement(By locatorName) {
        return driver.findElement(locatorName);
    }

    public void setText(By textElement, String textValue) {
        webElement(textElement).clear();
        webElement(textElement).sendKeys(textValue);
        webElement(textElement).sendKeys(Keys.RETURN);
    }

    public void clickLink (By link) {
        webElement(link).click();
    }
    public void waitElementVisability(By waitElement,int second){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until((ExpectedConditions.visibilityOf(webElement(waitElement))));
    }

}