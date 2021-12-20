import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.ShopPage;

public class Test_3 {
    @Test

    public void TestMethod3(){

        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        HomePage homePage = new HomePage(webDriver);
        ShopPage shopPage = new ShopPage(webDriver);

        homePage.clickTitleShop();
        Assertions.assertEquals("Shop - Sample Shop", homePage.getTitle(), "Hata!");
        shopPage.DropdownManager();
        shopPage.clickAddToCart(0);
        shopPage.clickAddToCart(1);
        shopPage.clickAddToCart(2);
        //shopPage.clickViewCart();

    }
}
