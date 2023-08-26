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

public class PracticeActions {
    @Test
    public void tc1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement dropBox = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@class='drop-box ui-droppable']"));
        String actualText = BrowserUtils.getText(dropBox);
        String expectedText = "Drop here";
        Assert.assertEquals(actualText,expectedText);
        WebElement draggable = driver.findElement(By.xpath("//div[@id='droppableExample-tabpane-simple']//div[@class='drag-box mt-4 ui-draggable ui-draggable-handle']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(dropBox).release().perform();
        WebElement boxAfterDrop = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@class='drop-box ui-droppable ui-state-highlight']"));
        String actualTextAfter = BrowserUtils.getText(boxAfterDrop);
        String expectedTextAfter = "Dropped!";
        Assert.assertEquals(actualTextAfter,expectedTextAfter);
        String actualColor = boxAfterDrop.getCssValue("background-color");
        String expectedColor = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor,expectedColor);

    }
    @Test
    public void clickAndHold(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement acceptButton = driver.findElement(By.cssSelector("#droppableExample-tab-accept"));
        Actions actions = new Actions(driver);
        actions.click(acceptButton).perform();
        WebElement draggable = driver.findElement(By.cssSelector("#notAcceptable"));
        WebElement dropBox = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@class='drop-box ui-droppable']"));
        String actualTextBefore = BrowserUtils.getText(dropBox);
        String expectedTextBefore = "Drop here";
        Assert.assertEquals(actualTextBefore,expectedTextBefore);
        actions.clickAndHold(draggable).moveToElement(dropBox).release().perform();
        dropBox = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@class='drop-box ui-droppable']"));
        String actualTextAfter = BrowserUtils.getText(dropBox);
        String expectedTextAfter = "Drop here";
        Assert.assertEquals(actualTextAfter,expectedTextAfter);
    }
}
