package Phptravels.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static Phptravels.configuration.DriverManager.getSingleDriver;
import static Phptravels.helpers.Screenshots.takeScreenshot;
import static Phptravels.helpers.WaitForElement.waitForElementToBeDisplayed;

public class Hotels extends BasePage
{
    @FindBy(id = "s2id_autogen8")
    private WebElement destinationInput;

    @FindBy(css = "#select2-drop input")
    private WebElement activeDestinationInput;

    @FindBy(css = "input[class='form input-lg dpd1']")
    private WebElement checkInInput;

    @FindBy(css = "input[class='form input-lg dpd2']")
    private WebElement checkOutInput;

    @FindBy(id = "travellersInput")
    private WebElement travellersNumberInput;

    @FindBy(css = "ul[class='select2-result-sub']")
    private WebElement destinationsList;

    @FindBy(xpath = "//ul[@class='select2-result-sub']/li")
    private List<WebElement> destinationResults;

    @FindBy(id = "adultMinusBtn")
    private WebElement adultMinusButton;

    @FindBy(id = "adultPlusBtn")
    private WebElement adultPlusButton;

    @FindBy(id = "options")
    private WebElement travellersNumberMenu;

    @FindBy(css = "div[class='col-md-2 form-group go-right col-xs-12 search-button'] button")
    private WebElement searchButton;

    public Results searchForHotel()
    {
        takeScreenshot(getSingleDriver());
        destinationInput.click();
        activeDestinationInput.sendKeys("Dubai");
        waitForElementToBeDisplayed(destinationsList);
        destinationResults.get(0).click();
        checkInInput.sendKeys("14/06/2020");
        checkOutInput.sendKeys("20/06/2020");
        travellersNumberInput.click();
        waitForElementToBeDisplayed(travellersNumberMenu);
        adultMinusButton.click();
        adultPlusButton.click();
        travellersNumberInput.click();
        takeScreenshot(getSingleDriver());
        searchButton.click();

        return new Results();
    }

}
