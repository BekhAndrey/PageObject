package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    private  By selectSizeLocator;
    private final By addToBagLocator = By.xpath("//button[@data-auto-id=\"add-to-bag\"]");
    private final By closeModalLocator = By.xpath("//button[@class=\"gl-modal__close\"]");
    private final By goToBagLocator = By.xpath("//button[@data-auto-id=\"view-bag-desktop\"]");
    private final By addToWishlistLocator = By.xpath("//div[@data-auto-id=\"wishlist-button\"]");
    private final By goToWishlistLocator = By.xpath("//div[@class=\"right-side-menu___16Ik7\"]/div[3]");
    private WebDriver driver;
    private String url;


    public ProductPage(WebDriver driver, String hoodieUrl){
        this.driver = driver;
        this.url = hoodieUrl;
    }

    public ProductPage openPage()
    {
        driver.get(url);
        return this;
    }

    public ProductPage addItemToWishlist(){
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

    public ProductPage addItemsToBag(){
        WebElement addToBagBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(addToBagLocator));
        addToBagBtn.click();
        return this;
    }

    public ProductPage selectItemSize(String size){
        selectSizeLocator = By.xpath(String.format("//button[@class=\"gl-label size___TqqSo\"]/span[text() =\"%s\"]", size));
        WebElement selectSizeBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(selectSizeLocator));
        selectSizeBtn.click();
        return this;
    }

    public ProductPage closeModal(){
        WebElement closeModalBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(closeModalLocator));
        closeModalBtn.click();
        return this;
    }

    public BagPage openBagPage(){
        WebElement goToBagBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(goToBagLocator));
        goToBagBtn.click();
        return new BagPage(driver);
    }
}
