package Phptravels.pages;

import Phptravels.helpers.DataFaker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static Phptravels.configuration.DriverManager.getSingleDriver;
import static Phptravels.helpers.WaitForElement.waitForElementToBeDisplayed;

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

    @FindBy(xpath = "label[@class='switch-light switch-ios'][1]/span/span[contains(text(),'No')]")
    private WebElement romanticRoomDecorationCheckbox;

    @FindBy(xpath = "label[@class='switch-light switch-ios'][2]/span/span[contains(text(),'No')]")
    private WebElement flowerBouquetInRoomCheckbox;

    @FindBy(css = ".form-group button[type='submit']")
    private WebElement confirmBookingButton;

    DataFaker dataFaker = new DataFaker();
    JavascriptExecutor jse = (JavascriptExecutor) getSingleDriver();

    public void fillForm(boolean isValid)
    {
        firstNameInput.sendKeys(dataFaker.getFirstName());
        lastNameInput.sendKeys(dataFaker.getLastName());
        String eMail = dataFaker.getEMail();
        emailInput.sendKeys(eMail);
        if(isValid)
        {
            confirmEmailInput.sendKeys(eMail);
        }
        jse.executeScript("window.scrollBy(0,250)");
        romanticRoomDecorationCheckbox.click();
        flowerBouquetInRoomCheckbox.click();
        jse.executeScript("window.scrollBy(0,250)");
    }

    public PersonalDetails fillFormWithInvalidData()
    {
        fillForm(false);
        confirmBookingButton.click();

        return this;
    }

    public Summary fillFormWithValidData()
    {
        fillForm(true);
        confirmBookingButton.click();

        return new Summary();
    }
}
