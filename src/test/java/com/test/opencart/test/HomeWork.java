package com.test.opencart.test;

import com.test.opencart.pages.CostumersPage;
import com.test.opencart.pages.DashboardPage;
import com.test.opencart.pages.LoginPage;
import org.testng.annotations.Test;

public class HomeWork extends OpenCartTestBase {
    @Test

    public void navigateToCostumer() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo", "demo");
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.navigateToCustomerPage();
        CostumersPage costumersPage = new CostumersPage(driver);
        costumersPage.addCostumer("Tony", "Tenev", "tonytenev@gmail.com",
                "123456789", "123456789");
        costumersPage.alertMessageVerification("Warning: You do not have permission to modify customers!",
                "rgba(136, 48, 37, 1)", "rgba(249, 220, 216, 1)");
    }
}
