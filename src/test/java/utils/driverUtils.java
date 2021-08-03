package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import stepDefinitions.stepDefinition;

public class driverUtils {

    public WebDriver initialiseDriver(WebDriver driver){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }
}
