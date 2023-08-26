package seleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathRealHealthProject {
    /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.
*/
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://katalon-demo-cura.herokuapp.com/ ");
        WebElement appointment = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        appointment.click();
        WebElement userName = driver.findElement(By.xpath("//input[@id='txt-username']"));
        userName.sendKeys("John Doe");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("ThisIsNotAPassword");
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='btn-login']"));
        loginButton.click();
        WebElement facility = driver.findElement(By.xpath("//select[@id='combo_facility']"));
        facility.sendKeys("Hongkong CURA Healthcare Center");
        WebElement checkBox = driver.findElement(By.xpath("//input[@type= 'checkbox']"));
        if (checkBox.isDisplayed()&& !checkBox.isSelected()){checkBox.click();}
        WebElement typeCare = driver.findElement(By.xpath("//input[@id= 'radio_program_medicaid']"));
        typeCare.click();
        WebElement date = driver.findElement(By.xpath("//input[@type= 'text']"));
        date.sendKeys("08/10/2023");
        WebElement comment = driver.findElement(By.xpath("//textarea[@id= 'txt_comment']"));
        comment.sendKeys("Selenium is fun");
        WebElement bookApointmentButton = driver.findElement(By.xpath("//button[contains(text(),'Book Appointment')]"));
        bookApointmentButton.click();
        Thread.sleep(3000);
        WebElement header = driver.findElement(By.xpath("//h2[contains(text(),'Appointment Confirmation')]"));
        String actualHeader = header.getText().trim();
        System.out.println(actualHeader);
        String expectedHeader = "Appointment Confirmation";
        System.out.println(actualHeader.equals(expectedHeader) ? "BOOKED":"NOT BOOKED");

        WebElement facilityHeader = driver.findElement(By.xpath("//p[.='Hongkong CURA Healthcare Center']"));
        System.out.println(facilityHeader.getText());
        WebElement hospitalReadimision = driver.findElement(By.xpath("//p[contains(text(),'Yes')]"));
        System.out.println(hospitalReadimision.getText());
        WebElement healthcareProgram = driver.findElement(By.xpath("//p[contains(text(),'Medicaid')]"));
        System.out.println(healthcareProgram.getText());
        WebElement visitDate = driver.findElement(By.xpath("//p[@id='visit_date']"));
        System.out.println(visitDate.getText());
        WebElement commentFinal = driver.findElement(By.xpath("//p[@id='comment']"));
        System.out.println(commentFinal.getText());
        driver.close();

    }
}
