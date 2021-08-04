package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class smartBearSteps {

    public static WebDriver driver;

    @Given("^User is on the smart bear home page$")
    public void user_is_on_the_smart_bear_home_page() throws Throwable {
        Thread.sleep(3000);
        System.out.println("Inside Given - Smart Bear");
    }

    @When("^user enters his credentails$")
    public void user_enters_his_credentails() throws Throwable {
        System.out.println("Inside When - Smart Bear");
    }

    @Then("^user is logged in$")
    public void user_is_logged_in() throws Throwable {
        System.out.println("Inside Then - Smart Bear");

    }
}
