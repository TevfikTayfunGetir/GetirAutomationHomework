import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

public class Test_2 {
    @Test
    public void TestMethod2(){
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        HomePage homePage = new HomePage(webDriver);

        Assertions.assertEquals("Home - Sample Shop", homePage.getTitle(), "Hata!");

        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

        homePage.ContactInfoText();

        homePage.scrollUpClick();

        webDriver.quit();
    }
}
