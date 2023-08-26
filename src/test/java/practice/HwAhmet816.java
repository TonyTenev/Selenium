package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HwAhmet816 {
    @Test
    public void tc() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/");
        WebElement newOrUsed = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(newOrUsed, "New & used", "text");
        WebElement make = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(make, "Acura", "text");
        WebElement model = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(model, "acura-tl", "value");
        WebElement maxPrice = driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select maxPrice1 = new Select(maxPrice);
        String defaultPrice = "No max price";
        Assert.assertEquals(maxPrice1.getFirstSelectedOption().getText(), defaultPrice);
        WebElement distance = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance, "40", "value");
        WebElement zipCode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipCode.clear();
        zipCode.sendKeys("60056");
        Thread.sleep(500);
        WebElement searchButton = driver.findElement(By.xpath("//button[@data-linkname='search-all-make']"));
        searchButton.click();
        Thread.sleep(2000);
        WebElement header = driver.findElement(By.xpath("//h1[@data-qa='page_h1']"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "New and used Acura TL for sale";
        Assert.assertEquals(actualHeader, expectedHeader);
        Thread.sleep(2000);
        WebElement sort = driver.findElement(By.xpath("//select[@id='sort-dropdown']"));
        BrowserUtils.selectBy(sort, "Lowest price", "text");
        Thread.sleep(2000);
        List<WebElement> allPrices = driver.findElements(By.xpath("//span[@class='primary-price']"));
        List<Double> actualPrice = new ArrayList<>();
        List<Double> expectedPrice = new ArrayList<>();
        for (int i = 1; i < allPrices.size(); i++) {
            double actual = Double.parseDouble(allPrices.get(i).getText().replace("$", "").replaceAll(",", ""));
            actualPrice.add(actual);
            double expected = Double.parseDouble(allPrices.get(i).getText().replace("$", "").replaceAll(",", ""));
            expectedPrice.add(expected);
        }
        Collections.sort(expectedPrice);
        Assert.assertEquals(actualPrice, expectedPrice);
        System.out.println(expectedPrice);
        BrowserUtils.selectBy(sort, "Highest price", "text");
        Thread.sleep(3000);
        List<WebElement> allPrices1 = driver.findElements(By.xpath("//span[@class='primary-price']"));
        List<Double> actualDescending = new ArrayList<>();
        List<Double> expectedDescending = new ArrayList<>();
        for (int i = 0; i < allPrices.size(); i++) {
            double actualDescending1 = Double.parseDouble(allPrices1.get(i).getText().replace("$", "").replaceAll(",", ""));
            actualDescending.add(actualDescending1);
            double expectedDescending1 = Double.parseDouble(allPrices1.get(i).getText().replace("$", "").replaceAll(",", ""));
            expectedDescending.add(expectedDescending1);
        }
        Collections.sort(expectedDescending);
        Collections.reverse(expectedDescending);
        Assert.assertEquals(actualDescending,expectedDescending);




    }
}
