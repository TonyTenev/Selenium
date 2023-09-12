package com.test.swagLabs.swagLabsTest;

import com.test.swagLabs.swagLabsPages.SwagLabsMainPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SwabLabsLoginTest extends SwagLabsTestBase {
    @Test(dataProvider = "LogInInfo", dataProviderClass = AllData.class)
    public void positiveLoginTest(String username, String password, String expectedURL) throws InterruptedException {
        SwagLabsMainPage swagLabsMainPage = new SwagLabsMainPage(driver);
        swagLabsMainPage.logIn(driver, username, password);
        swagLabsMainPage.positiveLogIn(driver, expectedURL);

    }

    @Test(dataProvider = "LogInInfoNegative", dataProviderClass = AllData.class)
    public void negativeLoginTest(String username, String password, String expectedErrorMessage) {
        SwagLabsMainPage swagLabsMainPage = new SwagLabsMainPage(driver);
        swagLabsMainPage.negativeTest(driver, username, password, expectedErrorMessage);
    }

}
