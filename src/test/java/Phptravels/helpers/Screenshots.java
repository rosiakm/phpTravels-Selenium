package Phptravels.helpers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static Phptravels.configuration.DriverManager.getSingleDriver;

public class Screenshots
{
    public static byte[] takeScreenshot()
    {
        return ((TakesScreenshot)getSingleDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
