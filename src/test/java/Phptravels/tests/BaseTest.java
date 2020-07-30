package Phptravels.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static Phptravels.configuration.DriverManager.*;

public class BaseTest
{
    protected WebDriver driver;
    Logger logger = Logger.getLogger(BaseTest.class);

    @BeforeMethod
    public void driverSetUp()
    {
        logger.info("Set up new chrome instance before method!");
        driver = getSingleDriver();
    }

    /*@AfterMethod
    public void tearDownDriver()
    {
        logger.info("Tear down chrome instance after method!");
        quit();
    }*/
}
