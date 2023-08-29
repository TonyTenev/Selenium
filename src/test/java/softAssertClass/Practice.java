package softAssertClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;

import java.time.Duration;

public class Practice {
    @Test
    public void practice() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");
        WebElement alertBox = driver.findElement(By.cssSelector("#alertBox"));
        alertBox.click();
        Alert alert = driver.switchTo().alert();
        String actualAlert = alert.getText();
        String expectedAlert = "I am an alert box!kjhgf";
//        Assert.assertEquals(actualAlert, expectedAlert);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAlert, expectedAlert);
        alert.accept();
        WebElement resultAlert = driver.findElement(By.cssSelector("#output"));
        String actualAlResult = BrowserUtils.getText(resultAlert);
        String expectedAlResult = "You selected alert popup";
        WebElement confBox = driver.findElement(By.cssSelector("#confirmBox"));
        confBox.click();
        String actualConfBox = alert.getText();
        String expectedConfBox = "Press a button!sdss";
//        Assert.assertEquals(actualConfBox, expectedConfBox);
        softAssert.assertEquals(actualConfBox, expectedConfBox);
        alert.dismiss();
        WebElement resultCCongBox = driver.findElement(By.cssSelector("#output"));
        String actualConfResult = BrowserUtils.getText(resultAlert);
        String expectedConfResult = "You pressed Cancel in confirmation popup";
//        Assert.assertEquals(actualConfResult, expectedConfResult);
        softAssert.assertEquals(actualConfResult,expectedConfResult);
        WebElement promptBox = driver.findElement(By.cssSelector("#promptBox"));
        promptBox.click();
        String actualPB = alert.getText();
        String expectedPB = "Please enter your name:";
        softAssert.assertEquals(actualPB, expectedPB);
//        Assert.assertEquals(actualPB, expectedPB);
        alert.sendKeys("Tony Tenev");
        alert.accept();
        WebElement resultPB = driver.findElement(By.cssSelector("#output"));
        String actualPBResult = BrowserUtils.getText(resultPB);
        String expectedPBResult = "You entered text Tony Tenev in prompt popup";
//        Assert.assertEquals(actualPBResult, expectedPBResult);
        softAssert.assertEquals(actualPBResult, expectedPBResult);
        softAssert.assertAll();

    }
}
