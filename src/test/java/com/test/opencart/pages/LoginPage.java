package com.test.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.layertree.model.StickyPositionConstraint;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#input-username")
    WebElement userName;

    @FindBy(css = "#input-password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement logInButton;
    @FindBy(css = "#alert")
    WebElement errorMessage;


    public void login(String username, String pass) throws InterruptedException {
        userName.sendKeys(username);
        password.sendKeys(pass);
        logInButton.submit();
        Thread.sleep(1000);
    }

    public void negativeTest(String expectedMessage, String backgroundExpectedColor) throws InterruptedException {
        Assert.assertEquals(BrowserUtils.getText(errorMessage), expectedMessage);
        Thread.sleep(2000);
        Assert.assertEquals(errorMessage.getCssValue("background-color"), backgroundExpectedColor);
        Thread.sleep(2000);

    }
}
