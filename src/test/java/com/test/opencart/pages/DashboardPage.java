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
    @FindBy(xpath = "//ul[@id='collapse-5']//li//a[contains(text(), 'Customers')]")
    WebElement customerButton;


    public void navigateToCustomerPage() {
        closePopUp.click();
        customersCollapseButton.click();
        customerButton.click();
    }
}
