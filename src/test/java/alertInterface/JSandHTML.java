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

public class JSandHTML {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://sweetalert.js.org/");
        WebElement button1 = driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        button1.click();
        Alert alert = driver.switchTo().alert();
        String actualAlert1 = alert.getText();
        String expectedAlert1 = "Oops, something went wrong!";
        Assert.assertEquals(actualAlert1, expectedAlert1);
        Thread.sleep(2000);
        alert.accept();
        WebElement button2 = driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        button2.click();
        Thread.sleep(2000);
        WebElement text = driver.findElement(By.xpath("//div[@class='swal-text']"));
        String actualAlert2 = BrowserUtils.getText(text);
        String expectedAlert2 = "Something went wrong!";
        Assert.assertEquals(actualAlert2, expectedAlert2);
        WebElement OKButton = driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']"));
        OKButton.click();
    }
}
