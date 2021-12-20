import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import pages.CartPage;
import pages.HomePage;
import pages.ShopPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Test_1 {


    @Test
    public void TestMethod1(){
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        HomePage homePage = new HomePage(webDriver);
        ShopPage shopPage = new ShopPage(webDriver);
        CartPage cartPage = new CartPage(webDriver);



        Assertions.assertEquals("Home - Sample Shop", homePage.getTitle(), "Hata!");

        homePage.clickFirstShopButton();

        Assertions.assertEquals("Shop - Sample Shop", homePage.getTitle(), "Hata!");

        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,350)", "");

        //js.executeScript("window.scrollBy(350,0)", "");

        shopPage.clickAddToCart(0);
        shopPage.clickCartButton();

        cartPage.updateProductCount("3");

        cartPage.removeFromCart();

    }



}