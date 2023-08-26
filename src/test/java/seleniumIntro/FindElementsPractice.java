package seleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElementsPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        /*Print out all the links adn count how many is there*/

        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> allLinks = driver.findElements(By.xpath("//li"));
        int count=0;
        for (WebElement link: allLinks) {
            count++;
            System.out.println(count+". " + link.getText().trim());


        }
        System.out.println("Total count: "+count);

        /*TASK 2
        * print links with >=12*/
        int countMoreThan12=0;
        for (WebElement link12:allLinks) {
            if (link12.getText().length()>=12){
                countMoreThan12++;
                System.out.println(countMoreThan12 +". "+link12.getText());

            }

        }
        System.out.println(countMoreThan12 +" is the number of links with >=12 characters");

    }
}
