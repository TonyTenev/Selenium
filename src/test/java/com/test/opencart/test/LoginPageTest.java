package com.test.opencart.test;

import com.test.opencart.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class LoginPageTest extends OpenCartTestBase {
    @Test
    public void happyPath() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("openCartUsername"), ConfigReader.readProperty("openCartPass"));
        Assert.assertEquals(driver.getTitle(), "Dashboard");
    }
    @Test
    public void validateNegativeLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo", "asdf");
        Thread.sleep(2000);
        loginPage.negativeTest("No match for Username and/or Password.", "rgba(249, 220, 216, 1)");
    }
}
