package seleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
2-Enter first and last name (textbox).
3-Select gender (radio button).
4-Select years of experience (radio button).
5-Enter date.(send keys)
6-Select Profession (Checkbox). -->choose Both
7-Select Automation tools you are familiar with (multiple checkboxes). --> Choose Selenium
8-Select Continent(Send Keys).
9-Click on Submit button.
10-Validate the url https://www.techlistic.com/p/selenium-practice-form.html
10-Close the webpage
Try your own logic and automate it without any help.
     */
public class LocatorPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Tony");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Tenev");
        Thread.sleep(2000);
        WebElement gender = driver.findElement(By.id("sex-0"));
        gender.click();
        Thread.sleep(2000);
        WebElement experiance = driver.findElement(By.id("exp-1"));
        experiance.click();
        Thread.sleep(2000);
        WebElement date = driver.findElement(By.id("datepicker"));
        date.sendKeys("08/08/2023");
        Thread.sleep(2000);
        WebElement profession = driver.findElement(By.id("profession-1"));
        profession.click();
        WebElement profession1 = driver.findElement(By.id("profession-0"));
        profession1.click();
        Thread.sleep(2000);
        WebElement autoTool = driver.findElement(By.id("tool-2"));
        autoTool.click();
        WebElement continent = driver.findElement(By.id("continents"));
        continent.sendKeys("North America");
        Thread.sleep(2000);
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        String actualUrl = driver.getCurrentUrl();
        String expectedURL = "https://www.techlistic.com/p/selenium-practice-form.html";
        System.out.println(actualUrl.equals(expectedURL) ? "Passed" : "Failed");
        driver.quit();


    }
}
