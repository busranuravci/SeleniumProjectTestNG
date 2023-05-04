package MyPractice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class Q02_DependMethods {

    //test01 ile amazona git
    //test02 ile "Nutella" arat
    //test03 ile sonuç yazısının "Nutella" içerdiğini test et

    //test02'yi test01'e bağla
    //test03'ü test02'ye bağla


    public Q02_DependMethods(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(id = "twotabsearchtextbox")
     WebElement searchBox;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
     WebElement resultText;



    @Test
    public void test01() {

        Driver.getDriver().get("https://amazon.com");
    }

    @Test (dependsOnMethods = "test01")
    public void test02() {
        searchBox.sendKeys("Nutella", Keys.ENTER);

    }

    @Test(dependsOnMethods = "test02")
    public void test03() {
        Assert.assertTrue(resultText.getText().contains("Nutella"));

        Driver.closeDriver();
    }

}
