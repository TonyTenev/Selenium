package com.test.opencart.test;

import com.test.opencart.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends OpenCartTestBase {
    @Test
    public void happyPath() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo", "demo");
        Assert.assertEquals(driver.getTitle(), "Dashboard");
    }
    @Test
    public void validateNegativeLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo", "asdf");
        Thread.sleep(2000);
        loginPage.negativeTest("No match for Username and/or Password.", "rgba(0, 0, 0, 0)");
    }
}
