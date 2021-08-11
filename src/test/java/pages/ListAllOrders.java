package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ListAllOrders {

    public static WebDriver driver;

    public ListAllOrders(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }


    @FindBy(xpath = "//a[contains(text(),'Check All')]")
    public WebElement checkAll;

    @FindBy(xpath = "//a[contains(text(),'Order')]")
    public WebElement order;


    public void checkAllBoxes(){

        checkAll.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void clickAllCheckBoxes(){

     List<WebElement> checkBoxes =  driver.findElements(By.xpath("//input[contains(@id,'ctl00_MainContent_orderGrid_ctl0')]"));

        for (WebElement  each: checkBoxes ) {

            each.click();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    public void clickOrder(){

        order.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
