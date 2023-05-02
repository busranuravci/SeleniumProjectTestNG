package techproed.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {
    @DataProvider
    public Object[][] sehirVerileri() {    // from >> DataProvider02
        return new Object[][]{{"Ankara","İç Anadolu","06"},{"İzmir","Ege","35"},{"Diyarbakır","Doğu","21"}}; // config içine yazıp ordan da çekebilirdik. şehir1-2 vs gibi.

    }

    @DataProvider
    public Object[][] kullanıcılar() {       // from >> DataProvider02
        return new Object[][]{{"Erol","123456"},{"Tarık","09876"}};
    }

    @DataProvider
    public Object[][] blueRental() {
        ExcelUtils excelUtils = new ExcelUtils("src/test/java/resources/mysmoketestdata.xlsx","customer_info");
        return excelUtils.getDataArray();
    }
}
