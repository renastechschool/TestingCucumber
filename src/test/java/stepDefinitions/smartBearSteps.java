package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class smartBearSteps {

    public static WebDriver driver;

    @Given("^user is on the login page$")
    public void user_is_on_the_login_page() throws Throwable {
        utils.commonUtils.getScreenshot(driver,"LoginPage");
        System.out.println(driver.getTitle());
    }

    @Given("^user is on View all orders page$")
    public void user_is_on_view_all_orders_page() throws Throwable {
        user_enters_username_as_something_and_password_as_something("Tester", "test");
    }

    @Given("^user is on View all products page$")
    public void user_is_on_view_all_products_page() throws Throwable {
        user_enters_username_as_something_and_password_as_something("Tester", "test");
        driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[2]/a")).click();
        String pageHead = driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/table/tbody/tr/td[2]/div[2]/h2")).getText().trim();
        if (pageHead.equals("List of Products")){
            System.out.println("User is on All Products Page");
        }
        else
        {
            System.out.println("User is NOT on All Products Page");
        }
    }

    @When("^user enters username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void user_enters_username_as_something_and_password_as_something(String strArg1, String strArg2) throws Throwable {
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(strArg1);
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(strArg2);
        utils.commonUtils.getScreenshot(driver,"BeforeLoginClick");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
    }

    @When("^user views the title as \"([^\"]*)\"$")
    public void user_views_the_title_as_something(String strArg1) throws Throwable {
        String pageHead = driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/table/tbody/tr/td[2]/div[2]/h2")).getText().trim();
        if (pageHead.equals(strArg1)){
            System.out.println("User is on correct page");
        }
        else
        {
            System.out.println("User is NOT on the correct page");
        }
    }

    @Then("^user is loggedin$")
    public void user_is_loggedin() throws Throwable {
        utils.commonUtils.getScreenshot(driver,"userLoggedIn");
        String title = driver.getTitle().trim();
        if(title.equals("Web Orders"))
        {
            System.out.println("Test Case Passed");
        }
        else{
            System.out.println("Test Case Failed");
        }
    }

    @Then("^view all orders page loads successfully$")
    public void view_all_orders_page_loads_successfully() throws Throwable {

    }

    @Then("^view all products page loads successfully$")
    public void view_all_products_page_loads_successfully() throws Throwable {

    }

    @Then("^Add orders page loads successfully$")
    public void add_orders_page_loads_successfully() throws Throwable {

    }

    public void login(){

    }
}
