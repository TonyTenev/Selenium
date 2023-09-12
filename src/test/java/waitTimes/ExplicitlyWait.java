package waitTimes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class ExplicitlyWait {
    @Test
    public void validateText() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement startButton = driver.findElement(By.xpath("//button[.='Start']"));
        startButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement hw = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        hw = wait.until(ExpectedConditions.visibilityOf(hw));
        System.out.println(BrowserUtils.getText(hw));
    }

    @Test
    public void validateText2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        WebElement startButton = driver.findElement(By.xpath("//button"));
        startButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement message = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        message = wait.until(ExpectedConditions.visibilityOf(message));
        Assert.assertEquals(BrowserUtils.getText(message), "Hello World!");

    }
}
