package MyPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Q03_SoftAssert {


     /*
    Amazon sayfasına git ve Title Amazon içerdiğini test et
    Arama kutusunun erişilebilir olduğunu test et
    Nutella arat ve sonuç yazısının görünür olduğunu test et
    Sonuç yazısının Nutella içerdiğini test et

    Hatalar için message yazdır **
     */


    @Test
    public void test01() {
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://amazon.com");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(searchBox.isDisplayed(), "Searchbox is not displayed");

        searchBox.sendKeys("Nutella", Keys.ENTER);

        WebElement resultText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(resultText.isDisplayed(), "Result text is not displayed");

        softAssert.assertTrue(resultText.getText().contains("Nutella"), "result text doesnt contain Nutella");

        softAssert.assertAll();

        driver.close();


    }
}
