package Phptravels.pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static Phptravels.configuration.DriverManager.getSingleDriver;
import static Phptravels.helpers.Screenshots.takeScreenshot;

public class HotelDetails extends BasePage
{
    @FindBy(xpath = "//div[@class='control__indicator'][1]")
    private WebElement roomCheckbox;

    @FindBy(css = "div[class='panel panel-default'] button[type='submit']")
    private WebElement bookNowButton;

    @FindBy(xpath = "small/i[@class='star fa fa-star']")
    private List<WebElement> starsList;

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

    public HotelDetails hotelAssertion(int stars)
    {
        Assertions.assertThat(starsList.size()).isEqualTo(stars);

        return this;
    }
}
