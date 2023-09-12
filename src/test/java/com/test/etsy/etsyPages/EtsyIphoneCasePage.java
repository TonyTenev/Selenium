package com.test.etsy.etsyPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class EtsyIphoneCasePage {
    public EtsyIphoneCasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3[contains(@class, 'listing-card__title')]")
    List<WebElement> adTitles;

    public void validateAdTitle(String phoneBrand, String phoneModel, String phoneAccessory) throws InterruptedException {
        Thread.sleep(2000);
        for (int i = 0; i < adTitles.size(); i++) {
            String word = BrowserUtils.getText(adTitles.get(i)).toLowerCase();
            System.out.println(BrowserUtils.getText(adTitles.get(i)));
            Assert.assertTrue(word.contains(phoneBrand) || word.contains(phoneModel) || word.contains(phoneAccessory));
//            Assert.assertTrue(BrowserUtils.getText(adTitles.get(i)).toLowerCase().contains(phoneModel));
//            Assert.assertTrue(BrowserUtils.getText(adTitles.get(i)).toLowerCase().contains(phoneAccessory));


        }
    }

}
