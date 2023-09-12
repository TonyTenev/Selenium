package com.test.etsy.etsyTest;

import com.test.etsy.etsyPages.EtsyIphoneCasePage;
import com.test.etsy.etsyPages.EtsyMainPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchIphoneCase extends EtsyTestBase {
    @Parameters({"itemSearched", "phoneBrand", "phoneModel", "accessory"})
    @Test
    public void searchIphone(String searchedItem, String phoneBrand, String phoneModel, String accessory) throws InterruptedException {
        EtsyMainPage etsyMainPage = new EtsyMainPage(driver);
        etsyMainPage.searchItem(searchedItem);
        EtsyIphoneCasePage etsyIphoneCasePage = new EtsyIphoneCasePage(driver);
        etsyIphoneCasePage.validateAdTitle(phoneBrand, phoneModel, accessory);

    }
}
