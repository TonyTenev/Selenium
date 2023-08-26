package selectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SelectBasicPractice {
    @Test
    public void practice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///Users/tentchotenev/Desktop/Techtorialhtml.html");
        WebElement countryDrop = driver.findElement(By.xpath("//select[@name='country']"));
        countryDrop.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        Select box = new Select(countryDrop);
        String actualCountry = box.getFirstSelectedOption().getText().trim();
        String expectedCountry = "UNITED STATES";
        Assert.assertEquals(actualCountry,expectedCountry);
        List<WebElement> allOptions = box.getOptions();
        int count=0;
        for (int i = 0; i < allOptions.size(); i++) {
            count++;
            System.out.println(count+ "." + allOptions.get(i).getText().trim());
        }
        System.out.println("Total:"+count);

        box.selectByVisibleText("BULGARIA ");
        Thread.sleep(2000);
        box.selectByValue("215");
        Thread.sleep(2000);
        box.selectByIndex(139);


    }
}
