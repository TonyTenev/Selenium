package com.test.blaze.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class MainPage {
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#itemc")
    List<WebElement> categories;
    @FindBy(linkText = "Cart")
    WebElement cartButton;
    @FindBy(xpath = "//a[contains(text(), 'PRODUCT STORE')]")
    WebElement productStoreHeader;

    public void clickOnCategory(String wantedCategory) throws InterruptedException {
        for (WebElement category : categories) {
            if (BrowserUtils.getText(category).contains(wantedCategory)) {
                category.click();
                break;
            }
        }
        Thread.sleep(2000);
    }
    public void clickCartButton() throws InterruptedException {
        Thread.sleep(1000);
        cartButton.click();
    }
    public void mainPageVerification(String expectedHeader){
        Assert.assertEquals(BrowserUtils.getText(productStoreHeader),expectedHeader );
    }
}
