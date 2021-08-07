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
import java.util.Map;

public class stepDefinition {

    public static WebDriver driver;

    @Given("^user is on the home page$")
    public void user_is_on_the_home_page() throws Throwable {
        String url = utils.commonUtils.getURL("src/test/Resources/automation.properties");
        driver.get(url);
        utils.commonUtils.getScreenshot(driver,"HomePage");
    }

    @When("^user enter (.+) in the search box and clicks on search button$")
    public void user_enter_something_in_the_search_box_and_clicks_on_search_button(String item) throws Throwable {
        driver.findElement(By.name("search_query")).sendKeys(item);
        utils.commonUtils.getScreenshot(driver,"BeforeSearchClick");
        driver.findElement(By.name("submit_search")).click();
    }

    @Then("^search results are displayed to the user with value (.+)$")
    public void search_results_are_displayed_to_the_user_with_value_something(String item) throws Throwable {
        utils.commonUtils.getScreenshot(driver,"AfterSearchClick");
        String resultText = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[1]")).getText();
        if (resultText.contains(item)) {
            System.out.println(item + " results are displayed");
        } else {
            System.out.println(item + "results are not displayed on the screen");
        }
    }

    @Given("results are displayed to the user")
    public void resultsDisplay()throws Throwable {
        String url = utils.commonUtils.getURL("src/test/Resources/automation.properties");
        driver.get(url);
        driver.findElement(By.name("search_query")).sendKeys("Shirt");
        utils.commonUtils.getScreenshot(driver,"BeforeSearchClick");
        driver.findElement(By.name("submit_search")).click();
        String resultText = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[1]")).getText();
        utils.commonUtils.getScreenshot(driver,"AfterSearchClick");
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
        utils.commonUtils.getScreenshot(driver,"ItemClicked");
        driver.findElement(By.name("qty")).clear();
        driver.findElement(By.name("qty")).sendKeys("5");
        WebElement size = driver.findElement(By.name("group_1"));
        Select sizeDrpDown = new Select(size);
        sizeDrpDown.selectByVisibleText("L");
        driver.findElement(By.name("Blue")).click();
        utils.commonUtils.getScreenshot(driver,"DetailsEntered");
        driver.findElement(By.name("Submit")).click();
    }

    @Then("^user can add the item to cart$")
    public void user_can_add_the_item_to_cart() throws Throwable {
        Thread.sleep(2000);
        utils.commonUtils.getScreenshot(driver,"ItemsAddedToCart");
        String result = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")).getText();
        System.out.println(result);
    }

    @When("user enters details to search")
    public void enterDetails(DataTable data){
        List<List<String>> details = data.asLists();
        String searchItem = details.get(0).get(0);
        driver.findElement(By.name("search_query")).sendKeys(searchItem);
        utils.commonUtils.getScreenshot(driver,"BeforeSearchClick");
        driver.findElement(By.name("submit_search")).click();
    }

    @Then("results are displayed based on his search")
    public void verifyResults(DataTable data){
        List<List<String>> details = data.asLists();
        String searchItem = details.get(0).get(0);
        utils.commonUtils.getScreenshot(driver,"AfterSearchClick");
        String resultText = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[1]")).getText();
        if (resultText.contains(searchItem)) {
            System.out.println(searchItem + " results are displayed");
        } else {
            System.out.println(searchItem + "results are not displayed on the screen");
        }
    }

    @Given("^user is on the Contact us page$")
    public void user_is_on_the_contact_us_page() throws Throwable {
        String url = utils.commonUtils.getURL("src/test/Resources/automation.properties");
        driver.get(url);
        driver.findElement(By.xpath("//*[@id=\"contact-link\"]/a")).click();
        utils.commonUtils.getScreenshot(driver,"ContactUsPage");
    }

    @When("^the user enters details and clicks on Send button$")
    public void the_user_enters_details_and_clicks_on_send_button(DataTable data) throws Throwable {
        System.out.println("INSIDE LIST");
        WebElement subject = driver.findElement(By.id("id_contact"));
        Select subjectDropDown = new Select(subject);
        List<String> details = data.asList();
        subjectDropDown.selectByVisibleText(details.get(0));
        driver.findElement(By.id("email")).sendKeys(details.get(1));
        driver.findElement(By.id("id_order")).sendKeys(details.get(2));
        driver.findElement(By.id("message")).sendKeys(details.get(3));
        utils.commonUtils.getScreenshot(driver,"BeforeSendClick");
        driver.findElement(By.id("submitMessage")).click();
        System.out.println("Outside List");
    }


    @When("contact information")
    public void userEntersDetails(Map<String , String> data){
        System.out.println("Inside Maps");
        WebElement subject = driver.findElement(By.id("id_contact"));
        Select subjectDropDown = new Select(subject);
        subjectDropDown.selectByVisibleText(data.get("Subject"));
        driver.findElement(By.id("email")).sendKeys(data.get("Email"));
        driver.findElement(By.id("id_order")).sendKeys(data.get("Order Reference"));
        driver.findElement(By.id("message")).sendKeys(data.get("Message"));
        utils.commonUtils.getScreenshot(driver,"BeforeSendClick");
        driver.findElement(By.id("submitMessage")).click();
        System.out.println("Outside Maps");
    }

    @Then("^a success message is displayed on the page$")
    public void a_success_message_is_displayed_on_the_page() throws Throwable {
        utils.commonUtils.getScreenshot(driver,"AfterSendClick");
        System.out.println(driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText());
    }
}