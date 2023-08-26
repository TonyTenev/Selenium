package seleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathPracticeHome {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


         /*
1-Navigate to the website http://tutorialsninja.com/demo/index.php?route=account/register
2-Provide First name,LastName,Email,Telephone,password,confirm password
and click privacy policy button.(isDisplayed and notSelected then click)
3-Click Continue Button
4-Validate message (Your Account Has Been Created!) -->if statement
5-Click Continue Button
6-Validate the url https://tutorialsninja.com/demo/index.php?route=account/account
7-Close your browser
NOTE:Please USE ALL XPATH TO LOCATE THE ELEMENT
 */
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Tony");
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Tenev");
        Thread.sleep(1500);
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("kabsdkajbcaboib@gmail.com");
        WebElement phone = driver.findElement(By.xpath("//input[@name='telephone']"));
        phone.sendKeys("1234567890");
        Thread.sleep(1500);
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("1234567");
        WebElement passwordConf = driver.findElement(By.xpath("//input[@name='confirm']"));
        passwordConf.sendKeys("1234567");
        Thread.sleep(1500);
        WebElement checkBox = driver.findElement(By.xpath("//input[@name='agree']"));
        checkBox.click();
        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();
        String actualTitle = driver.getTitle();
        Thread.sleep(1500);
        String expectedTitle = "Your Account Has Been Created!";
        WebElement continueButton1 = driver.findElement(By.xpath("//a[contains(text(),'Continue')]"));
        if (actualTitle.equals(expectedTitle)){continueButton1.click();}
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://tutorialsninja.com/demo/index.php?route=account/account";
        System.out.println(actualURL.equals(expectedURL)? "PASSED URL":"FAILED URL");
        Thread.sleep(1500);
        driver.quit();
    }
}
