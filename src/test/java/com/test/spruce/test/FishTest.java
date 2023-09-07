package com.test.spruce.test;

import com.test.spruce.page.FishAndSeaFoodPage;
import com.test.spruce.page.FishRecipePage;
import com.test.spruce.page.SpruceHomePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FishTest extends SpruceTestBase {
    @Parameters({"recipe", "expectedHeader"})
    @Test
    public void FishForDinner(String recipe, String expectedHeader) throws InterruptedException {
        SpruceHomePage spruceHomePage = new SpruceHomePage(driver);
        spruceHomePage.navigateToFishPage(driver);
        FishAndSeaFoodPage fishAndSeaFoodPage = new FishAndSeaFoodPage(driver);
        fishAndSeaFoodPage.searchRecipe(driver,recipe );
        FishRecipePage fishRecipePage = new FishRecipePage(driver);
        fishRecipePage.pickRecipe(driver, expectedHeader);

    }
}
