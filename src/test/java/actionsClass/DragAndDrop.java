package actionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class DragAndDrop {
    @Test
    public  void dragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualOrangeBoxText = BrowserUtils.getText(orangeBox);
        String expectedOrangeBoxText = "... Or here.";
        Assert.assertEquals(actualOrangeBoxText,expectedOrangeBoxText);
        String actualOrangeBoxColor = orangeBox.getCssValue("background-color");
        String expectedOrangeBoxColor = "rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualOrangeBoxColor,expectedOrangeBoxColor);
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable,orangeBox).perform();
        Thread.sleep(1000);
        orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualOrangeBoxAfter = BrowserUtils.getText(orangeBox);
        String expectedOrangeBoxAfter = "You did great!";
        Assert.assertEquals(actualOrangeBoxAfter,expectedOrangeBoxAfter);

    }
    @Test
    public void dragAndDropPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualBlueBoxText = BrowserUtils.getText(blueBox);
        String expectedBlueBoxText = "Drag the small circle here ...";
        Assert.assertEquals(actualBlueBoxText,expectedBlueBoxText);
        String actualBlueBoxColor = blueBox.getCssValue("background-color");
        String expectedBlueBoxColor = "rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualBlueBoxColor,expectedBlueBoxColor);
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable,blueBox).perform();
        blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualTextAfter = BrowserUtils.getText(blueBox);
        String expectedTextAfter ="You did great!";
        Assert.assertEquals(expectedTextAfter,actualTextAfter);


    }

    @Test
    public void ClickAndHoldMethods(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Actions actions = new Actions(driver);
        actions.scrollByAmount(300,300).perform();
        WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualBlueBoxText = BrowserUtils.getText(blueBox);
        String expectedBlueBoxText = "Drag the small circle here ...";
        Assert.assertEquals(actualBlueBoxText,expectedBlueBoxText);
        String actualBlueBoxColor = blueBox.getCssValue("background-color");
        String expectedBlueBoxColor = "rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualBlueBoxColor,expectedBlueBoxColor);
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        actions.clickAndHold(draggable).moveToElement(blueBox).release().perform();
        blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualTextAfter = BrowserUtils.getText(blueBox);
        String expectedTextAfter ="You did great!";
        Assert.assertEquals(expectedTextAfter,actualTextAfter);



    }
}
