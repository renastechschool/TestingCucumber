package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Hooks extends utils.driverUtils  {



    @Before()
    public void initialise_Regression_test() throws IOException {

        smartBearSteps.driver = initialiseDriver(smartBearSteps.driver,"chrome");
        String url = utils.commonUtils.getURL("src/test/Resources/smartbear.properties");
        smartBearSteps.driver.get(url);
    }


    @After()
    public void close_test( ){


        smartBearSteps.driver.quit();
        }


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


    @After("@RegressionTest")
    public void close_Regression_test(){
        smartBearSteps.driver.close();
    }

    @Before("@Testing")
    public void testingBefore(){

    }







}
