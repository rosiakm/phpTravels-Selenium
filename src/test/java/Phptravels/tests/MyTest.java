package Phptravels.tests;

import Phptravels.pages.Hotels;
import org.testng.annotations.Test;

public class MyTest extends BaseTest
{
    Hotels hotel = new Hotels();

    @Test
    public void bookingHotelTest()
    {
        hotel.searchForHotel()
             .chooseHotel()
             .bookHotel()
             .fillFormWithValidData();
    }
}
