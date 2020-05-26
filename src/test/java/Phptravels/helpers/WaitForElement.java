package Phptravels.helpers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.IOException;
import java.time.Duration;

import static Phptravels.configuration.DriverManager.getSingleDriver;

public class WaitForElement
{
    public static void waitForElementToBeDisplayed(WebElement element) throws IOException
    {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(getSingleDriver());
        fluentWait.withTimeout(Duration.ofSeconds(10))
                  .pollingEvery(Duration.ofSeconds(1))
                  .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOf(element));
    }
}
