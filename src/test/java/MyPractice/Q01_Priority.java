package MyPractice;

import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class Q01_Priority {

    // tech > amazon > bestbuy sıralamasıyla çalışsın.


    @Test(priority = -2)
    public void testAmazon() {
        Driver.getDriver().get("https://amazon.com");
    }

    @Test
    public void testBestBuy() {
        Driver.getDriver().get("https://bestbuy.com");
    }

    @Test(priority = -5)
    public void testTechPro() {
        Driver.getDriver().get("https://techproeducation.com");
    }

}
