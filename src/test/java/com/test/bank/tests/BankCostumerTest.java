package com.test.bank.tests;

import com.test.bank.pages.BankCostumerLogIn;
import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankCostumerTest extends BankTestBase {
    @Parameters({"name", "lastName", "zipCode", "expectedMessage", "customerName", "currency",
    "expectedAccountMessage", "expectedHeaderLoginIn", "defaultBalance", "depositAmount", "expectedDepositMessage",
    "expectedBalance", "withdrawalAmount", "expectedTransactionMessage"})
    @Test
    public void CostumerLogInTest(String firstName, String lastName, String zipCode,
                                  String expectedMessage, String customerName, String currency,
                                  String expectedAccountMessage, String expectedHeader, String defaultBalance,
                                  String depositAmount, String expectedDepositMessage, String expectedBalance,
                                  String withdrawalAmount, String expectedTransactionMessage) throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.costumerInformation(firstName, lastName, zipCode, driver, expectedMessage);
        bankManagerPage.OpenAccountInformation(driver, customerName, currency, expectedAccountMessage);
        bankManagerPage.CostumersData(firstName, lastName, zipCode);
        bankManagerPage.ClickHomeButton();
        bankLoginPage.clickCustomerLogIn();
        BankCostumerLogIn bankCostumerLogIn = new BankCostumerLogIn(driver);
        bankCostumerLogIn.selectName(customerName, "text");
        bankCostumerLogIn.accountGeneralInfo(expectedHeader, "1111", defaultBalance, currency);
        bankCostumerLogIn.depositTest(depositAmount, expectedDepositMessage, expectedBalance);
        bankCostumerLogIn.withdrawTest(withdrawalAmount, expectedTransactionMessage);
        bankCostumerLogIn.transactionProcess();


    }
}
