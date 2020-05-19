package Phptravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static Phptravels.configuration.DriverManager.getSingleDriver;

public class Results extends BasePage
{
    @FindBy(xpath = "//table[@class='bgwhite table table-striped']//tr")
    private List<WebElement> hotelsList;

    JavascriptExecutor jse = (JavascriptExecutor) getSingleDriver();

    public HotelDetails chooseHotel()
    {
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

}

