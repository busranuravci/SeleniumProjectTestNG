package techproed.tests.selenium_grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.AssertJUnit.assertEquals;

public class TC01 {

    WebDriver driver;

    @Test
    public void testChrome() throws MalformedURLException, InterruptedException {

        driver = new RemoteWebDriver(new URL("http://192.168.1.145:4444"), new ChromeOptions());
        driver.get("https://bluerentalcars.com");
        assertEquals("Blue Rental Cars | Cheap, Hygienic, VIP Car Hire",driver.getTitle());
    Thread.sleep(3000);
        driver.close();
    }

}
