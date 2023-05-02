package techproed.tests.day24_Properties_Pages;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class PageKullanımı {

    @Test
    public void test01() throws InterruptedException {

        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get(ConfigReader.getProperty("openSource_Url"));
        /*
Yukardaki adres icin 20 adet test methodu olusturursak sonrasinda yukardaki "url'de bir
degisiklik oldugunda" butun test methodlarindan tek tek url duzeltmek yerine bir kere .properties
dosyamdan url'i duzeltirim ve bu bizim icin daha hizli daha duzenli ve daha kolay olur.
         */


        //kullaniciAdi, kullaniciSifre, submitButton elementlerini bul
        OpenSourcePage openSourcePage = new OpenSourcePage();
    /* openSourcePage.username.sendKeys("Admin");
        openSourcePage.password.sendKeys("admin123");  */
    // config'den;
        openSourcePage.username.sendKeys(ConfigReader.getProperty("username"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("password"));
        openSourcePage.login.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Login Testinin basarili oldugunu test et
        Assert.assertTrue(openSourcePage.dashboard.isDisplayed());

        Driver.closeDriver();

    }
}
