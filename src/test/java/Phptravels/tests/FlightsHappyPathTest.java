package Phptravels.tests;

import Phptravels.pages.Flights;
import org.testng.annotations.Test;

public class FlightsHappyPathTest extends BaseTest
{
    public FlightsHappyPathTest()
    {
        super();
    }

    @Test(priority = 1)
    public void bookingFlightTest()
    {
        new Flights().searchForFlightConnection();
    }
}
