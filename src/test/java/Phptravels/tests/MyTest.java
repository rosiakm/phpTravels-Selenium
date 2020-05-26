package Phptravels.tests;

import Phptravels.pages.Hotels;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyTest extends BaseTest
{
    Hotels hotel = new Hotels();

    public MyTest() throws IOException
    {
        super();
    }

    @Test(priority = 1)
    public void bookingHotelTest() throws IOException
    {
        hotel.searchForHotel()
             .assertResults()
             .chooseHotel()
             .hotelAssertion(3)
             .bookHotel()
             .fillFormWithValidData();
    }

    @Test(priority = 2)
    public void bookingHotelWithInvalidDataTest() throws IOException
    {
        hotel.searchForHotel()
             .assertResults()
             .chooseHotel()
             .hotelAssertion(3)
             .bookHotel()
             .fillFormWithInvalidData()
             .alertsAssertion();
    }
}
