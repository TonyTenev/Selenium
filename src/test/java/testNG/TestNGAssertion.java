package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {

    public int multiplication(int number1, int number2) {
        return number1 * number2;
    }

    @Test
    public void validateMultiplication() {
        int actualResult = multiplication(3, 4);
        int expectedResult = 12;
//        if (actualResult==expectedResult){
//            System.out.println("CORRECT");
//        }else {
//            System.out.println("WRONG");
//        }
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void validateZeroLogic() {
        int actualResult = multiplication(0, 999);
        int expectedResult = 0;
        Assert.assertTrue(actualResult==expectedResult);
    }
}
