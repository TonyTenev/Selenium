package com.test.spruce.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class FishAndSeaFoodPage {

    public FishAndSeaFoodPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#search-form-input")
    WebElement searchBar;
    @FindBy(css = "#button_1-0")
    WebElement searchButton;

    public void searchRecipe(WebDriver driver, String recipe) throws InterruptedException {
        Thread.sleep(2000);
        BrowserUtils.scrollIntoView(driver, searchBar);
        searchBar.sendKeys(recipe, Keys.ENTER);
//        searchButton.click();
    }
}
