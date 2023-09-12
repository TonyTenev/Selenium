package waitTimes;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitlyWait {
    //We store under driverHelper snf here is the syntax
    //it works for all the WebElements that you are looking under your page

    @Test
    public void ImplicitlyWait(){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
