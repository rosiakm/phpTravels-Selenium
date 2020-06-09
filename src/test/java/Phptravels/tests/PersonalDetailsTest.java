package Phptravels.tests;

import Phptravels.helpers.Listener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class PersonalDetailsTest extends BaseTest
{
    public PersonalDetailsTest()
    {
        super();
    }

    @Test(priority = 1)
    public void amountTableTest()
    {

    }
}
