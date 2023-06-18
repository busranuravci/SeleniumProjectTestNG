package techproed.tests.selenium_grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.AssertJUnit.assertEquals;

public class TC03 {

    WebDriver driver;

    @Test
    public void testEdge() throws MalformedURLException, InterruptedException {

        driver = new RemoteWebDriver(new URL("http://192.168.1.145:4444"), new EdgeOptions());
        driver.get("https://bluerentalcars.com");
        assertEquals("Blue Rental Cars | Cheap, Hygienic, VIP Car Hire",driver.getTitle());
        Thread.sleep(3000);
        driver.close();
    }

}
