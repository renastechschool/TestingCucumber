package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.*;

import java.sql.SQLOutput;
import java.util.List;


public class stepDefinition {

    @Given("^User is on the login page$")
    public void user_is_on_the_login_page() throws Throwable {
        System.out.println("User is on the login page");
    }

    @When("^user enter username as (.+) and password as (.+) and clicks on login button$")
    public void user_enter_username_as_and_password_as_and_clicks_on_login_button(String username, String password) throws Throwable {
        System.out.println("Username - "+ username + " Password - "+ password);
    }

    @When("user enter credentials")
    public void credentials(){
        System.out.println("When Credentials");
    }

    @Then("^user is given access to the system$")
    public void user_is_given_access_to_the_system() throws Throwable {
        System.out.println("User is given access to the system");
    }

    @Then("^user is not given access to the system$")
    public void user_is_not_given_access_to_the_system() throws Throwable {
        System.out.println("User is not given access to the system");
    }

    @Given("User is on the registration page")
    public void validateRegistrationPage(){
        System.out.println("User is on the Registration page");
    }

    @When("user enters all the details on the page")
    public void enterDetails(DataTable details){
        List<String> data = details.asList();
        System.out.println(data.get(0)+" "+ data.get(1)+" "+ data.get(2)+ " "+data.get(3)+ " "+ data.get(4)+ " "+data.get(5));
    }

    @Then("user is registered to the system")
    public void validateRegistration(){
        System.out.println("Registration Validated");
    }

    @Given("^User is on page one$")
    public void user_is_on_page_one() throws Throwable {
        System.out.println("Given - Page one");
    }

    @Given("^User is on page two$")
    public void user_is_on_page_two() throws Throwable {
        System.out.println("Given - Page Two");
    }

    @Given("^User is on page three$")
    public void user_is_on_page_three() throws Throwable {
        System.out.println("Given - Page Three");
    }

    @Given("^User is on page four$")
    public void user_is_on_page_four() throws Throwable {
        System.out.println("Given - Page Four");
    }

    @Given("^User is on page five$")
    public void user_is_on_page_five() throws Throwable {
        System.out.println("Given - Page Five");
    }

    @When("^user enters values in page one$")
    public void user_enters_values_in_page_one() throws Throwable {
        System.out.println("When - Page One");
    }

    @When("^user enters values in page two$")
    public void user_enters_values_in_page_two() throws Throwable {
        System.out.println("When - Page Two");
    }

    @When("^user enters values in page three$")
    public void user_enters_values_in_page_three() throws Throwable {
        System.out.println("When - Page Three");
    }

    @When("^user enters values in page four$")
    public void user_enters_values_in_page_four() throws Throwable {
        System.out.println("When - Page Four");
    }

    @When("^user enters values in page five$")
    public void user_enters_values_in_page_five() throws Throwable {
        System.out.println("When - Page Five");
    }

    @Then("^user reaches page two$")
    public void user_reaches_page_two() throws Throwable {
        System.out.println("Then - Page Two");
    }

    @Then("^user reaches page three$")
    public void user_reaches_page_three() throws Throwable {
        System.out.println("Then - Page Three");
    }

    @Then("^user reaches page four$")
    public void user_reaches_page_four() throws Throwable {
        System.out.println("Then - Page Four");
    }

    @Then("^user reaches page five$")
    public void user_reaches_page_five() throws Throwable {
        System.out.println("Then - Page Five");
    }

    @Then("^user reaches page six$")
    public void user_reaches_page_six() throws Throwable {
        System.out.println("Then - Page Six");
    }

    @Given("^user check webpage$")
    public void user_check_webpage() throws Throwable {
        System.out.println("Background Given");
    }

    @When("^user validates webpage$")
    public void user_validates_webpage() throws Throwable {
        System.out.println("Background When");
    }

    @Then("^webpage is fine$")
    public void webpage_is_fine() throws Throwable {
        System.out.println("Background Then");
    }
}