package seleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDriverMethods {
    public static void main(String[] args) throws InterruptedException {
        //driver.get
        //driver.manage.window.maximize();
        //driver.getTitle();
        //driver.getCurrentUrl()
        //driver.navigate.refresh()
        //driver.navigate.forward();
        //driver.navigate.back();
        //driver.navigate.to();
        //driver.getPageSource();
        //driver.close();
        //driver.quit();


        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);//this will wait for 2 seconds
        driver.navigate().to("https://www.facebook.com/");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        driver.navigate().forward();
        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource());
        driver.quit();

    }
}
