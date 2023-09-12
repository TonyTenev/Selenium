package com.test.swagLabs.swagLabsPages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class SwagLabsMainPage {
    public SwagLabsMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#user-name")
    WebElement userName;
    @FindBy(css = "#password")
    WebElement password;
    @FindBy(css = "#login-button")
    WebElement logInButton;
    @FindBy(xpath = "//h3")
    WebElement errorMessage;

    public void logIn(WebDriver driver, String username, String pass) throws InterruptedException {
        userName.sendKeys(username);
        password.sendKeys(pass);
        logInButton.click();
        Thread.sleep(1000);
    }

    public void positiveLogIn(WebDriver driver, String expectedURL){
        Assert.assertEquals(driver.getCurrentUrl().trim(), expectedURL);
    }

    public void negativeTest(WebDriver driver, String username, String pass, String expectedErrorMessage) {
        userName.sendKeys(username);
        password.sendKeys(pass);
        logInButton.click();
        Assert.assertEquals(BrowserUtils.getText(errorMessage), expectedErrorMessage);
    }
}
