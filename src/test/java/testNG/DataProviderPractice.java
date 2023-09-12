package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
//    @DataProvider(name = "couples")
//    public Object [][] getData(){
//        return new Object[][]{
//                {"Ahmet", "Leyla"},
//                {"Tony", "Mariela"},
//                {"Alexandra", "Nick"}
//        };
//    }
    @Test(dataProvider = "couples", dataProviderClass = DataSupport.class)
    public void naming1(String firstCouple, String secondCouple){
        System.out.println(firstCouple+" & "+secondCouple);
    }
//    @Test
//    public void case1(){
//        System.out.println("Ahmet & Leyla");
//    }
//    @Test
//    public void case2(){
//        System.out.println("Tony & Mariela");
//    }
//    @Test
//    public void case3(){
//        System.out.println("Alexandra & Nick");
//    }

}
