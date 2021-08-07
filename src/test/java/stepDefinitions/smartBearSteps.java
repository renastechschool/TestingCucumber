package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class smartBearSteps {

    public static WebDriver driver;
    static Logger log = LogManager.getLogger(smartBearSteps.class);


    @Given("^user is on the login page$")
    public void user_is_on_the_login_page() throws Throwable {
        log.info("===============Starting Login==================");
        utils.commonUtils.getScreenshot(driver,"LoginPage");
        log.info("User is on the page - "+ driver.getTitle());
    }

    @Given("^user is on View all orders page$")
    public void user_is_on_view_all_orders_page() throws Throwable {
        log.info("===============Starting View All Orders==================");
        user_enters_username_as_something_and_password_as_something("Tester", "test");
    }

    @Given("^user is on Add orders page$")
    public void user_is_on_add_orders_page() throws Throwable {
        log.info("===============Starting Add Orders==================");
        user_enters_username_as_something_and_password_as_something("Tester", "test");
        driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a")).click();
        utils.commonUtils.getScreenshot(driver,"NewOrder");
    }

    @Given("^user is on View all products page$")
    public void user_is_on_view_all_products_page() throws Throwable {
        log.info("===============Starting View All Products==================");
        user_enters_username_as_something_and_password_as_something("Tester", "test");
        driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[2]/a")).click();
        String pageHead = driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/table/tbody/tr/td[2]/div[2]/h2")).getText().trim();
        if (pageHead.equals("List of Products")){
            log.info("User is on ALL products page");
       }
        else
        {
            log.error("User is NOT on All Products Page");
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
            log.info("User is on correct page");
        }
        else
        {
            log.error("User is NOT on the correct page" + pageHead);
        }
    }

    @Then("^user is loggedin$")
    public void user_is_loggedin() throws Throwable {
        utils.commonUtils.getScreenshot(driver,"userLoggedIn");
        String title = driver.getTitle().trim();
        if(title.equals("Web Orders"))
        {
            log.info("Test Case Passed");
        }
        else{
            log.error("Test Case Failed");
        }
        log.info("==================Stopping Login=================");
    }

    @Then("^view all orders page loads successfully$")
    public void view_all_orders_page_loads_successfully() throws Throwable {
        log.info("==================Stopping View All Orders=================");
    }

    @Then("^view all products page loads successfully$")
    public void view_all_products_page_loads_successfully() throws Throwable {
        log.info("==================Stopping View All Products=================");
    }

    @Then("^Add orders page loads successfully$")
    public void add_orders_page_loads_successfully() throws Throwable {
        log.info("==================Stopping Add Orders=================");
    }

    @When("^user enters all the information and click on Process button$")
    public void user_enters_all_the_information_and_click_on_process_button(Map<String, String> data) {
        WebElement product = driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select productDrpDown = new Select(product);
        productDrpDown.selectByVisibleText(data.get("Product"));
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(data.get("Quantity"));
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(data.get("Customer Name"));
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(data.get("Street"));
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(data.get("City"));
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(data.get("State"));
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(data.get("Zip"));
        if(data.get("Card").equalsIgnoreCase("visa")){
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
        }
        else if (data.get("Card").equalsIgnoreCase("MasterCard")){
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();
        }
        else
        {
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).click();
        }
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(data.get("Card Number"));
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys(data.get("Expiry Date"));
        utils.commonUtils.getScreenshot(driver,"BeforePlacingOrder");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
    }

    @Then("^order is added successfully$")
    public void order_is_added_successfully() {
        utils.commonUtils.getScreenshot(driver,"AfterPlacingOrder");
        String message = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong")).getText().trim();
        if (message.equals("New order has been successfully added.")){
            log.info("Order has been added successfully");
        }
        else
        {
            log.error("Order has not been added");
        }
    }
}
