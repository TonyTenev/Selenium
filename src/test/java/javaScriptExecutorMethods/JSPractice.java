package javaScriptExecutorMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class JSPractice {
    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/radio-button");
        Actions actions = new Actions(driver);
        WebElement yesButton = driver.findElement(By.cssSelector("#yesRadio"));
//        yesButton.click();
//        actions.click(yesButton).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", yesButton);
        WebElement yesMessage = driver.findElement(By.cssSelector(".text-success"));
        String expectedMessageYes = "Yes";
        Assert.assertEquals(BrowserUtils.getText(yesMessage), expectedMessageYes);
        WebElement impressiveButton = driver.findElement(By.cssSelector("#impressiveRadio"));
//        impressiveButton.click();
//        actions.click(impressiveButton).perform();
        js.executeScript("arguments[0].click()", impressiveButton);
        WebElement impressiveMessage = driver.findElement(By.cssSelector(".text-success"));
        String expectedImpressive = "Impressive";
        Assert.assertEquals(BrowserUtils.getText(impressiveMessage), expectedImpressive);
        WebElement noButton = driver.findElement(By.cssSelector("#noRadio"));
        Assert.assertFalse(noButton.isEnabled());




    }
}
