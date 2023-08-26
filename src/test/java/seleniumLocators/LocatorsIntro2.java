package seleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///Users/tentchotenev/Desktop/Techtorialhtml.html");

        //TAG NAME LOCATOR

        WebElement version = driver.findElement(By.tagName("u"));
        String actualVersion = version.getText();
        String expectedVersion = "Use Java Version";
        System.out.println(actualVersion.equals(expectedVersion) ? "Passed" : "Failed");

        //LINK TEXT LOCATOR

        WebElement javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();
        WebElement header = driver.findElement(By.tagName("h1"));
        String actualHeader = header.getText();
        String expectedHeader = "Java";
        System.out.println(actualHeader.equals(expectedHeader) ? "JAVA Passed" : "JAVA Failed");
        driver.navigate().back();

        WebElement seleniumLink = driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();
        WebElement headerSelenium = driver.findElement(By.tagName("h1"));
        String actualHeaderSelenium = headerSelenium.getText();
        String expectedHeaderSelenium = "Selenium automates browsers. That's it!";
        System.out.println(actualHeaderSelenium.equals(expectedHeaderSelenium) ? "Selenium passed" : "Selenium failed");
        driver.navigate().back();

        WebElement cucumberLink = driver.findElement(By.linkText("Cucumber"));
        cucumberLink.click();
        WebElement headerCucumber = driver.findElement(By.tagName("h1"));
        String actualHeaderCucumber = headerCucumber.getText();
        String expectedHeaderCucumber = "Tools & techniques that elevate teams to greatness";
        System.out.println(actualHeaderCucumber.equals(expectedHeaderCucumber) ? "Cucumber passed" : "Cucumber failed");
        driver.navigate().back();

        WebElement testNG = driver.findElement(By.linkText("TestNG"));
        testNG.click();
        WebElement headerTestNG = driver.findElement(By.tagName("h2"));
        String actualHeaderTestNG = headerTestNG.getText();
        String expectedHeaderTestNG = "TestNG";
        System.out.println(actualHeaderTestNG.equals(expectedHeaderTestNG) ? "TestNG Passed" : "TestNG Failed");
        driver.navigate().back();

        String homeURL = driver.getCurrentUrl();
        String expectedHomeURL = "file:///Users/tentchotenev/Desktop/Techtorialhtml.html";
        System.out.println(homeURL.equals(expectedHomeURL) ? "URL passed" : "URL failed");


//        driver.quit();

        //PARTIAL LINK TEXT

        WebElement restApi = driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        System.out.println(driver.getTitle());



    }
}
