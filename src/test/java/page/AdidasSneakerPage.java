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

public class AdidasSneakerPage {

    private static final String SNEAKER_URL = "https://www.adidas.com/us/nite-jogger-shoes/FV1267.html";
    private final By addToWishlistLocator = By.xpath("//div[@data-auto-id=\"wishlist-button\"]");
    private final By goToWishlistLocator = By.xpath("//div[@class=\"gl-wishlist-icon wishlist_button___3ppwb solid-icon-color___1IHWy\"]");
    private WebDriver driver;


    public AdidasSneakerPage(WebDriver driver){
        this.driver = driver;
    }

    public AdidasSneakerPage addItemToWishlist(){
        driver.get(SNEAKER_URL);
        WebElement addToWishlistBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(addToWishlistLocator));
        addToWishlistBtn.click();
        return this;
    }

    public AdidasWishlistPage openWishlistPage(){
        WebElement goToWishlistBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(goToWishlistLocator));
        goToWishlistBtn.click();
        return new AdidasWishlistPage(driver);
    }
}
