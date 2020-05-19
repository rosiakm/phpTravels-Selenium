package Phptravels.helpers;

import com.github.javafaker.Faker;

public class DataFaker
{
    private Faker faker;

    public DataFaker()
    {
        faker = new Faker();
    }

    public String getFirstName()
    {
        return faker.name().firstName();
    }

    public String getLastName()
    {
        return faker.name().lastName();
    }

    public String getEMail()
    {
        return faker.internet().emailAddress();
    }

}
