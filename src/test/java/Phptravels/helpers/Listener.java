package Phptravels.helpers;

import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static Phptravels.helpers.Screenshots.takeScreenshot;

public class Listener implements ITestListener
{
    Logger logger = Logger.getLogger(Listener.class);

    @Override
    public void onTestStart(ITestResult result)
    {
        logger.info("Test start!");
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        takeScreenshot();
        logger.info("Test failed! Screenshot attached!");
    }
}
