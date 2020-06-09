package Phptravels.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Phptravels.configuration.DriverManager.getSingleDriver;
import static Phptravels.helpers.WaitForElement.waitForElementToBeDisplayed;

public abstract class BasePage
{
    @FindBy(id = "body-section")
    private WebElement baseElement;

    Logger logger = Logger.getLogger(BasePage.class);

    public BasePage()
    {
        logger.info("Initializing web elements on this page");
        PageFactory.initElements(getSingleDriver(), this);
        waitForElementToBeDisplayed(baseElement);
    }
}
