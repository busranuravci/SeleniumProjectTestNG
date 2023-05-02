package techproed.tests.day25_ExcelUtils;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class DataProvider01 {

     /*
DataProvider, TestNG nin bir ozelligidir
Test Caselere data göndermek icin kullanilir -Loop kullanmadan
Aynı test metodunu farklı parametrelerle çalıştırmaya ve veri kaynaklarının merkezi bir şekilde yönetilmesine olanak tanır.
Bu özellik, test otomasyonunda önemli bir rol oynar ve testlerin okunabilirliğini arttırarak bakımını kolaylaştırır.
Data Provider 2 boyutlu Array return eder
2 tane parametre alabilir. Parametre zorunlu degildir
name : yeni isimlendirme icin kullanilir
parallel : paralel test icin kullanilir
     */

    /*

     DDT(Data Driven Testing) için kullanılır. Yani birden fazla veriyi test case'lerde aynı anda kullanmak
    için kullanılır
     Kullanımı için @Test notasyonundan sonra paremetre olarak dataprovider yazilir ve String bir isim
    belirtilir. Bu belittiğimiz isimle @DataProvider notasyonu ile bir method oluşturulur

    Eğer farklı bir test methodu için aynı dataProvider methodu kullanılacaksa
    @DataProvider(name = "googleTest") şeklinde dataprovider notasyonundan sonra name paremetresine yeni olusturduğumuz
    methodun adını yazarız
     */



    @DataProvider(name = "googleTest")  //>> artık googleTest için kullanılacak ürünler testi için değil
    public static Object[][] urunler() {
        return new Object[][]{{"Volvo"},{"Mercedes"},{"Audi"},{"Bentley"},{"Massarati"}};
    }



    @Test(dataProvider = "urunler")
    public void test1(String data) {   //DP'daki verileri almak için parametre atadık
        System.out.println(data);

    }

    @Test
    public void googleTest(String araclar) {
        //Google sayfasına gidiniz
        //Driver.getDriver().get("https://google.com");
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));

        //{"Volvo"},{"Mercedes"},{"Audi"},{"Bentley"},{"Massarati"} araçları aratınız
        GooglePage googlePage = new GooglePage();
        googlePage.aramaKutusu.sendKeys(araclar, Keys.ENTER);

        //Her aratmadan sonra sayfa resmi alınız
        ReusableMethods.tumSayfaResmi();
        ReusableMethods.bekle(2);


        Driver.closeDriver();

    }
}

//fail için hoca çözünce dönüş yapacak