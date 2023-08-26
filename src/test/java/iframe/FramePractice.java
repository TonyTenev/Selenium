package iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class FramePractice {
    @Test
    public void frame(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        WebElement header = driver.findElement(By.xpath("//h3"));
        System.out.println(BrowserUtils.getText(header));
        driver.switchTo().frame("mce_0_ifr");
        WebElement text = driver.findElement(By.cssSelector("#tinymce"));
        text.clear();
        text.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();
        WebElement elemSel = driver.findElement(By.xpath("//a[.='Elemental Selenium']"));
        System.out.println(BrowserUtils.getText(elemSel));
    }

    @Test
    public void iFramePractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");
        WebElement pavilionLink = driver.findElement(By.linkText("Pavilion"));
        pavilionLink.click();
        BrowserUtils.switchWindow(driver, "Home - qavalidation");
        WebElement seleniumDrop = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(seleniumDrop).perform();
        Thread.sleep(2000);
        WebElement selPyt = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Python']"));
        actions.moveToElement(selPyt).click().perform();
        List<WebElement> allLinks = driver.findElements(By.xpath("//p//a"));
        int count = 0;

        for (int i =0; i < allLinks.size() ; i++) {
            System.out.println(BrowserUtils.getText(allLinks.get(i)));
            count++;

        }
        System.out.println(count);
        BrowserUtils.switchWindow(driver, "iframes");
        driver.switchTo().frame("Frame1");
        WebElement cat1Button = driver.findElement(By.linkText("Category1"));
        cat1Button.click();
        BrowserUtils.switchWindow(driver, "SeleniumTesting Archives");
        WebElement header = driver.findElement(By.tagName("h1"));
        String expectedHeader = "Category Archives: SeleniumTesting";
        Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);
        Thread.sleep(2000);
        List<WebElement> allText = driver.findElements(By.tagName("h3"));
        for (WebElement text:allText) {
            System.out.println(BrowserUtils.getText(text));
        }
        BrowserUtils.switchWindow(driver, "iframes");
        driver.switchTo().frame("Frame1");
        WebElement insideFrame = driver.findElement(By.cssSelector("#frametext"));
        System.out.println(BrowserUtils.getText(insideFrame));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("Frame2");
        WebElement cat2 = driver.findElement(By.linkText("Category3"));
        cat2.click();
        BrowserUtils.switchWindow(driver, "SoftwareTesting Archives");
        WebElement header1 = driver.findElement(By.tagName("h1"));
        System.out.println(BrowserUtils.getText(header1));






    }
}
