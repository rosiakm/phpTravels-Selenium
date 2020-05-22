package Phptravels.helpers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static Phptravels.configuration.DriverManager.getSingleDriver;

public class Screenshots
{
    public static byte[] takeScreenshot(WebDriver driver)
    {
        return ((TakesScreenshot)getSingleDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
