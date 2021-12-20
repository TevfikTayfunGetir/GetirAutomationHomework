package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends BasePage{

    By updateCartButton = new By.ByCssSelector("button[name='update_cart']");

    By removeFromCartButton = By.cssSelector("div.woocommerce form.woocommerce-cart-form td.product-remove");
    By quantityValue = By.cssSelector("//div[@class='quantity'] /input");
    By productList = By.cssSelector("tbody");
    By emptyCartMessage = By.cssSelector("div.woocommerce-notices-wrapper p");


    By emptyCartMessage2 = By.cssSelector("p.cart-empty");

    By quantity = new By.ByCssSelector("input.input-text[type='number']");
    By updatedCartMessage = new By.ByCssSelector("div.woocommerce-message");


    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void updateCart()
    {
        webDriver.findElement(updateCartButton).click();
    }

    public void removeFromCart()
    {
        //webDriver.findElement(By.xpath("a[href='https://training.qastorming.com/cart/?remove_item=eae27d77ca20db309e056e3d2dcd7d69&_wpnonce=dd15f618d5'")).click();
        webDriver.findElement(removeFromCartButton).click();
        WebDriverWait wait = new WebDriverWait(webDriver, 6);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMessage));
        String messageControl = webDriver.findElement(emptyCartMessage2).getText();
        Assertions.assertEquals("Your cart is currently empty.", messageControl, "Hata!");
    }

    public void quantityUpdate()
    {
        webDriver.findElement(quantityValue).sendKeys("3");
    }

    public void productControl()
    {
        webDriver.findElements(productList).isEmpty();
    }

    public void updateProductCount(String productCount) {
        WebElement element = webDriver.findElement(quantity);
        element.click();
        element.clear();
        element.sendKeys(productCount);
        webDriver.findElement(updateCartButton).click();
        WebDriverWait wait = new WebDriverWait(webDriver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(updatedCartMessage));
    }





}
