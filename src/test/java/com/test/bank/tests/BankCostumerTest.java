package com.test.bank.tests;

import com.test.bank.pages.BankCostumerLogIn;
import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankCostumerTest extends BankTestBase {
    @Test
    public void CostumerLogInTest() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.costumerInformation("Tony", "Tenev", "60656", driver,
                "Customer added successfully with customer id ");
        bankManagerPage.OpenAccountInformation(driver, "Tony Tenev", "Dollar",
                "Account created successfully with account Number");
        bankManagerPage.CostumersData("Tony", "Tenev", "60656");
        bankManagerPage.ClickHomeButton();
        bankLoginPage.clickCustomerLogIn();
        BankCostumerLogIn bankCostumerLogIn = new BankCostumerLogIn(driver);
        bankCostumerLogIn.selectName("Tony Tenev", "text");
        bankCostumerLogIn.accountGeneralInfo("Welcome Tony Tenev !!", "1111", "0", "Dollar");
        bankCostumerLogIn.depositTest("500", "Deposit Successful", "500");
        bankCostumerLogIn.withdrawTest("300", "Transaction successful");
        bankCostumerLogIn.transactionProcess();


    }
}
