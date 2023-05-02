package techproed.tests.day26_ExcelDataProvider;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.*;

import java.util.Arrays;

public class DataProvider03 {

    @Test
    public void test1() {
        ExcelUtils excelUtils = new ExcelUtils("src/test/java/resources/mysmoketestdata.xlsx","customer_info");
        System.out.println(Arrays.deepToString(excelUtils.getDataArray()));   //2 boyutlu Array olarak yazdırıyoruz
    }

    @Test(dataProvider = "blueRental",dataProviderClass = DataProviderUtils.class)

    public void test2(String email,String password) {

        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();
        blueRentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);
        ReusableMethods.bekle(3);

        Driver.closeDriver();
    }

}


 /*           HATIRLATMA :

    TESTLERİMİZ: TEST PACKAGE ALTINDA
    LOCATELERİMİZ: PAGES PACKAGE ALTINDA
    AYARLAMALARI YAPTIĞIMIZ VE METHODLAR OLUŞTURDUĞUMUZ CLASSLAR : UTILITIES ALTINDA
*/