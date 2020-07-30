package Phptravels.pages;

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
import static Phptravels.helpers.WaitForElement.waitForAllElementsToBeDisplayed;
import static Phptravels.helpers.WaitForElement.waitForElementToBeDisplayed;

public class Results extends BasePage
{
    @FindBy(xpath = "//table[@class='bgwhite table table-striped']//tr")
    private List<WebElement> hotelsList;

    @FindBy(css = "div[class='rating'] div[class='go-right']")
    private List<WebElement> starGradeFilterList;

    @FindBy(xpath = "//h2[contains(text(),'No Results Found')]")
    private WebElement noResultsMessage;

    @FindBy(id = "searchform")
    private WebElement searchButton;

    Logger logger = Logger.getLogger(Results.class);

    public Results()
    {
        super();
        logger.info("New Results page returned.");
    }

    public HotelDetails chooseHotel()
    {
        JavascriptExecutor jse = (JavascriptExecutor)getSingleDriver();

        logger.info("Choosing hotel with specified number of stars.");
        takeScreenshot();
        WebElement myHotel = getHotel(3).get(0);
        WebElement detailsButton = myHotel.findElement(By.xpath(".//button[contains(text(),'Details')]"));
        jse.executeScript("window.scrollBy(0,500)");
        detailsButton.click();

        logger.info("Detail button clicked.");
        logger.info("HotelDetails page is going to be return.");
        return new HotelDetails();
    }


    public List<WebElement> getHotel(int stars)
    {
        List<WebElement> results = new ArrayList<>();

        logger.info("Searching for hotel with specified number of stars");
        for (WebElement hotel : hotelsList)
        {
            List<WebElement> list = hotel.findElements(By.xpath(".//i[@class='star fa fa-star']"));

            if(list.size() == stars)
            {
                results.add(hotel);
            }
        }

        logger.info("Hotels found and return in a list");
        return results;
    }

    public Results assertResults()
    {
        logger.info("Checking that there are at least on hotel on a list.");
        Assertions.assertThat(hotelsList).hasSizeGreaterThan(0);

        return this;
    }

    public Results assertStarGradeFilter()
    {
        logger.info("Star grade filter checking");

        for (int i = 0; i < starGradeFilterList.size(); i++)
        {
            WebElement radioButton = starGradeFilterList.get(i).findElement(By.xpath(".//div[@class='iradio_square-grey']"));
            List<WebElement> starsFilterList = starGradeFilterList.get(i).findElements(By.xpath(".//i[@class='star text-warning fa fa-star voted']"));
            int starsNumberFilter = starsFilterList.size();

            radioButton.click();
            searchButton.click();

            if(starsNumberFilter == 1)
            {
                waitForElementToBeDisplayed(noResultsMessage);
            }
            else
            {
                waitForAllElementsToBeDisplayed(hotelsList);
            }
            takeScreenshot();

            int numberOfSearchedHotels = hotelsList.size();
            if(numberOfSearchedHotels != 0)
            {
                for (WebElement hotel : hotelsList)
                {
                    List<WebElement> stars = hotel.findElements(By.xpath(".//i[@class='star fa fa-star']"));
                    int starsNumber = stars.size();
                    Assertions.assertThat(starsNumberFilter).isEqualTo(starsNumber);
                }
            }
            else
            {
                Assertions.assertThat(noResultsMessage.getText()).isEqualTo("No Results Found");
            }
        }

        return this;
    }

}

