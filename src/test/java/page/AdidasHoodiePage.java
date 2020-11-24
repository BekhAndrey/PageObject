package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class AdidasHoodiePage {

    private static final String HOODIE_URL = "https://www.adidas.com/us/trefoil-hoodie/DT7963.html";
    private final By selectSizeLocator = By.xpath("//button[@data-di-id=\"di-id-782932f4-62ee50a0\"]");
    private final By addToBagLocator = By.xpath("//button[@data-auto-id=\"add-to-bag\"]");
    private final By closeModalLocator = By.xpath("//button[@class=\"gl-modal__close\"]");
    private final By goToBagLocator = By.xpath("//button[@data-auto-id=\"view-bag-desktop\"]");
    private final By deliveryValueLocator = By.xpath("//span[@data-auto-id=\"glass-cart-summary-delivery-value\"]");
    private WebDriver driver;


    public AdidasHoodiePage(WebDriver driver){
        this.driver = driver;
    }

    public AdidasHoodiePage openPage(){
        driver.get(HOODIE_URL);
        WebElement selectSizeBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(selectSizeLocator));
        selectSizeBtn.click();
        WebElement addToBagBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(addToBagLocator));
        addToBagBtn.click();
        WebElement closeModalBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(closeModalLocator));
        closeModalBtn.click();
        addToBagBtn.click();
        WebElement goToBagBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(goToBagLocator));
        goToBagBtn.click();
        return this;
    }

    public String getDeliveryValue(){
        WebElement deliveryValue = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(deliveryValueLocator));
        return deliveryValue.getText();
    }
}
