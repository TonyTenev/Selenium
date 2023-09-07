package testNG;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite annotation");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest annotation");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass annotation");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod annotation");
    }
    @Test
    public void test1(){
        System.out.println("test1 annotation");
    }
    @Test
    public void test2(){
        System.out.println("test2 annotation");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod annotation");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass annotation");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("afterTest annotation");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite annotation");
    }

}
