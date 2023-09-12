package com.test.blaze.test;

import org.testng.annotations.DataProvider;

public class AllData {
    @DataProvider(name = "customerInfo")
    public Object[][] getData() {
        return new Object[][]{
                {"Tony Tenev", "USA", "Chicago", "123456789", "10", "2023"},
                {"Mehmet", "USA", "Chicago", "87654356", "09", "2026"},
                {"Mahmut", "Kyrgyzstan", "Osh", "987654321", "1", "2030"},
                {"Jasmin", "Malaysia", "Johor", "34334434343", "6", "2026"}
        };
    }
}
