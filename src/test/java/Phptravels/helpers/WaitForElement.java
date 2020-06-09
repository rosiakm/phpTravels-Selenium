package Phptravels.helpers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

import static Phptravels.configuration.DriverManager.getSingleDriver;

public class WaitForElement
{
    public static void waitForElementToBeDisplayed(WebElement element)
    {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(getSingleDriver());
        fluentWait.withTimeout(Duration.ofSeconds(10))
                  .pollingEvery(Duration.ofSeconds(1))
                  .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeDisplayed(List<WebElement> elements)
    {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(getSingleDriver());
        fluentWait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
}
