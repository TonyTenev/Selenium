package com.test.blaze.page;

import com.test.blaze.test.MackBookPro;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class MackBookProPage {
    public MackBookProPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h2")
    WebElement header;

    @FindBy(tagName = "h3")
    WebElement price;

    @FindBy(css = "#myTabContent")
    WebElement description;
    @FindBy(linkText = "Add to cart")
    WebElement addToCartButton;



    public void namePriceDescriptionValidation(String expectedHeader, String expectedPrice, String expectedDescription) {
        Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);
        Assert.assertEquals(BrowserUtils.getText(price), expectedPrice);
        Assert.assertEquals(BrowserUtils.getText(description), expectedDescription);
    }

    public void addToCart() throws InterruptedException {
        addToCartButton.click();
        Thread.sleep(1000);
    }

    public void messageVerification(WebDriver driver, String expectedTextAlert) {
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), expectedTextAlert);
        alert.accept();
    }
}
