package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Hooks extends utils.driverUtils  {

    @Before("@SmokeTest")
    public void initialise_test(){
        stepDefinition.driver = initialiseDriver(stepDefinition.driver,"chrome");
    }

    @Before("@SanityTest")
    public void initialise_smartBear() throws IOException {
        smartBearSteps.driver = initialiseDriver(smartBearSteps.driver,"chrome");
        String url = utils.commonUtils.getURL("src/test/Resources/smartbear.properties");
        smartBearSteps.driver.get(url);
    }

    @After("@SanityTest")
            public void close_smartBear(){
            smartBearSteps.driver.close();
    }

    @After("@SmokeTest")
    public void close_test(){
        stepDefinition.driver.close();
    }
}
