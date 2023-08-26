package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PracticeTim8923 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.google.com/");

        WebElement search = driver.findElement(By.id("APjFqb"));
        search.sendKeys("Indian food", Keys.ENTER);
        WebElement website = driver.findElement(By.xpath("//h3[contains(text(),'THE BEST 10 Indian Restaurants in Des Plaines, IL')]"));
        website.click();
        System.out.println(driver.getCurrentUrl());


    }
}
