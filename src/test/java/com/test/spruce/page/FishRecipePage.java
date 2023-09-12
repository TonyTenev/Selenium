package com.test.spruce.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import javax.sql.rowset.BaseRowSet;

public class FishRecipePage {
    public FishRecipePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a//input[@id='starRating_score_4Star']")
    WebElement fourStarsRadio;

    @FindBy(css = "#pop_search_editor")
    WebElement editorsChoice;
    @FindBy(xpath = "//span[.='6-Ingredient Roasted Salmon Fillets']")
    WebElement header;

    public void pickRecipe(WebDriver driver, String expectedHeader) throws InterruptedException {
        Thread.sleep(2000);
        BrowserUtils.clickWithJS(driver, fourStarsRadio);
        if (!editorsChoice.isSelected()){
            BrowserUtils.clickWithJS(driver, editorsChoice);}
        Thread.sleep(2000);
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader );
    }


}
