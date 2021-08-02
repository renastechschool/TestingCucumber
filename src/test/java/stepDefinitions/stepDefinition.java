package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.SQLOutput;
import java.util.List;

public class stepDefinition {

    public WebDriver driver;

    @Given("^user is on the home page$")
    public void user_is_on_the_home_page() throws Throwable {
        System.setProperty("webdriver.chrome.driver","C:\\Noel\\Selenium\\Chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @When("^user enter (.+) in the search box and clicks on search button$")
    public void user_enter_something_in_the_search_box_and_clicks_on_search_button(String item) throws Throwable {
        driver.findElement(By.name("search_query")).sendKeys(item);
        driver.findElement(By.name("submit_search")).click();
    }

    @Then("^search results are displayed to the user with value (.+)$")
    public void search_results_are_displayed_to_the_user_with_value_something(String item) throws Throwable {
        String resultText = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[1]")).getText();
        if (resultText.contains(item)) {
            System.out.println(item + " results are displayed");
        } else {
            System.out.println(item + "results are not displayed on the screen");
        }
        //driver.close();
    }

    @Given("results are displayed to the user")
    public void resultsDisplay()throws Throwable {
        System.setProperty("webdriver.chrome.driver","C:\\Noel\\Selenium\\Chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.name("search_query")).sendKeys("Shirt");
        driver.findElement(By.name("submit_search")).click();
        String resultText = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[1]")).getText();
        if (resultText.contains("SHIRT"))
        {
            System.out.println("Shirt results are displayed");
        }
        else
        {
            System.out.println("Shirt results are not displayed on the screen");
        }
    }

    @When("^user clicks on the search button and enters details$")
    public void user_clicks_on_the_search_button_and_enters_details() throws Throwable {

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("qty")).clear();
        driver.findElement(By.name("qty")).sendKeys("5");
        WebElement size = driver.findElement(By.name("group_1"));
        Select sizeDrpDown = new Select(size);
        sizeDrpDown.selectByVisibleText("L");
        driver.findElement(By.name("Blue")).click();
        driver.findElement(By.name("Submit")).click();
    }

    @Then("^user can add the item to cart$")
    public void user_can_add_the_item_to_cart() throws Throwable {
        Thread.sleep(2000);
        String result = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")).getText();
        System.out.println(result);
    }

    @When("user enters details to search")
    public void enterDetails(DataTable data){
        List<List<String>> details = data.asLists();
        String searchItem = details.get(0).get(0);
        driver.findElement(By.name("search_query")).sendKeys(searchItem);
        driver.findElement(By.name("submit_search")).click();
    }

    @Then("results are displayed based on his search")
    public void verifyResults(DataTable data){
        List<List<String>> details = data.asLists();
        String searchItem = details.get(0).get(0);
        String resultText = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[1]")).getText();
        if (resultText.contains(searchItem)) {
            System.out.println(searchItem + " results are displayed");
        } else {
            System.out.println(searchItem + "results are not displayed on the screen");
        }
    }
}