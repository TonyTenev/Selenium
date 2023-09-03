package com.test.blaze.test;

import com.test.blaze.page.CartPage;
import com.test.blaze.page.LaptopsPage;
import com.test.blaze.page.MackBookProPage;
import com.test.blaze.page.MainPage;
import org.testng.annotations.Test;

public class MackBookPro extends BlazeTestBase {
    @Test
    public void macbookTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnCategory("Laptops");
        LaptopsPage laptopsPage = new LaptopsPage(driver);
        laptopsPage.findLaptop("MacBook Pro");
        MackBookProPage mackBookProPage = new MackBookProPage(driver);
        mackBookProPage.namePriceDescriptionValidation("MacBook Pro", "$1100 *includes tax",
                "Product description\n" +
                        "Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar," +
                        " a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.");
        mackBookProPage.addToCart();
        mackBookProPage.messageVerification(driver, "Product added");
    }
    @Test
    public void purchaseVerificationHappyPath() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnCategory("Laptops");
        LaptopsPage laptopsPage = new LaptopsPage(driver);
        laptopsPage.findLaptop("MacBook Pro");
        MackBookProPage mackBookProPage = new MackBookProPage(driver);
        mackBookProPage.addToCart();
        mackBookProPage.messageVerification(driver, "Product added");
        mainPage.clickCartButton();
        CartPage cartPage = new CartPage(driver);
        cartPage.verifyOrderDetails("MacBook Pro", "1100");
        cartPage.clickPlaceOrder();
        cartPage.fillOutInfo("Tony Tenev", "USA", "Chicago",
                "123456789", "10", "2023");
        cartPage.clickPurchaseButton();
        cartPage.validatePurchaseMessage("Thank you for your purchase!");
        mainPage.mainPageVerification("PRODUCT STORE");
    }
    @Test
    public void purchaseNegativeTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnCategory("Laptops");
        LaptopsPage laptopsPage = new LaptopsPage(driver);
        laptopsPage.findLaptop("MacBook Pro");
        MackBookProPage mackBookProPage = new MackBookProPage(driver);
        mackBookProPage.addToCart();
        mackBookProPage.messageVerification(driver, "Product added");
        mainPage.clickCartButton();
        CartPage cartPage = new CartPage(driver);
        cartPage.verifyOrderDetails("MacBook Pro", "1100");
        cartPage.clickPlaceOrder();
        cartPage.clickPurchaseButton();
        cartPage.validateNegativeMessage(driver, "Please fill out Name and Creditcard.");
    }
}
