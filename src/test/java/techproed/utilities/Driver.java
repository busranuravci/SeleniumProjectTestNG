package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;


//  ***   AMAÇ: extends yönteminden kurtulup, static metotları class ismiyle her yerden çağırabilmek   !!!!

public class Driver {

    static WebDriver driver;

// ** driver her çağırıldığında yeni bir pencere açılmaması için if bloğu içinde
// eğer drive a bir değer atanmamışsa bir değer ata
// eğer değer atanmışsa driver ı aynı sayfada return et demek doğrudur.
    // yani if(driver==null)
// tek window

    public static WebDriver getDriver() {

        if (driver == null) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;

    }

    public static void closeDriver(){
        driver.close();
    }

}
