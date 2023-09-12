package waitTimes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FluentWaitPractice {
    @Test
    public void fluentWait(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();
        WebElement removeButton = driver.findElement(By.xpath("//button[contains(@onclick, 'swapCheckbox()')]"));
        removeButton.click();
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(3))
                .withMessage("Text is not on the page")
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);

        WebElement message = fluentWait.until(mydriver-> driver.findElement(By.cssSelector("#message")));
        System.out.println(BrowserUtils.getText(message));
        Assert.assertEquals(BrowserUtils.getText(message), "It's gone!");


    }

}
