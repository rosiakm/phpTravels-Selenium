package Phptravels.pages;

import org.apache.log4j.Logger;

import static Phptravels.helpers.Screenshots.takeScreenshot;

public class Summary extends BasePage
{
    Logger logger = Logger.getLogger(Summary.class);

    public Summary()
    {
        super();
        logger.info("New Summary page returned.");
        takeScreenshot();
    }
}
