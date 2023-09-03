package com.test.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn-close")
    WebElement closePopUp;
    @FindBy(xpath = "//a[@href='#collapse-5']")
    WebElement customersCollapseButton;
    @FindBy(xpath = "//a[.='Customers']")
    WebElement customerButton;


    public void navigateToCustomerPage() {
        customersCollapseButton.click();
        customerButton.click();
    }

    public void closePopUp(){
        closePopUp.click();
    }
}
