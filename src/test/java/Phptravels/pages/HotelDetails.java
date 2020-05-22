package Phptravels.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static Phptravels.configuration.DriverManager.getSingleDriver;
import static Phptravels.helpers.Screenshots.takeScreenshot;

public class HotelDetails extends BasePage
{
    @FindBy(xpath = "//div[@class='control__indicator'][1]")
    private WebElement roomCheckbox;

    @FindBy(css = "div[class='panel panel-default'] button[type='submit']")
    private WebElement bookNowButton;

    JavascriptExecutor jse = (JavascriptExecutor) getSingleDriver();

    public PersonalDetails bookHotel()
    {
        takeScreenshot(getSingleDriver());
        jse.executeScript("window.scrollBy(0,1200)");
        roomCheckbox.click();
        takeScreenshot(getSingleDriver());
        bookNowButton.click();

        return new PersonalDetails();
    }
}
