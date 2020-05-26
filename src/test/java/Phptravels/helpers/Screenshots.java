package Phptravels.helpers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static Phptravels.configuration.DriverManager.getSingleDriver;

public class Screenshots
{
    public static byte[] takeScreenshot(WebDriver driver) throws IOException
    {
        return ((TakesScreenshot)getSingleDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
