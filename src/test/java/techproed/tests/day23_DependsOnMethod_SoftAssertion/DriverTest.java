package techproed.tests.day23_DependsOnMethod_SoftAssertion;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class DriverTest {

    @Test
    public void driverTest() {

        Driver.getDriver().get("https://techproeducation.com");
        Driver.getDriver().get("https://amazon.com");
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        System.out.println(ConfigReader.getProperty("username"));
        System.out.println(ConfigReader.getProperty("password"));

    }

}
