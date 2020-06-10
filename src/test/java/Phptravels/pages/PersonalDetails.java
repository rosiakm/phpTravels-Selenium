package Phptravels.pages;

import Phptravels.helpers.DataFaker;
import org.apache.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static Phptravels.configuration.DriverManager.getSingleDriver;
import static Phptravels.helpers.Screenshots.takeScreenshot;

public class PersonalDetails extends BasePage
{
    @FindBy(css = "input[name='firstname']")
    private WebElement firstNameInput;

    @FindBy(css = "input[name='lastname']")
    private WebElement lastNameInput;

    @FindBy(css = "input[name='email']")
    private WebElement emailInput;

    @FindBy(css = "input[name='confirmemail']")
    private WebElement confirmEmailInput;

    @FindBy(xpath = "//div[@class='alert alert-danger']/p")
    private List<WebElement> alertsList;

    @FindBy(xpath = "//form[@id='bookingdetails']//tbody/tr[1]/td[4]//span[contains(text(),'No')]")
    private WebElement romanticRoomDecorationCheckbox;

    @FindBy(xpath = "//form[@id='bookingdetails']//tbody/tr[2]/td[4]//span[contains(text(),'No')]")
    private WebElement flowerBouquetInRoomCheckbox;

    @FindBy(css = ".form-group button[type='submit']")
    private WebElement confirmBookingButton;

    @FindBy(xpath = "//table[@class='table table_summary'][1]//tr")
    private List<WebElement> amountUnitsList;

    @FindBy(xpath = "//form[@id='bookingdetails']//tbody//td[4]//span[contains(text(),'No')]")
    private List<WebElement> orderButtonsFromExtrasList;

    @FindBy(xpath = "//form[@id='bookingdetails']//tbody//td[2]/span")
    private List<WebElement> itemsFromExtrasList;

    @FindBy(xpath = "//form[@id='bookingdetails']//tbody//td[3]")
    private List<WebElement> pricesFromExtrasList;

    @FindBy(id = "displaytotal")
    private WebElement totalAmount;

    DataFaker dataFaker = new DataFaker();
    Logger logger = Logger.getLogger(PersonalDetails.class);

    public PersonalDetails()
    {
        super();
        logger.info("New PersonalDetails page returned.");
    }

    public void fillForm(boolean isValid)
    {
        JavascriptExecutor jse = (JavascriptExecutor) getSingleDriver();

        takeScreenshot();
        firstNameInput.sendKeys(dataFaker.getFirstName());
        lastNameInput.sendKeys(dataFaker.getLastName());
        String eMail = dataFaker.getEMail();
        emailInput.sendKeys(eMail);
        if(isValid)
        {
            confirmEmailInput.sendKeys(eMail);
        }
        takeScreenshot();
        jse.executeScript("window.scrollBy(0,250)");
        romanticRoomDecorationCheckbox.click();
        flowerBouquetInRoomCheckbox.click();
        takeScreenshot();
        jse.executeScript("window.scrollBy(0,250)");
    }

    public PersonalDetails fillFormWithInvalidData()
    {
        logger.info("Populating personal details with invalid data.");
        fillForm(false);
        takeScreenshot();
        confirmBookingButton.click();

        logger.info("Confirm button clicked");
        logger.info("The alert is going to display on this page.");
        return this;
    }

    public Summary fillFormWithValidData()
    {
        logger.info("Populating personal details with valid data.");
        fillForm(true);
        takeScreenshot();
        confirmBookingButton.click();

        logger.info("Confirm button clicked");
        logger.info("New Summary page is going to be returned.");
        return new Summary();
    }

    public PersonalDetails alertsAssertion()
    {
        logger.info("Alert checking!");
        Assertions.assertThat(alertsList).hasSizeGreaterThan(0);
        Assertions.assertThat(alertsList.get(0).getText()).isEqualTo("Email is required");

        return this;
    }

    public PersonalDetails amountTableAssertion() throws InterruptedException
    {
        for (int i = 0; i < 2; i++)
        {
            double beforePrice = convertWebElementToInteger(totalAmount);
            int units = amountUnitsList.size();
            orderButtonsFromExtrasList.get(i).click();
            Thread.sleep(2000);
            int unitsAfterClick = amountUnitsList.size();
            Assertions.assertThat(unitsAfterClick).isEqualTo(units+1);

            String item = itemsFromExtrasList.get(i).getText();
            List<String> unitNames = new ArrayList<>();
            for(WebElement e : amountUnitsList)
            {
                String unit = e.findElement(By.xpath(".//td[1]")).getText();
                unitNames.add(unit);
            }
            Assertions.assertThat(unitNames).contains(item);

            double price = convertWebElementToInteger(pricesFromExtrasList.get(i));
            double afterPrice = convertWebElementToInteger(totalAmount);
            Assertions.assertThat(afterPrice).isEqualTo(beforePrice + 1.05*price);
        }
        for (int i = 1; i >= 0; i--)
        {
            double beforePrice = convertWebElementToInteger(totalAmount);
            int units = amountUnitsList.size();
            orderButtonsFromExtrasList.get(i).click();
            Thread.sleep(2000);
            int unitsAfterClick = amountUnitsList.size();
            Assertions.assertThat(unitsAfterClick).isEqualTo(units-1);

            String item = itemsFromExtrasList.get(i).getText();
            List<String> unitNames = new ArrayList<>();
            for(WebElement e : amountUnitsList)
            {
                String unit = e.findElement(By.xpath(".//td[1]")).getText();
                unitNames.add(unit);
            }
            Assertions.assertThat(unitNames).doesNotContain(item);

            double price = convertWebElementToInteger(pricesFromExtrasList.get(i));
            double afterPrice = convertWebElementToInteger(totalAmount);
            Assertions.assertThat(afterPrice).isEqualTo(beforePrice - 1.05*price);
        }

        return this;
    }

    public double convertWebElementToInteger (WebElement element)
    {
        String text = element.getText();
        double i = Double.parseDouble(text);

        return i;
    }
}
