package Phptravels.pages;

import Phptravels.helpers.DataFaker;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
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

    DataFaker dataFaker = new DataFaker();

    public PersonalDetails() throws IOException
    {
        super();
    }

    public void fillForm(boolean isValid) throws IOException
    {
        JavascriptExecutor jse = (JavascriptExecutor) getSingleDriver();

        takeScreenshot(getSingleDriver());
        firstNameInput.sendKeys(dataFaker.getFirstName());
        lastNameInput.sendKeys(dataFaker.getLastName());
        String eMail = dataFaker.getEMail();
        emailInput.sendKeys(eMail);
        if(isValid)
        {
            confirmEmailInput.sendKeys(eMail);
        }
        takeScreenshot(getSingleDriver());
        jse.executeScript("window.scrollBy(0,250)");
        romanticRoomDecorationCheckbox.click();
        flowerBouquetInRoomCheckbox.click();
        takeScreenshot(getSingleDriver());
        jse.executeScript("window.scrollBy(0,250)");
    }

    public PersonalDetails fillFormWithInvalidData() throws IOException
    {
        fillForm(false);
        takeScreenshot(getSingleDriver());
        confirmBookingButton.click();

        return this;
    }

    public Summary fillFormWithValidData() throws IOException
    {
        fillForm(true);
        takeScreenshot(getSingleDriver());
        confirmBookingButton.click();

        return new Summary();
    }

    public PersonalDetails alertsAssertion()
    {
        Assertions.assertThat(alertsList).hasSizeGreaterThan(0);
        Assertions.assertThat(alertsList.get(0).getText()).isEqualTo("Email is required");

        return this;
    }
}
