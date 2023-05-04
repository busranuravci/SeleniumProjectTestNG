package MyPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.FacebookPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Q04_PagesUsing {

    @Test
    public void testFacebook() {

        // facebook git
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));

        //kullanıcı email kutusuna random isim yaz
        FacebookPage facebookPage= new FacebookPage();
        facebookPage.emailBox.sendKeys("xxXxx");

Driver.bekle(3);

        //kullanıcı şifre kutusuna random password yaz ve giriş yap
        facebookPage.passwordBox.sendKeys("1230987");
        facebookPage.loginBox.click();

Driver.bekle(3);

        //şifre yanlış yazısının görünür olduğunu test et ve sayfayı kapat
        Assert.assertTrue(facebookPage.wrongPassText.isDisplayed());

        Driver.closeDriver();
    }
}
