package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks extends utils.driverUtils  {

    @Before
    public void initialise_test(){
        stepDefinition.driver = initialiseDriver(stepDefinition.driver);
    }

    @After
    public void close_test(){
        stepDefinition.driver.close();
    }
}
