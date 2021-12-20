package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    String baseURL = "https://training.qastorming.com/";
    WebDriver webDriver;


    public BasePage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }
}
