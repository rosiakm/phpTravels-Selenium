package Phptravels.tests;

import Phptravels.helpers.Listener;
import Phptravels.pages.Hotels;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class HappyPathTest extends BaseTest
{
    public HappyPathTest()
    {
        super();
    }

    @Test(priority = 1)
    public void bookingHotelTest()
    {
        new Hotels().searchForHotel()
                    .assertResults()
                    .chooseHotel()
                    .hotelAssertion(3)
                    .bookHotel()
                    .fillFormWithValidData();
    }

    @Test(priority = 2)
    public void bookingHotelWithInvalidDataTest()
    {
        new Hotels().searchForHotel()
                    .assertResults()
                    .chooseHotel()
                    .hotelAssertion(3)
                    .bookHotel()
                    .fillFormWithInvalidData()
                    .alertsAssertion();
    }
}
