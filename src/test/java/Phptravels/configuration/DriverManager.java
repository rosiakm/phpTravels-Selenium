package Phptravels.configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static Phptravels.helpers.taskManagerProcessHelper.isProcessRunning;
import static Phptravels.helpers.taskManagerProcessHelper.killProcess;

public class DriverManager
{
    private static WebDriver driver;
    private static String processName = "chrome.exe";

    public static WebDriver getSingleDriver() throws IOException
    {
        if(driver == null)
        {
            getDriverType(DriverType.CHROME);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("http://www.kurs-selenium.pl/demo/");
        }

        return driver;
    }

    private static void getDriverType(DriverType driverType) throws IOException
    {
        switch (driverType)
        {
            case CHROME:
            {
                if (isProcessRunning(processName))
                {
                    killProcess(processName);
                }
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            break;
            case FIREFOX:
            {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            break;
            case IE:
            {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            }
            break;
        }
    }

    public static void quit()
    {
        if(driver != null)
        {
            driver.quit();
        }
        driver = null;
    }
}
