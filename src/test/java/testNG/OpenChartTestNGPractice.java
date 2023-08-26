package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OpenChartTestNGPractice {
    @Test
    public void validateSuccessfullLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement logInButton = driver.findElement(By.tagName("button"));
        logInButton.click();
        Thread.sleep(1000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(actualTitle, expectedTitle);
        driver.quit();
    }

    @Test
    public void validateNegativeScenario() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo111");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo111");
        WebElement logInButton = driver.findElement(By.tagName("button"));
        logInButton.click();
        Thread.sleep(1000);
        String error = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().trim();
        String expectedError = "No match for Username and/or Password.";
        Assert.assertEquals(error, expectedError);
        driver.quit();
    }

    @Test
    public void validateProductButton() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement logInButton = driver.findElement(By.tagName("button"));
        logInButton.click();
        Thread.sleep(1000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();
        Thread.sleep(1000);
        WebElement catalogButton = driver.findElement(By.linkText("Catalog"));
        catalogButton.click();
        Thread.sleep(2000);
        WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
        Assert.assertTrue(productButton.isDisplayed());
        Assert.assertTrue(productButton.isEnabled());
        driver.quit();


    }

    @Test
    public void validateBoxesFunctionalityProducts() throws InterruptedException {
        //TIPS:
//1-Find the all boxes location for the first page
//2-Use regular loop and start from i=1 because i=0 is choosing all boxes right away
//3-This box is displayed
//4-The box is enabled
//5-The box is not selected(Assert.assertFalse)
//6-Click
//7-The box is selected(Assert.AssertTrue)
//Thread.sleep(1000)
//sendKeys(Keys.Arrow) -->We did in youtube remember
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement logInButton = driver.findElement(By.tagName("button"));
        logInButton.click();
        Thread.sleep(1000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();
        Thread.sleep(1000);
        WebElement catalogButton = driver.findElement(By.linkText("Catalog"));
        catalogButton.click();
        Thread.sleep(2000);
        WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
        productButton.click();
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (int i = 1; i < checkBoxes.size(); i++) {
            Thread.sleep(500);
            WebElement checkBox = checkBoxes.get(i);
            Assert.assertTrue(checkBox.isDisplayed() && checkBox.isEnabled());
            Assert.assertFalse(checkBox.isSelected());
            Thread.sleep(500);
            checkBox.click();
            Assert.assertTrue(checkBox.isSelected());
            Thread.sleep(500);
            checkBox.sendKeys(Keys.ARROW_DOWN);


        }
        driver.quit();

    }

    @Test
    public void validateAscendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement logInButton = driver.findElement(By.tagName("button"));
        logInButton.click();
        Thread.sleep(1000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();
        Thread.sleep(1000);
        WebElement catalogButton = driver.findElement(By.linkText("Catalog"));
        catalogButton.click();
        Thread.sleep(2000);
        WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
        productButton.click();
        Thread.sleep(1000);
        List<WebElement> allProducts = driver.findElements(By.xpath("//td[@class='text-start']"));
        List<String> expectedProduct = new ArrayList<>();
        List<String> actualProducts = new ArrayList<>();
        for (int i = 1; i < allProducts.size(); i++) {
            actualProducts.add(allProducts.get(i).getText().toLowerCase().trim());
            expectedProduct.add(allProducts.get(i).getText().toLowerCase().trim());

        }
        Collections.sort(expectedProduct);

        System.out.println(actualProducts);
        System.out.println(expectedProduct);
        Assert.assertEquals(actualProducts, expectedProduct);
        driver.quit();


    }

    @Test
    public void validateDescendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement logInButton = driver.findElement(By.tagName("button"));
        logInButton.click();
        Thread.sleep(1000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();
        Thread.sleep(1000);
        WebElement catalogButton = driver.findElement(By.linkText("Catalog"));
        catalogButton.click();
        Thread.sleep(2000);
        WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
        productButton.click();
        Thread.sleep(1000);
        WebElement productNameButton = driver.findElement(By.cssSelector(".asc"));
        productNameButton.click();
        Thread.sleep(2000);
        List<WebElement> allProduct = driver.findElements(By.xpath("//td[@class='text-start']"));
        List<String> expectedProduct = new ArrayList<>();
        List<String> actualProducts = new ArrayList<>();
        for (int i = 1; i < allProduct.size(); i++) {
            actualProducts.add(allProduct.get(i).getText().toLowerCase().trim());
            expectedProduct.add(allProduct.get(i).getText().toLowerCase().trim());
        }
        Collections.sort(expectedProduct);
        Collections.reverse(expectedProduct);
        System.out.println(expectedProduct);
        System.out.println(actualProducts);
        Assert.assertEquals(actualProducts,expectedProduct);
        driver.quit();

    }


}
