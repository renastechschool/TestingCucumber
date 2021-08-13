package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.commonUtils;

import java.util.Map;

public class Products {

    public static WebDriver driver;

    utils.commonUtils commonUtils = new commonUtils();


    public Products(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(text(),'View all products')]")
    private WebElement product;

    @FindBy(xpath = "//table[@class='ProductsTable']//tr//td[contains(text(),'ScreenSaver')]//following-sibling::td[1]")
    private WebElement price;

    @FindBy(xpath = "//table[@class='ProductsTable']//tr//td[contains(text(),'ScreenSaver')]//following-sibling::td[2]")
    private WebElement discount;


    public void clickProductPage(){

        commonUtils.timeOut(2000);
        product.click();
    }


    public void verifyPriceAndDiscount(Map<String,String> dataTable){

        String actualPrice   = price.getText();
        String expectedPrice = dataTable.get("Price");

        Assert.assertEquals("The Actual Price is NOT same as expected",expectedPrice,actualPrice );


        String actualDiscount = discount.getText().trim();
        String expectedDiscount = dataTable.get("Discount");

        Assert.assertEquals("The Actual Discount is Not Same as Expected :    ",expectedDiscount,actualDiscount);



    }







}
