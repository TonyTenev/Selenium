package fileUploads;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FileUploadsPractice {
    @Test
    public void practice() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        WebElement chooseButton = driver.findElement(By.cssSelector("#file-upload"));
        chooseButton.sendKeys("/Users/tentchotenev/Desktop/screenshots/usa.png");
        WebElement uploadButton = driver.findElement(By.cssSelector("#file-submit"));
        uploadButton.submit();
        WebElement text = driver.findElement(By.cssSelector("#uploaded-files"));
        String actualText = BrowserUtils.getText(text);
        String expectedText = "usa.png";
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/upload/");
        WebElement chooseButton = driver.findElement(By.cssSelector(".upload_txt"));
        chooseButton.sendKeys("/Users/tentchotenev/Desktop/screenshots/b.jpeg");
        WebElement text = driver.findElement(By.xpath("//b[contains(text(), 'Select file')]"));
        String actualText = BrowserUtils.getText(text);
        String expectedText = "Select file to send(max 196.45 MB)";
        Assert.assertEquals(actualText, expectedText);
        WebElement termsAccept = driver.findElement(By.cssSelector("#terms"));
        termsAccept.click();
        WebElement submitButton = driver.findElement(By.cssSelector("#submitbutton"));
        submitButton.click();
        Thread.sleep(3000);
        WebElement confMsg = driver.findElement(By.tagName("h3"));
        String actualConfMsg = BrowserUtils.getText(confMsg);
        String expectedConfMsg = "1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(actualConfMsg, expectedConfMsg);


    }
}
