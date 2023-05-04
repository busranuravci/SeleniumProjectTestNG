package techproed.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class FacebookPage {

    public FacebookPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//input[@name='email']")
     public WebElement emailBox;

    @FindBy(id = "pass")
    public WebElement passwordBox;


    @FindBy(xpath = "//button[@name='login']")
    public WebElement loginBox;


    @FindBy(xpath = "//div[@class='_9ay7']")
    public WebElement wrongPassText;
}
