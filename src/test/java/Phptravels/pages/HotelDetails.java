package Phptravels.pages;

import org.apache.log4j.Logger;
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

    @FindBy(xpath = "//small/i[@class='star fa fa-star']")
    private List<WebElement> starsList;

    Logger logger = Logger.getLogger(HotelDetails.class);

    public HotelDetails()
    {
        super();
        logger.info("New HotelDetails page returned.");
    }

    public PersonalDetails bookHotel()
    {
        JavascriptExecutor jse = (JavascriptExecutor)getSingleDriver();

        logger.info("Checking the room");
        takeScreenshot();
        jse.executeScript("window.scrollBy(0,1200)");
        roomCheckbox.click();
        takeScreenshot();
        bookNowButton.click();

        logger.info("Book now button clicked.");
        logger.info("PersonalDetails page is going to be returned.");
        return new PersonalDetails();
    }

    public HotelDetails hotelAssertion(int stars)
    {
        logger.info("Checking that correct hotel page opened.");
        Assertions.assertThat(starsList.size()).isEqualTo(stars);

        return this;
    }
}
