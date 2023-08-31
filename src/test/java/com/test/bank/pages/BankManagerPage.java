package com.test.bank.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class BankManagerPage {
    public BankManagerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCostumerButton;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitAddCostumer;
    @FindBy(xpath = "//button[contains(text(), 'Open Account')]")
    WebElement openAccount;
    @FindBy(css = "#userSelect")
    WebElement costumerName;
    @FindBy(css = "#currency")
    WebElement currency;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement processButton;

    @FindBy(xpath = "//button[contains(text(), 'Customers')]")
    WebElement costumersButton;

    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement searchBar;

    @FindBy(xpath = "//td[@class='ng-binding']")
    List<WebElement> allInfo;

    @FindBy(xpath = "//button[@class='btn home']")
    WebElement homeButton;




    public void costumerInformation(String firstName, String lastName, String postCode, WebDriver driver, String expectedMessage) {
        addCostumerButton.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postCode.sendKeys(postCode);
        submitAddCostumer.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().trim().contains(expectedMessage));
        alert.accept();
    }

    public void OpenAccountInformation(WebDriver driver, String customerName, String currency, String expectedMessage) throws InterruptedException {
        openAccount.click();
        BrowserUtils.selectBy(costumerName, customerName, "text");
        BrowserUtils.selectBy(this.currency, currency, "text");
        processButton.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().trim().contains(expectedMessage));
        Thread.sleep(3000);
        alert.accept();

    }

    public void CostumersData(String firstName, String lastName, String zipCode) {
        costumersButton.click();
        searchBar.sendKeys(firstName);
        List<String> expectedData = Arrays.asList(firstName, lastName, zipCode);
        for (int i = 0; i < allInfo.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(allInfo.get(i)), expectedData.get(i));

        }

    }

    public void ClickHomeButton(){
        homeButton.click();
    }
}
