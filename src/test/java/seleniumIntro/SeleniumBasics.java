package seleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {
    public static void main(String[] args) {
     //First STEP:Setting up automation

        WebDriverManager.chromedriver().setup();
        //Second Step:creating driver to make a connection with website
        WebDriver driver = new ChromeDriver();
        //third step
        driver.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon.com. Spend less. Smile more.";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title is passed");
        }else {
            System.out.println("Title is failed");
        }

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.amazon.com/";

        if (actualURL.equals(expectedURL)){
            System.out.println("URL is passing");
        }else {
            System.out.println("URL is failed");
        }

        driver.close();

        //homework
        //go to 3 different websites and validate title and url


    }
}
