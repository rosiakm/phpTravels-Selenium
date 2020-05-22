package Phptravels.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static Phptravels.configuration.DriverManager.*;

public class BaseTest
{
    private WebDriver driver;

    @BeforeMethod
    public void driverSetUp()
    {
        driver = getSingleDriver();
    }

    @AfterMethod
    public void tearDownDriver()
    {
        quit();
    }
}
