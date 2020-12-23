package test;

import driver.DriverSingleton;
import model.Item;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.ProductPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class AdidasTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp()
    {
        driver = DriverSingleton.getDriver();
    }

    @Test
    public void addToWishlistTest() {
        Item expectedItem = new Item("TREFOIL HOODIE",null,null,"$65","1 ITEM");
        Item wishlistItem = new ProductPage(driver,"https://www.adidas.com/us/trefoil-hoodie/DT7963.html")
                .openPage()
                .addItemToWishlist()
                .openWishlistPage()
                .getWishlistResult();
        assertThat(wishlistItem, equalTo(expectedItem));
    }

    @Test
    public void freeDeliveryTest() {
        String expectedDeliveryValue = "FREE";
        String deliveryValue = new ProductPage(driver,"https://www.adidas.com/us/trefoil-hoodie/DT7963.html")
                .openPage()
                .selectItemSize("M")
                .addItemsToBag()
                .closeModal()
                .addItemsToBag()
                .openBagPage()
                .getDeliveryValue();
        assertThat(deliveryValue, equalTo(expectedDeliveryValue));
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }
}
