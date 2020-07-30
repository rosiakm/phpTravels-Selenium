package Phptravels.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static Phptravels.helpers.WaitForElement.waitForElementToBeDisplayed;

public class Flights extends BasePage
{
    @FindBy(css = "a[title='Flights']")
    private WebElement flightsTab;

    @FindBy(css = "#s2id_location_from span[class='select2-chosen']")
    private WebElement fromInput;

    @FindBy(xpath = "//div[@id='select2-drop']/ul/li[3]")
    private WebElement valueFromList;

    @FindBy(id = "#s2id_location_to span[class='select2-chosen']")
    private WebElement destinationInput;

    @FindBy(xpath = "//div[@id='select2-drop'/ul/li[1]")
    private WebElement valueDestinationList;

    @FindBy(css = "input[name='departure']")
    private WebElement departureInput;

    @FindBy(css = "div[style='display: block; top: 358.087px; left: 581.25px;'] td[class='day  active']")
    private WebElement departDay;

    @FindBy(css = "input[name='arrival']")
    private WebElement arrivalInput;

    @FindBy(css = "div[style='display: block; top: 358.087px; left: 759.575px;'] td[class='day ']")
    private WebElement arrivalDay;

    @FindBy(id = "oneway")
    private WebElement oneWayRadioButton;

    @FindBy(id = "round")
    private WebElement roundTripRadioButton;

    @FindBy(xpath = "//div[@id='flights']//button[contains(text(),'Search')]")
    private WebElement searchButton;

    Logger logger = Logger.getLogger(Flights.class);

    public Flights()
    {
        super();
    }

    public Results searchForFlightConnection()
    {
        flightsTab.click();
        fromInput.click();
        fromInput.sendKeys("London");
        waitForElementToBeDisplayed(valueFromList);
        valueFromList.click();
        destinationInput.click();
        destinationInput.sendKeys("Dublin");
        waitForElementToBeDisplayed(valueDestinationList);
        valueDestinationList.click();
        departureInput.click();
        waitForElementToBeDisplayed(departDay);
        departDay.click();
        arrivalInput.click();
        waitForElementToBeDisplayed(arrivalDay);
        arrivalDay.click();
        searchButton.click();

        return new Results();
    }
}
