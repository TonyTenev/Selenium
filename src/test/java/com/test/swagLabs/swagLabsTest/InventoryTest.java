package com.test.swagLabs.swagLabsTest;

import com.test.swagLabs.swagLabsPages.InventoryPage;
import com.test.swagLabs.swagLabsPages.SwagLabsMainPage;
import org.testng.annotations.Test;

public class InventoryTest extends SwagLabsTestBase {
    @Test(dataProvider = "ItemList", dataProviderClass = AllData.class)
    public void validateItems(String username, String password, String itemName,
                              String expectedHeader, String expectedDesc, String expectedPrice) throws InterruptedException {
        SwagLabsMainPage swagLabsMainPage = new SwagLabsMainPage(driver);
        swagLabsMainPage.logIn(driver, username, password);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickItem(itemName);
        inventoryPage.productInfo(expectedHeader, expectedDesc, expectedPrice);

    }

}
