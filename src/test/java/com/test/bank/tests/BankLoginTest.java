package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankLoginTest extends BankTestBase{
    @Test
    public void ValidateHeaderOfTheLoginPage(){
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        BankLoginPage bankLoginPage = new BankLoginPage(driver);//to access the methods from that class
        Assert.assertEquals(bankLoginPage.getHeader(), "XYZ Bank");
    }
}
