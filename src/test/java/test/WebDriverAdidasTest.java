package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.AdidasHoodiePage;
import page.AdidasSneakerPage;


public class WebDriverAdidasTest {

    public static String expectedWishlistResult = "1 ITEM";
    public static String expectedDeliveryValue = "FREE";
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver","D:\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void addToWishlistTest() {
        String wishlistResult = new AdidasSneakerPage(driver)
                .addItemToWishlist()
                .openWishlistPage()
                .getWishlistResult();
        Assert.assertEquals(wishlistResult, expectedWishlistResult);
    }

    @Test
    public void freeDeliveryTest() {
        String deliveryValue = new AdidasHoodiePage(driver)
                .addItemToBag()
                .getDeliveryValue();
        Assert.assertEquals(deliveryValue, expectedDeliveryValue);
    }

    @AfterMethod(alwaysRun = true)
    public void driverShutDown(){
        driver.quit();
        driver=null;
    }
}
