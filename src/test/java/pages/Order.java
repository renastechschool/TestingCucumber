package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.commonUtils;

import java.util.Map;

public class Order {

    public static WebDriver driver;

    public Order(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    commonUtils common = new commonUtils();

    @FindBy (id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement dropdown;

    @FindBy (id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantity;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement cName;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement street;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement city;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement state;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zip;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement visa;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNo;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expDate;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;



    public void productInfo(Map<String,String> datatable){

        Select select = new Select(dropdown);
        select.selectByVisibleText(datatable.get("product"));
        common.timeOut(1000);
        quantity.sendKeys(datatable.get("Quantity"));

    }


    public void addressInfo(Map<String,String> dataTable){

        common.timeOut(1000);
        cName.sendKeys(dataTable.get("Customer name"));

        common.timeOut(1000);
        street.sendKeys(dataTable.get("Street"));

        common.timeOut(1000);
        city.sendKeys(dataTable.get("City"));

        common.timeOut(1000);
        state.sendKeys(dataTable.get("State"));

        common.timeOut(1000);
        zip.sendKeys(dataTable.get("Zip"));

    }

    public void paymentInfo(Map<String,String> dataTable){

        common.timeOut(1000);
        visa.click();
        common.timeOut(1000);
        cardNo.sendKeys(dataTable.get("CardNo"));
        common.timeOut(1000);
        expDate.sendKeys(dataTable.get("Expire date"));

    }

    public void clickProcess(){

        processButton.click();
    }



}
