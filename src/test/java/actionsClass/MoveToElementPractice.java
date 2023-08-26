package actionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoveToElementPractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/fx/expand");
        List<WebElement> allImages = driver.findElements(By.xpath("//div[@role]//img"));
        List<WebElement> allNames = driver.findElements(By.xpath("//h3"));
        List<WebElement> allPrices = driver.findElements(By.xpath("//div[@role]//p"));
        Actions actions = new Actions(driver);
        Map<String, String> product = new HashMap<>();


        for (int i = 0; i < allImages.size(); i++) {
            Thread.sleep(500);
            actions.moveToElement(allImages.get(i)).perform();
            product.put(allNames.get(i).getText(), allPrices.get(i).getText());
        }
        System.out.println(product);


    }
}
