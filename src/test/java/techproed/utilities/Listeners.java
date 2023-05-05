package techproed.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

     /*
    Listeners; TestNG de bir test'in durumunu ve sonucunu izleyen ve bu duruma yanıt veren bir yapıdır.
    Testlerin passed ve failed olma durumlarını, başlangıç ve bitişini takip eder ve raporlayabilir.
        Bunun için TestNG den ITestListener arayüzünü(interface) kullanırız. Oluşturduğumuz Listeners
    class'ına ITestListener arayüzündeki methodları Override etmek için implements ederiz
     */


    // public yazdığımız an implements sayesinde metotları hazır gösteriyor::
    @Override
    public void onStart(ITestContext context) {   // BeforeClass gibi
        System.out.println("On Start Method : 'tüm' testlerden önce tek bir sefer çağırılır  " + context.getName());  //--> testin ismini veriyor
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("On Finish Method: 'tüm' testlerden sonra tek bir sefer çağırılır  " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {  // Before gibi
        System.out.println("On Test Start: 'her bir' testten önce tek bir sefer çağırılır  " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess Methodu -> PASSED olan testlerden sonra tek bir sefer çağrılır  " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure Methodu -> FAILED olan testlerden sonra tek bir sefer çağrılır  " + result.getName());
      //  ReusableMethods.tumSayfaResmi(result.getName());   // ---> fail olan testin SS i alıyoruz
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped Methodu -> SKIP(atlanan) olan testlerden sonra tek bir sefer çağrılır  " + result.getName());
    }

}
