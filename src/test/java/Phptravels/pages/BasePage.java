package Phptravels.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Phptravels.configuration.DriverManager.getSingleDriver;
import static Phptravels.helpers.WaitForElement.waitForElementToBeDisplayed;

public class BasePage
{
    @FindBy(id = "body-section")
    private WebElement baseElement;

    public BasePage()
    {
        PageFactory.initElements(getSingleDriver(), this);
        waitForElementToBeDisplayed(baseElement);
    }
}
