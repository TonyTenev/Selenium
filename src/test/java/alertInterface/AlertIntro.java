package alertInterface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertIntro {
    @Test

    public void AcceptAndGetText() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsAlert = driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]"));
        jsAlert.click();
        Thread.sleep(1500);
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        String expectedMessage = "I am a JS Alert";
        Assert.assertEquals(actualMessage, expectedMessage);
        alert.accept();//clicks OK button
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult = BrowserUtils.getText(result);
        String expectedResult = "You successfully clicked an alert";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void Dismiss(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsConf = driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm')]"));
        jsConf.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult = BrowserUtils.getText(result);
        String expectedResult = "You clicked: Cancel";
        Assert.assertEquals(actualResult, expectedResult);

    }
    @Test
    public void SendKeys() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsPrompt = driver.findElement(By.xpath("//button[contains(@onclick,'jsPrompt')]"));
        jsPrompt.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("I love Selenium");
        Thread.sleep(3000);
        alert.accept();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult = BrowserUtils.getText(result);
        String expectedResult = "You entered: I love Selenium";
        Assert.assertEquals(actualResult, expectedResult);

    }
}
