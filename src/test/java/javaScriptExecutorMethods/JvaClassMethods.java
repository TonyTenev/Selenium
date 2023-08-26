package javaScriptExecutorMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class JvaClassMethods {
    @Test
    public void getTitleMethod() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://codefish.io/");
        System.out.println(driver.getTitle() + " this is from driver()");
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        System.out.println(js.executeScript("return document.title") + " With JS");
        System.out.println(BrowserUtils.getTitleWithJS(driver));
    }

    @Test
    public void clickJS() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://codefish.io/");
        WebElement aboutUsButton = driver.findElement(By.xpath("//button[.='About us']"));
        aboutUsButton.click();
        driver.navigate().back();
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.click(aboutUsButton).perform();
        driver.navigate().back();
        Thread.sleep(3000);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click()", aboutUsButton);
        BrowserUtils.clickWithJS(driver, aboutUsButton);
    }
    @Test
    public void scrollIntoView() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://codefish.io/");
        WebElement address = driver.findElement(By.xpath("//p[contains(text(), '2200')]"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true)", address);

        BrowserUtils.scrollIntoView(driver,address);
        System.out.println(BrowserUtils.getText(address));
        Thread.sleep(3000);
        WebElement contactUs = driver.findElement(By.xpath("//button[.='Contact Us']"));
//        js.executeScript("arguments[0].scrollIntoView(true)", contactUs);
        BrowserUtils.scrollIntoView(driver,contactUs);
    }
    @Test
    public void practiceAll() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techtorialacademy.com/");
        /*
        USE BROWSER UTILS!!!!
        scroll all the way down and validate "Copyright © 2023"
        scroll back up to "LAUNCH A NEW TECH CAREER" adn click APPLY NOW
        Validate title with JS "Apply Now"
        Validate info in the middle "info@techtorialacademy.com", "+ 1 (224) 570 91 91", "Chicago & Houston"

        */
        WebElement copyrights = driver.findElement(By.xpath("//div[contains(text(),'Copyright')]"));
        BrowserUtils.scrollIntoView(driver,copyrights);
        String expectedCopyrights = "Copyright © 2023";
        Assert.assertEquals(BrowserUtils.getText(copyrights), expectedCopyrights);
        WebElement top = driver.findElement(By.xpath("//b[.= 'LAUNCH A NEW TECH CAREER']"));
        BrowserUtils.scrollIntoView(driver, top);
        WebElement applyButton = driver.findElement(By.xpath("//strong[.='APPLY NOW']"));
        BrowserUtils.clickWithJS(driver, applyButton);
        Thread.sleep(1000);
        String mainPageId = driver.getWindowHandle();
        Set<String> allPagesId = driver.getWindowHandles();
        for (String id:allPagesId) {
            if (!id.equals(mainPageId)){
                driver.switchTo().window(id);
                break;
            }
        }
        WebElement title = driver.findElement(By.xpath("//h1"));
        String actualTitle = BrowserUtils.getTitleWithJS(driver);
        String expectedTitle = "Apply Now";
        Assert.assertEquals(actualTitle, expectedTitle);
        List<WebElement> allInfo = driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
        List<String> expectedInfo = Arrays.asList("info@techtorialacademy.com", "+ 1 (224) 570 91 91", "Chicago & Houston");

        for (int i = 0; i < allInfo.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(allInfo.get(i)), expectedInfo.get(i));
        }

    }


}
