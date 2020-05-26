package Phptravels.pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Phptravels.configuration.DriverManager.getSingleDriver;
import static Phptravels.helpers.Screenshots.takeScreenshot;

public class Results extends BasePage
{
    @FindBy(xpath = "//table[@class='bgwhite table table-striped']//tr")
    private List<WebElement> hotelsList;

    public Results() throws IOException
    {
        super();
    }

    public HotelDetails chooseHotel() throws IOException
    {
        JavascriptExecutor jse = (JavascriptExecutor) getSingleDriver();

        takeScreenshot(getSingleDriver());
        WebElement myHotel = getHotel(3).get(0);
        WebElement detailsButton = myHotel.findElement(By.xpath(".//button[contains(text(),'Details')]"));
        jse.executeScript("window.scrollBy(0,500)");
        detailsButton.click();

        return new HotelDetails();
    }


    public List<WebElement> getHotel(int stars)
    {
        List<WebElement> results = new ArrayList<>();

        for (WebElement hotel : hotelsList)
        {
            List<WebElement> list = hotel.findElements(By.xpath(".//i[@class='star fa fa-star']"));

            if(list.size() == stars)
            {
                results.add(hotel);
            }
        }

        return results;
    }

    public Results assertResults()
    {
        Assertions.assertThat(hotelsList).hasSizeGreaterThan(0);

        return this;
    }

}

