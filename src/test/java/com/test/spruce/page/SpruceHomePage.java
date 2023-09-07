package com.test.spruce.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class SpruceHomePage {
    public SpruceHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[.='Ingredients']")
    WebElement ingredients;

    @FindBy(xpath = "//a[contains(text(), 'Fish & Seafood')]")
    WebElement fishAndSeaFood;

    public void navigateToFishPage(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(ingredients).perform();
        fishAndSeaFood.click();

    }
}
