package testNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterAnnotation {
    @Parameters("firstName")
    @Test
    public void test(String name) {
        System.out.println(name);
    }

    @Parameters({"name", "lastName", "zipCode"})
    @Test
    public void test2(String name, String lastName, String zipCode) {
        System.out.println(name + lastName + zipCode);
    }
}
