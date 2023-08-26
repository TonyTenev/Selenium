package seleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class YoutubeRealInterview {
    /* navigate to YouTube
    search for Justin Bieber
    find the location of all links
    Once the link equals to Justin Bieber - Baby ft. Ludacris
    getAttribute
    click link play video


     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com/");
        WebElement search = driver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys("Justin Bieber");
        search.sendKeys(Keys.ENTER);
        List<WebElement> links = driver.findElements(By.xpath("//a[@id='video-title']"));
        for (WebElement link : links) {
            if (link.getAttribute("title").equalsIgnoreCase("Justin Bieber - Baby ft. Ludacris")) {
                Thread.sleep(1000);
                link.sendKeys(Keys.ARROW_DOWN);
                link.click();
                break;
            }
        }


    }
}
