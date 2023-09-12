package com.test.swagLabs.swagLabsTest;

import org.testng.annotations.DataProvider;
import utils.ConfigReader;

public class AllData {
    @DataProvider(name = "LogInInfo")
    public Object[][] getData() {
        return new Object[][]{
                {ConfigReader.readProperty("swabPU1"), ConfigReader.readProperty("swabPass"), "https://www.saucedemo.com/inventory.html"},
                {ConfigReader.readProperty("swabPU2"), ConfigReader.readProperty("swabPass"), "https://www.saucedemo.com/inventory.html"},
                {ConfigReader.readProperty("swabPU3"), ConfigReader.readProperty("swabPass"), "https://www.saucedemo.com/inventory.html"},
        };
    }



    @DataProvider(name = "LogInInfoNegative")
    public Object[][] getDataNegative() {
        return new Object[][]{
                {"wronguser", "wrongpass", "Epic sadface: Username and password do not match any user in this service"},
                {"", "wrongpass", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "", "Epic sadface: Username is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."}
        };
    }
        @DataProvider(name = "ItemList")
                public Object[][] itemsTest(){
            return new Object[][]{
                    {ConfigReader.readProperty("swabPU1"), ConfigReader.readProperty("swabPass"),"Sauce Labs Backpack","Sauce Labs Backpack","Sly Pack", "$29.99" },
                    {ConfigReader.readProperty("swabPU1"), ConfigReader.readProperty("swabPass"),"Sauce Labs Bike Light", "Sauce Labs Bike Light", "Water-resistant ", "$9.99"},
                    {ConfigReader.readProperty("swabPU1"), ConfigReader.readProperty("swabPass"),"Sauce Labs Bolt T-Shirt", "Sauce Labs Bolt T-Shirt", "Sauce Labs bolt T-shirt", "$15.99"},
                    {ConfigReader.readProperty("swabPU1"), ConfigReader.readProperty("swabPass"),"Sauce Labs Fleece Jacket", "Sauce Labs Fleece Jacket", "quarter-zip fleece", "$49.99"},
                    {ConfigReader.readProperty("swabPU1"), ConfigReader.readProperty("swabPass"),"Sauce Labs Onesie", "Sauce Labs Onesie", "Reinforced 3-snap bottom closure", "$7.99"},
                    {ConfigReader.readProperty("swabPU1"), ConfigReader.readProperty("swabPass"),"Test.allTheThings() T-Shirt (Red)", "Test.allTheThings() T-Shirt (Red)", "This classic Sauce Labs t-shirt ", "$15.99"}
            };
        }
    }

