package com.test.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class CostumersPage {
    public CostumersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[@class='fas fa-plus']")
    WebElement addButton;

    @FindBy(css = "#input-firstname")
    WebElement firstName;

    @FindBy(css = "#input-lastname")
    WebElement lastName;

    @FindBy(css = "#input-email")
    WebElement email;

    @FindBy(css = "#input-password")
    WebElement password;

    @FindBy(css = "#input-confirm")
    WebElement confirmPassword;

    @FindBy(xpath = "//i[@class='fas fa-save']")
    WebElement saveButton;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement alertMessage;

    public void addCostumer(String inputFirstName, String inputLastName, String inputEmail, String inputPass) {
        addButton.click();
        firstName.sendKeys(inputFirstName);
        lastName.sendKeys(inputLastName);
        email.sendKeys(inputEmail);
        password.sendKeys(inputPass);
        confirmPassword.sendKeys(inputPass);
        saveButton.click();
    }

    public void alertMessageVerification(String expectedMessage, String expectedColor, String expectedBackgroundColor) {
        Assert.assertEquals(BrowserUtils.getText(alertMessage), expectedMessage);
        Assert.assertEquals(alertMessage.getCssValue("color"), expectedColor);
        Assert.assertEquals(alertMessage.getCssValue("background-color"), expectedBackgroundColor);
    }
}
