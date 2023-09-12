package com.test.swagLabs.swagLabsPages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class InventoryPage {
    public InventoryPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".inventory_item_name")
    List<WebElement> items;
    @FindBy(css = ".inventory_details_name")
    WebElement header;
    @FindBy(css = ".inventory_details_desc")
    WebElement description;
    @FindBy(css = ".inventory_details_price")
    WebElement price;

    public void clickItem(String itemTitle){
        for (WebElement item:items) {
            if (BrowserUtils.getText(item).contains(itemTitle)){
                item.click();
                break;
            }
        }
    }
    public void productInfo(String expectedHeader, String expectedDesc, String expectedPrice){
        Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);
        Assert.assertTrue(BrowserUtils.getText(description).contains(expectedDesc));
        Assert.assertEquals(BrowserUtils.getText(price), expectedPrice);
    }

}
