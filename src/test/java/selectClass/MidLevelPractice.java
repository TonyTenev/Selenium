package selectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class MidLevelPractice {
    /*
1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message from header which should be "After flight finder - No Seats Available"


 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
     */

    @Test

    public void tc() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement tripOption = driver.findElement(By.xpath("//input[@value='oneway']"));
        tripOption.click();
        WebElement passCount = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passCount1 = new Select(passCount);
        Thread.sleep(500);
        passCount1.selectByValue("4");
        WebElement depPort = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select depPort1 = new Select(depPort);
        String defaultDepPort = "Acapulco";
        Assert.assertEquals(depPort1.getFirstSelectedOption().getText(), defaultDepPort);
        depPort1.selectByVisibleText("Paris");
        WebElement fromDate = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select fromDate1 = new Select(fromDate);
        fromDate1.selectByVisibleText("August");
        WebElement fromDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select fromDay1 = new Select(fromDay);
        Thread.sleep(500);
        fromDay1.selectByValue("15");
        WebElement arrPort = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arrPort1 = new Select(arrPort);
        arrPort1.selectByVisibleText("San Francisco");
        WebElement toDate = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select toDate1 = new Select(toDate);
        Thread.sleep(500);
        toDate1.selectByVisibleText("December");
        WebElement toDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select toDay1 = new Select(toDay);
        toDay1.selectByValue("15");
        WebElement classOptions = driver.findElement(By.xpath("//input[@value='First']"));
        classOptions.click();
        WebElement airlines = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airLines = new Select(airlines);
        Thread.sleep(500);
        List<WebElement> allAirLines = airLines.getOptions();
        List<String> expectedAirLines = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");
        for (int i = 0; i < allAirLines.size(); i++) {
            Assert.assertEquals(allAirLines.get(i).getText().trim(), expectedAirLines.get(i).trim());
        }
        Thread.sleep(1000);
        airLines.selectByVisibleText("Unified Airlines");
        WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();
        WebElement header = driver.findElement(By.xpath("//font[@size='4']"));
        String expectedHeader = "After flight finder - No Seats Available";
        Assert.assertEquals(header.getText().trim(), expectedHeader.trim());


    }

    @Test

    public void shortcutAutomation() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement tripOption = driver.findElement(By.xpath("//input[@value='oneway']"));
        tripOption.click();
        WebElement passCount = driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(passCount, "4", "text");
//        Select passCount1 = new Select(passCount);
//        Thread.sleep(500);
//        passCount1.selectByValue("4");
        WebElement depPort = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select depPort1 = new Select(depPort);
        String defaultDepPort = "Acapulco";
        Assert.assertEquals(depPort1.getFirstSelectedOption().getText(), defaultDepPort);
        BrowserUtils.selectBy(depPort,"Paris", "value");
//        depPort1.selectByVisibleText("Paris");
        WebElement fromDate = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        BrowserUtils.selectBy(fromDate, "7", "index");
//        Select fromDate1 = new Select(fromDate);
//        fromDate1.selectByVisibleText("August");
        WebElement fromDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
//        Select fromDay1 = new Select(fromDay);
//        Thread.sleep(500);
//        fromDay1.selectByValue("15");
        BrowserUtils.selectBy(fromDay, "15", "value");
        WebElement arrPort = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arrPort1 = new Select(arrPort);
        arrPort1.selectByVisibleText("San Francisco");
        WebElement toDate = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select toDate1 = new Select(toDate);
        Thread.sleep(500);
        toDate1.selectByVisibleText("December");
        WebElement toDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select toDay1 = new Select(toDay);
        toDay1.selectByValue("15");
        WebElement classOptions = driver.findElement(By.xpath("//input[@value='First']"));
        classOptions.click();
        WebElement airlines = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airLines = new Select(airlines);
        Thread.sleep(500);
        List<WebElement> allAirLines = airLines.getOptions();
        List<String> expectedAirLines = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");
        for (int i = 0; i < allAirLines.size(); i++) {
            Assert.assertEquals(allAirLines.get(i).getText().trim(), expectedAirLines.get(i).trim());
        }
        Thread.sleep(1000);
        airLines.selectByVisibleText("Unified Airlines");
        WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();
        WebElement header = driver.findElement(By.xpath("//font[@size='4']"));
        String expectedHeader = "After flight finder - No Seats Available";
        Assert.assertEquals(header.getText().trim(), expectedHeader.trim());
    }
}
