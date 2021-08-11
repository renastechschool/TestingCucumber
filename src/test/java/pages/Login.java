package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {


    public static WebDriver driver;


    public Login(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }


    @FindBy(id = "ctl00_MainContent_username")
    private WebElement username;

    @FindBy(id = "ctl00_MainContent_password")
    private WebElement password;

    @FindBy(xpath = "//input[@type='submit' and @name='ctl00$MainContent$login_button']")
    public WebElement submitButton;


    public void loginMethodForUsername(){

       username.sendKeys("Tester");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void loginMethodForPassword(){

        password.sendKeys("test");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

     public void setSubmitButton() throws InterruptedException {

        submitButton.click();
        Thread.sleep(2000);

     }



}
