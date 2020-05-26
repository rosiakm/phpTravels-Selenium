package Phptravels.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import static Phptravels.configuration.DriverManager.*;

public class BaseTest
{
    private WebDriver driver;

    @BeforeMethod
    public void driverSetUp() throws IOException
    {
        driver = getSingleDriver();
    }

    @AfterMethod
    public void tearDownDriver()
    {
        quit();
    }
}
