package seleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathPractice {
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
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Tony");
        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("Tenev");
        Thread.sleep(2000);
        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("oasnddvknaf908765@gmail.com");
        WebElement phone = driver.findElement(By.id("input-telephone"));
        phone.sendKeys("1234567890");
        WebElement pass = driver.findElement(By.id("input-password"));
        pass.sendKeys("12345");
        WebElement passVer = driver.findElement(By.id("input-confirm"));
        passVer.sendKeys("12345");
        WebElement checkBox = driver.findElement(By.xpath("//input[@name='agree']"));
        if (checkBox.isDisplayed()&&!checkBox.isSelected()){checkBox.click();}
        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();
        String actualTitle =  driver.getTitle();
        String expectedTitle ="Your Account Has Been Created!";
        WebElement continueButton = driver.findElement(By.linkText("Continue"));
        if (actualTitle.equals(expectedTitle)){continueButton.click();}
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://tutorialsninja.com/demo/index.php?route=account/account";
        System.out.println(actualURL.equals(expectedURL)? "PASSED URL" : "FAILED URL");
        Thread.sleep(3000);
        driver.quit();
    }
}
