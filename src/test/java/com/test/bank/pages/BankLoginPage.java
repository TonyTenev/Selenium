package com.test.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class BankLoginPage {
    public BankLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "strong")
    WebElement header;

    @FindBy(xpath = "//button[.='Bank Manager Login']")
    WebElement managerButton;

    @FindBy(xpath = "//button[contains(text(), 'Customer Login')]")
    WebElement customerLogIn;

    public  String getHeader(){
        return BrowserUtils.getText(header);
    }

    public  void clickManagerButton(){
        managerButton.click();
    }

    public void clickCustomerLogIn(){
        customerLogIn.click();
    }

}
