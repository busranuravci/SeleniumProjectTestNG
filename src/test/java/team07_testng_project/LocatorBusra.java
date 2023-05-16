package team07_testng_project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class LocatorBusra {

    public LocatorBusra(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//*[@class='login inline-type']")
    public WebElement signIn;

    @FindBy(id = "username")
    public WebElement userNameBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(name = "login")
    public WebElement signInButton;


    @FindBy(xpath = "//*[@class='form-control']")
    public WebElement searchBox;

    @FindBy(className = "single_add_to_cart_button button alt")
    public WebElement addCartButton;

    @FindBy(xpath = "(//div[@class='elementor-widget-container'])[6]")
    public WebElement cartIcon;

    @FindBy(xpath = "//a[@class='button checkout wc-forward']")
    public WebElement checkOutButton;

    @FindBy(id = "billing_first_name")
    public WebElement firstnameBox;

    @FindBy(className = "woocommerce-checkout-review-order")
    public WebElement reviewOrderButton;

    @FindBy(id = "place_order")
    public WebElement placeOrderButton;

    @FindBy(xpath = "//div[@class='woocommerce-order']")
    public WebElement successfulText;

    @FindBy(linkText = "My Orders")
    public WebElement myOrdersButton;

    @FindBy(className = "main pt-lg")
    public WebElement orderScreen;

    @FindBy(xpath = "//a[@class='showcoupon']")
    public WebElement enterYourCoupon;

    @FindBy(id = "coupon_code")
    public WebElement couponCodeBox;


    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement couponApplyButton;

    @FindBy(xpath = "//tr[@class='cart-discount coupon-nike20']")
    public WebElement couponDiscountText;


}
