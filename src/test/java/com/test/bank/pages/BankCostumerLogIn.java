package com.test.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class BankCostumerLogIn {

    public BankCostumerLogIn(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#userSelect")
    WebElement dropDown;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement costumerLogInButton;

    @FindBy(xpath = "//strong[contains(text(),'Welcome')]")
    WebElement welcomeMessage;

    @FindBy(xpath = "//strong[@class='ng-binding']")
    List<WebElement> accNumberBalanceCurrency;

    @FindBy(xpath = "//button[@ng-click='deposit()']")
    WebElement depositButton;

    @FindBy(xpath = "//input[@ placeholder ='amount']")
    WebElement amountBar;

    @FindBy(xpath = "//button[@ type ='submit']")
    WebElement submitDepositWithdrawButton;

    @FindBy(xpath = "//span[@ ng-show ='message']")
    WebElement transactionSuccessMessage;
    @FindBy(xpath = "//button[@ng-click='withdrawl()']")
    WebElement withdrawButton;
    @FindBy(xpath = "//strong[2]")
    WebElement balance;
    @FindBy(xpath = "//button[@ng-click='transactions()']")
    WebElement transactionsButton;
    @FindBy(xpath = "//tr[@id='anchor0']//td[2]")
    WebElement creditAmount;
    @FindBy(xpath = "//tr[@id='anchor1']//td[2]")
    WebElement debitAmount;


    public void selectName(String name, String value) {
        BrowserUtils.selectBy(dropDown, name, value);
        costumerLogInButton.click();
    }

    public void accountGeneralInfo(String expectedMessage, String accNumber, String balance, String currency) {
        Assert.assertTrue(BrowserUtils.getText(welcomeMessage).trim().contains(expectedMessage));
        List<String> expected = Arrays.asList(accNumber, balance, currency);
        for (int i = 1; i < accNumberBalanceCurrency.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(accNumberBalanceCurrency.get(i)), expected.get(i));
        }
    }

    public void depositTest(String amount, String expectedMessage, String expectedAmount) {
        depositButton.click();
        amountBar.sendKeys(amount);
        submitDepositWithdrawButton.click();
        Assert.assertEquals(BrowserUtils.getText(transactionSuccessMessage), expectedMessage);
        Assert.assertEquals(BrowserUtils.getText(balance), expectedAmount);
    }

    public void withdrawTest(String amount, String expectedMessage) throws InterruptedException {
        withdrawButton.click();
        Thread.sleep(2000);
        amountBar.sendKeys(amount);
        submitDepositWithdrawButton.click();
        Thread.sleep(200);
        Assert.assertEquals(BrowserUtils.getText(transactionSuccessMessage), expectedMessage);
        System.out.println(BrowserUtils.getText(balance));

    }
    public void transactionProcess() throws InterruptedException {
        int expectedBalance = Integer.parseInt(BrowserUtils.getText(balance));
        Thread.sleep(1000);
        transactionsButton.click();
        Thread.sleep(2000);
        int actualBalance = Integer.parseInt(BrowserUtils.getText(creditAmount))-
                Integer.parseInt(BrowserUtils.getText(debitAmount));
        Assert.assertEquals(actualBalance, expectedBalance);


    }


}
