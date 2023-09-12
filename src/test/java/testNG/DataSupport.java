package testNG;

import org.testng.annotations.DataProvider;

public class DataSupport {
    @DataProvider(name = "couples")
    public static Object [][] getData(){
        return new Object[][]{
                {"Ahmet", "Leyla"},
                {"Tony", "Mariela"},
                {"Alexandra", "Nick"}
        };
    }
}
