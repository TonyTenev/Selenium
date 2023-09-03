package com.test.blaze.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class LaptopsPage {
    public LaptopsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".hrefch")
    List<WebElement> laptopLinks;

    public void findLaptop(String wantedLaptop) throws InterruptedException {
        for (WebElement laptop : laptopLinks) {
            if (BrowserUtils.getText(laptop).equals(wantedLaptop)) {
                laptop.click();
                break;
            }
        }
        Thread.sleep(2000);
    }

}
