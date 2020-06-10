package Phptravels.tests;

import Phptravels.helpers.Listener;
import Phptravels.pages.Hotels;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class FilterSearchTest extends BaseTest
{
    public FilterSearchTest()
    {
        super();
    }

    @Test(priority = 1)
    public void starGradeFilterTest()
    {
        new Hotels().searchForHotel()
                    .assertStarGradeFilter();
    }
}
