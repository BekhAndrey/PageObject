package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HoodiePage {

    private final By selectSizeLocator = By.xpath("//button[@data-di-id=\"size_M\"]");
    private final By addToBagLocator = By.xpath("//button[@data-auto-id=\"add-to-bag\"]");
    private final By closeModalLocator = By.xpath("//button[@class=\"gl-modal__close\"]");
    private final By goToBagLocator = By.xpath("//button[@data-auto-id=\"view-bag-desktop\"]");
    private final By deliveryValueLocator = By.xpath("//span[@data-auto-id=\"glass-cart-summary-delivery-value\"]");
    private final By addToWishlistLocator = By.xpath("//div[@data-auto-id=\"wishlist-button\"]");
    private final By goToWishlistLocator = By.xpath("//div[@class=\"right-side-menu___16Ik7\"]/div[3]");
    private WebDriver driver;
    private String url;


    public HoodiePage(WebDriver driver, String hoodieUrl){
        this.driver = driver;
        this.url = hoodieUrl;
    }

    public HoodiePage openPage()
    {
        driver.get(url);
        return this;
    }

    public HoodiePage addItemToWishlist(){
        WebElement addToWishlistBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(addToWishlistLocator));
        addToWishlistBtn.click();
        return this;
    }

    public WishlistPage openWishlistPage(){
        WebElement goToWishlistBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(goToWishlistLocator));
        goToWishlistBtn.click();
        return new WishlistPage(driver);
    }

    public HoodiePage addItemsToBag(){
        WebElement selectSizeBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(selectSizeLocator));
        selectSizeBtn.click();
        WebElement addToBagBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(addToBagLocator));
        addToBagBtn.click();
        return this;
    }

    public HoodiePage closeModal(){
        WebElement closeModalBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(closeModalLocator));
        closeModalBtn.click();
        return this;
    }

    public HoodiePage goToBag(){
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
