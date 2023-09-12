package com.test.etsy.etsyPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EtsyMainPage {
    public EtsyMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@data-id='search-query']")
    WebElement searchBar;

    public void searchItem(String item) throws InterruptedException {
        searchBar.sendKeys(item, Keys.ENTER);
        Thread.sleep(2000);
    }
}
