package seleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    /*
    Locators:
    it is a way to locate the element and manipulate on it
     */

    public static void main(String[] args) {
        //ID LOCATOR
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///Users/tentchotenev/Desktop/Techtorialhtml.html");
        WebElement header = driver.findElement(By.id("techtorial1"));
        System.out.println(header.getText());
        String actualHeader = header.getText();
        String expectedHeader = "Techtorial Academy";
        System.out.println(actualHeader.equals(expectedHeader) ? "Passed" : "Failed");

        WebElement paragraph = driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());


        //NAME LOCATOR

        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Tony");
        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Tenev");
        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("7737737777");
        WebElement email = driver.findElement(By.id("userName"));
        email.sendKeys("tentchotenev@gmail.com");
        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("4040 s main");
        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Des plaines");
        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("IL");
        WebElement zip = driver.findElement(By.name("postalCode"));
        zip.sendKeys("60660");

        //CLASSNAME LOCATOR:

        WebElement allTools = driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText());
        WebElement javaBox = driver.findElement(By.id("cond1"));
        if (javaBox.isDisplayed() && !javaBox.isSelected()) {
            javaBox.click();
        }
        System.out.println(javaBox.isSelected() ? "JAVA SELECTED" : "JAVA NOT SELECTED");
        WebElement seleniumBox = driver.findElement(By.id("cond2"));
        if (seleniumBox.isDisplayed() && !seleniumBox.isSelected()) seleniumBox.click();
        System.out.println(seleniumBox.isSelected() ? "SELENIUM SELECTED" : "SELENIUM NOT SELECTED");

        WebElement testNG = driver.findElement(By.id("cond3"));
        if (testNG.isDisplayed() && !testNG.isSelected()) testNG.click();
        System.out.println(testNG.isSelected() ? "TESTNG SELECTED" : "TESTNG NOT SELECTED");

        WebElement cucumberBox = driver.findElement(By.id("cond4"));
        if (cucumberBox.isDisplayed() && !cucumberBox.isSelected()) cucumberBox.click();
        System.out.println(cucumberBox.isSelected() ? "CUCUMBER SELECTED" : "CUCUMBER NOT SELECTED");


    }
}
