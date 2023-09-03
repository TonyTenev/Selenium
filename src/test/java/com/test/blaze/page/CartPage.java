package com.test.blaze.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartPage {
    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tr//td")
    List<WebElement> productTable;

    @FindBy(xpath = "//button[.='Place Order']")
    WebElement placeOrderButton;
    @FindBy(css = "#name")
    WebElement name;
    @FindBy(css = "#country")
    WebElement country;
    @FindBy(css = "#city")
    WebElement city;
    @FindBy(css = "#card")
    WebElement creditCard;
    @FindBy(css = "#month")
    WebElement month;
    @FindBy(css = "#year")
    WebElement year;
    @FindBy(xpath = "//button[.='Purchase']")
    WebElement purchaseButton;
    @FindBy(xpath = "//h2[contains(text(), 'Thank you')]")
    WebElement confMessage;
    @FindBy(xpath = "//button[.='OK']")
    WebElement okButton;



    public void verifyOrderDetails(String expectedTitle, String expectedPrice) throws InterruptedException {
        List<String> expectedValues = Arrays.asList("", expectedTitle,expectedPrice,"");
        for (int i = 1; i < productTable.size()-1; i++) {
            Assert.assertEquals(BrowserUtils.getText(productTable.get(i)), expectedValues.get(i));
        }
    }
    public void clickPlaceOrder() throws InterruptedException {
        placeOrderButton.click();
        Thread.sleep(1000);
    }
    public void fillOutInfo(String name, String country, String city, String creditCardNumber, String month, String year) throws InterruptedException {
        this.name.sendKeys(name);
        this.country.sendKeys(country);
        this.city.sendKeys(city);
        creditCard.sendKeys(creditCardNumber);
        this.month.sendKeys(month);
        this.year.sendKeys(year);
        Thread.sleep(1000);




    }
    public void clickPurchaseButton(){
        purchaseButton.click();
    }
    public void validatePurchaseMessage(String expectedConfMessage) throws InterruptedException {
        Assert.assertEquals(BrowserUtils.getText(confMessage), expectedConfMessage);
        Thread.sleep(1000);
        okButton.click();
    }
    public void validateNegativeMessage(WebDriver driver, String expectedNegativeMessage){
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), expectedNegativeMessage);
        alert.accept();
    }
}
