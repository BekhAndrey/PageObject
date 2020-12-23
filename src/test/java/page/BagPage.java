package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BagPage {

    private WebDriver driver;
    private final By deliveryValueLocator = By.xpath("//span[@data-auto-id=\"glass-cart-summary-delivery-value\"]");
    public BagPage(WebDriver driver){
        this.driver = driver;
    }

    public String getDeliveryValue(){
        WebElement deliveryValue = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(deliveryValueLocator));
        return deliveryValue.getText();
    }
}
