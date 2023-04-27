package techproed.tests.day23_DependsOnMethod_SoftAssertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SoftAssertion01 {

    /*
       Doğrulama--verification
 SoftAssert kullanmak icin oncelikle bir obje olusturmamiz gerek
 Hard assertionda bir dogrulama fail olursa testin calismasi durur
 SoftAssertion da assertAll () methodu ile testin farkli bolumlerinde softassert kullanarak
    dogrulama yapsakta testi istedigimiz yerde "sonlandiririz."
     */

    SoftAssert softAssert;
    WebDriver driver;
    @Test
    public void amazonTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //İlk olarak obje oluşturduk sonrasında oluşturmuş olduğum obje ile assert methodları ile doğrulama yaparız
        //Son olarak objemi kullanarak assertAll() methodu kullanmam gerekir
        softAssert = new SoftAssert();

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Url'in amazon.com olup olmadığını doğrulayınız
        softAssert.assertEquals(driver.getCurrentUrl(),"https://amazon.com");

        //Başlığın best içerdiğini test edelim
        softAssert.assertTrue(driver.getTitle().contains("best"));

        //Arama kutusunda iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Sonucun samsung içerip içermediğini test edin
        WebElement sonuc = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        softAssert.assertTrue(sonuc.getText().contains("samsung"));
        System.out.println("Gerçek sonuç Iphone olmalı");
        softAssert.assertAll();
        System.out.println("Test sonuçlandı");    // Bunu yazdırmaz, assertAll sonrası test fail ise çalıştırmaz
    }

//   *** assertAll kısmına kadar fail kod olsa bile çalıştırır / hard assertion gibi testi ilk failde durdurmaz.
}
