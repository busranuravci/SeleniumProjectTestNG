package techproed.tests.day29_Listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;


@Listeners(techproed.utilities.Listeners.class)

public class Listeners01 {

    @Test (retryAnalyzer = techproed.utilities.Listeners.class)
    public void test1() {
        Driver.getDriver().get(ConfigReader.getProperty("techproeducation_url"));
        Driver.getDriver().findElement(By.xpath("//wrongLocate")); //page yazmadığımız için locate burda aldık. ve test amacı için YANLIŞ locate yazdık.
    }


    @Test
    public void test2() {

        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
    }


    @Test
    public void test3() {
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();
        blueRentalPage.email.sendKeys("bna@gmail.com",Keys.TAB,"12345",Keys.ENTER);
    }

    @AfterClass
    public void afterClass() {
        Driver.quitDriver();
    }
}
         // testlere tek tek retryAnalyzer yazmamak için XML file kullanılır ! TRANSFORM İLE.(Listeners util içine ekledim )