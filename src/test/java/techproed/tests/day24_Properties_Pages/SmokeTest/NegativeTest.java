package techproed.tests.day24_Properties_Pages.SmokeTest;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ReusableMethods;

public class NegativeTest {

    @Test(groups = "smoke")  //--> group xml file için belirttik
    public void test1() {

         /*
        Description:
        Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapilamamali
        Acceptance Criteria
        Customer email: fake@bluerentalcars.com
        Customer password: fakepass
        Error:
        User with email fake@bluerentalcars.com not found
         */

        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));

        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();
        blueRentalPage.email.sendKeys(ConfigReader.getProperty("fakeEmail"),
                Keys.TAB,ConfigReader.getProperty("fakePass"));
        blueRentalPage.login2.click();

        ReusableMethods.bekle(3);
        ReusableMethods.tumSayfaResmi();

        Assert.assertTrue(blueRentalPage.hataMesaji.isDisplayed());

        Driver.closeDriver();

    }
}
