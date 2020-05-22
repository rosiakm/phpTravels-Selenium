package Phptravels.tests;

import Phptravels.pages.Hotels;
import org.testng.annotations.Test;

public class MyTest extends BaseTest
{
    Hotels hotel = new Hotels();

    @Test(priority = 1)
    public void bookingHotelTest()
    {
        hotel.searchForHotel()
             .assertResults()
             .chooseHotel()
             .bookHotel()
             .fillFormWithValidData();
    }

    @Test(priority = 2)
    public void bookingHotelWithInvalidDataTest()
    {
        hotel.searchForHotel()
             .assertResults()
             .chooseHotel()
             .bookHotel()
             .fillFormWithInvalidData();
    }
}
