package getWindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {
    @Test
    public void switchWindow() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/windows");
        WebElement newWindow = driver.findElement(By.linkText("Click Here"));
        newWindow.click();
        WebElement text = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(text));
        String mainID = driver.getWindowHandle();
        System.out.println(mainID);
        Set<String> allWindows = driver.getWindowHandles();

        for (String id : allWindows) {
            if (!id.equals(mainID)) {
                driver.switchTo().window(id);
                break;
            }
        }
        text = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(text));
    }

    @Test

    public void switchWindowPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement newTabButton = driver.findElement(By.xpath("//button[@id='newTabBtn']"));
        BrowserUtils.scrollIntoView(driver, newTabButton);
        newTabButton.click();
        String mainID = driver.getWindowHandle();
        Set<String> allID = driver.getWindowHandles();
        for (String id : allID) {
            if (!id.equals(mainID)) {
                driver.switchTo().window(id);
                break;
            }
        }
        WebElement alertDemo = driver.findElement(By.xpath("//h1[@itemprop= 'name']"));
        String expectedDemo = "AlertsDemo";
        Assert.assertEquals(BrowserUtils.getText(alertDemo), expectedDemo);
        WebElement confButton = driver.findElement(By.cssSelector("#alertBox"));
        confButton.click();
    }
}
