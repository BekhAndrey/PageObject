package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.AdidasSneakerPage;

import javax.xml.datatype.Duration;


public class WebDriverAdidasTest {

    public static String expectedResult = "1 ITEM";
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver","D:\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void addToWishlistTest() {
        String wishlistResult = new AdidasSneakerPage(driver)
                .openPage()
                .openWishlistPage()
                .getWishlistResult();
        Assert.assertEquals(wishlistResult, expectedResult);
    }

    @AfterMethod(alwaysRun = true)
    public void driverShutDown(){
        driver.quit();
        driver=null;
    }
}
